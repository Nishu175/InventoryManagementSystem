package com.example.inventorymanagementsystem.repositories;

import com.example.inventorymanagementsystem.models.Inventory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends MongoRepository<Inventory,Integer> {
}
