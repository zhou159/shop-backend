package com.zhou.shop.exception;

public class UserNotLoginException extends RuntimeException{
    public UserNotLoginException(String message) {
        super(message);
    }
}
