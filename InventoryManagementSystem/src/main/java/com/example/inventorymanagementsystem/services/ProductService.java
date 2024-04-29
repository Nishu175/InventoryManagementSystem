package com.example.inventorymanagementsystem.services;

import com.example.inventorymanagementsystem.exceptions.InvalidDataException;
import com.example.inventorymanagementsystem.models.Product;
import com.example.inventorymanagementsystem.repositories.ProductRepository;
import com.example.inventorymanagementsystem.requests.ProductItemRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;

    public Product addNewProduct(Product product){
        product.setProductId((int)(System.currentTimeMillis()/1000L));
        if(!categoryService.isCategoryExists(product.getCategoryId())){
            throw new InvalidDataException("not a valid category");
        }

        return productRepository.save(product);
    }

    public boolean isProductExists(int productId){
        return productRepository.existsById(productId);
    }
}
