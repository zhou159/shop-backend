package com.zhou.shop.controller;

import com.zhou.shop.entity.SitcomNumber;
import com.zhou.shop.result.RestObject;
import com.zhou.shop.result.RestResponse;
import com.zhou.shop.service.ISitcomNumberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * 前端控制器
 *
 * @author 周雄
 * @since 2021-08-21
 */
@RestController
@RequestMapping("/sitcomNumber")
public class SitcomNumberController {
    final ISitcomNumberService iSitcomNumberService;

    public SitcomNumberController(ISitcomNumberService iSitcomNumberService) {
        this.iSitcomNumberService = iSitcomNumberService;
    }

    @PostMapping("/createSitcomNumber")
    public RestObject<String> createSitcomNumber(@RequestBody SitcomNumber sitcomNumber) {
        sitcomNumber.setSitcomNumberId(UUID.randomUUID().toString().replace("-", "").toUpperCase());
        boolean save = iSitcomNumberService.save(sitcomNumber);
        if (save) {
            return RestResponse.makeOkRsp("新增成功！");
        } else {
            return RestResponse.makeErrRsp("新增成功！");
        }
    }

    @GetMapping("/retrieveBySitcomNumberId/{sitcomNumberId}")
    public RestObject<SitcomNumber> retrieveBySitcomNumberId(@PathVariable String sitcomNumberId) {
        SitcomNumber sitcomNumber = iSitcomNumberService.getById(sitcomNumberId);
        return RestResponse.makeOkRsp(sitcomNumber);
    }

    @GetMapping("/retrieveAllSitcomNumber")
    public RestObject<List<SitcomNumber>> retrieveAllSitcomNumber() {
        List<SitcomNumber> list = iSitcomNumberService.list();
        return RestResponse.makeOkRsp(list);
    }

    @PostMapping("/updateSitcomNumberBySitcomNumberId/{sitcomNumberId}")
    public RestObject<String> updateSitcomNumberBySitcomNumberId(
            @PathVariable String sitcomNumberId, @RequestBody SitcomNumber sitcomNumber) {
        sitcomNumber.setSitcomId(sitcomNumberId);
        boolean b = iSitcomNumberService.updateById(sitcomNumber);
        if (b) {
            return RestResponse.makeOkRsp("修改成功！");
        } else {
            return RestResponse.makeErrRsp("修改失败！");
        }
    }

    @PostMapping("/deleteBySitcomNumberId/{sitcomNumberId}")
    public RestObject<String> deleteSitcomNumberById(@PathVariable String sitcomNumberId) {
        boolean b = iSitcomNumberService.removeById(sitcomNumberId);
        if (b) {
            return RestResponse.makeOkRsp("删除成功！");
        } else {
            return RestResponse.makeErrRsp("删除失败！");
        }
    }

    @GetMapping("/retrieveBySitcomId/{sitcomId}")
    public RestObject<List<SitcomNumber>> retrieveBySitcomId(@PathVariable String sitcomId) {
        List<SitcomNumber> sitcomNumbers = iSitcomNumberService.retrieveBySitcomId(sitcomId);
        return RestResponse.makeOkRsp(sitcomNumbers);
    }
}
