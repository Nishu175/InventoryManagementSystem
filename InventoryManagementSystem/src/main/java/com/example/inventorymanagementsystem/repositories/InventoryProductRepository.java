package com.example.inventorymanagementsystem.repositories;

import com.example.inventorymanagementsystem.models.InventoryProduct;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryProductRepository extends MongoRepository<InventoryProduct,Integer> {

    Optional<InventoryProduct> findByInventoryIdAndAndProductId(Integer invId, Integer productId);
}
