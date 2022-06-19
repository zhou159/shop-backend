package com.zhou.shop.common.exception;

/**
 * @author zhouxiong
 * @description:
 * @version: v1.0-2022/6/19 10:02-zhouxiong： 创建此类
 * @since 2022/6/19 10:02
 */
public class CheckCodeErrorException extends RuntimeException{
    public CheckCodeErrorException(String message) {
        super(message);
    }
}
