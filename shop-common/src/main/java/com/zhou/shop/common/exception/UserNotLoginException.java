package com.zhou.shop.common.exception;

public class UserNotLoginException extends RuntimeException{
    public UserNotLoginException(String message) {
        super(message);
    }
}
