package com.zhou.shop.api.vo.user;

import com.zhou.shop.api.vo.user.login.UserLoginUuidVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author zhouxiong
 * @description: 暂时还是用uuid来绑定验证码，后续看直接用token绑定
 * @version: v1.0-2022/6/29 15:38-zhouxiong： 创建此类
 * @since 2022/6/29 15:38
 */
@ApiModel("前端更换邮箱对象")
public class UserModifyEmailVO extends UserLoginUuidVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "用户id不能为空")
    @ApiModelProperty("用户id")
    private String userId;

    @Email(message = "邮箱地址格式错误！")
    @ApiModelProperty("用户旧邮箱")
    private String OldMail;

    @Email(message = "邮箱地址格式错误！")
    @ApiModelProperty("用户新邮箱")
    private String NewMail;

    @NotBlank(message = "用户密码不能为空")
    @ApiModelProperty("用户id")
    private String userPassword;

    @NotBlank(message = "验证码不能为空")
    @ApiModelProperty("验证码")
    private String checkCode;

    public UserModifyEmailVO() {}

    public UserModifyEmailVO(
            String uuid,
            String userId,
            String oldMail,
            String newMail,
            String userPassword,
            String checkCode) {
        super(uuid);
        this.userId = userId;
        OldMail = oldMail;
        NewMail = newMail;
        this.userPassword = userPassword;
        this.checkCode = checkCode;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOldMail() {
        return OldMail;
    }

    public void setOldMail(String oldMail) {
        OldMail = oldMail;
    }

    public String getNewMail() {
        return NewMail;
    }

    public void setNewMail(String newMail) {
        NewMail = newMail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    @Override
    public String toString() {
        return "UserModifyEmailVO{"
                + "userId='"
                + userId
                + '\''
                + ", OldMail='"
                + OldMail
                + '\''
                + ", NewMail='"
                + NewMail
                + '\''
                + ", userPassword='"
                + userPassword
                + '\''
                + ", checkCode='"
                + checkCode
                + '\''
                + '}';
    }
}
