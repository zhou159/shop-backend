package com.zhou.shop.controller;

import com.zhou.shop.entity.Flag;
import com.zhou.shop.enums.LogStatus;
import com.zhou.shop.result.RestObject;
import com.zhou.shop.result.RestResponse;
import com.zhou.shop.service.IFlagService;
import com.zhou.shop.util.LogUtil;
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
    final LogUtil logUtil;
    final IFlagService iFlagService;

    public FlagController(IFlagService iFlagService, LogUtil logUtil) {
        this.iFlagService = iFlagService;
        this.logUtil = logUtil;
    }

    @ApiOperation("新增标签")
    @PostMapping("/createFlag")
    public RestObject<String> createFlag(@RequestBody Flag flag) {
        boolean save = iFlagService.save(flag);
        if (save) {
            logUtil.log("新增了一个标签", LogStatus.INFO.info);
            return RestResponse.makeOkRsp("新增成功！");
        }
        logUtil.log("新增标签出现异常", LogStatus.ERROR.info);
        return RestResponse.makeErrRsp("新增失败！");
    }

    @ApiOperation("按id查询标签")
    @GetMapping("/retrieveByFlagId/{flagId}")
    public RestObject<Flag> retrieveByFlagId(@PathVariable String flagId) {
        Flag flag = iFlagService.getById(flagId);
        return RestResponse.makeOkRsp(flag);
    }

    @ApiOperation("查询全部标签")
    @GetMapping("/retrieveAllFlag")
    public RestObject<List<Flag>> retrieveAllFlag() {
        List<Flag> list = iFlagService.list();
        return RestResponse.makeOkRsp(list);
    }

    @ApiOperation("按id修改标签")
    @PostMapping("/updateFlagByFlagId/{flagId}")
    public RestObject<String> updateFlagByFlagId(@PathVariable String flagId, @RequestBody Flag flag) {
        flag.setFlagId(flagId);
        boolean b = iFlagService.updateById(flag);
        if (b) {
            logUtil.log("成功修改了标签信息，标签ID：" + flagId, LogStatus.INFO.info);
            return RestResponse.makeOkRsp("修改成功！");
        }
        logUtil.log("修改标签信息时失败，标签ID：" + flagId, LogStatus.ERROR.info);
        return RestResponse.makeErrRsp("修改失败！");
    }

    @ApiOperation("按id删除标签")
    @PostMapping("/deleteByFlagId/{flagId}")
    public RestObject<String> deleteFlagById(@PathVariable String flagId) {
        boolean b = iFlagService.removeById(flagId);
        if (b) {
            logUtil.log("成功删除了标签信息，标签ID：" + flagId, LogStatus.INFO.info);
            return RestResponse.makeOkRsp("删除成功！");
        }
        logUtil.log("删除标签信息时失败，标签ID：" + flagId, LogStatus.ERROR.info);
        return RestResponse.makeErrRsp("删除失败！");
    }
}
