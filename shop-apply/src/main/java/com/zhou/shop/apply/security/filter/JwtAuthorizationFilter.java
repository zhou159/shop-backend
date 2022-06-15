package com.zhou.shop.apply.security.filter;

import com.zhou.shop.apply.security.Usersafvdjk;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhouxiong
 * @description:
 * @version: v1.0
 * @since 2022/6/15 20:22
 */
public class JwtAuthorizationFilter extends BasicAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
        super(authenticationManager);
    }

    /**
     * @param request
     * @param response
     * @param chain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    protected void doFilterInternal(
            HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        final Usersafvdjk authentication = getAuthentication(request);

        if (!"".equals(authentication)){
            // 设置springsecurity上下文中
            SecurityContextHolder.getContext().setAuthentication((Authentication) authentication);
        }

        chain.doFilter(request,response);
    }


    private Usersafvdjk getAuthentication(HttpServletRequest request) throws IOException {

        try {

            //获取请求头token
            String token = request.getHeader("token");

            if (token !=null){
                //解析Token
                return new Usersafvdjk("S"); //返回用户以及权限
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Usersafvdjk("F");
    }
}
