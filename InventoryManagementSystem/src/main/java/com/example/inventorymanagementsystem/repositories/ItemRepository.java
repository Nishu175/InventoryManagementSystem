package com.example.inventorymanagementsystem.repositories;

import com.example.inventorymanagementsystem.models.Item;
import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends MongoRepository<Item,Long> {

    Optional<Item> findByItemIdAndProductId(Long itemId, Integer productId);
}
