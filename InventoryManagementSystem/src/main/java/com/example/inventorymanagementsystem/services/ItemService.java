package com.example.inventorymanagementsystem.services;


import com.example.inventorymanagementsystem.exceptions.InventoryNotFoundException;
import com.example.inventorymanagementsystem.models.Item;
import com.example.inventorymanagementsystem.repositories.ItemRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
    @Autowired
    private ItemRepository itemRepository;

    public Item createNewItem(@NonNull Item item){
        item.setItemId(System.currentTimeMillis());
        return itemRepository.save(item);
    }

    public Item getItem(long itemId){
       return itemRepository.findById(itemId).get();
    }


    public synchronized boolean increaseItems(long itemId,int productId,int itemsToBeAdded){

        /**
         * we can use here $inc operator
         */

        Item item = itemRepository.findByItemIdAndProductId(itemId,productId).get();
        if(item.getQuantityInGram() + itemsToBeAdded > Item.MAX_ITEMS_ALLOWED_IN_GRAM){
            return false;
        }
        item.setQuantityInGram(item.getQuantityInGram() + itemsToBeAdded);
        itemRepository.save(item);
        return true;
    }

    public synchronized boolean decreaseItems(long itemId,int productId,int itemsToBeRemoved){
        Item item = itemRepository.findByItemIdAndProductId(itemId,productId).orElseThrow(()->new InventoryNotFoundException("no item found"));

        /**
         * we can use here $dec operator
         */

        if(item.getQuantityInGram() < itemsToBeRemoved){
            return false;
        }

        item.setQuantityInGram(item.getQuantityInGram() - itemsToBeRemoved);
        itemRepository.save(item);
        return true;
    }

}
