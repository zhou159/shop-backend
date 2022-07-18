package com.zhou.shop.apply.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import com.zhou.shop.api.entity.PubCodeType;
import com.zhou.shop.apiServer.service.IPubCodeTypeService;
import com.zhou.shop.common.RestObject;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author zhouxiong
 * @version v0.1
 * @since 2022/7/18 15:23
 */
@SaCheckRole("superAdmin")
@RestController
@RequestMapping("/pubCodeType")
@Api(tags = "码表类别")
public class PubCodeTypeController {
    private final IPubCodeTypeService pubCodeTypeService;

    public PubCodeTypeController(IPubCodeTypeService pubCodeTypeService) {
        this.pubCodeTypeService = pubCodeTypeService;
    }

    @GetMapping("/retrieveAllPubCodeType")
    public RestObject<List<PubCodeType>> retrieveAllPubCodeType(){
        return pubCodeTypeService.getAllPubCodeType();
    }

    @PostMapping("/createPubCodeType")
    public RestObject<String> createPubCodeType(@RequestBody PubCodeType pubCodeType){
        return pubCodeTypeService.createPubCodeType(pubCodeType);
    }
}
