package com.mohbaba.api.exceptions;

public class PostNotFoundException extends BlogAppException{
    public PostNotFoundException(String message){
        super(message);
    }
}
