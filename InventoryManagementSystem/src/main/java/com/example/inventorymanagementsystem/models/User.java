package com.example.inventorymanagementsystem.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Document("users")
public class User {
    @Id
    private int userId;
    private String userName;
    private String userEmail;
    private int userRole; // keeping single role for now
    private long createdTs;
    private long updatedTs;
}
