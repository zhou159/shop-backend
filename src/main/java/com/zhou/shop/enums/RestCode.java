package com.zhou.shop.enums;

public enum RestCode {
    SUCCESS(200),
    NOTFOUND(404),
    FAIL(400),
    ERROR(500)
    ;

    public int code;

    RestCode(int code) {
        this.code = code;
    }
}
