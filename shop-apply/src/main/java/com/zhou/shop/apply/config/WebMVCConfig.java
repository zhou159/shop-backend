package com.zhou.shop.apply.config;

import cn.dev33.satoken.interceptor.SaAnnotationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
/**
 * web核心配置文件
 *
 * @author zhouxiong
 * @description:
 * @version: v1.0
 *           v2.0 2022/6/16 00:13 引入sa-token的拦截器
 * @since 2021/7/20 20:12
 */
@EnableWebMvc
@Configuration
public class WebMVCConfig implements WebMvcConfigurer {

    //    public UserLoginInterceptor authenticationInterceptor() {
    //        return new UserLoginInterceptor();
    //    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new SaAnnotationInterceptor())
                // 添加所有请求到拦截器
                .addPathPatterns("/**")
                .excludePathPatterns("/swagger-ui.html#/")
                .excludePathPatterns("/swagger-resources/**")
                .excludePathPatterns("/userLogin/verifyCode")
                .excludePathPatterns("/userLogin/login")
                .excludePathPatterns("/userLogin/uuid")
                .excludePathPatterns("/blog/**")
                .excludePathPatterns("/blogCategory/**")
                .excludePathPatterns("/updateLog/**")
                .excludePathPatterns("/error")
                // 拦截所有请求，与第二个类似，两者选其一，留在这是为了做个说明
                .excludePathPatterns("");
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
