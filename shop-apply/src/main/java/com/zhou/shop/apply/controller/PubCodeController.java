package com.zhou.shop.apply.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import com.zhou.shop.api.entity.PubCode;
import com.zhou.shop.apiServer.service.IPubCodeService;
import com.zhou.shop.common.RestObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 周雄
 * @date 2022/5/17 18:28
 * @description
 */
@RestController
@RequestMapping("/pubCode")
@Api(tags = "码表")
public class PubCodeController {

    private final IPubCodeService ipubCodeService;

    public PubCodeController(IPubCodeService ipubCodeService) {
        this.ipubCodeService = ipubCodeService;
    }

    @ApiOperation("根据类别获取码表")
    @GetMapping("/retrievePubCodeByType/{pubCodeType}")
    public RestObject<List<PubCode>> retrievePubCodeByType(@PathVariable String pubCodeType) {
        return ipubCodeService.retrievePubCodeByType(pubCodeType);
    }

    @SaCheckRole("superAdmin")
    @ApiOperation("查询全部码表")
    @GetMapping("/retrieveAllPubCode")
    public RestObject<List<PubCode>> retrieveAllPubCode() {
        return ipubCodeService.retrieveAllPubCode();
    }

    @SaCheckRole("superAdmin")
    @ApiOperation("新增码表")
    @PostMapping ("/createPubCode")
    public RestObject<String> createPubCode(@RequestBody PubCode pubCode) {
        return ipubCodeService.createPubCode(pubCode);
    }

    @SaCheckRole("superAdmin")
    @ApiOperation("修改码表")
    @PostMapping("/updatePubCode")
    public RestObject<String> updatePubCode(@RequestBody PubCode pubCode) {
        return ipubCodeService.updatePubCode(pubCode);
    }

    @SaCheckRole("superAdmin")
    @ApiOperation("删除码表码表")
    @PostMapping("/deletePubCode/{pubCodeId}")
    public RestObject<String> deletePubCode(@PathVariable("pubCodeId") String pubCodeId) {
        return ipubCodeService.deletePubCode(pubCodeId);
    }
}
