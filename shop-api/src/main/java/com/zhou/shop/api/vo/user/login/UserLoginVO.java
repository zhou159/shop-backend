package com.zhou.shop.api.vo.user.login;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

/**
 * 前端登陆实体
 *
 * @author zhouxiong
 */
public class UserLoginVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户电话")
    private String tel;

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

    public UserLoginVO(
            String tel, String userPassword, String userAccount, String checkCode, String uuid) {
        this.tel = tel;
        this.userPassword = userPassword;
        this.userAccount = userAccount;
        this.checkCode = checkCode;
        this.uuid = uuid;
    }

    public UserLoginVO() {}

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserLoginVO that = (UserLoginVO) o;
        return Objects.equals(tel, that.tel)
                && userPassword.equals(that.userPassword)
                && Objects.equals(userAccount, that.userAccount)
                && checkCode.equals(that.checkCode)
                && uuid.equals(that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tel, userPassword, userAccount, checkCode, uuid);
    }

    @Override
    public String toString() {
        return "UserLoginVO{"
                + "tel='"
                + tel
                + '\''
                + ", password='"
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
