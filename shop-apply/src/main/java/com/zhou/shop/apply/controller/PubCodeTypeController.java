package com.zhou.shop.apply.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import com.zhou.shop.api.entity.PubCode;
import com.zhou.shop.api.entity.PubCodeType;
import com.zhou.shop.apiServer.service.IPubCodeTypeService;
import com.zhou.shop.common.RestObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation("查询全部码表类别信息")
    @GetMapping("/retrieveAllPubCodeType")
    public RestObject<List<PubCodeType>> retrieveAllPubCodeType(){
        return pubCodeTypeService.getAllPubCodeType();
    }

    @ApiOperation("新增码表类别信息")
    @PostMapping("/createPubCodeType")
    public RestObject<String> createPubCodeType(@RequestBody PubCodeType pubCodeType){
        return pubCodeTypeService.createPubCodeType(pubCodeType);
    }

    @ApiOperation("修改码表类别信息")
    @PostMapping("/updatePubCodeType")
    public RestObject<String> updatePubCodeType(@RequestBody PubCodeType pubCodeType){
        return pubCodeTypeService.updatePubCodeType(pubCodeType);
    }

    @ApiOperation("删除码表类别信息")
    @PostMapping("/deletePubCodeType")
    public RestObject<String> deletePubCodeType(@RequestBody PubCodeType pubCodeType){
        return pubCodeTypeService.deletePubCodeType(pubCodeType);
    }

    @ApiOperation("修改码表类别状态")
    @GetMapping("/updatePubCodeTypeStatus")
    public RestObject<String> updatePubCodeTypeStatus(String pubCodeTypeId, Integer status){
        return pubCodeTypeService.updateStatus(pubCodeTypeId,status);
    }

    @ApiOperation("根据码表类别查询码表")
    @GetMapping("/retrievePubCodeByType")
    public RestObject<List<PubCode>> retrievePubCodeByType(String pubCodeTypeId){
        return pubCodeTypeService.retrievePubCodeByTypeId(pubCodeTypeId);
    }
}
