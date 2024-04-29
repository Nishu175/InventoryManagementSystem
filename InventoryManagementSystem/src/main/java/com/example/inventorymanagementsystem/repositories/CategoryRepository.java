package com.example.inventorymanagementsystem.repositories;

import com.example.inventorymanagementsystem.models.Category;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends MongoRepository<Category,Integer> {
}
