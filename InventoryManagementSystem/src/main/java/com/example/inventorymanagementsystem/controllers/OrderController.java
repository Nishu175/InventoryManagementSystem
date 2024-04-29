package com.example.inventorymanagementsystem.controllers;

import com.example.inventorymanagementsystem.models.Order;
import com.example.inventorymanagementsystem.models.OrderedItem;
import com.example.inventorymanagementsystem.requests.OrderRequest;
import com.example.inventorymanagementsystem.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order placeAOrder(@RequestBody OrderRequest orderRequest){
        return orderService.placeAOrder(orderRequest);
    }


    @PostMapping("/{orderId}/return")
    public String returnAItem(@RequestBody OrderedItem orderedItem){
        return orderService.cancelAItemInOrder(orderedItem);
    }
}
