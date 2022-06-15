package com.zhou.shop.apply.security;

import com.alibaba.excel.util.StringUtils;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhouxiong
 * @description:
 * @version: v1.0
 * @since 2022/6/15 21:24
 */
@Component("rbacService")
public class RbacServiceImpl implements RbacService{
    private AntPathMatcher antPathMatcher = new AntPathMatcher();
    /**
     * @param request
     * @param authentication
     * @return
     */
    @Override
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        Object principal = authentication.getPrincipal();

        boolean hasPermission = false;

        if (principal instanceof JwtUserLoginDTO) {
            // 如果角色是“ROLE_ADMIN”，就永远返回true
            if (StringUtils.equals(((JwtUserLoginDTO) principal).getRoleName(), "ROLE_ADMIN")) {
                hasPermission = true;
            } else {
                // 查询用户角色所拥有权限的所有URL，这里假设是从数据库或缓存（或者登录的时候可以直接将该角色拥有的权限保存到JWT）中查的
                List<String> urls = Arrays.asList("/user/retrieveAllUser");
                for (String url : urls) {
                    if (antPathMatcher.match(url, request.getRequestURI())) {
                        hasPermission = true;
                        break;
                    }
                }
            }
        }

        return hasPermission;
    }
}
