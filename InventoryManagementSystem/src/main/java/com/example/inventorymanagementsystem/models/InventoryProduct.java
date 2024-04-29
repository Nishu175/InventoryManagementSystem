package com.example.inventorymanagementsystem.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document("inventory_products")
public class InventoryProduct {
    private int id;
    private int inventoryId;
    private int productId;
}
