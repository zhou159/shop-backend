package com.zhou.shop.api.dto;

import java.io.Serializable;

/**
 * @author zhouxiong
 * @description:
 * @version: v1.0
 * @since 2022/6/11 15:53
 */
public class UserLoginDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private String token;

    private String userId;

    private String userPicture;

    public UserLoginDTO() {}

    public UserLoginDTO(String token, String userId, String userPicture) {
        this.token = token;
        this.userId = userId;
        this.userPicture = userPicture;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPicture() {
        return userPicture;
    }

    public void setUserPicture(String userPicture) {
        this.userPicture = userPicture;
    }

    @Override
    public String toString() {
        return "UserLoginDTO{"
                + "token='"
                + token
                + '\''
                + ", userId='"
                + userId
                + '\''
                + ", userPicture='"
                + userPicture
                + '\''
                + '}';
    }
}
