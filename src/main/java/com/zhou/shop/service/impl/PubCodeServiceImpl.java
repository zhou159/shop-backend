package com.zhou.shop.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.entity.PubCode;
import com.zhou.shop.mapper.PubCodeMapper;
import com.zhou.shop.result.RestObject;
import com.zhou.shop.result.RestResponse;
import com.zhou.shop.service.IPubCodeService;
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
