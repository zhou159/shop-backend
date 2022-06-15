package com.zhou.shop.apply.security;

import org.springframework.security.core.AuthenticationException;

/**
 * @author zhouxiong
 * @description:
 * @version: v1.0
 * @since 2022/6/15 21:08
 */
public class LoginAuthenticationException extends AuthenticationException {
    public static LoginAuthenticationException VERIFY_CODE_INVALID =
            new LoginAuthenticationException(100001, "VERIFY_CODE_INVALID", "验证码无效！");

    public static LoginAuthenticationException USER_NAME_NOT_EXIST =
            new LoginAuthenticationException(100003, "USER_NAME_NOT_EXIST", "用户不存在！");

    public static LoginAuthenticationException PASSWORD_NOT_EXIST =
            new LoginAuthenticationException(100005, "PASSWORD_NOT_EXIST", "密码错误！");

    public static LoginAuthenticationException JWT_IS_EMPTY =
            new LoginAuthenticationException(100007, "JWT_IS_EMPTY", "令牌为空！");

    public static LoginAuthenticationException JWT_EXPIRED =
            new LoginAuthenticationException(100009, "JWT_EXPIRED", "令牌过期！");

    public static LoginAuthenticationException JWT_FORMAT_ERROR =
            new LoginAuthenticationException(100011, "JWT_FORMAT_ERROR", "令牌格式错误！");

    public static LoginAuthenticationException AUTH_ERROR =
            new LoginAuthenticationException(100013, "AUTH_ERROR", "系统验证异常！");

    /**
     * 响应码，成功200
     */
    private Integer code;

    /**
     * 响应英文描述
     */
    private String engDesc;

    /**
     * 响应中文描述
     */
    private String chnDesc;

    /**
     * 响应描述明细
     */
    private String detail;

    public LoginAuthenticationException(Integer code, String engDesc, String chnDesc) {
        super(engDesc);
        this.code = code;
        this.engDesc = engDesc;
        this.chnDesc = chnDesc;
    }

    public LoginAuthenticationException(String msg) {
        super(msg);
        this.engDesc = msg;
    }

    public String toJSONString() {
        return "{    \"chnDesc\": \"" + chnDesc + "\",\n" +
                "    \"code\": " + code + ",\n" +
                "    \"engDesc\": \"" + engDesc + "\",\n" +
                "    \"message\": \"" + detail + "\"}";
    }

    public static LoginAuthenticationException getVerifyCodeInvalid() {
        return VERIFY_CODE_INVALID;
    }

    public static void setVerifyCodeInvalid(LoginAuthenticationException verifyCodeInvalid) {
        VERIFY_CODE_INVALID = verifyCodeInvalid;
    }

    public static LoginAuthenticationException getUserNameNotExist() {
        return USER_NAME_NOT_EXIST;
    }

    public static void setUserNameNotExist(LoginAuthenticationException userNameNotExist) {
        USER_NAME_NOT_EXIST = userNameNotExist;
    }

    public static LoginAuthenticationException getPasswordNotExist() {
        return PASSWORD_NOT_EXIST;
    }

    public static void setPasswordNotExist(LoginAuthenticationException passwordNotExist) {
        PASSWORD_NOT_EXIST = passwordNotExist;
    }

    public static LoginAuthenticationException getJwtIsEmpty() {
        return JWT_IS_EMPTY;
    }

    public static void setJwtIsEmpty(LoginAuthenticationException jwtIsEmpty) {
        JWT_IS_EMPTY = jwtIsEmpty;
    }

    public static LoginAuthenticationException getJwtExpired() {
        return JWT_EXPIRED;
    }

    public static void setJwtExpired(LoginAuthenticationException jwtExpired) {
        JWT_EXPIRED = jwtExpired;
    }

    public static LoginAuthenticationException getJwtFormatError() {
        return JWT_FORMAT_ERROR;
    }

    public static void setJwtFormatError(LoginAuthenticationException jwtFormatError) {
        JWT_FORMAT_ERROR = jwtFormatError;
    }

    public static LoginAuthenticationException getAuthError() {
        return AUTH_ERROR;
    }

    public static void setAuthError(LoginAuthenticationException authError) {
        AUTH_ERROR = authError;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getEngDesc() {
        return engDesc;
    }

    public void setEngDesc(String engDesc) {
        this.engDesc = engDesc;
    }

    public String getChnDesc() {
        return chnDesc;
    }

    public void setChnDesc(String chnDesc) {
        this.chnDesc = chnDesc;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
