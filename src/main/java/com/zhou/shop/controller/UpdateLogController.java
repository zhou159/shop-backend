package com.zhou.shop.controller;

import com.zhou.shop.entity.UpdateLog;
import com.zhou.shop.result.RestObject;
import com.zhou.shop.result.RestResponse;
import com.zhou.shop.service.IUpdateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 周雄
 * @since 2021-07-24
 */
@RestController
@RequestMapping("/updateLog")
public class UpdateLogController {

    @Autowired
    IUpdateLogService iUpdateLogService;

    @PostMapping("/createUpdateLog")
    public RestObject<String> createUpdateLog(@RequestBody UpdateLog updateLog){
        updateLog.setUpdateLogCreateTime(LocalDate.now());
        boolean save = iUpdateLogService.save(updateLog);
        if (save){
            return RestResponse.makeOKRsp("新增成功！");
        }else {
            return RestResponse.makeErrRsp("新增成功！");
        }
    }

    @GetMapping("/retrieveByUpdateLogId/{updateLogId}")
    public RestObject<UpdateLog> retrieveByUpdateId(@PathVariable int updateLogId){
        UpdateLog updateLog = iUpdateLogService.getById(updateLogId);
        return RestResponse.makeOKRsp(updateLog);
    }

    @GetMapping("/retrieveAllUpdateLog")
    public RestObject<List<UpdateLog>> retrieveAllUpdateLog (){
        List<UpdateLog> list = iUpdateLogService.list();
        return RestResponse.makeOKRsp(list);
    }

    @PostMapping("/updateUpdateByUpdateLogId/{updateLogId}")
    public RestObject<String> updateUpdateByUpdateId(@PathVariable int updateLogId,@RequestBody UpdateLog updateLog){
        updateLog.setUpdateLogId(updateLogId);
        updateLog.setUpdateLogCreateTime(LocalDate.now());
        boolean b = iUpdateLogService.updateById(updateLog);
        if (b){
            return RestResponse.makeOKRsp("修改成功！");
        }else {
            return RestResponse.makeErrRsp("修改失败！");
        }
    }

    @PostMapping("/deleteByUpdateLogId/{updateLogId}")
    public RestObject<String> deleteUpdateById(@PathVariable int updateLogId){
        boolean b = iUpdateLogService.removeById(updateLogId);
        if (b){
            return RestResponse.makeOKRsp("删除成功！");
        }else {
            return RestResponse.makeErrRsp("删除失败！");
        }
    }





}
