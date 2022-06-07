package com.zhou.shop.apply.controller;

import com.zhou.shop.api.entity.Unit;
import com.zhou.shop.apiServer.service.IUnitService;
import com.zhou.shop.common.RestObject;
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
    private final IUnitService iUnitService;

    public UnitController(IUnitService iUnitService) {
        this.iUnitService = iUnitService;
    }

    @ApiOperation("新增单位")
    @PostMapping("/createUnit")
    public RestObject<String> createUnit(@RequestBody Unit unit) {
        return iUnitService.createUnit(unit);
    }

    @ApiOperation("按id查询单位")
    @GetMapping("/retrieveByUnitId/{unitId}")
    public RestObject<Unit> retrieveByUnitId(@PathVariable String unitId) {
        return iUnitService.retrieveByUnitId(unitId);
    }

    @ApiOperation("查询全部单位")
    @GetMapping("/retrieveAllUnit")
    public RestObject<List<Unit>> retrieveAllUnit() {
        return iUnitService.retrieveAllUnit();
    }

    @ApiOperation("按id修改单位")
    @PostMapping("/updateUnitByUnitId/{unitId}")
    public RestObject<String> updateUnitByUnitId(@PathVariable String unitId, @RequestBody Unit unit) {
        return iUnitService.updateUnitByUnitId(unitId, unit);
    }

    @ApiOperation("按id删除单位")
    @PostMapping("/deleteByUnitId/{unitId}")
    public RestObject<String> deleteUnitById(@PathVariable String unitId) {
        return iUnitService.deleteUnitById(unitId);
    }

    @ApiOperation("按单位名称查询")
    @PostMapping("/retrieveByUnitName")
    public RestObject<List<Unit>> retrieveUnitByShopName(@RequestBody Unit unit) {
        return iUnitService.retrieveByUnitName(unit.getUnitName());
    }
}
