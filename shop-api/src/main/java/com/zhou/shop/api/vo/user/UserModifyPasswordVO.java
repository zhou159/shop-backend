package com.zhou.shop.api.vo.user;

import com.zhou.shop.api.vo.user.login.UserLoginUuidVO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author zhouxiong
 * @description:
 * @version: v1.0-2022/6/19 14:42-zhouxiong： 创建此类
 * @since 2022/6/19 14:42
 */
@ApiModel("前端修改密码对象")
public class UserModifyPasswordVO extends UserLoginUuidVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "原密码不能为空")
    @ApiModelProperty("用户旧密码")
    private String userOldPassword;

    @NotBlank(message = "新密码不能为空")
    @ApiModelProperty("用户新密码")
    private String userNewPassword;

    @NotBlank(message = "确认新密码不能为空")
    @ApiModelProperty("用户新密码重复")
    private String userNewPasswordRe;

    @NotBlank(message = "验证码不能为空")
    @ApiModelProperty("验证码")
    private String checkCode;

    public UserModifyPasswordVO() {}

    public UserModifyPasswordVO(
            String uuid,
            String userOldPassword,
            String userNewPassword,
            String userNewPasswordRe,
            String checkCode) {
        super(uuid);
        this.userOldPassword = userOldPassword;
        this.userNewPassword = userNewPassword;
        this.userNewPasswordRe = userNewPasswordRe;
        this.checkCode = checkCode;
    }

    public String getUserOldPassword() {
        return userOldPassword;
    }

    public void setUserOldPassword(String userOldPassword) {
        this.userOldPassword = userOldPassword;
    }

    public String getUserNewPassword() {
        return userNewPassword;
    }

    public void setUserNewPassword(String userNewPassword) {
        this.userNewPassword = userNewPassword;
    }

    public String getUserNewPasswordRe() {
        return userNewPasswordRe;
    }

    public void setUserNewPasswordRe(String userNewPasswordRe) {
        this.userNewPasswordRe = userNewPasswordRe;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    @Override
    public String toString() {
        return "UserModifyPasswordVO{"
                + "userOldPassword='"
                + userOldPassword
                + '\''
                + ", userNewPassword='"
                + userNewPassword
                + '\''
                + ", userNewPasswordRe='"
                + userNewPasswordRe
                + '\''
                + ", checkCode='"
                + checkCode
                + '\''
                + '}';
    }
}
