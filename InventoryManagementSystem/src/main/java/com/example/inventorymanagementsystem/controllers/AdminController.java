package com.example.inventorymanagementsystem.controllers;

import com.example.inventorymanagementsystem.models.User;
import com.example.inventorymanagementsystem.services.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService userService;

    @PostMapping("/buyers")
    public User createBuyer(@RequestBody User user){
        return userService.createBuyer(user);
    }

    @PostMapping("/supplier")
    public User createSupplier(@RequestBody User user){
        return userService.createSupplier(user);
    }
}
