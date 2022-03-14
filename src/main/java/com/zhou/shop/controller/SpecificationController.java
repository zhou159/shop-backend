package com.zhou.shop.controller;

import com.zhou.shop.entity.Specification;
import com.zhou.shop.enums.LogStatus;
import com.zhou.shop.result.RestObject;
import com.zhou.shop.result.RestResponse;
import com.zhou.shop.service.ISpecificationService;
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
@RequestMapping("/specification")
public class SpecificationController {
    final ISpecificationService iSpecificationService;
    final LogUtil logUtil;

    public SpecificationController(ISpecificationService iSpecificationService, LogUtil logUtil) {
        this.iSpecificationService = iSpecificationService;
        this.logUtil = logUtil;
    }

    @ApiOperation("新增规格")
    @PostMapping("/createSpecification")
    public RestObject<String> createSpecification(@RequestBody Specification specification) {
        boolean save = iSpecificationService.save(specification);
        if (save) {
            logUtil.log("新增规格成功", LogStatus.INFO.info);
            return RestResponse.makeOkRsp("新增成功！");
        }
        logUtil.log("新增规格出现异常", LogStatus.ERROR.info);
        return RestResponse.makeErrRsp("新增成功！");
    }

    @ApiOperation("按id查询规格")
    @GetMapping("/retrieveBySpecificationId/{specificationId}")
    public RestObject<Specification> retrieveBySpecificationId(@PathVariable String specificationId) {
        Specification specification = iSpecificationService.getById(specificationId);
        /* logUtil.log("查询了规格信息，规格ID：" + specificationId, LogStatus.INFO.info); */
        return RestResponse.makeOkRsp(specification);
    }

    @ApiOperation("查询全部规格")
    @GetMapping("/retrieveAllSpecification")
    public RestObject<List<Specification>> retrieveAllSpecification() {
        List<Specification> list = iSpecificationService.list();
        /* logUtil.log("查询了全部规格信息", LogStatus.INFO.info); */
        return RestResponse.makeOkRsp(list);
    }

    @ApiOperation("按id修改规格")
    @PostMapping("/updateSpecificationBySpecificationId/{specificationId}")
    public RestObject<String> updateSpecificationBySpecificationId(@PathVariable String specificationId, @RequestBody Specification specification) {
        specification.setSpecificationId(specificationId);
        boolean b = iSpecificationService.updateById(specification);
        if (b) {
            logUtil.log("成功修改了规格信息，规格ID：" + specificationId, LogStatus.INFO.info);
            return RestResponse.makeOkRsp("修改成功！");
        }
        logUtil.log("修改规格信息时失败，规格ID：" + specificationId, LogStatus.ERROR.info);
        return RestResponse.makeErrRsp("修改失败！");
    }

    @ApiOperation("按id删除规格")
    @PostMapping("/deleteBySpecificationId/{specificationId}")
    public RestObject<String> deleteSpecificationById(@PathVariable String specificationId) {
        boolean b = iSpecificationService.removeById(specificationId);
        if (b) {
            logUtil.log("成功删除了规格信息，规格ID：" + specificationId, LogStatus.INFO.info);
            return RestResponse.makeOkRsp("删除成功！");
        }
        logUtil.log("删除规格信息时失败，规格ID：" + specificationId, LogStatus.ERROR.info);
        return RestResponse.makeErrRsp("删除失败！");
    }

    @ApiOperation("按规格名称查询")
    @PostMapping("/retrieveBySpecificationName")
    public RestObject<List<Specification>> retrieveSpecificationByShopName(@RequestBody Specification specification) {
        List<Specification> list = iSpecificationService.retrieveBySpecificationName(specification.getSpecificationName());
        /* logUtil.log("按规格名查询了全部规格信息，规格名：" + specification.getSpecificationName(), LogStatus.INFO.info); */
        return RestResponse.makeOkRsp(list);
    }
}
