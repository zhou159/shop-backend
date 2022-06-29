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
@ApiModel("前端绑定邮箱对象")
public class UserBindEmailVO extends UserLoginUuidVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "用户id不能为空")
    @ApiModelProperty("用户id")
    private String userId;

    @Email(message = "邮箱地址格式错误！")
    @ApiModelProperty("用户邮箱")
    private String mail;

    @NotBlank(message = "验证码不能为空")
    @ApiModelProperty("验证码")
    private String checkCode;

    public UserBindEmailVO() {}

    public UserBindEmailVO(String uuid, String userId, String mail, String checkCode) {
        super(uuid);
        this.userId = userId;
        this.mail = mail;
        this.checkCode = checkCode;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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

    @Override
    public String toString() {
        return "UserBindEmailVO{"
                + "userId='"
                + userId
                + '\''
                + ", mail='"
                + mail
                + '\''
                + ", checkCode='"
                + checkCode
                + '\''
                + '}';
    }
}
