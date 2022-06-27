package com.zhou.shop.apply.controller.privates;

import cn.dev33.satoken.annotation.SaCheckRole;
import com.zhou.shop.api.entity.privates.Specification;
import com.zhou.shop.apiServer.service.privates.ISpecificationService;
import com.zhou.shop.common.RestObject;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 前端控制器
 *
 * @author 周雄
 * @since 2021-07-20
 */
@SaCheckRole("superAdmin")
@RestController
@RequestMapping("/specification")
@Api(tags = "规格")
public class SpecificationController {
    private final ISpecificationService iSpecificationService;

    public SpecificationController(ISpecificationService iSpecificationService) {
        this.iSpecificationService = iSpecificationService;
    }

    @ApiOperation("新增规格")
    @PostMapping("/createSpecification")
    public RestObject<String> createSpecification(@RequestBody Specification specification) {
        return iSpecificationService.createSpecification(specification);
    }

    @ApiOperation("按id查询规格")
    @GetMapping("/retrieveBySpecificationId/{specificationId}")
    public RestObject<Specification> retrieveBySpecificationId(@PathVariable String specificationId) {
        return iSpecificationService.retrieveBySpecificationId(specificationId);
    }

    @ApiOperation("查询全部规格")
    @GetMapping("/retrieveAllSpecification")
    public RestObject<List<Specification>> retrieveAllSpecification() {
        return iSpecificationService.retrieveAllSpecification();
    }

    @ApiOperation("按id修改规格")
    @PostMapping("/updateSpecificationBySpecificationId/{specificationId}")
    public RestObject<String> updateSpecificationBySpecificationId(@PathVariable String specificationId, @RequestBody Specification specification) {
        return iSpecificationService.updateSpecificationBySpecificationId(
                specificationId, specification);
    }

    @ApiOperation("按id删除规格")
    @PostMapping("/deleteBySpecificationId/{specificationId}")
    public RestObject<String> deleteSpecificationById(@PathVariable String specificationId) {
        return iSpecificationService.deleteSpecificationById(specificationId);
    }

    @ApiOperation("按规格名称查询")
    @PostMapping("/retrieveBySpecificationName")
    public RestObject<List<Specification>> retrieveSpecificationByShopName(@RequestBody Specification specification) {
        return iSpecificationService.retrieveBySpecificationName(
                specification.getSpecificationName());
    }
}
