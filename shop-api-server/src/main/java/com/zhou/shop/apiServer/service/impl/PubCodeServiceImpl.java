package com.zhou.shop.apiServer.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
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
public class PubCodeServiceImpl extends ServiceImpl<PubCodeMapper, PubCode>
        implements IPubCodeService {

    private final PubCodeMapper pubCodeMapper;

    public PubCodeServiceImpl(PubCodeMapper pubCodeMapper) {
        this.pubCodeMapper = pubCodeMapper;
    }

    @Override
    public RestObject<List<PubCode>> retrieveSitcomByClassId(String pubCodeClassId) {
        return RestResponse.makeOkRsp(
                pubCodeMapper.selectList(
                        new LambdaQueryWrapper<PubCode>()
                                .eq(PubCode::getPubCodeClassId, pubCodeClassId)));
    }

    @Override
    public RestObject<List<PubCode>> retrieveAllPubCode() {
        return RestResponse.makeOkRsp(pubCodeMapper.selectList(null));
    }

    @Override
    public RestObject<String> createPubCode(PubCode pubCode) {
        int insert = pubCodeMapper.insert(pubCode);
        return insert > 0 ? RestResponse.makeOkRsp("新增成功！") : RestResponse.makeErrRsp("新增失败！");
    }

    @Override
    public RestObject<String> updatePubCode(PubCode pubCode) {
        int i = pubCodeMapper.updateById(pubCode);
        return i > 0 ? RestResponse.makeOkRsp("修改成功！") : RestResponse.makeErrRsp("修改失败！");
    }

    @Override
    public RestObject<String> deletePubCode(String pubCodeId) {
        int i = pubCodeMapper.deleteById(pubCodeId);
        return i > 0 ? RestResponse.makeOkRsp("删除成功！") : RestResponse.makeErrRsp("删除失败！");
    }
}
