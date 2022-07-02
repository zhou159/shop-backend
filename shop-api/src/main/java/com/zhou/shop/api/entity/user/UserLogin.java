package com.zhou.shop.api.entity.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @auther: 周雄 @Date: 2022/3/14 17:37 @Description:
 */
@TableName("user_login")
@ApiModel("用户登录")
public class UserLogin implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("登陆表id")
    @TableId(value = "user_login_id", type = IdType.ASSIGN_ID)
    private String userLoginId;

    @ApiModelProperty("登陆表用户id")
    @TableField("user_id")
    private String userId;

    @ApiModelProperty("登陆表用户账号")
    @TableField("user_account")
    private String userAccount;

    @ApiModelProperty("登陆表用户密码")
    @TableField("user_password")
    private String userPassword;

    @ApiModelProperty("登陆账户类别")
    @TableField("type")
    private String type;

    public UserLogin() {}

    public UserLogin(String userId) {
        this.userId = userId;
    }

    public UserLogin(
            String userLoginId,
            String userId,
            String userAccount,
            String userPassword,
            String type) {
        this.userLoginId = userLoginId;
        this.userId = userId;
        this.userAccount = userAccount;
        this.userPassword = userPassword;
        this.type = type;
    }

    public String getUserLoginId() {
        return userLoginId;
    }

    public void setUserLoginId(String userLoginId) {
        this.userLoginId = userLoginId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "UserLogin{"
                + "userLoginId='"
                + userLoginId
                + '\''
                + ", userId='"
                + userId
                + '\''
                + ", userAccount='"
                + userAccount
                + '\''
                + ", userPassword='"
                + userPassword
                + '\''
                + ", type='"
                + type
                + '\''
                + '}';
    }
}
