package com.zhou.shop.apiServer.service.impl.privates;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.api.entity.privates.Unit;
import com.zhou.shop.apiServer.mapper.privates.UnitMapper;
import com.zhou.shop.apiServer.service.privates.IUnitService;
import com.zhou.shop.common.RestObject;
import com.zhou.shop.common.RestResponse;
import com.zhou.shop.common.exception.ShopException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 服务实现类
 *
 * @author 周雄
 * @since 2021-07-20
 */
@Service
public class UnitServiceImpl extends ServiceImpl<UnitMapper, Unit> implements IUnitService {

    private final UnitMapper unitMapper;

    private final Logger log = LoggerFactory.getLogger(UnitServiceImpl.class);

    public UnitServiceImpl(UnitMapper unitMapper) {
        this.unitMapper = unitMapper;
    }

    @Override
    public RestObject<List<Unit>> retrieveByUnitName(String userId, String unitName) {
        return RestResponse.makeOkRsp(
                unitMapper.selectList(
                        new LambdaQueryWrapper<Unit>()
                                .like(Unit::getUnitName, unitName)
                                .eq(Unit::getUserId, userId)));
    }

    @Override
    public RestObject<String> createUnit(Unit unit) {
        unit.setUnitCreateTime(LocalDateTime.now());
        int insert = unitMapper.insert(unit);
        if (insert < 1) {
            log.warn("新增单位失败！");
            throw new ShopException("新增失败！");
        }
        log.info("新增单位成功！");
        return RestResponse.makeOkRsp("新增成功!");
    }

    @Override
    public RestObject<Unit> retrieveByUnitId(String unitId) {
        return RestResponse.makeOkRsp(unitMapper.selectById(unitId));
    }

    @Override
    public RestObject<List<Unit>> retrieveAllUnit(String userId) {
        return RestResponse.makeOkRsp(
                unitMapper.selectList(new LambdaQueryWrapper<Unit>().eq(Unit::getUserId, userId)));
    }

    @Override
    public RestObject<String> updateUnitByUnitId(String unitId, Unit unit) {
        unit.setUnitId(unitId);
        unit.setUnitUpdateTime(LocalDateTime.now());
        int i = unitMapper.updateById(unit);
        if (i < 1) {
            log.warn("修改单位失败！单位id:" + unitId);
            throw new ShopException("修改失败！");
        }
        log.info("修改单位成功！单位id:" + unitId);
        return RestResponse.makeOkRsp("修改成功！");
    }

    @Override
    public RestObject<String> deleteUnitById(String unitId) {
        int i = unitMapper.deleteById(unitId);
        if (i < 1) {
            log.warn("删除单位失败！单位id:" + unitId);
            throw new ShopException("删除失败！");
        }
        log.info("删除单位成功！单位id:" + unitId);
        return RestResponse.makeOkRsp("删除成功！");
    }
}
