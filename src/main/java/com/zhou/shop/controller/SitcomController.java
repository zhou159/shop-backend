package com.zhou.shop.controller;

import com.zhou.shop.entity.Sitcom;
import com.zhou.shop.result.RestObject;
import com.zhou.shop.result.RestResponse;
import com.zhou.shop.service.ISitcomService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 周雄
 * @since 2021-08-21
 */
@RestController
@RequestMapping("/sitcom")
public class SitcomController {
    final ISitcomService iSitcomService;

    public SitcomController(ISitcomService iSitcomService) {
        this.iSitcomService = iSitcomService;
    }

    @PostMapping("/createSitcom")
    public RestObject<String> createSitcom(@RequestBody Sitcom sitcom) {
        sitcom.setSitcomId(UUID.randomUUID().toString().replace("-","").toUpperCase());
        sitcom.setSitcomWatchStartTime(LocalDate.now());
        boolean save = iSitcomService.save(sitcom);
        if (save) {
            return RestResponse.makeOkRsp("新增成功！");
        } else {
            return RestResponse.makeErrRsp("新增成功！");
        }
    }

    @GetMapping("/retrieveBySitcomId/{sitcomId}")
    public RestObject<Sitcom> retrieveBySitcomId(@PathVariable String sitcomId) {
        Sitcom sitcom = iSitcomService.getById(sitcomId);
        return RestResponse.makeOkRsp(sitcom);
    }

    @GetMapping("/retrieveAllSitcom")
    public RestObject<List<Sitcom>> retrieveAllSitcom() {
        List<Sitcom> list = iSitcomService.list();
        return RestResponse.makeOkRsp(list);
    }

    @PostMapping("/updateSitcomBySitcomId/{sitcomId}")
    public RestObject<String> updateSitcomBySitcomId(@PathVariable String sitcomId, @RequestBody Sitcom sitcom) {
        sitcom.setSitcomId(sitcomId);
        boolean b = iSitcomService.updateById(sitcom);
        if (b) {
            return RestResponse.makeOkRsp("修改成功！");
        } else {
            return RestResponse.makeErrRsp("修改失败！");
        }
    }

    @PostMapping("/deleteBySitcomId/{sitcomId}")
    public RestObject<String> deleteSitcomById(@PathVariable String sitcomId) {
        boolean b = iSitcomService.removeById(sitcomId);
        if (b) {
            return RestResponse.makeOkRsp("删除成功！");
        } else {
            return RestResponse.makeErrRsp("删除失败！");
        }
    }
}
