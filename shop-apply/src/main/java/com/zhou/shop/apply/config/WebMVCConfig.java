package com.zhou.shop.apply.config;

import cn.dev33.satoken.interceptor.SaRouteInterceptor;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import org.hibernate.validator.HibernateValidator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;
import org.springframework.validation.beanvalidation.SpringValidatorAdapter;
import org.springframework.web.servlet.config.annotation.*;

import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

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

    /*    public UserLoginInterceptor authenticationInterceptor() {
        return new UserLoginInterceptor();
    }*/

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(
                        new SaRouteInterceptor(
                                (req, res, handler) -> {
                                    SaRouter.match("/**")
                                            .notMatch(
                                                    "/userLogin/**",
                                                    "/blog/**",
                                                    "/blogCategory/**",
                                                    "/updateLog/**",
                                                    "/common/**",
                                                    "/error")
                                            .check(r -> StpUtil.checkLogin());

                                    SaRouter.match(
                                            "/item/**",
                                            r -> StpUtil.checkRoleOr("admin", "superAdmin"));

                                    SaRouter.match(
                                            "/user/retrieveAllUser",
                                            r -> StpUtil.checkPermission("连续剧"));

                                    // todo 拦截器将swagger也给拦截了，需待解决。
                                }))
                // 添加所有请求到拦截器
                .addPathPatterns("/**");
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

    // ========== valid验证配置 ==========
    @Bean
    public Validator validator() {
        ValidatorFactory validatorFactory =
                Validation.byProvider(HibernateValidator.class)
                        .configure()
                        // 快速失败(Fail Fast)模式，设置为true即可，如果想验证全部，则设置为false或者取消配置即可
                        .failFast(true)
                        .buildValidatorFactory();

        return validatorFactory.getValidator();
    }

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        MethodValidationPostProcessor postProcessor = new MethodValidationPostProcessor();
        postProcessor.setValidator(validator());
        return postProcessor;
    }

    /**
     * @return
     */
    @Override
    public org.springframework.validation.Validator getValidator() {
        return new SpringValidatorAdapter(validator());
    }
    // ============ end ==============
}
