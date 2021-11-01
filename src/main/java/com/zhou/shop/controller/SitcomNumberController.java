package com.zhou.shop.controller;

import com.zhou.shop.entity.SitcomNumber;
import com.zhou.shop.enums.LogStatus;
import com.zhou.shop.result.RestObject;
import com.zhou.shop.result.RestResponse;
import com.zhou.shop.service.ISitcomNumberService;
import com.zhou.shop.util.LogUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
    final LogUtil logUtil;

    public SitcomNumberController(ISitcomNumberService iSitcomNumberService, LogUtil logUtil) {
        this.iSitcomNumberService = iSitcomNumberService;
        this.logUtil = logUtil;
    }

    @ApiOperation("新增剧集")
    @PostMapping("/createSitcomNumber")
    public RestObject<String> createSitcomNumber(@RequestBody SitcomNumber sitcomNumber) {
        if (sitcomNumber.getSitcomNumberWatchTime() == null) {
            sitcomNumber.setSitcomNumberWatchTime(LocalDateTime.now());
        }
        boolean save = iSitcomNumberService.save(sitcomNumber);
        if (save) {
            logUtil.log("新增剧集成功", LogStatus.INFO.info);
            return RestResponse.makeOkRsp("新增成功！");
        } else {
            logUtil.log("新增剧集出现异常", LogStatus.ERROR.info);
            return RestResponse.makeErrRsp("新增失败！");
        }
    }

    @ApiOperation("按id查询剧集")
    @GetMapping("/retrieveBySitcomNumberId/{sitcomNumberId}")
    public RestObject<SitcomNumber> retrieveBySitcomNumberId(@PathVariable String sitcomNumberId) {
        SitcomNumber sitcomNumber = iSitcomNumberService.getById(sitcomNumberId);
        logUtil.log("查询了剧集信息，剧集ID：" + sitcomNumberId, LogStatus.INFO.info);
        return RestResponse.makeOkRsp(sitcomNumber);
    }

    @ApiOperation("查询全部剧集")
    @GetMapping("/retrieveAllSitcomNumber")
    public RestObject<List<SitcomNumber>> retrieveAllSitcomNumber() {
        List<SitcomNumber> list = iSitcomNumberService.list();
        logUtil.log("查询了全部剧集信息", LogStatus.INFO.info);
        return RestResponse.makeOkRsp(list);
    }

    @ApiOperation("按id修改剧集")
    @PostMapping("/updateSitcomNumberBySitcomNumberId/{sitcomNumberId}")
    public RestObject<String> updateSitcomNumberBySitcomNumberId(
            @PathVariable String sitcomNumberId, @RequestBody SitcomNumber sitcomNumber) {
        sitcomNumber.setSitcomNumberId(sitcomNumberId);
        boolean b = iSitcomNumberService.updateById(sitcomNumber);
        if (b) {
            logUtil.log("成功修改了剧集信息，剧集ID：" + sitcomNumberId, LogStatus.INFO.info);
            return RestResponse.makeOkRsp("修改成功！");
        } else {
            logUtil.log("修改剧集信息时失败，剧集ID：" + sitcomNumberId, LogStatus.ERROR.info);
            return RestResponse.makeErrRsp("修改失败！");
        }
    }

    @ApiOperation("按id删除剧集")
    @PostMapping("/deleteBySitcomNumberId/{sitcomNumberId}")
    public RestObject<String> deleteSitcomNumberById(@PathVariable String sitcomNumberId) {
        boolean b = iSitcomNumberService.removeById(sitcomNumberId);
        if (b) {
            logUtil.log("成功删除了剧集信息，剧集ID：" + sitcomNumberId, LogStatus.INFO.info);
            return RestResponse.makeOkRsp("删除成功！");
        } else {
            logUtil.log("删除剧集信息时失败，剧集ID：" + sitcomNumberId, LogStatus.ERROR.info);
            return RestResponse.makeErrRsp("删除失败！");
        }
    }

    @ApiOperation("按连续剧id查询剧集")
    @GetMapping("/retrieveBySitcomId/{sitcomId}")
    public RestObject<List<SitcomNumber>> retrieveBySitcomId(@PathVariable String sitcomId) {
        List<SitcomNumber> sitcomNumbers = iSitcomNumberService.retrieveBySitcomId(sitcomId);
        logUtil.log("查询了连续剧的全部剧集信息，连续剧ID：" + sitcomId, LogStatus.INFO.info);
        return RestResponse.makeOkRsp(sitcomNumbers);
    }

    @ApiOperation("按集名查询")
    @PostMapping("/retrieveBySitcomNumberName")
    public RestObject<List<SitcomNumber>> retrieveItemByItemName(
            @RequestBody SitcomNumber sitcomNumber) {
        List<SitcomNumber> list =
                iSitcomNumberService.retrieveBySitcomNumberName(sitcomNumber.getSitcomNumberName());
        logUtil.log("按剧集名查询了全部剧集信息，剧集名：" + sitcomNumber.getSitcomNumberName(), LogStatus.INFO.info);
        return RestResponse.makeOkRsp(list);
    }
}
