package com.example.inventorymanagementsystem.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Document("items")
public class Item {

    public static final int MAX_ITEMS_ALLOWED_IN_GRAM = 1000000;  //(1000 KG capacity)

    @Id
    private int itemId;
    private String itemName;
    private String itemDescription;
    private int productId;
    private double unitPriceInINR; // price of one item
    private int quantityInGram;

}
