package com.example.inventorymanagementsystem.response;

import com.example.inventorymanagementsystem.models.Item;
import com.example.inventorymanagementsystem.models.Product;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductItemResponse {
    private Product product;
    private List<Item> items;
}
