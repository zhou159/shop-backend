package com.zhou.shop.apply.config;

import com.zhou.shop.apply.security.UserLoginConfigurer;
import com.zhou.shop.apply.security.handler.LogoutSuccessHandlerImpl;
import com.zhou.shop.apply.security.handler.NoRightAccessHandler;
import com.zhou.shop.apply.security.handler.NotLoginEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.Header;
import org.springframework.security.web.header.writers.StaticHeadersWriter;

import java.util.Collections;

/**
 * @author zhouxiong
 * @description:
 * @version: v1.0
 * @since 2022/6/15 16:39
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired LogoutSuccessHandlerImpl logoutSuccessHandlerImpl;

    @Autowired NotLoginEntryPoint notLoginEntryPoint;

    @Autowired NoRightAccessHandler noRightAccessHandler;

    @Autowired
    private SecurityConfig securityConfig;

    private String[] urls = {"/userLogin/**","/swagger-ui.html#/","/swagger-resources/**","/blog/**","/blogCategory/**","/updateLog/**","/error"};

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.csrf().disable()
                .cors().and()
                .sessionManagement().disable()
                .formLogin()
                .loginProcessingUrl("/user/login")
                .usernameParameter("username")
                .passwordParameter("password")
                .and()
                .logout().logoutUrl("/user/logout").logoutSuccessHandler(logoutSuccessHandlerImpl).and()
                .httpBasic()
                .authenticationEntryPoint(notLoginEntryPoint).and()
                .exceptionHandling()
                .accessDeniedHandler(noRightAccessHandler).and()
                .securityContext().disable()
                .authorizeHttpRequests().antMatchers(urls).permitAll().and()
                .headers().addHeaderWriter(
                        new StaticHeadersWriter(Collections.singletonList(
                                new Header("Access-control-Allow-Origin", "*"))))
                .and()
                // 自定义的登录过滤器，不同的登录方式创建不同的登录过滤器，一样的配置方式
                .apply(new UserLoginConfigurer<>(securityConfig))
                .and()
                .build();
    }

    /**
     * 密码加密
     *
     * @return
     */
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
