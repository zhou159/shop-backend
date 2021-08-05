package com.zhou.shop.controller;

import com.zhou.shop.entity.Flag;
import com.zhou.shop.result.RestObject;
import com.zhou.shop.result.RestResponse;
import com.zhou.shop.service.IFlagService;
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

    final IFlagService iFlagService;

    public FlagController(IFlagService iFlagService) {
        this.iFlagService = iFlagService;
    }

    @PostMapping("/createFlag")
    public RestObject<String> createFlag(@RequestBody Flag flag) {
        boolean save = iFlagService.save(flag);
        if (save) {
            return RestResponse.makeOkRsp("新增成功！");
        } else {
            return RestResponse.makeErrRsp("新增成功！");
        }
    }

    @GetMapping("/retrieveByFlagId/{flagId}")
    public RestObject<Flag> retrieveByFlagId(@PathVariable int flagId) {
        Flag flag = iFlagService.getById(flagId);
        return RestResponse.makeOkRsp(flag);
    }

    @GetMapping("/retrieveAllFlag")
    public RestObject<List<Flag>> retrieveAllFlag() {
        List<Flag> list = iFlagService.list();
        return RestResponse.makeOkRsp(list);
    }

    @PostMapping("/updateFlagByFlagId/{flagId}")
    public RestObject<String> updateFlagByFlagId(@PathVariable int flagId, @RequestBody Flag flag) {
        flag.setFlagId(flagId);
        boolean b = iFlagService.updateById(flag);
        if (b) {
            return RestResponse.makeOkRsp("修改成功！");
        } else {
            return RestResponse.makeErrRsp("修改失败！");
        }
    }

    @PostMapping("/deleteByFlagId/{flagId}")
    public RestObject<String> deleteFlagById(@PathVariable int flagId) {
        boolean b = iFlagService.removeById(flagId);
        if (b) {
            return RestResponse.makeOkRsp("删除成功！");
        } else {
            return RestResponse.makeErrRsp("删除失败！");
        }
    }
}
