package com.mohbaba.api.exceptions;

public class EmptyPostException extends BlogAppException{
    public EmptyPostException(String message){
        super(message);
    }
}
