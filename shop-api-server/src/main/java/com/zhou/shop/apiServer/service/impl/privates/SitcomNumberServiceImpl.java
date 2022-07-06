package com.zhou.shop.apiServer.service.impl.privates;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.api.entity.privates.Sitcom;
import com.zhou.shop.api.entity.privates.SitcomNumber;
import com.zhou.shop.apiServer.mapper.privates.SitcomMapper;
import com.zhou.shop.apiServer.mapper.privates.SitcomNumberMapper;
import com.zhou.shop.apiServer.service.privates.ISitcomNumberService;
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
 * @since 2021-08-21
 */
@Service
public class SitcomNumberServiceImpl extends ServiceImpl<SitcomNumberMapper, SitcomNumber>
        implements ISitcomNumberService {
    private static final String WATCH_STATUS_ONE = "1";
    private final SitcomNumberMapper sitcomNumberMapper;
    private final SitcomMapper sitcomMapper;
    private final Logger log = LoggerFactory.getLogger(SitcomNumberServiceImpl.class);

    public SitcomNumberServiceImpl(
            SitcomNumberMapper sitcomNumberMapper, SitcomMapper sitcomMapper) {
        this.sitcomNumberMapper = sitcomNumberMapper;
        this.sitcomMapper = sitcomMapper;
    }

    @Override
    public RestObject<List<SitcomNumber>> retrieveBySitcomId(String sitcomId) {
        return RestResponse.makeOkRsp(
                sitcomNumberMapper.selectList(
                        new LambdaQueryWrapper<SitcomNumber>()
                                .eq(SitcomNumber::getSitcomId, sitcomId)));
    }

    @Override
    public RestObject<List<SitcomNumber>> retrieveBySitcomNumberName(
            String sitcomNumberName, String sitcomId) {
        return RestResponse.makeOkRsp(
                sitcomNumberMapper.selectList(
                        new LambdaQueryWrapper<SitcomNumber>()
                                .like(SitcomNumber::getSitcomNumberName, sitcomNumberName)));
    }

    @Override
    public RestObject<String> createSitcomNumber(SitcomNumber sitcomNumber) {
        if ("".equals(sitcomNumber.getSitcomNumberWatchTime())
                || sitcomNumber.getSitcomNumberWatchTime() == null) {
            sitcomNumber.setSitcomNumberWatchTime(LocalDateTime.now().toString());
        }
        int save = sitcomNumberMapper.insert(sitcomNumber);
        if (save < 1) {
            log.warn("新增剧集失败！");
            throw new ShopException("新增失败！");
        }
        log.info("新增剧集成功！");
        return RestResponse.makeOkRsp("新增成功！");
    }

    @Override
    public RestObject<String> createSitcomNumberFast(SitcomNumber sitcomNumber) {
        Sitcom byId = sitcomMapper.selectById(sitcomNumber.getSitcomId());
        if (!WATCH_STATUS_ONE.equals(byId.getSitcomWatchStatus())) {
            throw new ShopException("这部连续剧已经看完了！");
        }
        /*获取当前电视剧集数*/
        final Long count =
                sitcomNumberMapper.selectCount(
                        new LambdaQueryWrapper<SitcomNumber>()
                                .eq(SitcomNumber::getSitcomId, sitcomNumber.getSitcomId()));

        String sitcomNumberNumber = String.valueOf(count + 1);
        String sitcomNumberName = "第" + sitcomNumberNumber + "集";

        sitcomNumber
                .setSitcomNumberNumber(sitcomNumberNumber)
                .setSitcomNumberName(sitcomNumberName)
                .setSitcomNumberWatchTime(LocalDateTime.now().toString());
        int save = sitcomNumberMapper.insert(sitcomNumber);
        if (save < 1) {
            log.warn("新增剧集失败！");
            throw new ShopException("新增失败！");
        }
        log.info("新增剧集成功！");
        return RestResponse.makeOkRsp("新增成功！");
    }

    @Override
    public RestObject<SitcomNumber> retrieveBySitcomNumberId(String sitcomNumberId) {
        return RestResponse.makeOkRsp(sitcomNumberMapper.selectById(sitcomNumberId));
    }

    @Override
    public RestObject<String> updateSitcomNumberBySitcomNumberId(SitcomNumber sitcomNumber) {
        sitcomNumber.setSitcomNumberId(sitcomNumber.getSitcomNumberId());
        int b = sitcomNumberMapper.updateById(sitcomNumber);
        if (b < 1) {
            log.warn("修改剧集失败！剧集id:" + sitcomNumber.getSitcomNumberId());
            throw new ShopException("修改剧集失败！");
        }
        log.info("修改剧集成功！剧集id:" + sitcomNumber.getSitcomNumberId());
        return RestResponse.makeOkRsp("修改成功！");
    }

    @Override
    public RestObject<String> deleteSitcomNumberById(String sitcomNumberId) {
        int b = sitcomNumberMapper.deleteById(sitcomNumberId);
        if (b < 1) {
            log.warn("删除剧集失败！剧集id:" + sitcomNumberId);
            throw new ShopException("删除剧集失败！");
        }
        log.info("删除剧集成功！剧集id:" + sitcomNumberId);
        return RestResponse.makeOkRsp("删除成功！");
    }
}
