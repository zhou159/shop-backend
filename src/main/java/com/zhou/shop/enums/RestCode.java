package com.zhou.shop.enums;

/**
 * 返回值枚举对象
 * @author Administrator
 */

public enum RestCode {
    SUCCESS(200),
    ERROR(500)
    ;

    public int code;

    RestCode(int code) {
        this.code = code;
    }
}
