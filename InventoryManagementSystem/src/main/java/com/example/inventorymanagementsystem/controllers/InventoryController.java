package com.example.inventorymanagementsystem.controllers;

import com.example.inventorymanagementsystem.models.Inventory;
import com.example.inventorymanagementsystem.requests.ProductItemRequest;
import com.example.inventorymanagementsystem.response.ProductItemResponse;
import com.example.inventorymanagementsystem.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;


    @PostMapping
    public Inventory createInventory(@RequestBody Inventory inventory){
        return inventoryService.createInventory(inventory);
    }

    @GetMapping("/{invId}")
    public Inventory createInventory(@PathVariable int invId){
        return inventoryService.getInventoryById(invId);
    }

    @PostMapping("/{invId}/products")
    public ProductItemResponse addNewProductWithItems(@RequestBody ProductItemRequest productItemRequest, @PathVariable int invId){
        return inventoryService.addProductWithItems(productItemRequest,invId);
    }

    @PutMapping("/{invId}/products/{productId}/items/{itemId}/add")
    public String addItemsQuantityToExistingProduct(@PathVariable int invId, @PathVariable int productId, @PathVariable long itemId, @RequestParam int quantityToBeAdded){
        inventoryService.addItemsQuantityToExistingProduct(invId,productId,itemId,quantityToBeAdded);
        return "item added";
    }

    @PutMapping("/{invId}/products/{productId}/items/{itemId}/remove")
    public String removeItemsQuantityToExistingProduct(@PathVariable int invId, @PathVariable int productId, @PathVariable long itemId, @RequestParam int quantityToBeRemoved){
        inventoryService.removeItemsQuantityToExistingProduct(invId,productId,itemId,quantityToBeRemoved);
        return "item removed";
    }
}
