package com.zhou.shop.apply.controller;

import com.zhou.shop.api.entity.Flag;
import com.zhou.shop.common.RestObject;
import com.zhou.shop.common.RestResponse;
import com.zhou.shop.oss.minio.MinioUtil;
import com.zhou.shop.oss.redis.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.condition.PatternsRequestCondition;
import org.springframework.web.servlet.mvc.condition.RequestMethodsRequestCondition;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 公共的接口
 *
 * @author 周雄
 * @date 2021年8月5日 21点26分
 */
@RestController
@RequestMapping("/common")
@Api(tags = "公共")
public class CommonController {
    private final MinioUtil minioUtil;
    private final RedisUtil redisUtil;

    public CommonController(MinioUtil minioUtil, RedisUtil redisUtil, RedisUtil redisUtil1) {
        this.minioUtil = minioUtil;
        this.redisUtil = redisUtil1;
    }

    @ApiOperation("文件上传")
    @PostMapping("/upload")
    public RestObject<String> upload(MultipartFile file) {
        return RestResponse.makeOkRsp(uploadFile(file, "item"));
    }

    @Autowired
    private WebApplicationContext applicationContext;



    public List getAllUrl() {
        RequestMappingHandlerMapping mapping = applicationContext.getBean(RequestMappingHandlerMapping.class);
        // 获取url与类和方法的对应信息
        Map<RequestMappingInfo, HandlerMethod> map = mapping.getHandlerMethods();

        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        for (Map.Entry<RequestMappingInfo, HandlerMethod> m : map.entrySet()) {
            Map<String, String> map1 = new HashMap<String, String>();
            RequestMappingInfo info = m.getKey();
            HandlerMethod method = m.getValue();
            //获取当前方法所在类名
            Class<?> bean = method.getBeanType();
            //使用反射获取当前类注解内容
            Api api = bean.getAnnotation(Api.class);
            RequestMapping requestMapping = bean.getAnnotation(RequestMapping.class);
            String[] value = requestMapping.value();
            map1.put("parent",value[0]);
            //获取方法上注解以及注解值
            ApiOperation methodAnnotation = method.getMethodAnnotation(ApiOperation.class);
            String privilegeName = methodAnnotation.notes();
            PatternsRequestCondition p = info.getPatternsCondition();
            for (String url : p.getPatterns()) {
                map1.put("url", url);
            }
            map1.put("className", method.getMethod().getDeclaringClass().getName()); // 类名
            map1.put("method", method.getMethod().getName()); // 方法名
            RequestMethodsRequestCondition methodsCondition = info.getMethodsCondition();
            for (RequestMethod requestMethod : methodsCondition.getMethods()) {
                map1.put("type", requestMethod.toString());
            }

            list.add(map1);
        }

        System.out.println(list);
        return list;
    }

    @ApiOperation("test")
    @PostMapping("/test")
    public RestObject<String> test(@RequestPart("file")MultipartFile file, @RequestPart("flag") Flag flag){
        final String item = uploadFile(file, "item");
        System.out.println(item);
        System.out.println(flag.toString());
        return RestResponse.makeOkRsp();
    }

    @ApiOperation("test")
    @GetMapping("/redisTest")
    public void RedisTest(){
        redisUtil.set("1","1");
    }

    private String uploadFile(MultipartFile file,String folderName){
        return minioUtil.upload(file, folderName);
    }

}
