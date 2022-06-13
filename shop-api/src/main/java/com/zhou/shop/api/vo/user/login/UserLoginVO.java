package com.zhou.shop.api.vo.user.login;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 前端登陆实体
 *
 * @author zhouxiong
 */
public class UserLoginVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户电话")
    private String tel;

    @ApiModelProperty("用户邮箱")
    private String mail;

    @NotNull
    @ApiModelProperty("用户密码")
    private String userPassword;

    @ApiModelProperty("用户账号")
    private String userAccount;

    @NotNull
    @ApiModelProperty("验证码")
    private String checkCode;

    @NotNull
    @ApiModelProperty("uuid")
    private String uuid;

    public UserLoginVO() {}

    public UserLoginVO(
            String tel,
            String mail,
            String userPassword,
            String userAccount,
            String checkCode,
            String uuid) {
        this.tel = tel;
        this.mail = mail;
        this.userPassword = userPassword;
        this.userAccount = userAccount;
        this.checkCode = checkCode;
        this.uuid = uuid;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public String toString() {
        return "UserLoginVO{"
                + "tel='"
                + tel
                + '\''
                + ", mail='"
                + mail
                + '\''
                + ", userPassword='"
                + userPassword
                + '\''
                + ", userAccount='"
                + userAccount
                + '\''
                + ", checkCode='"
                + checkCode
                + '\''
                + ", uuid='"
                + uuid
                + '\''
                + '}';
    }
}
