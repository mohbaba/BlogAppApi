package com.mohbaba.api.exceptions;

public class UsernameExistsException extends BlogAppException{
    public UsernameExistsException(String message) {
        super(message);
    }
}
