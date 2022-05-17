package com.zhou.shop.controller;

import com.zhou.shop.entity.UpdateLog;
import com.zhou.shop.result.RestObject;
import com.zhou.shop.service.IUpdateLogService;
import com.zhou.shop.util.LogUtil;
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
public class UpdateLogController {

    final IUpdateLogService iUpdateLogService;
    final LogUtil logUtil;

    public UpdateLogController(IUpdateLogService iUpdateLogService, LogUtil logUtil) {
        this.iUpdateLogService = iUpdateLogService;
        this.logUtil = logUtil;
    }

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

    @ApiOperation("按id修改更新日志")
    @PostMapping("/updateUpdateByUpdateLogId/{updateLogId}")
    public RestObject<String> updateUpdateByUpdateId(@PathVariable int updateLogId, @RequestBody UpdateLog updateLog) {
        return iUpdateLogService.updateUpdateByUpdateId(updateLogId,updateLog);
    }

    @ApiOperation("按id删除更新日志")
    @PostMapping("/deleteByUpdateLogId/{updateLogId}")
    public RestObject<String> deleteUpdateById(@PathVariable int updateLogId) {
        return iUpdateLogService.deleteUpdateById(updateLogId);
    }
}
