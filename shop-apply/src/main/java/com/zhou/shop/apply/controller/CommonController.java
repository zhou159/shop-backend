package com.zhou.shop.apply.controller;

import com.zhou.shop.common.RestObject;
import com.zhou.shop.common.RestResponse;
import com.zhou.shop.oss.minio.MinioUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 公共的接口
 *
 * @author 周雄
 * @date 2021年8月5日 21点26分
 */
@RestController
@RequestMapping("/common")
public class CommonController {
    private final MinioUtil minioUtil;

    public CommonController(MinioUtil minioUtil) {
        this.minioUtil = minioUtil;
    }

    @ApiOperation("上传图片")
    @PostMapping("/upload")
    public RestObject<String> upload(MultipartFile file) {
        String item = minioUtil.upload(file, "item");
        return RestResponse.makeOkRsp(item);
    }
}
