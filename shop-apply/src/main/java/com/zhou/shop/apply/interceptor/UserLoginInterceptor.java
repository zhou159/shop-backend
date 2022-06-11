package com.zhou.shop.apply.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.zhou.shop.api.entity.user.User;
import com.zhou.shop.apiServer.service.user.IUserService;
import com.zhou.shop.apply.annotations.NotLogin;
import com.zhou.shop.common.BaseConstant;
import com.zhou.shop.common.exception.UserNotLoginException;
import com.zhou.shop.oss.redis.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @author zhouxiong
 * @description:
 * @version: v1.0
 * @since 2022/6/11 16:35
 */
@Component
public class UserLoginInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private IUserService userService;

    @Override
    public boolean preHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        // 从请求头中拿取token
        String token_UUID = request.getHeader(BaseConstant.AUTHORIZATION_TOKEN_KEY);

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        //        //检查是否有passtoken注释，有则跳过认证
        //        if (method.isAnnotationPresent(PassToken.class)) {
        //            PassToken passToken = method.getAnnotation(PassToken.class);
        //            if (passToken.required()) {
        //                return true;
        //            }
        //        }

        // 检查有没有跳过登录的注解
        if (method.isAnnotationPresent(NotLogin.class)) {
            NotLogin passToken = method.getAnnotation(NotLogin.class);
            if (!passToken.required()) {
                throw new UserNotLoginException("用户信息已过期！请重新登录");
            }
        } else {
            // 从redis中拿取token真实值
            if (token_UUID == null) {
                throw new UserNotLoginException("用户信息已过期！请重新登录");
            }
            String token = String.valueOf(redisUtil.get(token_UUID));

            NotLogin notLogin = method.getAnnotation(NotLogin.class);
            if (notLogin.required()) {
                // 执行认证
                if (token == null) {
                    throw new UserNotLoginException("请登录!");
                }
                // 获取 token 中的 user id
                String userId_token;
                try {
                    userId_token = JWT.decode(token).getClaim(BaseConstant.TOKEN_USER_ID).asString();
                } catch (JWTDecodeException j) {
                    throw new UserNotLoginException("请登录!");
                }

                final User byId = userService.getById(userId_token);
                if (byId == null) {
                    throw new UserNotLoginException("用户不存在，请重新登录");
                }
                // 验证 token
                JWTVerifier jwtVerifier =
                        JWT.require(Algorithm.HMAC256(String.valueOf(byId.getUserId()))).build();
                try {
                    jwtVerifier.verify(token);
                } catch (JWTVerificationException e) {
                    throw new UserNotLoginException("请登录!");
                }
                return true;
            }
        }
        return true;
    }

    @Override
    public void postHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            ModelAndView modelAndView)
            throws Exception {}

    @Override
    public void afterCompletion(
            HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {}
}