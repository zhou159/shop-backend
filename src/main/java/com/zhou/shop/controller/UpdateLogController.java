package com.zhou.shop.controller;

import com.zhou.shop.entity.UpdateLog;
import com.zhou.shop.result.RestObject;
import com.zhou.shop.result.RestResponse;
import com.zhou.shop.service.IUpdateLogService;
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

    public UpdateLogController(IUpdateLogService iUpdateLogService) {
        this.iUpdateLogService = iUpdateLogService;
    }

    @PostMapping("/createUpdateLog")
    public RestObject<String> createUpdateLog(@RequestBody UpdateLog updateLog) {
        updateLog.setUpdateLogCreateTime(LocalDate.now());
        boolean save = iUpdateLogService.save(updateLog);
        if (save) {
            return RestResponse.makeOkRsp("新增成功！");
        } else {
            return RestResponse.makeErrRsp("新增成功！");
        }
    }

    @GetMapping("/retrieveByUpdateLogId/{updateLogId}")
    public RestObject<UpdateLog> retrieveByUpdateId(@PathVariable int updateLogId) {
        UpdateLog updateLog = iUpdateLogService.getById(updateLogId);
        return RestResponse.makeOkRsp(updateLog);
    }

    @GetMapping("/retrieveAllUpdateLog")
    public RestObject<List<UpdateLog>> retrieveAllUpdateLog() {
        List<UpdateLog> list = iUpdateLogService.list();
        return RestResponse.makeOkRsp(list);
    }

    @PostMapping("/updateUpdateByUpdateLogId/{updateLogId}")
    public RestObject<String> updateUpdateByUpdateId(
            @PathVariable int updateLogId, @RequestBody UpdateLog updateLog) {
        updateLog.setUpdateLogId(updateLogId);
        boolean b = iUpdateLogService.updateById(updateLog);
        if (b) {
            return RestResponse.makeOkRsp("修改成功！");
        } else {
            return RestResponse.makeErrRsp("修改失败！");
        }
    }

    @PostMapping("/deleteByUpdateLogId/{updateLogId}")
    public RestObject<String> deleteUpdateById(@PathVariable int updateLogId) {
        boolean b = iUpdateLogService.removeById(updateLogId);
        if (b) {
            return RestResponse.makeOkRsp("删除成功！");
        } else {
            return RestResponse.makeErrRsp("删除失败！");
        }
    }
}
