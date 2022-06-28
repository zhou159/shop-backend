package com.zhou.shop.apply.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import cn.dev33.satoken.annotation.SaMode;
import com.zhou.shop.api.entity.Flag;
import com.zhou.shop.apiServer.service.IFlagService;
import com.zhou.shop.common.RestObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 前端控制器
 *
 * @author 周雄
 * @since 2021-06-24
 */
@RestController
@RequestMapping("/flag")
@Api(tags = "标签")
public class FlagController {
    private final IFlagService iFlagService;

    public FlagController(IFlagService iFlagService) {
        this.iFlagService = iFlagService;
    }

    @SaCheckRole(value = {"superAdmin","admin"} ,mode = SaMode.OR)
    @ApiOperation("新增标签")
    @PostMapping("/createFlag")
    public RestObject<String> createFlag(@RequestBody Flag flag) {
        return iFlagService.createFlag(flag);
    }

    @ApiOperation("按id查询标签")
    @GetMapping("/retrieveByFlagId/{flagId}")
    public RestObject<Flag> retrieveByFlagId(@PathVariable String flagId) {
        return iFlagService.retrieveByFlagId(flagId);
    }

    @ApiOperation("查询全部标签")
    @GetMapping("/retrieveAllFlag")
    public RestObject<List<Flag>> retrieveAllFlag() {
        return iFlagService.retrieveAllFlag();
    }

    @SaCheckRole(value = {"superAdmin","admin"} ,mode = SaMode.OR)
    @ApiOperation("按id修改标签")
    @PostMapping("/updateFlagByFlagId/{flagId}")
    public RestObject<String> updateFlagByFlagId(@PathVariable String flagId, @RequestBody Flag flag) {
        return iFlagService.updateFlagByFlagId(flagId, flag);
    }

    @SaCheckRole(value = {"superAdmin","admin"} ,mode = SaMode.OR)
    @ApiOperation("按id删除标签")
    @PostMapping("/deleteByFlagId/{flagId}")
    public RestObject<String> deleteFlagById(@PathVariable String flagId) {
        return iFlagService.deleteFlagById(flagId);
    }
}
