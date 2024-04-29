package com.example.inventorymanagementsystem.models;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("ordered_items")
public class OrderedItem {
    private int id;
    private int orderId;
    private int itemId;
    private int quantityInGram;
    private int pricePerGram;
}
