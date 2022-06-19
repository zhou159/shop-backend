package com.zhou.shop.api.vo.user;

import com.zhou.shop.api.vo.user.login.UserLoginUuidVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author zhouxiong
 * @description:
 * @version: v1.0-2022/6/19 14:42-zhouxiong： 创建此类
 * @since 2022/6/19 14:42
 */
@ApiModel("用户前端对象")
public class UserForgetVO extends UserLoginUuidVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户电话")
    private String tel;

    @Email(message = "邮箱地址格式错误！")
    @ApiModelProperty("用户邮箱")
    private String mail;

    @ApiModelProperty("用户账号")
    private String userAccount;

    @NotBlank(message = "验证码不能为空")
    @ApiModelProperty("验证码")
    private String checkCode;

    public UserForgetVO() {}

    public UserForgetVO(
            String tel, String mail, String userAccount, String checkCode) {
        this.tel = tel;
        this.mail = mail;
        this.userAccount = userAccount;
        this.checkCode = checkCode;
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
        return "UserForgetVO{"
                + "tel='"
                + tel
                + '\''
                + ", mail='"
                + mail
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
