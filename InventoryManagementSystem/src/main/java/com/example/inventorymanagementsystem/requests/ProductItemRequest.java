package com.example.inventorymanagementsystem.requests;

import com.example.inventorymanagementsystem.models.Item;
import com.example.inventorymanagementsystem.models.Product;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductItemRequest {
    private Product product;
    private List<Item> items;
}
