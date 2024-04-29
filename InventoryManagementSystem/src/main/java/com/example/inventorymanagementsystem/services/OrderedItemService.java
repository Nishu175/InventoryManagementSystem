package com.example.inventorymanagementsystem.services;

import com.example.inventorymanagementsystem.models.Item;
import com.example.inventorymanagementsystem.models.OrderedItem;
import com.example.inventorymanagementsystem.repositories.OrderedItemsRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderedItemService {
    @Autowired
    private OrderedItemsRepository orderedItemsRepository;

    public List<OrderedItem> addOrderedItem( List<OrderedItem> items){
        return orderedItemsRepository.saveAll(items);
    }
}
