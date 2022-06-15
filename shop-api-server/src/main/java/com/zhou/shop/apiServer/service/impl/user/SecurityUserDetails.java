package com.zhou.shop.apiServer.service.impl.user;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author zhouxiong
 * @description:
 * @version: v1.0
 * @since 2022/6/15 14:17
 */
public class SecurityUserDetails implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
