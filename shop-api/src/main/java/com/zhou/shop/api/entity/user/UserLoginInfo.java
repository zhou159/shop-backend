package com.zhou.shop.api.entity.user;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author zhouxiong
 * @since 2022-7-1 16:33
 */
@ApiModel("用户登录信息")
@TableName(value = "user_login_info")
public class UserLoginInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ASSIGN_ID)
    @ApiModelProperty("登录信息表id")
    private String id;

    @TableField(value = "user_id")
    @ApiModelProperty("用户id")
    private String userId;

    @TableField(value = "user_login_time")
    @ApiModelProperty("登录时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime userLoginTime;

    @TableField(value = "user_login_ip")
    @ApiModelProperty("登录ip(公网)")
    private String userLoginIp;

    @TableField(value = "user_login_address")
    @ApiModelProperty("登录地址信息")
    private String userLoginAddress;

    @TableField(value = "newest")
    @ApiModelProperty("是否是当前登录信息")
    private Integer newest;

    public UserLoginInfo() {}

    public UserLoginInfo(String userId) {
        this.userId = userId;
    }

    public UserLoginInfo(
            String id,
            String userId,
            LocalDateTime userLoginTime,
            String userLoginIp,
            String userLoginAddress,
            Integer newest) {
        this.id = id;
        this.userId = userId;
        this.userLoginTime = userLoginTime;
        this.userLoginIp = userLoginIp;
        this.userLoginAddress = userLoginAddress;
        this.newest = newest;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDateTime getUserLoginTime() {
        return userLoginTime;
    }

    public void setUserLoginTime(LocalDateTime userLoginTime) {
        this.userLoginTime = userLoginTime;
    }

    public String getUserLoginIp() {
        return userLoginIp;
    }

    public void setUserLoginIp(String userLoginIp) {
        this.userLoginIp = userLoginIp;
    }

    public String getUserLoginAddress() {
        return userLoginAddress;
    }

    public void setUserLoginAddress(String userLoginAddress) {
        this.userLoginAddress = userLoginAddress;
    }

    public Integer getNewest() {
        return newest;
    }

    public void setNewest(Integer newest) {
        this.newest = newest;
    }

    @Override
    public String toString() {
        return "UserLoginInfo{"
                + "id='"
                + id
                + '\''
                + ", userId='"
                + userId
                + '\''
                + ", userLoginTime="
                + userLoginTime
                + ", userLoginIp='"
                + userLoginIp
                + '\''
                + ", userLoginAddress='"
                + userLoginAddress
                + '\''
                + ", newest="
                + newest
                + '}';
    }
}
