package com.zhou.shop.common.exception;

/**
 * @author 周雄
 * @description:
 * @version: v1.0
 * @since 2022/6/10 17:10
 */
public class RedisException extends RuntimeException{
    public RedisException(String message) {super(message);}
}
