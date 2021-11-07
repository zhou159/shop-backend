package com.zhou.shop.controller;

import com.zhou.shop.entity.Unit;
import com.zhou.shop.enums.LogStatus;
import com.zhou.shop.result.RestObject;
import com.zhou.shop.result.RestResponse;
import com.zhou.shop.service.IUnitService;
import com.zhou.shop.util.LogUtil;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 前端控制器
 *
 * @author 周雄
 * @since 2021-07-20
 */
@RestController
@RequestMapping("/unit")
public class UnitController {
    final IUnitService iUnitService;
    final LogUtil logUtil;

    public UnitController(IUnitService iUnitService, LogUtil logUtil) {
        this.iUnitService = iUnitService;
        this.logUtil = logUtil;
    }

    @ApiOperation("新增单位")
    @PostMapping("/createUnit")
    public RestObject<String> createUnit(@RequestBody Unit unit) {
        boolean save = iUnitService.save(unit);
        if (save) {
            logUtil.log("新增单位成功", LogStatus.INFO.info);
            return RestResponse.makeOkRsp("新增成功！");
        }
        logUtil.log("新增单位出现异常", LogStatus.ERROR.info);
        return RestResponse.makeErrRsp("新增失败！");
    }

    @ApiOperation("按id查询单位")
    @GetMapping("/retrieveByUnitId/{unitId}")
    public RestObject<Unit> retrieveByUnitId(@PathVariable String unitId) {
        Unit unit = iUnitService.getById(unitId);
        logUtil.log("查询了单位信息，单位ID：" + unitId, LogStatus.INFO.info);
        return RestResponse.makeOkRsp(unit);
    }

    @ApiOperation("查询全部单位")
    @GetMapping("/retrieveAllUnit")
    public RestObject<List<Unit>> retrieveAllUnit() {
        List<Unit> list = iUnitService.list();
        logUtil.log("查询了全部单位信息", LogStatus.INFO.info);
        return RestResponse.makeOkRsp(list);
    }

    @ApiOperation("按id修改单位")
    @PostMapping("/updateUnitByUnitId/{unitId}")
    public RestObject<String> updateUnitByUnitId(@PathVariable String unitId, @RequestBody Unit unit) {
        unit.setUnitId(unitId);
        boolean b = iUnitService.updateById(unit);
        if (b) {
            logUtil.log("成功修改了单位信息，单位ID：" + unitId, LogStatus.INFO.info);
            return RestResponse.makeOkRsp("修改成功！");
        }
        logUtil.log("修改单位信息时失败，单位ID：" + unitId, LogStatus.ERROR.info);
        return RestResponse.makeErrRsp("修改失败！");
    }

    @ApiOperation("按id删除单位")
    @PostMapping("/deleteByUnitId/{unitId}")
    public RestObject<String> deleteUnitById(@PathVariable String unitId) {
        boolean b = iUnitService.removeById(unitId);
        if (b) {
            logUtil.log("成功删除了单位信息，单位ID：" + unitId, LogStatus.INFO.info);
            return RestResponse.makeOkRsp("删除成功！");
        }
        logUtil.log("删除单位信息时失败，单位ID：" + unitId, LogStatus.ERROR.info);
        return RestResponse.makeErrRsp("删除失败！");
    }

    @ApiOperation("按单位名称查询")
    @PostMapping("/retrieveByUnitName")
    public RestObject<List<Unit>> retrieveUnitByShopName(@RequestBody Unit unit) {
        List<Unit> list = iUnitService.retrieveByUnitName(unit.getUnitName());
        logUtil.log("按单位名查询了全部单位信息，单位名：" + unit.getUnitName(), LogStatus.INFO.info);
        return RestResponse.makeOkRsp(list);
    }
}
