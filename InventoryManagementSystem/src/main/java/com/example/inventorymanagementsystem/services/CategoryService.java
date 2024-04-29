package com.example.inventorymanagementsystem.services;

import com.example.inventorymanagementsystem.models.Category;
import com.example.inventorymanagementsystem.repositories.CategoryRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category addNewCategory(@NonNull Category category){
        category.setCategoryId((int)(System.currentTimeMillis()/1000L));
        return categoryRepository.save(category);
    }

    public boolean isCategoryExists(int categoryId){
        return categoryRepository.existsById(categoryId);
    }
}
