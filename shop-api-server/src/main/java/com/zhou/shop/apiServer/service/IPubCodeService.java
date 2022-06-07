package com.zhou.shop.apiServer.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.api.entity.PubCode;
import com.zhou.shop.common.RestObject;

import java.util.List;

/**
 * @author 周雄
 * @date 2022/5/17 18:24
 * @description
 */
public interface IPubCodeService extends IService<PubCode> {
    /**
     * 根据classid查询
     *
     * @param pubcodeClassId
     * @return
     */
    RestObject<List<PubCode>> retrieveSitcomByClassId(String pubcodeClassId);
}
