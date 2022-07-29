package com.zhou.shop.apiServer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.api.entity.PubCode;
import com.zhou.shop.api.entity.PubCodeType;
import com.zhou.shop.apiServer.mapper.PubCodeMapper;
import com.zhou.shop.apiServer.mapper.PubCodeTypeMapper;
import com.zhou.shop.apiServer.service.IPubCodeTypeService;
import com.zhou.shop.common.RestObject;
import com.zhou.shop.common.RestResponse;
import com.zhou.shop.common.exception.ShopException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author zhouxiong
 * @version v0.1
 * @since 2022/7/18 15:24
 */
@Service
public class PubCodeTypeServiceImpl extends ServiceImpl<PubCodeTypeMapper, PubCodeType>
        implements IPubCodeTypeService {

    private final PubCodeTypeMapper pubCodeTypeMapper;
    private final PubCodeMapper pubCodeMapper;

    public PubCodeTypeServiceImpl(
            PubCodeTypeMapper pubCodeTypeMapper, PubCodeMapper pubCodeMapper) {
        this.pubCodeTypeMapper = pubCodeTypeMapper;
        this.pubCodeMapper = pubCodeMapper;
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

    @Override
    public RestObject<String> updatePubCodeType(PubCodeType pubCodeType) {
        pubCodeType.setTypeUpdateTime(LocalDateTime.now());
        int i = pubCodeTypeMapper.updateById(pubCodeType);
        return i > 0 ? RestResponse.makeOkRsp("修改成功！") : RestResponse.makeErrRsp("修改失败！");
    }

    @Override
    public RestObject<String> deletePubCodeType(PubCodeType pubCodeType) {
        String id = pubCodeType.getId();
        Integer status = pubCodeType.getTypeStatus();
        if (status == 1) {
            throw new ShopException("该码表正在使用中！不能删除！");
        }
        int i = pubCodeTypeMapper.deleteById(id);
        return i > 0 ? RestResponse.makeOkRsp("删除成功！") : RestResponse.makeErrRsp("删除失败！");
    }

    @Override
    public RestObject<String> updateStatus(String pubCodeTypeId, Integer status) {
        int update =
                pubCodeTypeMapper.update(
                        null,
                        new LambdaUpdateWrapper<PubCodeType>()
                                .eq(PubCodeType::getId, pubCodeTypeId)
                                .set(PubCodeType::getTypeStatus, status)
                                .set(PubCodeType::getTypeUpdateTime, LocalDateTime.now()));

        return update > 0 ? RestResponse.makeOkRsp("修改成功！") : RestResponse.makeErrRsp("修改失败！");
    }

    @Override
    public RestObject<List<PubCode>> retrievePubCodeByTypeId(String pubCodeType) {
        List<PubCode> pubCodeList = pubCodeMapper.selectList(
                new LambdaQueryWrapper<PubCode>()
                        .eq(
                                PubCode::getPubCodeTypeId,
                                pubCodeTypeMapper
                                        .selectOne(
                                                new LambdaQueryWrapper<PubCodeType>()
                                                        .eq(
                                                                PubCodeType::getPubCodeType,
                                                                pubCodeType))
                                        .getId()));
        return RestResponse.makeOkRsp(pubCodeList);
    }
}
