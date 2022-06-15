package com.zhou.shop.apply.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author zhouxiong
 * @description:
 * @version: v1.0
 * @since 2022/6/15 21:14
 */
public class UserAuthenticationToken extends AbstractAuthenticationToken {
    /**
     * 登录账号/手机号
     */
    private String mobile;

    /**
     * 登录密码
     */
    private String password;

    public UserAuthenticationToken(Collection<? extends GrantedAuthority> authorities, String mobile, String password) {
        super(authorities);
        this.mobile = mobile;
        this.password = password;
    }

    /**
     * @return
     */
    @Override
    public Object getCredentials() {
        return mobile;
    }

    /**
     * @return
     */
    @Override
    public Object getPrincipal() {
        return mobile;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
