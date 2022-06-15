package com.zhou.shop.apply.security;

import org.springframework.security.core.Authentication;

import javax.servlet.http.HttpServletRequest;

/**
 * @author zhouxiong
 * @description:
 * @version: v1.0
 * @since 2022/6/15 21:23
 */
public interface RbacService {/**
 * 是否有权限访问
 *
 * @param request
 * @param authentication
 * @return
 */
boolean hasPermission(HttpServletRequest request, Authentication authentication);}
