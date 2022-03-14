package com.zhou.shop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * @Auther: 周雄 @Date: 2022/3/14 17:37 @Description:
 */
public class UserLogin implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.ASSIGN_ID)
    private String userId;

    @TableField("user_account")
    private String userAccount;

    @TableField("user_password")
    private String userPassword;

    public UserLogin() {}

    public UserLogin(String userId, String userAccount, String userPassword) {
        this.userId = userId;
        this.userAccount = userAccount;
        this.userPassword = userPassword;
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

    @Override
    public String toString() {
        return "UserLogin{"
                + "userId='"
                + userId
                + '\''
                + ", userAccount='"
                + userAccount
                + '\''
                + ", userPassword='"
                + userPassword
                + '\''
                + '}';
    }
}
