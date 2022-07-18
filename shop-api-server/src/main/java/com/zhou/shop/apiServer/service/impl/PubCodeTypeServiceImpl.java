package com.zhou.shop.apiServer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.api.entity.PubCodeType;
import com.zhou.shop.apiServer.mapper.PubCodeTypeMapper;
import com.zhou.shop.apiServer.service.IPubCodeTypeService;
import com.zhou.shop.common.RestObject;
import com.zhou.shop.common.RestResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author zhouxiong
 * @version v0.1
 * @since 2022/7/18 15:24
 */
@Service
public class PubCodeTypeServiceImpl extends ServiceImpl<PubCodeTypeMapper, PubCodeType> implements IPubCodeTypeService {

    private final PubCodeTypeMapper pubCodeTypeMapper;

    public PubCodeTypeServiceImpl(PubCodeTypeMapper pubCodeTypeMapper) {
        this.pubCodeTypeMapper = pubCodeTypeMapper;
    }

    @Override
    public RestObject<List<PubCodeType>> getAllPubCodeType() {
        return RestResponse.makeOkRsp(pubCodeTypeMapper.selectList(null));
    }

    @Override
    public RestObject<String> createPubCodeType(PubCodeType pubCodeType) {
        pubCodeType.setTypeCreateTime(LocalDateTime.now());
        int insert = pubCodeTypeMapper.insert(pubCodeType);
        return insert > 0 ? RestResponse.makeOkRsp("新增成功！") : RestResponse.makeErrRsp("新增失败！");
    }
}
