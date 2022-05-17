package com.zhou.shop.controller;

import com.zhou.shop.entity.Flag;
import com.zhou.shop.result.RestObject;
import com.zhou.shop.service.IFlagService;
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
public class FlagController {
    private final IFlagService iFlagService;

    public FlagController(IFlagService iFlagService) {
        this.iFlagService = iFlagService;
    }

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

    @ApiOperation("按id修改标签")
    @PostMapping("/updateFlagByFlagId/{flagId}")
    public RestObject<String> updateFlagByFlagId(@PathVariable String flagId, @RequestBody Flag flag) {
        return iFlagService.updateFlagByFlagId(flagId, flag);
    }

    @ApiOperation("按id删除标签")
    @PostMapping("/deleteByFlagId/{flagId}")
    public RestObject<String> deleteFlagById(@PathVariable String flagId) {
        return iFlagService.deleteFlagById(flagId);
    }
}
