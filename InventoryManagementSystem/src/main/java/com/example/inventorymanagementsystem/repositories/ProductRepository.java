package com.example.inventorymanagementsystem.repositories;

import com.example.inventorymanagementsystem.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product,Integer> {
}
