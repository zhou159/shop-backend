package com.zhou.shop.common;

import com.zhou.shop.common.enums.RestCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 接口返回对象
 *
 * @author Administrator
 */
@ApiModel("接口返回对象")
public class RestObject<T> {
    @ApiModelProperty("接口响应状态码")
    private int code;
    @ApiModelProperty("接口响应信息")
    private String msg;
    @ApiModelProperty("接口返回数据")
    private T data;

    public int getCode() {
        return code;
    }

    public RestObject<T> setCode(RestCodeEnum restCode) {
        this.code = restCode.getCode();
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
