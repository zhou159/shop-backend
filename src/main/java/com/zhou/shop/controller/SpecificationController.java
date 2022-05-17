package com.zhou.shop.controller;

import com.zhou.shop.entity.Specification;
import com.zhou.shop.result.RestObject;
import com.zhou.shop.service.ISpecificationService;
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
