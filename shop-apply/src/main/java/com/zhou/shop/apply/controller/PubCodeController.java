package com.zhou.shop.apply.controller;

import com.zhou.shop.api.entity.PubCode;
import com.zhou.shop.apiServer.service.IPubCodeService;
import com.zhou.shop.common.RestObject;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
