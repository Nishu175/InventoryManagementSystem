package com.example.inventorymanagementsystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ItemCapacityExceedException extends RuntimeException{
    public ItemCapacityExceedException(String message){
        super(message);
    }
}
