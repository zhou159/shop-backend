package com.zhou.shop.apply.security.handler;

import com.alibaba.fastjson.JSON;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
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
 * @description: 未登录handler
 * @version: v1.0
 * @since 2022/6/15 16:38
 */
@Component
public class NotLoginEntryPoint implements AuthenticationEntryPoint {
    /**
     * @param request that resulted in an <code>AuthenticationException</code>
     * @param response so that the user agent can begin authentication
     * @param authException that caused the invocation
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void commence(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException authException)
            throws IOException, ServletException {
        response.setContentType("applicatiopn/json;charset=utf-8");
        PrintWriter writer = response.getWriter();
        Map<String,Object> map = new HashMap<>();
        map.put("code","405");
        map.put("msg","请先登录");
        writer.println(JSON.toJSONString(map));
        writer.flush();
        writer.close();
    }
}
