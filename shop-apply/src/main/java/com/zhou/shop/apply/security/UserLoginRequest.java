package com.zhou.shop.apply.security;

import java.io.Serializable;

/**
 * @author zhouxiong
 * @description:
 * @version: v1.0
 * @since 2022/6/15 21:13
 */
public class UserLoginRequest implements Serializable {
    /**
     * 登录账号/手机号
     */
    private String mobile;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 验证码
     */
    private String verifyCode;

    public UserLoginRequest() {
    }

    public UserLoginRequest(String mobile, String password, String verifyCode) {
        this.mobile = mobile;
        this.password = password;
        this.verifyCode = verifyCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }
}
