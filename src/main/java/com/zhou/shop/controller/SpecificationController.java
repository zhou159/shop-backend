package com.zhou.shop.controller;

import com.zhou.shop.entity.Specification;
import com.zhou.shop.result.RestObject;
import com.zhou.shop.result.RestResponse;
import com.zhou.shop.service.ISpecificationService;
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
@RequestMapping("/specification")
public class SpecificationController {
    final ISpecificationService iSpecificationService;

    public SpecificationController(ISpecificationService iSpecificationService) {
        this.iSpecificationService = iSpecificationService;
    }

    @PostMapping("/createSpecification")
    public RestObject<String> createSpecification(@RequestBody Specification specification){
        specification.setSpecificationId(UUID.randomUUID().toString().replace("-","").toUpperCase());
        boolean save = iSpecificationService.save(specification);
        if (save){
            return RestResponse.makeOkRsp("新增成功！");
        }else {
            return RestResponse.makeErrRsp("新增成功！");
        }
    }

    @GetMapping("/retrieveBySpecificationId/{specificationId}")
    public RestObject<Specification> retrieveBySpecificationId(@PathVariable String specificationId){
        Specification specification = iSpecificationService.getById(specificationId);
        return RestResponse.makeOkRsp(specification);
    }

    @GetMapping("/retrieveAllSpecification")
    public RestObject<List<Specification>> retrieveAllSpecification (){
        List<Specification> list = iSpecificationService.list();
        return RestResponse.makeOkRsp(list);
    }

    @PostMapping("/updateSpecificationBySpecificationId/{specificationId}")
    public RestObject<String> updateSpecificationBySpecificationId(@PathVariable String specificationId,@RequestBody Specification specification){
        specification.setSpecificationId(specificationId);
        boolean b = iSpecificationService.updateById(specification);
        if (b){
            return RestResponse.makeOkRsp("修改成功！");
        }else {
            return RestResponse.makeErrRsp("修改失败！");
        }
    }

    @PostMapping("/deleteBySpecificationId/{specificationId}")
    public RestObject<String> deleteSpecificationById(@PathVariable String specificationId){
        boolean b = iSpecificationService.removeById(specificationId);
        if (b){
            return RestResponse.makeOkRsp("删除成功！");
        }else {
            return RestResponse.makeErrRsp("删除失败！");
        }
    }

    @ApiOperation("按商店名称查询")
    @PostMapping("/retrieveBySpecificationName")
    public RestObject<List<Specification>> retrieveSpecificationByShopName (@RequestBody Specification specification){
        List<Specification> list = iSpecificationService.retrieveBySpecificationName(specification.getSpecificationName());
        return RestResponse.makeOkRsp(list);
    }
}