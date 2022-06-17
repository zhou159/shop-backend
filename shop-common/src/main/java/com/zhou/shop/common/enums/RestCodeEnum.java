package com.zhou.shop.common.enums;

/**
 * 返回值枚举对象
 *
 * @author Administrator
 */
public enum RestCodeEnum {
    /** 接口调用状态码 */
    SUCCESS(200),
    ERROR(500);

    public int getCode() {
        return code;
    }

    private final int code;

    RestCodeEnum(int code) {
        this.code = code;
    }


}
