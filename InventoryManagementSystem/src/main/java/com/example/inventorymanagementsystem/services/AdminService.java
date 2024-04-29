package com.example.inventorymanagementsystem.services;

import com.example.inventorymanagementsystem.exceptions.InvalidDataException;
import com.example.inventorymanagementsystem.models.User;
import com.example.inventorymanagementsystem.models.UserRole;
import com.example.inventorymanagementsystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private UserRepository userRepository;

    public User createBuyer(User user){
        if(user == null){
            throw new InvalidDataException("bad user data");
        }

        if(user.getUserEmail().isEmpty()){
            throw new InvalidDataException("no email Id");
        }

        user.setUserId((int)(System.currentTimeMillis()/1000L));
        user.setCreatedTs(System.currentTimeMillis());
        user.setUserRole(UserRole.BUYER.ordinal());
        return userRepository.save(user);
    }

    public User createSupplier(User user){
        if(user == null){
            throw new InvalidDataException("bad user data");
        }

        if(user.getUserEmail().isEmpty()){
            throw new InvalidDataException("no email Id");
        }

        user.setUserId((int)(System.currentTimeMillis()/1000L));
        user.setCreatedTs(System.currentTimeMillis());
        user.setUserRole(UserRole.SUPPLIER.ordinal());
        return userRepository.save(user);
    }
}
