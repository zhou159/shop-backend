package com.zhou.shop.apply.interceptor;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.zhou.shop.api.entity.user.User;
import com.zhou.shop.api.entity.user.UserLogin;
import com.zhou.shop.apiServer.service.user.IUserLoginService;
import com.zhou.shop.apiServer.service.user.IUserService;
import com.zhou.shop.apply.annotations.NotLogin;
import com.zhou.shop.common.BaseConstant;
import com.zhou.shop.common.exception.UserNotLoginException;
import com.zhou.shop.oss.redis.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 * @deprecated 引入了sa-token，弃用原本的登录拦截器 2022/06/16 00:07:02
 * @author zhouxiong
 * @description:
 * @version: v1.0
 * @since 2022/6/11 16:35
 */
@Deprecated
public class UserLoginInterceptor implements HandlerInterceptor {

    Logger logger = LoggerFactory.getLogger(UserLoginInterceptor.class);
    @Autowired private RedisUtil redisUtil;
    @Autowired private IUserService userService;
    @Autowired private IUserLoginService userLoginService;

    @Override
    public boolean preHandle(
            HttpServletRequest request, HttpServletResponse response, Object handler) {
        final long startTime = System.currentTimeMillis();
        // 如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        // 从请求头中拿取token
        String tokenUuid = request.getHeader(BaseConstant.AUTHORIZATION_TOKEN_KEY);

        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();

        // 检查有没有跳过登录的注解
        if (method.isAnnotationPresent(NotLogin.class)) {
            NotLogin passToken = method.getAnnotation(NotLogin.class);
            if (!passToken.required()) {
                throw new UserNotLoginException("用户信息已过期！请重新登录");
            }
        } else {
            // 从redis中拿取token真实值
            if (tokenUuid == null) {
                throw new UserNotLoginException("用户信息已过期！请重新登录");
            }
            String token = String.valueOf(redisUtil.get(tokenUuid));

            // 执行认证
            if (token == null) {
                throw new UserNotLoginException("请登录!");
            }
            // 获取 token 中的 userId
            String userIdToken;
            try {
                userIdToken = JWT.decode(token).getClaim(BaseConstant.TOKEN_USER_ID).asString();
                logger.info("token中的用户id:{}", userIdToken);
            } catch (JWTDecodeException j) {
                throw new UserNotLoginException("请登录!");
            }

            final User byId = userService.getById(userIdToken);
            if (byId == null) {
                throw new UserNotLoginException("用户不存在，请重新登录");
            }
            final UserLogin one = userLoginService.lambdaQuery().eq(UserLogin::getUserId, byId.getUserId()).one();
            // 验证 token
            JWTVerifier jwtVerifier =
                    JWT.require(Algorithm.HMAC256(String.valueOf(one.getUserPassword()))).build();
            try {
                jwtVerifier.verify(token);
            } catch (JWTVerificationException e) {
                throw new UserNotLoginException("请登录!");
            }
            final long endTime = System.currentTimeMillis();
            logger.info("登录拦截器执行耗时:{}ms", endTime - startTime);
            logger.info("用户:{}，调用接口:{}",byId.getUserId(),request.getRequestURI());
            return true;
        }
        return true;
    }

    @Override
    public void postHandle(
            HttpServletRequest request,
            HttpServletResponse response,
            Object handler,
            ModelAndView modelAndView)
            throws Exception {
        System.out.println("拦截器post**");
    }

    @Override
    public void afterCompletion(
            HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        System.out.println("拦截器after**");
    }
}
