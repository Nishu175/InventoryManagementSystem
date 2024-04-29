package com.example.inventorymanagementsystem.services;

import com.example.inventorymanagementsystem.exceptions.InvalidDataException;
import com.example.inventorymanagementsystem.models.Item;
import com.example.inventorymanagementsystem.models.Order;
import com.example.inventorymanagementsystem.models.OrderStatus;
import com.example.inventorymanagementsystem.models.OrderedItem;
import com.example.inventorymanagementsystem.models.TransactionType;
import com.example.inventorymanagementsystem.repositories.OrderRepository;
import com.example.inventorymanagementsystem.requests.OrderRequest;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderedItemService orderedItemService;

    @Autowired
    private ItemService itemService;


    //@Transactional

    /**
     * @Transactional giving error on due to no repilca set as mongo transation management only
     * work on repilca set
     * so inconsistense state due to any operation failure in below method must be solve by transaction manager
     * @param orderRequest
     * @return
     */
    public Order placeAOrder(OrderRequest orderRequest) {
        Order order = orderRequest.getOrder();
        order.setOrderId((int)(System.currentTimeMillis()/1000L));
        order.setOrderedTs(System.currentTimeMillis());
        order.setOrderStatus(OrderStatus.SHIPPED.ordinal());
        order.setTransactionType(TransactionType.DEDUCTION.ordinal());

        orderRepository.save(order);

        List<Item> items = orderRequest.getItems();

        for(Item item:items){
            boolean status = itemService.decreaseItems(item.getItemId(), item.getProductId(), item.getQuantityInGram());
            if (!status){
                throw new IllegalStateException("items not avaialble");
            }
        }

        List<OrderedItem> orderedItems = new ArrayList<>();
        for(Item item : items){
            OrderedItem orderedItem = new OrderedItem();
            orderedItem.setId((int)(System.currentTimeMillis()/1000L));
            orderedItem.setItemId(item.getItemId());
            orderedItem.setOrderId(order.getOrderId());
            orderedItem.setQuantityInGram(item.getQuantityInGram());
            orderedItem.setPricePerGram(item.getQuantityInGram());
            orderedItems.add(orderedItem);

        }

        orderedItemService.addOrderedItem(orderedItems);



        return order;
    }


    /**
     * @Transactional giving error on due to no repilca set as mongo transation management only
     * work on repilca set
     * so inconsistense state due to any operation failure in below method must be solve by transaction manager

     * @return
     */
    public String cancelAItemInOrder(OrderedItem orderedItem) {

        orderRepository.findById(orderedItem.getOrderId()).orElseThrow(()->new InvalidDataException("order does not exists"));

        Item items = itemService.getItem(orderedItem.getItemId());

        itemService.increaseItems(items.getItemId(), items.getProductId(), orderedItem.getQuantityInGram());

        return "return placed of given items";
    }
}
