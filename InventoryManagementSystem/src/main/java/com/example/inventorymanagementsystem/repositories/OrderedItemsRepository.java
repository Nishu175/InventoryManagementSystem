package com.example.inventorymanagementsystem.repositories;

import com.example.inventorymanagementsystem.models.OrderedItem;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderedItemsRepository extends MongoRepository<OrderedItem,Integer> {
}
