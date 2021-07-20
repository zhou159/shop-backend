package com.zhou.shop.controller;

import com.zhou.shop.entity.Specification;
import com.zhou.shop.result.RestObject;
import com.zhou.shop.result.RestResponse;
import com.zhou.shop.service.ISpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @Autowired
    ISpecificationService iSpecificationService;

    @PostMapping("/createSpecification")
    public RestObject<String> createSpecification(@RequestBody Specification specification){
        boolean save = iSpecificationService.save(specification);
        if (save){
            return RestResponse.makeOKRsp("新增成功！");
        }else {
            return RestResponse.makeErrRsp("新增成功！");
        }
    }

    @GetMapping("/retrieveBySpecificationId/{specificationId}")
    public RestObject<Specification> retrieveBySpecificationId(@PathVariable int specificationId){
        Specification specification = iSpecificationService.getById(specificationId);
        return RestResponse.makeOKRsp(specification);
    }

    @GetMapping("/retrieveAllSpecification")
    public RestObject<List<Specification>> retrieveAllSpecification (){
        List<Specification> list = iSpecificationService.list();
        return RestResponse.makeOKRsp(list);
    }

    @PostMapping("/updateSpecificationBySpecificationId/{specificationId}")
    public RestObject<String> updateSpecificationBySpecificationId(@PathVariable int specificationId,@RequestBody Specification specification){
        specification.setSpecificationId(specificationId);
        boolean b = iSpecificationService.updateById(specification);
        if (b){
            return RestResponse.makeOKRsp("修改成功！");
        }else {
            return RestResponse.makeErrRsp("修改失败！");
        }
    }

    @PostMapping("/deleteBySpecificationId/{specificationId}")
    public RestObject<String> deleteSpecificationById(@PathVariable int specificationId){
        boolean b = iSpecificationService.removeById(specificationId);
        if (b){
            return RestResponse.makeOKRsp("删除成功！");
        }else {
            return RestResponse.makeErrRsp("删除失败！");
        }
    }
}