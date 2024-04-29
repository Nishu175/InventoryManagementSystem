package com.example.inventorymanagementsystem.services;

import com.example.inventorymanagementsystem.exceptions.UserNotFoundException;
import com.example.inventorymanagementsystem.models.User;
import com.example.inventorymanagementsystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUserById(int userId){
        return  userRepository.findById(userId).orElseThrow( ()->new UserNotFoundException("user not found") );
    }
}
