package com.zhou.shop.common;

import com.zhou.shop.common.enums.RestCodeEnum;

/**
 * 返回调用对象
 *
 * @author Administrator
 */
public class RestResponse {
    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    public static <T> RestObject<T> makeOkRsp() {
        return new RestObject<T>().setCode(RestCodeEnum.SUCCESS).setMsg(SUCCESS);
    }

    public static <T> RestObject<T> makeOkRsp(T data) {
        return new RestObject<T>().setCode(RestCodeEnum.SUCCESS).setMsg(SUCCESS).setData(data);
    }

    public static <T> RestObject<T> makeErrRsp(T data) {
        return new RestObject<T>().setCode(RestCodeEnum.ERROR).setMsg(FAIL).setData(data);
    }

    public static <T> RestObject<T> errRsp(int code, String msg, T data) {
        return new RestObject<T>().setCode(code).setMsg(msg).setData(data);
    }

    public static <T> RestObject<T> makeRsp(int code, String msg) {
        return new RestObject<T>().setCode(code).setMsg(msg);
    }

    public static <T> RestObject<T> makeRsp(int code, String msg, T data) {
        return new RestObject<T>().setCode(code).setMsg(msg).setData(data);
    }
}
