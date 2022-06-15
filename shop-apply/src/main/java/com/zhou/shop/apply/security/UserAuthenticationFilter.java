package com.zhou.shop.apply.security;

import com.alibaba.fastjson2.JSON;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.StreamUtils;
import org.springframework.util.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author zhouxiong
 * @description:
 * @version: v1.0
 * @since 2022/6/15 21:11
 */
public class UserAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    public UserAuthenticationFilter() {
        super(new AntPathRequestMatcher("/user/login", "POST"));
    }
    /**
     * @param request from which to extract parameters and perform the authentication
     * @param response the response, which may be needed if the implementation has to do a redirect
     *     as part of a multi-stage authentication process (such as OpenID).
     * @return
     * @throws AuthenticationException
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public Authentication attemptAuthentication(
            HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException, IOException, ServletException {
        String body = StreamUtils.copyToString(request.getInputStream(), StandardCharsets.UTF_8);
        String mobile = null, password = null, verifyCode = null;

        if(StringUtils.hasText(body)) {
            UserLoginRequest loginRequest = JSON.parseObject(body, UserLoginRequest.class);
            mobile = loginRequest.getMobile();
            password = loginRequest.getPassword();
            verifyCode = loginRequest.getVerifyCode();
        }

        // TODO 这里验证图形验证码 verifyCode 是否正确

        UserAuthenticationToken token = new UserAuthenticationToken(
                null, mobile, password);

        // 这里进行下一步认证，会走到我们定义的 UserAuthenticationProvider 中
        return this.getAuthenticationManager().authenticate(token);
    }
}
