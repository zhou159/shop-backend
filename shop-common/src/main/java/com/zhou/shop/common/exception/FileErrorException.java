package com.zhou.shop.common.exception;

/**
 * @author 周雄
 * @description:
 * @version: v1.0
 * @since 2022/6/9 15:28
 */
public class FileErrorException extends RuntimeException {
    public FileErrorException(String message) {
        super(message);
    }
}
