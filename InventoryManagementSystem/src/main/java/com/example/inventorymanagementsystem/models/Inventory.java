package com.example.inventorymanagementsystem.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Document("inventories")
public class Inventory {
    @Id
    private int inventoryId;
    private String inventoryName;
    private long createdAt;
    private int supplierId; // managerId
    private int pincode;


    @JsonIgnore
    public boolean isValid(){
        return  !this.inventoryName.isEmpty() && this.supplierId!=0 && this.pincode!=0;
    }
}
