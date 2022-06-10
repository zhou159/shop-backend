package com.zhou.shop.apply.controller.privates;

import com.zhou.shop.api.entity.privates.SitcomNumber;
import com.zhou.shop.apiServer.service.privates.ISitcomNumberService;
import com.zhou.shop.apiServer.service.privates.ISitcomService;
import com.zhou.shop.common.RestObject;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 前端控制器
 *
 * @author 周雄
 * @since 2021-08-21
 */
@RestController
@RequestMapping("/sitcomNumber")
public class SitcomNumberController {
    final ISitcomNumberService iSitcomNumberService;
    final ISitcomService iSitcomService;

    public SitcomNumberController(
            ISitcomNumberService iSitcomNumberService, ISitcomService iSitcomService) {
        this.iSitcomNumberService = iSitcomNumberService;
        this.iSitcomService = iSitcomService;
    }

    @ApiOperation("新增剧集")
    @PostMapping("/createSitcomNumber")
    public RestObject<String> createSitcomNumber(@RequestBody SitcomNumber sitcomNumber) {
        return iSitcomNumberService.createSitcomNumber(sitcomNumber);
    }

    @ApiOperation("快速新增剧集")
    @PostMapping("/createSitcomNumberFast")
    public RestObject<String> createSitcomNumberFast(@RequestBody SitcomNumber sitcomNumber) {
        return iSitcomNumberService.createSitcomNumberFast(sitcomNumber);
    }

    @ApiOperation("按id查询剧集")
    @GetMapping("/retrieveBySitcomNumberId/{sitcomNumberId}")
    public RestObject<SitcomNumber> retrieveBySitcomNumberId(@PathVariable String sitcomNumberId) {
        return iSitcomNumberService.retrieveBySitcomNumberId(sitcomNumberId);
    }

    @ApiOperation("查询全部剧集")
    @GetMapping("/retrieveAllSitcomNumber")
    public RestObject<List<SitcomNumber>> retrieveAllSitcomNumber() {
        return iSitcomNumberService.retrieveAllSitcomNumber();
    }

    @ApiOperation("按id修改剧集")
    @PostMapping("/updateSitcomNumberBySitcomNumberId/{sitcomNumberId}")
    public RestObject<String> updateSitcomNumberBySitcomNumberId(
            @PathVariable String sitcomNumberId, @RequestBody SitcomNumber sitcomNumber) {
        return iSitcomNumberService.updateSitcomNumberBySitcomNumberId(
                sitcomNumberId, sitcomNumber);
    }

    @ApiOperation("按id删除剧集")
    @PostMapping("/deleteBySitcomNumberId/{sitcomNumberId}")
    public RestObject<String> deleteSitcomNumberById(@PathVariable String sitcomNumberId) {
        return iSitcomNumberService.deleteSitcomNumberById(sitcomNumberId);
    }

    @ApiOperation("按连续剧id查询剧集")
    @GetMapping("/retrieveBySitcomId/{sitcomId}")
    public RestObject<List<SitcomNumber>> retrieveBySitcomId(@PathVariable String sitcomId) {
        return iSitcomNumberService.retrieveBySitcomId(sitcomId);
    }

    @ApiOperation("按集名查询")
    @PostMapping("/retrieveBySitcomNumberName")
    public RestObject<List<SitcomNumber>> retrieveItemByItemName(
            @RequestBody SitcomNumber sitcomNumber) {
        return iSitcomNumberService.retrieveBySitcomNumberName(
                sitcomNumber.getSitcomNumberName(), sitcomNumber.getSitcomId());
    }
}
