package com.example.inventorymanagementsystem.services;


import com.example.inventorymanagementsystem.models.InventoryProduct;
import com.example.inventorymanagementsystem.repositories.InventoryProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryProductService {
    @Autowired
    private InventoryProductRepository inventoryProductRepository;

    public boolean addProductIntoInventoryIfNotExists(int invId,int productId){
        if(!inventoryProductRepository.findByInventoryIdAndAndProductId(invId,productId).isPresent()){
            InventoryProduct inventoryProduct = new InventoryProduct();
            inventoryProduct.setId((int)(System.currentTimeMillis()/1000L));
            inventoryProduct.setInventoryId(invId);
            inventoryProduct.setProductId(productId);
            inventoryProductRepository.save(inventoryProduct);
            return true;
        }

        return false;
    }
}
