package com.mohbaba.api.exceptions;

public class AccountNotFoundException extends BlogAppException{
    public AccountNotFoundException(String message){
        super(message);
    }
}
