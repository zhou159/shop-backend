package com.zhou.shop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.regex.Pattern;

/**
 * @author 周雄
 * @since 2021-06-24
 */
@TableName("user")
@ApiModel(value = "User对象")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    private static Pattern NUMBER_PATTERN = Pattern.compile("\\d+");

    @ApiModelProperty(value = "用户id")
    @TableId(value = "user_id", type = IdType.ID_WORKER_STR)
    private String userId;

    @ApiModelProperty(value = "用户账号")
    @TableField("username")
    private String username;

    @ApiModelProperty(value = "用户角色")
    @TableField("role")
    private String role;

    @ApiModelProperty(value = "用户头像")
    @TableField("user_picture")
    private String userPicture;

    public User() {}

    public User(String userId, String username, String role, String userPicture) {
        this.userId = userId;
        this.username = username;
        this.role = role;
        this.userPicture = userPicture;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture;
    }

    @Override
    public String toString() {
        return "User{"
                + "userId="
                + userId
                + ", username='"
                + username
                + '\''
                + ", role='"
                + role
                + '\''
                + ", userPicture='"
                + userPicture
                + '\''
                + '}';
    }

}
