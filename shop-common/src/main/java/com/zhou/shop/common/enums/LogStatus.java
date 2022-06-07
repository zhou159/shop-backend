package com.zhou.shop.common.enums;

/**
 * 日志状态码
 *
 * @author Administrator
 */
public enum LogStatus {
    /** 日志状态码 */
    INFO("INFO"),
    DEBUG("DEBUG"),
    WARING("WARING"),
    ERROR("ERROR");

    public String info;

    LogStatus(String info) {
        this.info = info;
    }
}
