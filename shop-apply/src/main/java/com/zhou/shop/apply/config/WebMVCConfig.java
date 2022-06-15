package com.zhou.shop.apply.config;

import com.zhou.shop.apply.interceptor.UserLoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


public class WebMVCConfig implements WebMvcConfigurer {

    @Bean
    public UserLoginInterceptor authenticationInterceptor() {
        return new UserLoginInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(authenticationInterceptor())
//                .addPathPatterns("/**")
////                .excludePathPatterns("/swagger-ui.html#/")
////                .excludePathPatterns("/swagger-resources/**")
////                .excludePathPatterns("/userLogin/verifyCode")
////                .excludePathPatterns("/userLogin/login")
////                .excludePathPatterns("/userLogin/uuid")
////                .excludePathPatterns("/blog/**")
////                .excludePathPatterns("/blogCategory/**")
////                .excludePathPatterns("/updateLog/**")
////                .excludePathPatterns("/error")
//                .excludePathPatterns("");    // 拦截所有请求，通过判断是否有 @LoginRequired 注解 决定是否需要登录
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html#")
                .addResourceLocations("classpath:/META-INF/resources/");
    }


    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**")
                //设置允许跨域请求的域名
                .allowedOriginPatterns("*")
                //是否允许证书 不再默认开启
                .allowCredentials(true)
                //设置允许的方法
                .allowedMethods("*")
                //跨域允许时间
                .maxAge(3600);
    }
}
