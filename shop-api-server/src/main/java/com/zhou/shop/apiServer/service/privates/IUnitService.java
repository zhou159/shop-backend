package com.zhou.shop.apiServer.service.privates;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.api.entity.privates.Unit;
import com.zhou.shop.common.RestObject;

import java.util.List;

/**
 * 服务类
 *
 * @author 周雄
 * @since 2021-07-20
 */
public interface IUnitService extends IService<Unit> {
    /**
     * 按单位名查询单位
     *
     * @param unitName 单位名
     * @return 单位对象
     */
    RestObject<List<Unit>> retrieveByUnitName(String userId,String unitName);

    /**
     * 新增
     *
     * @param unit
     * @return
     */
    RestObject<String> createUnit(Unit unit);

    /**
     * 根据id查询
     *
     * @param unitId id
     * @return
     */
    RestObject<Unit> retrieveByUnitId(String unitId);

    /**
     * 查询全部
     *
     * @return
     */
    RestObject<List<Unit>> retrieveAllUnit(String userId);

    /**
     * 根据id修改
     *
     * @param unitId id
     * @param unit 对象
     * @return
     */
    RestObject<String> updateUnitByUnitId(String unitId, Unit unit);

    /**
     * 根据id删除
     *
     * @param unitId id
     * @return
     */
    RestObject<String> deleteUnitById(String unitId);
}
