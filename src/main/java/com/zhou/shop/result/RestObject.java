package com.zhou.shop.result;

import com.zhou.shop.enums.RestCode;

/**
 * 接口返回对象
 *
 * @author Administrator
 */
public class RestObject<T> {
    private int code;
    private String msg;
    private T data;

    public int getCode() {
        return code;
    }

    public RestObject<T> setCode(RestCode restCode) {
        this.code = restCode.code;
        return this;
    }

    public RestObject<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public RestObject<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public T getData() {
        return data;
    }

    public RestObject<T> setData(T data) {
        this.data = data;
        return this;
    }
}
