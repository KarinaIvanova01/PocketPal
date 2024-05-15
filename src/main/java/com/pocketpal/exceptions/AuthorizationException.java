package com.pocketpal.exceptions;

public class AuthorizationException extends RuntimeException{

    public AuthorizationException(String message){
        super(message);
    }
}
