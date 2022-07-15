package com.zhou.shop.apply.annotations;

import com.chinapopin.frame.mq.common.vo.MessageVo;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhouxiong
 * @description:
 * @version: v1.0-2022/6/23 8:59-zhouxiong： 创建此类
 * @since 2022/6/23 8:59
 */
@Slf4j
@Component
@Aspect
@EnableAspectJAutoProxy
public class MyLogAspect {
    private static ConcurrentHashMap<String,String> webSocketMap = new ConcurrentHashMap<>();


    /**
     * 切点
     */
    @Pointcut("@annotation(com.chinapopin.apply.aop.MyLog)")
    public void pointCut(){

    }

    @Pointcut("@annotation(com.chinapopin.apply.aop.RequestLimit)")
    public void limitCut(){

    }

    /**
     * 前置通知
     */
    @Before("limitCut()")
    public void beforeLimitAdvice(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        // 获取方法
        Method method = methodSignature.getMethod();
        RequestLimit annotation = method.getAnnotation(RequestLimit.class);
        int count = annotation.count();
        long time = annotation.time();
        final RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        final HttpSession session =(HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
        System.out.println(session.getId());

        log.info("方法:【{}】,前置通知",method);
    }

    /**
     * 前置通知
     */
    @Before("pointCut()")
    public void beforeAdvice(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        // 获取方法
        Method method = methodSignature.getMethod();

        log.info("方法:【{}】,前置通知",method);
    }

    /**
     * 后置通知
     */
    @After("pointCut()")
    public void afterAdvice(JoinPoint joinPoint){
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        // 获取方法
        Method method = methodSignature.getMethod();
        log.info("方法:【{}】，后置通知",method);
    }

    /**
     * 返回通知
     */
    @AfterReturning(value = "pointCut()", returning = "keys")
    public void afterReturnAdvice(JoinPoint joinPoint, Object keys){
        //构造请求
        final RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        final HttpSession o =(HttpSession) requestAttributes.resolveReference(RequestAttributes.REFERENCE_SESSION);

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        // 获取方法
        Method method = methodSignature.getMethod();
        log.info("方法:【{}】,返回值:【{}】",method,keys == null ? null : keys.toString());
    }

    /**
     * 环绕通知
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    @Around("pointCut()") // 引用切点
    public Object aroundAdvice(ProceedingJoinPoint joinPoint) throws Throwable {
//        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
//        ServletRequestAttributes sra = (ServletRequestAttributes) requestAttributes;
//        HttpServletRequest request = sra.getRequest();
//        request.getMethod();
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        // 执行方法
        Object returnValue = joinPoint.proceed();
        // 方法执行后的日志打印
        printAfterLog(returnValue);
        return returnValue;
    }

    /**
     * 异常通知
     * 将异常信息写入消息队列
     * @param joinPoint
     * @param ex
     */
    @AfterThrowing(value = "pointCut()",throwing = "ex")
    public void afterThrowingAdvice(JoinPoint joinPoint, Exception ex) {

        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        // 获取方法
        Method method = methodSignature.getMethod();

        final MessageVo<String> stringMessageVo = new MessageVo<>();
        stringMessageVo.setDate(new Date().toInstant().toEpochMilli());
        stringMessageVo.setData(String.format("%s: %s",method ,ex.getMessage()));
        stringMessageVo.setMsgType("ERROR_TOPIC");
        mqSendService.send(stringMessageVo);
    }

    /**
     * 方法执行前的日志打印
     * @param joinPoint
     */
    public void printBeforeLog(ProceedingJoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        // 获取方法
        Method method = methodSignature.getMethod();
        // 获取参数
        Object[] args = joinPoint.getArgs();
        if (args == null || args.length == 0) {
            return;
        }
        // 获取参数名称
        String[] parameterNames = methodSignature.getParameterNames();
        StringBuilder parameterBuilder = new StringBuilder();
        for (int i = 0; i < args.length; i++) {
            parameterBuilder.append(parameterNames[i]).append(":").append(String.format("\"%s\"",args[i]));
            if (i < parameterNames.length - 1) {
                parameterBuilder.append(",");
            }
        }
        final MessageVo<String> stringMessageVo = new MessageVo<>();
        stringMessageVo.setDate(new Date().toInstant().toEpochMilli());
        stringMessageVo.setData(String.format("方法名:【%s】,方法参数:【%s】",method, parameterBuilder));
        stringMessageVo.setMsgType("METHOD_LOG_TOPIC");
        mqSendService.send(stringMessageVo);
    }

    /**
     * 方法执行后的日志打印
     * @param returnValue
     */
    public void printAfterLog(Object returnValue) {
        log.info("方法返回值【{}】", returnValue == null ? null : returnValue.toString());
    }
}
