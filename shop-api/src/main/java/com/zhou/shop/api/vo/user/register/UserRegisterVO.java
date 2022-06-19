package com.zhou.shop.api.vo.user.register;

import com.zhou.shop.api.vo.user.login.UserLoginUuidVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author zhouxiong
 * @description:
 * @version: v1.0-2022/6/17 15:42-zhouxiong： 创建此类
 * @since 2022/6/17 15:42
 */
@ApiModel("用户注册uuid前端对象")
public class UserRegisterVO extends UserLoginUuidVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户头像")
    private String userPicture;

    @NotBlank(message = "用户昵称不能为空")
    @ApiModelProperty("用户昵称")
    private String username;

    @ApiModelProperty("用户电话")
    private String tel;

    @ApiModelProperty("用户邮箱")
    private String mail;

    @NotBlank(message = "密码不能为空")
    @ApiModelProperty("用户密码")
    private String userPassword;

    @ApiModelProperty("用户账号")
    private String userAccount;

    @NotBlank(message = "验证码不能为空")
    @ApiModelProperty("验证码")
    private String checkCode;

    public UserRegisterVO() {}

    public UserRegisterVO(
            String userPicture,
            String username,
            String tel,
            String mail,
            String userPassword,
            String userAccount,
            String checkCode) {
        this.userPicture = userPicture;
        this.username = username;
        this.tel = tel;
        this.mail = mail;
        this.userPassword = userPassword;
        this.userAccount = userAccount;
        this.checkCode = checkCode;
    }

    public String getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    @Override
    public String toString() {
        return "UserRegisterVO{"
                + "userPicture='"
                + userPicture
                + '\''
                + ", username='"
                + username
                + '\''
                + ", tel='"
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
                + '}';
    }
}
