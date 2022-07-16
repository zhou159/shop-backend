package com.zhou.shop.apply.aop;

import cn.dev33.satoken.stp.StpUtil;
import com.zhou.shop.apply.annotations.RequestLimit;
import com.zhou.shop.common.exception.ShopException;
import com.zhou.shop.oss.redis.RedisUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/**
 * @author zhouxiong
 * @description:
 * @version: v1.0-2022/6/23 8:59-zhouxiong： 创建此类
 * @since 2022/6/23 8:59
 */
@Component
@Aspect
@EnableAspectJAutoProxy
public class MyLogAspect {

    @Autowired
    RedisUtil redisUtil;

    private final ConcurrentHashMap<HttpSession, String> sessionMap = new ConcurrentHashMap<>();

    @Pointcut("@annotation(com.zhou.shop.apply.annotations.RequestLimit)")
    public void limitCut() {

    }

    /**
     * 前置通知
     */
    @Before("limitCut()")
    public void beforeLimitAdvice(JoinPoint joinPoint) {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        // 获取方法
        Method method = methodSignature.getMethod();
        //获取注解
        RequestLimit annotation = method.getAnnotation(RequestLimit.class);
        //获取注解中的数据
        int count = annotation.count();
        long time = annotation.time();
        TimeUnit timeUnit = annotation.timeUnit();
        //获取连接的session信息
        final RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        final HttpSession session = (HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);

        Integer value = (Integer) redisUtil.get(session.getId());
        if (value != null) {
            if (value + 1 > count) {
                throw new ShopException("接口请求次数过多！");
            }
            redisUtil.setex(session.getId(), value + 1, time, timeUnit);
        } else {
            redisUtil.setex(session.getId(), 1, time, timeUnit);
        }
    }

    /**
     * 后置通知
     */
    @After("limitCut()")
    public void afterAdvice(JoinPoint joinPoint) {

    }

    /**
     * 返回通知
     */
    @AfterReturning(value = "limitCut()", returning = "keys")
    public void afterReturnAdvice(JoinPoint joinPoint, Object keys) {

    }

    /**
     * 环绕通知
     */
    //@Around("limitCut()") // 引用切点
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
        // 执行方法
        return joinPoint.proceed();
    }

    /**
     * 异常通知
     */
    @AfterThrowing(value = "limitCut()", throwing = "ex")
    public void afterThrowingAdvice(JoinPoint joinPoint, Exception ex) {

    }
}
