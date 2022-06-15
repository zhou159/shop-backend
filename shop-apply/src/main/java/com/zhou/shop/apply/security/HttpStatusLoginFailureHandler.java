package com.zhou.shop.apply.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author zhouxiong
 * @description:
 * @version: v1.0
 * @since 2022/6/15 21:07
 */
public class HttpStatusLoginFailureHandler implements AuthenticationFailureHandler {

    Logger log = LoggerFactory.getLogger(HttpStatusLoginFailureHandler.class);
    /**
     * @param request the request during which the authentication attempt occurred.
     * @param response the response.
     * @param exception the exception which was thrown to reject the authentication request.
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void onAuthenticationFailure(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException exception)
            throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");
        response.setCharacterEncoding(Charset.defaultCharset().displayName());

        if (exception instanceof LoginAuthenticationException) {
            LoginAuthenticationException e = (LoginAuthenticationException) exception;
            response.getWriter().print(e.toJSONString());
        } else {
            response.getWriter().print("{\"msg\": \"" + exception.getMessage() + "\"}");
        }

        log.error(exception.getMessage());
    }
}
