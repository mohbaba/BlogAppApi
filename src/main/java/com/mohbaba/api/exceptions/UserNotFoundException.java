package com.mohbaba.api.exceptions;

public class UserNotFoundException extends BlogAppException{
    public UserNotFoundException(String message){
        super(message);
    }
}
