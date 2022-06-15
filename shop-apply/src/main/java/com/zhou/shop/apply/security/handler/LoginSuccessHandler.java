package com.zhou.shop.apply.security.handler;

import com.alibaba.fastjson2.JSON;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouxiong
 * @description: 登录成功handler
 * @version: v1.0
 * @since 2022/6/15 16:36
 */
@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    /**
     * @param request the request which caused the successful authentication
     * @param response the response
     * @param authentication the <tt>Authentication</tt> object which was created during the
     *     authentication process.
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationSuccess(
            HttpServletRequest request, HttpServletResponse response, Authentication authentication)
            throws IOException, ServletException {
        response.setContentType("applicatiopn/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        Map<String,Object> map = new HashMap<>();
        map.put("code","200");
        map.put("msg","登录成功");
        writer.println(JSON.toJSONString(map));
        writer.flush();
        writer.close();
    }
}
