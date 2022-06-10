package com.zhou.shop.apply.controller;

import com.zhou.shop.api.entity.privates.Sitcom;
import com.zhou.shop.apiServer.service.ISitcomService;
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
@RequestMapping("/sitcom")
public class SitcomController {
    final ISitcomService iSitcomService;

    public SitcomController(ISitcomService iSitcomService) {
        this.iSitcomService = iSitcomService;
    }

    @ApiOperation("新增连续剧")
    @PostMapping("/createSitcom")
    public RestObject<String> createSitcom(@RequestBody Sitcom sitcom) {
        return iSitcomService.createSitcom(sitcom);
    }

    @ApiOperation("按id查询连续剧")
    @GetMapping("/retrieveBySitcomId/{sitcomId}")
    public RestObject<Sitcom> retrieveBySitcomId(@PathVariable String sitcomId) {
        return iSitcomService.retrieveBySitcomId(sitcomId);
    }

    @ApiOperation("查询全部连续剧")
    @GetMapping("/retrieveAllSitcom")
    public RestObject<List<Sitcom>> retrieveAllSitcom() {
        return iSitcomService.retrieveAllSitcom();
    }

    @ApiOperation("按id修改连续剧")
    @PostMapping("/updateSitcomBySitcomId/{sitcomId}")
    public RestObject<String> updateSitcomBySitcomId(@PathVariable String sitcomId, @RequestBody Sitcom sitcom) {
        return iSitcomService.updateSitcomBySitcomId(sitcomId, sitcom);
    }

    @ApiOperation("按id删除连续剧及其剧集")
    @PostMapping("/deleteBySitcomId/{sitcomId}")
    public RestObject<String> deleteSitcomById(@PathVariable String sitcomId) {
        return iSitcomService.deleteSitcomById(sitcomId);
    }
}
