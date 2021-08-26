package com.zhou.shop.controller;

import com.zhou.shop.entity.Unit;
import com.zhou.shop.result.RestObject;
import com.zhou.shop.result.RestResponse;
import com.zhou.shop.service.IUnitService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 周雄
 * @since 2021-07-20
 */
@RestController
@RequestMapping("/unit")
public class UnitController {
    final IUnitService iUnitService;

    public UnitController(IUnitService iUnitService) {
        this.iUnitService = iUnitService;
    }

    @PostMapping("/createUnit")
    public RestObject<String> createUnit(@RequestBody Unit unit){
        unit.setUnitId(UUID.randomUUID().toString().replace("-","").toUpperCase());
        boolean save = iUnitService.save(unit);
        if (save){
            return RestResponse.makeOkRsp("新增成功！");
        }else {
            return RestResponse.makeErrRsp("新增成功！");
        }
    }

    @GetMapping("/retrieveByUnitId/{unitId}")
    public RestObject<Unit> retrieveByUnitId(@PathVariable String unitId){
        Unit unit = iUnitService.getById(unitId);
        return RestResponse.makeOkRsp(unit);
    }

    @GetMapping("/retrieveAllUnit")
    public RestObject<List<Unit>> retrieveAllUnit (){
        List<Unit> list = iUnitService.list();
        return RestResponse.makeOkRsp(list);
    }

    @PostMapping("/updateUnitByUnitId/{unitId}")
    public RestObject<String> updateUnitByUnitId(@PathVariable String unitId,@RequestBody Unit unit){
        unit.setUnitId(unitId);
        boolean b = iUnitService.updateById(unit);
        if (b){
            return RestResponse.makeOkRsp("修改成功！");
        }else {
            return RestResponse.makeErrRsp("修改失败！");
        }
    }

    @PostMapping("/deleteByUnitId/{unitId}")
    public RestObject<String> deleteUnitById(@PathVariable String unitId){
        boolean b = iUnitService.removeById(unitId);
        if (b){
            return RestResponse.makeOkRsp("删除成功！");
        }else {
            return RestResponse.makeErrRsp("删除失败！");
        }
    }

    @ApiOperation("按商店名称查询")
    @PostMapping("/retrieveByUnitName")
    public RestObject<List<Unit>> retrieveUnitByShopName (@RequestBody Unit unit){
        List<Unit> list = iUnitService.retrieveByUnitName(unit.getUnitName());
        return RestResponse.makeOkRsp(list);
    }
}