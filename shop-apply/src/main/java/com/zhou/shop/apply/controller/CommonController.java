package com.zhou.shop.apply.controller;

import com.zhou.shop.api.entity.Flag;
import com.zhou.shop.common.RestObject;
import com.zhou.shop.common.RestResponse;
import com.zhou.shop.oss.minio.MinioUtil;
import com.zhou.shop.oss.redis.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
