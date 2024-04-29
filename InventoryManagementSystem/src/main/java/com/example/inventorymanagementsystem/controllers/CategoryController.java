package com.example.inventorymanagementsystem.controllers;

import com.example.inventorymanagementsystem.models.Category;
import com.example.inventorymanagementsystem.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @PostMapping("/category")
    public Category createNewCategory(@RequestBody Category category){
     return categoryService.addNewCategory(category);
    }
}
