package com.zhou.shop.controller;

import com.zhou.shop.entity.Sitcom;
import com.zhou.shop.result.RestObject;
import com.zhou.shop.result.RestResponse;
import com.zhou.shop.service.ISitcomService;
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

    public SitcomController(ISitcomService iSitcomService) {
        this.iSitcomService = iSitcomService;
    }

    @PostMapping("/createSitcom")
    public RestObject<String> createSitcom(@RequestBody Sitcom sitcom) {
        String updateStatusZero = "0";
        String watchStatusZero = "0";
        if ("".equals(sitcom.getSitcomWatchStartTime()) || sitcom.getSitcomWatchStartTime() == null){
            return RestResponse.makeErrRsp("连续剧开始观看时间不能为空");
        }
        if ("".equals(sitcom.getSitcomUpdateStatus()) || sitcom.getSitcomUpdateStatus() == null) {
            return RestResponse.makeErrRsp("连续剧更新状态不能为空");
        }
        if ("".equals(sitcom.getSitcomWatchStatus()) || sitcom.getSitcomWatchStatus() == null) {
            return RestResponse.makeErrRsp("连续剧观看状态不能为空");
        }
        if (!sitcom.getSitcomUpdateStatus().equals(updateStatusZero) && sitcom.getSitcomWatchStatus().equals(watchStatusZero)){
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
            return RestResponse.makeOkRsp("新增成功！");
        } else {
            return RestResponse.makeErrRsp("新增成功！");
        }
    }

    @GetMapping("/retrieveBySitcomId/{sitcomId}")
    public RestObject<Sitcom> retrieveBySitcomId(@PathVariable String sitcomId) {
        Sitcom sitcom = iSitcomService.getById(sitcomId);
        return RestResponse.makeOkRsp(sitcom);
    }

    @GetMapping("/retrieveAllSitcom")
    public RestObject<List<Sitcom>> retrieveAllSitcom() {
        List<Sitcom> list = iSitcomService.list();
        return RestResponse.makeOkRsp(list);
    }

    @PostMapping("/updateSitcomBySitcomId/{sitcomId}")
    public RestObject<String> updateSitcomBySitcomId(
            @PathVariable String sitcomId, @RequestBody Sitcom sitcom) {
        sitcom.setSitcomId(sitcomId);
        String updateStatusZero = "0";
        String watchStatusZero = "0";
        String watchEndTime = sitcom.getSitcomWatchEndTime().toString();
        if ("".equals(sitcom.getSitcomUpdateStatus()) || sitcom.getSitcomUpdateStatus() == null) {
            return RestResponse.makeErrRsp("连续剧更新状态不能为空");
        }
        if ("".equals(sitcom.getSitcomWatchStatus()) || sitcom.getSitcomWatchStatus() == null) {
            return RestResponse.makeErrRsp("连续剧观看状态不能为空");
        }
        if (!sitcom.getSitcomUpdateStatus().equals(updateStatusZero) && sitcom.getSitcomWatchStatus().equals(watchStatusZero)){
            return RestResponse.makeErrRsp("连续剧还未完结，不可能看完的哦！");
        }
//        if(!sitcom.getSitcomUpdateStatus().equals(updateStatusZero)) {
//            sitcom.setSitcomWatchEndTime(null);
//        }
        boolean b = iSitcomService.updateById(sitcom);
        if (b) {
            return RestResponse.makeOkRsp("修改成功！");
        } else {
            return RestResponse.makeErrRsp("修改失败！");
        }
    }

    @PostMapping("/deleteBySitcomId/{sitcomId}")
    public RestObject<String> deleteSitcomById(@PathVariable String sitcomId) {
        boolean b = iSitcomService.removeById(sitcomId);
        if (b) {
            return RestResponse.makeOkRsp("删除成功！");
        } else {
            return RestResponse.makeErrRsp("删除失败！");
        }
    }
}
