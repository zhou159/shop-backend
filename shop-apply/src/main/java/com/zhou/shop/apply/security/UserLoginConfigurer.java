package com.zhou.shop.apply.security;

import com.zhou.shop.apply.config.SecurityConfig;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.HttpSecurityBuilder;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.security.web.authentication.session.NullAuthenticatedSessionStrategy;

/**
 * @author zhouxiong
 * @description:
 * @version: v1.0
 * @since 2022/6/15 21:02
 */
public class UserLoginConfigurer<T extends UserLoginConfigurer<T, B>, B extends HttpSecurityBuilder<B>> extends AbstractHttpConfigurer<T, B> {
    private SecurityConfig securityConfig;

    public UserLoginConfigurer(SecurityConfig securityConfig) {
        this.securityConfig = securityConfig;
    }

    @Override
    public void configure(B http) throws Exception {

        UserAuthenticationFilter authFilter = new UserAuthenticationFilter();

        authFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));
        authFilter.setSessionAuthenticationStrategy(new NullAuthenticatedSessionStrategy());

        // 登录成功处理器
        authFilter.setAuthenticationSuccessHandler(new UserLoginSuccessHandler(securityConfig));
        // 登录失败处理器
        authFilter.setAuthenticationFailureHandler(new HttpStatusLoginFailureHandler());

        // 拦截器位置
        UserAuthenticationFilter filter = postProcess(authFilter);
        http.addFilterAfter(filter, LogoutFilter.class);
    }
}
