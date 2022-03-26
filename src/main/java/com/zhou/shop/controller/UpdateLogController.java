package com.zhou.shop.controller;

import com.zhou.shop.entity.UpdateLog;
import com.zhou.shop.enums.LogStatus;
import com.zhou.shop.result.RestObject;
import com.zhou.shop.result.RestResponse;
import com.zhou.shop.service.IUpdateLogService;
import com.zhou.shop.util.LogUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
        LocalDate updateLogCreateTime = updateLog.getUpdateLogCreateTime();
        if (updateLogCreateTime == null) {
            updateLog.setUpdateLogCreateTime(LocalDate.now());
        }
        boolean save = iUpdateLogService.save(updateLog);
        if (save) {
            logUtil.log("新增更新日志成功", LogStatus.INFO.info);
            return RestResponse.makeOkRsp("新增成功！");
        }
        logUtil.log("新增更新日志出现异常", LogStatus.INFO.info);
        return RestResponse.makeErrRsp("新增失败！");
    }

    @ApiOperation("按id查询更新日志")
    @GetMapping("/retrieveByUpdateLogId/{updateLogId}")
    public RestObject<UpdateLog> retrieveByUpdateId(@PathVariable int updateLogId) {
        UpdateLog updateLog = iUpdateLogService.getById(updateLogId);
        logUtil.log("查询了更新日志信息，更新日志ID：" + updateLogId, LogStatus.INFO.info);
        return RestResponse.makeOkRsp(updateLog);
    }

    @ApiOperation("查询全部更新日志信息")
    @GetMapping("/retrieveAllUpdateLog")
    public RestObject<List<UpdateLog>> retrieveAllUpdateLog() {
        List<UpdateLog> list = iUpdateLogService.list();
        return RestResponse.makeOkRsp(list);
    }

    @ApiOperation("按id修改更新日志")
    @PostMapping("/updateUpdateByUpdateLogId/{updateLogId}")
    public RestObject<String> updateUpdateByUpdateId(@PathVariable int updateLogId, @RequestBody UpdateLog updateLog) {
        updateLog.setUpdateLogId(updateLogId);
        boolean b = iUpdateLogService.updateById(updateLog);
        if (b) {
            logUtil.log("成功修改了更新日志信息，更新日志ID：" + updateLogId, LogStatus.INFO.info);
            return RestResponse.makeOkRsp("修改成功！");
        }
        logUtil.log("修改更新日志信息时失败，更新日志ID：" + updateLogId, LogStatus.ERROR.info);
        return RestResponse.makeErrRsp("修改失败！");
    }

    @ApiOperation("按id删除更新日志")
    @PostMapping("/deleteByUpdateLogId/{updateLogId}")
    public RestObject<String> deleteUpdateById(@PathVariable int updateLogId) {
        boolean b = iUpdateLogService.removeById(updateLogId);
        if (b) {
            logUtil.log("成功删除了更新日志信息，更新日志ID：" + updateLogId, LogStatus.INFO.info);
            return RestResponse.makeOkRsp("删除成功！");
        }
        logUtil.log("删除更新日志信息时失败，更新日志ID：" + updateLogId, LogStatus.ERROR.info);
        return RestResponse.makeErrRsp("删除失败！");
    }
}
