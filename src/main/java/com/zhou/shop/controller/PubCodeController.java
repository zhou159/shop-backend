package com.zhou.shop.controller;

import com.zhou.shop.entity.PubCode;
import com.zhou.shop.result.RestObject;
import com.zhou.shop.service.IPubCodeService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 周雄
 * @date 2022/5/17 18:28
 * @description
 */
@RestController
@RequestMapping("/pubcode")
public class PubCodeController {

    private final IPubCodeService ipubCodeService;

    public PubCodeController(IPubCodeService ipubCodeService){
        this.ipubCodeService = ipubCodeService;
    }

    @ApiOperation("码表")
    @GetMapping("/retrieveSitcomByClassId/{pubcodeClassId}")
    public RestObject<List<PubCode>> retrieveSitcomByClassId(@PathVariable String pubcodeClassId){
        return ipubCodeService.retrieveSitcomByClassId(pubcodeClassId);
    }
}
