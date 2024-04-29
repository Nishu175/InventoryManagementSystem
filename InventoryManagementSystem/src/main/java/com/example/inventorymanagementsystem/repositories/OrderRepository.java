package com.example.inventorymanagementsystem.repositories;

import com.example.inventorymanagementsystem.models.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends MongoRepository<Order,Integer> {
}
