package com.zhou.shop.apply.controller;

import cn.dev33.satoken.annotation.SaCheckRole;
import com.zhou.shop.api.entity.UpdateLog;
import com.zhou.shop.apiServer.service.IUpdateLogService;
import com.zhou.shop.common.RestObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 前端控制器
 *
 * @author 周雄
 * @since 2021-07-24
 */
@RestController
@RequestMapping("/updateLog")
@Api(tags = "更新日志")
public class UpdateLogController {

    final IUpdateLogService iUpdateLogService;

    public UpdateLogController(IUpdateLogService iUpdateLogService) {
        this.iUpdateLogService = iUpdateLogService;
    }

    @SaCheckRole("superAdmin")
    @ApiOperation("新增更新日志")
    @PostMapping("/createUpdateLog")
    public RestObject<String> createUpdateLog(@RequestBody UpdateLog updateLog) {
        return iUpdateLogService.createUpdateLog(updateLog);
    }

    @ApiOperation("按id查询更新日志")
    @GetMapping("/retrieveByUpdateLogId/{updateLogId}")
    public RestObject<UpdateLog> retrieveByUpdateId(@PathVariable Integer updateLogId) {
        return iUpdateLogService.retrieveByUpdateId(updateLogId);
    }

    @ApiOperation("查询全部更新日志信息")
    @GetMapping("/retrieveAllUpdateLog")
    public RestObject<List<UpdateLog>> retrieveAllUpdateLog() {
        return iUpdateLogService.retrieveAllUpdateLog();
    }

    @SaCheckRole("superAdmin")
    @ApiOperation("按id修改更新日志")
    @PostMapping("/updateUpdateByUpdateLogId/{updateLogId}")
    public RestObject<String> updateUpdateByUpdateId(@PathVariable int updateLogId, @RequestBody UpdateLog updateLog) {
        return iUpdateLogService.updateUpdateByUpdateId(updateLogId,updateLog);
    }

    @SaCheckRole("superAdmin")
    @ApiOperation("按id删除更新日志")
    @PostMapping("/deleteByUpdateLogId/{updateLogId}")
    public RestObject<String> deleteUpdateById(@PathVariable int updateLogId) {
        return iUpdateLogService.deleteUpdateById(updateLogId);
    }
}
