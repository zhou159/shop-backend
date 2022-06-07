package com.zhou.shop.apiServer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.api.entity.PubCode;
import com.zhou.shop.apiServer.mapper.PubCodeMapper;
import com.zhou.shop.apiServer.service.IPubCodeService;
import com.zhou.shop.common.RestObject;
import com.zhou.shop.common.RestResponse;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 周雄
 * @date 2022/5/17 18:27
 * @description
 */
@Service
public class PubCodeServiceImpl extends ServiceImpl<PubCodeMapper, PubCode> implements IPubCodeService {

    private final PubCodeMapper pubCodeMapper;

    public PubCodeServiceImpl(PubCodeMapper pubCodeMapper){
        this.pubCodeMapper = pubCodeMapper;
    }

    @Override
    public RestObject<List<PubCode>> retrieveSitcomByClassId(String pubcodeClassId){
        QueryWrapper<PubCode> wrapper = new QueryWrapper<>();
        wrapper.eq("pubcode_class_id",pubcodeClassId);
        return RestResponse.makeOkRsp(pubCodeMapper.selectList(wrapper));
    }

}
