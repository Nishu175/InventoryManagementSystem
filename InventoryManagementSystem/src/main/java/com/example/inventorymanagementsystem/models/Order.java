package com.example.inventorymanagementsystem.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Document("orders")
public class Order {
    @Id
    private int orderId;
    private long orderedTs;
    private long lastUpdatedTs;
    private int orderedBy;
    private int transactionType;
    private int orderStatus;
    private int shippedToPincode;
}
