package com.zhou.shop.apply.controller.privates;

import cn.dev33.satoken.annotation.SaCheckRole;
import com.zhou.shop.api.dto.SitcomDTO;
import com.zhou.shop.api.entity.privates.Sitcom;
import com.zhou.shop.apiServer.service.privates.ISitcomService;
import com.zhou.shop.common.RestObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * 前端控制器
 *
 * @author 周雄
 * @since 2021-08-21
 */
@SaCheckRole("superAdmin")
@RestController
@RequestMapping("/sitcom")
@Api(tags = "连续剧")
public class SitcomController {
    final ISitcomService iSitcomService;

    public SitcomController(ISitcomService iSitcomService) {
        this.iSitcomService = iSitcomService;
    }

    @ApiOperation("新增连续剧")
    @PostMapping("/createSitcom")
    public RestObject<String> createSitcom(@Valid @RequestBody Sitcom sitcom) {
        return iSitcomService.createSitcom(sitcom);
    }

    @ApiOperation("按id查询连续剧")
    @GetMapping("/retrieveBySitcomId/{sitcomId}")
    public RestObject<SitcomDTO> retrieveBySitcomId(@PathVariable String sitcomId) {
        return iSitcomService.retrieveBySitcomId(sitcomId);
    }

    @ApiOperation("查询全部连续剧")
    @GetMapping("/retrieveAllSitcom/{userId}")
    public RestObject<List<SitcomDTO>> retrieveAllSitcom(@PathVariable("userId")String userId) {
        return iSitcomService.retrieveAllSitcom(userId);
    }

    @ApiOperation("按id修改连续剧")
    @PostMapping("/updateSitcomBySitcomId")
    public RestObject<String> updateSitcomBySitcomId(@RequestBody Sitcom sitcom) {
        return iSitcomService.updateSitcomBySitcomId(sitcom);
    }

    @ApiOperation("按id删除连续剧及其剧集")
    @PostMapping("/deleteBySitcomId/{sitcomId}")
    public RestObject<String> deleteSitcomById(@PathVariable String sitcomId) {
        return iSitcomService.deleteSitcomById(sitcomId);
    }
}
