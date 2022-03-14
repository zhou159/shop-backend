package com.zhou.shop.controller;

import com.zhou.shop.entity.Sitcom;
import com.zhou.shop.enums.LogStatus;
import com.zhou.shop.result.RestObject;
import com.zhou.shop.result.RestResponse;
import com.zhou.shop.service.ISitcomNumberService;
import com.zhou.shop.service.ISitcomService;
import com.zhou.shop.util.LogUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * 前端控制器
 *
 * @author 周雄
 * @since 2021-08-21
 */
@RestController
@RequestMapping("/sitcom")
public class SitcomController {
    final ISitcomService iSitcomService;
    final ISitcomNumberService iSitcomNumberService;
    final LogUtil logUtil;

    String updateStatusZero = "0";
    String watchStatusZero = "0";

    public SitcomController(ISitcomService iSitcomService, LogUtil logUtil, ISitcomNumberService iSitcomNumberService) {
        this.iSitcomService = iSitcomService;
        this.logUtil = logUtil;
        this.iSitcomNumberService = iSitcomNumberService;
    }

    @ApiOperation("新增连续剧")
    @PostMapping("/createSitcom")
    public RestObject<String> createSitcom(@RequestBody Sitcom sitcom) {
        if ("".equals(sitcom.getSitcomUpdateStatus()) || sitcom.getSitcomUpdateStatus() == null) {
            return RestResponse.makeErrRsp("连续剧更新状态不能为空");
        }
        if ("".equals(sitcom.getSitcomWatchStatus()) || sitcom.getSitcomWatchStatus() == null) {
            return RestResponse.makeErrRsp("连续剧观看状态不能为空");
        }
        if (!sitcom.getSitcomUpdateStatus().equals(updateStatusZero)
                && sitcom.getSitcomWatchStatus().equals(watchStatusZero)) {
            return RestResponse.makeErrRsp("连续剧还未完结，不可能看完的哦！");
        }
        sitcom.setSitcomId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
        sitcom.setSitcomWatchStartTime(
                (sitcom.getSitcomWatchStartTime() == null
                                || "".equals(sitcom.getSitcomWatchStartTime().toString()))
                        ? LocalDate.now()
                        : sitcom.getSitcomWatchStartTime());
        boolean save = iSitcomService.save(sitcom);
        if (save) {
            logUtil.log("新增连续剧成功", LogStatus.INFO.info);
            return RestResponse.makeOkRsp("新增成功！");
        }
        logUtil.log("新增连续剧出现异常", LogStatus.ERROR.info);
        return RestResponse.makeErrRsp("新增成功！");
    }

    @ApiOperation("按id查询连续剧")
    @GetMapping("/retrieveBySitcomId/{sitcomId}")
    public RestObject<Sitcom> retrieveBySitcomId(@PathVariable String sitcomId) {
        Sitcom sitcom = iSitcomService.getById(sitcomId);
        /* logUtil.log("查询了连续剧信息，连续剧ID：" + sitcomId, LogStatus.INFO.info); */
        return RestResponse.makeOkRsp(sitcom);
    }

    @ApiOperation("查询全部连续剧")
    @GetMapping("/retrieveAllSitcom")
    public RestObject<List<Sitcom>> retrieveAllSitcom() {
        List<Sitcom> list = iSitcomService.list();
        /* logUtil.log("查询了全部连续剧信息", LogStatus.INFO.info); */
        return RestResponse.makeOkRsp(list);
    }

    @ApiOperation("按id修改连续剧")
    @PostMapping("/updateSitcomBySitcomId/{sitcomId}")
    public RestObject<String> updateSitcomBySitcomId(@PathVariable String sitcomId, @RequestBody Sitcom sitcom) {
        sitcom.setSitcomId(sitcomId);
        if ("".equals(sitcom.getSitcomUpdateStatus()) || sitcom.getSitcomUpdateStatus() == null) {
            return RestResponse.makeErrRsp("连续剧更新状态不能为空");
        }
        if ("".equals(sitcom.getSitcomWatchStatus()) || sitcom.getSitcomWatchStatus() == null) {
            return RestResponse.makeErrRsp("连续剧观看状态不能为空");
        }
        if (!sitcom.getSitcomUpdateStatus().equals(updateStatusZero)
                && sitcom.getSitcomWatchStatus().equals(watchStatusZero)) {
            return RestResponse.makeErrRsp("连续剧还未完结，不可能看完的哦！");
        }
        boolean b = iSitcomService.updateById(sitcom);
        if (b) {
            logUtil.log("成功修改了连续剧信息，连续剧ID：" + sitcomId, LogStatus.INFO.info);
            return RestResponse.makeOkRsp("修改成功！");
        }
        logUtil.log("修改连续剧信息时失败，连续剧ID：" + sitcomId, LogStatus.ERROR.info);
        return RestResponse.makeErrRsp("修改失败！");
    }

    @ApiOperation("按id删除连续剧及其剧集")
    @PostMapping("/deleteBySitcomId/{sitcomId}")
    public RestObject<String> deleteSitcomById(@PathVariable String sitcomId) {
        boolean b = iSitcomService.removeById(sitcomId);
        int i = iSitcomNumberService.deleteBySitcomId(sitcomId);
        if (b && i != 0) {
            logUtil.log("成功删除了连续剧及其剧集信息，连续剧ID：" + sitcomId, LogStatus.INFO.info);
            return RestResponse.makeOkRsp("删除成功！");
        }
        logUtil.log("删除连续剧信息及其剧集时失败，连续剧ID：" + sitcomId, LogStatus.ERROR.info);
        return RestResponse.makeErrRsp("删除失败！");
    }
}
