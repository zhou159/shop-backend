package com.zhou.shop.apiServer.service.privates;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhou.shop.api.dto.SitcomDTO;
import com.zhou.shop.api.entity.privates.Sitcom;
import com.zhou.shop.common.RestObject;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * 服务类
 *
 * @author 周雄
 * @since 2021-08-21
 */
public interface ISitcomService extends IService<Sitcom> {

    /**
     * 新增
     *
     * @param sitcom 对象
     * @return
     */
    RestObject<String> createSitcom(Sitcom sitcom);

    /**
     * 根据id查询
     *
     * @param sitcomId id
     * @return
     */
    RestObject<SitcomDTO> retrieveBySitcomId(String sitcomId);

    /**
     * 查询全部
     *
     * @return
     */
    RestObject<List<SitcomDTO>> retrieveAllSitcom(String userId);

    /**
     * 根据id修改
     *
     * @param sitcom 对象
     * @return
     */
    RestObject<String> updateSitcomBySitcomId(Sitcom sitcom);

    /**
     * 根据id删除
     *
     * @param sitcomId id
     * @return
     */
    RestObject<String> deleteSitcomById(@PathVariable String sitcomId);
}
