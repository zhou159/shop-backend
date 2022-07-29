package com.zhou.shop.api.entity.user;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 周雄
 * @since 2021-06-24
 */
@TableName("user")
@ApiModel("用户")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("用户id")
    @TableId(value = "user_id", type = IdType.INPUT)
    private String userId;

    @ApiModelProperty("用户账号")
    @TableField("username")
    private String username;

    @ApiModelProperty("用户头像")
    @TableField("user_picture")
    private String userPicture;

    @TableLogic
    @ApiModelProperty("用户逻辑删除")
    @TableField("user_deleted")
    private Integer userDeleted;

    @ApiModelProperty("用户创建时间")
    @TableField("user_create_time")
    private LocalDateTime userCreateTime;

    @ApiModelProperty("用户更新时间")
    @TableField("user_update_time")
    private LocalDateTime userUpdateTime;

    public User() {
    }

    public User(String userId) {
        this.userId = userId;
    }

    public User(String userId, String username, String userPicture, Integer userDeleted, LocalDateTime userCreateTime, LocalDateTime userUpdateTime) {
        this.userId = userId;
        this.username = username;
        this.userPicture = userPicture;
        this.userDeleted = userDeleted;
        this.userCreateTime = userCreateTime;
        this.userUpdateTime = userUpdateTime;
    }

    public String getUserId() {
        return userId;
    }

    public User setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getUserPicture() {
        return userPicture;
    }

    public User setUserPicture(String userPicture) {
        this.userPicture = userPicture;
        return this;
    }

    public Integer getUserDeleted() {
        return userDeleted;
    }

    public User setUserDeleted(Integer userDeleted) {
        this.userDeleted = userDeleted;
        return this;
    }

    public LocalDateTime getUserCreateTime() {
        return userCreateTime;
    }

    public User setUserCreateTime(LocalDateTime userCreateTime) {
        this.userCreateTime = userCreateTime;
        return this;
    }

    public LocalDateTime getUserUpdateTime() {
        return userUpdateTime;
    }

    public User setUserUpdateTime(LocalDateTime userUpdateTime) {
        this.userUpdateTime = userUpdateTime;
        return this;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", username='" + username + '\'' +
                ", userPicture='" + userPicture + '\'' +
                ", userDeleted=" + userDeleted +
                ", userCreateTime=" + userCreateTime +
                ", userUpdateTime=" + userUpdateTime +
                '}';
    }
}
