package com.zhou.shop.apiServer.service.impl.privates;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.api.entity.privates.Sitcom;
import com.zhou.shop.api.entity.privates.SitcomNumber;
import com.zhou.shop.apiServer.mapper.privates.SitcomMapper;
import com.zhou.shop.apiServer.mapper.privates.SitcomNumberMapper;
import com.zhou.shop.apiServer.service.privates.ISitcomService;
import com.zhou.shop.common.RestObject;
import com.zhou.shop.common.RestResponse;
import com.zhou.shop.common.exception.ShopException;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

/**
 * 服务实现类
 *
 * @author 周雄
 * @since 2021-08-21
 */
@Service
public class SitcomServiceImpl extends ServiceImpl<SitcomMapper, Sitcom> implements ISitcomService {
    private static final String UPDATE_STATUS_ZERO = "0";
    private static final String WATCH_STATUS_ZERO = "0";
    private static final String WATCH_END_TIME_NULL = "null";
    private final SitcomMapper sitcomMapper;
    private final SitcomNumberMapper sitcomNumberMapper;
    private final Logger log = LoggerFactory.getLogger(SitcomServiceImpl.class);

    public SitcomServiceImpl(SitcomMapper sitcomMapper, SitcomNumberMapper sitcomNumberMapper) {
        this.sitcomMapper = sitcomMapper;
        this.sitcomNumberMapper = sitcomNumberMapper;
    }

    @Override
    public RestObject<String> createSitcom(Sitcom sitcom) {
        if (!StringUtils.isNotBlank(sitcom.getSitcomUpdateStatus())
                || sitcom.getSitcomUpdateStatus() == null) {
            throw new ShopException("连续剧更新状态不能为空！");
        }
        if (!StringUtils.isNotBlank(sitcom.getSitcomWatchStatus())
                || sitcom.getSitcomWatchStatus() == null) {
            throw new ShopException("连续剧观看状态不能为空！");
        }
        if (!sitcom.getSitcomUpdateStatus().equals(UPDATE_STATUS_ZERO)
                && sitcom.getSitcomWatchStatus().equals(WATCH_STATUS_ZERO)) {
            throw new ShopException("连续剧还未完结，操作失败！");
        }
        if("".equals(sitcom.getSitcomWatchEndTime())){
            sitcom.setSitcomWatchEndTime(null);
        }
        sitcom.setSitcomWatchStartTime(
                (sitcom.getSitcomWatchStartTime() == null
                                || "".equals(sitcom.getSitcomWatchStartTime().toString()))
                        ? LocalDate.now().toString()
                        : sitcom.getSitcomWatchStartTime());
        int save = sitcomMapper.insert(sitcom);
        if (save < 1) {
            log.warn("新增连续剧失败！");
            throw new ShopException("新增失败！");
        }
        log.info("新增连续剧成功！");
        return RestResponse.makeOkRsp("新增成功！");
    }

    @Override
    public RestObject<Sitcom> retrieveBySitcomId(String sitcomId) {
        return RestResponse.makeOkRsp(sitcomMapper.selectById(sitcomId));
    }

    @Override
    public RestObject<List<Sitcom>> retrieveAllSitcom() {
        return RestResponse.makeOkRsp(sitcomMapper.selectList(null));
    }

    @Override
    public RestObject<String> updateSitcomBySitcomId(String sitcomId, Sitcom sitcom) {
        sitcom.setSitcomId(sitcomId);
        if (!StringUtils.isNotBlank(sitcom.getSitcomUpdateStatus())
                || sitcom.getSitcomUpdateStatus() == null) {
            throw new ShopException("连续剧更新状态不能为空！");
        }
        if (!StringUtils.isNotBlank(sitcom.getSitcomWatchStatus())
                || sitcom.getSitcomWatchStatus() == null) {
            throw new ShopException("连续剧观看状态不能为空！");
        }
        if (!sitcom.getSitcomUpdateStatus().equals(UPDATE_STATUS_ZERO)
                && sitcom.getSitcomWatchStatus().equals(WATCH_STATUS_ZERO)) {
            throw new ShopException("连续剧还未完结，操作失败！");
        }
        if (sitcom.getSitcomWatchEndTime().equals(WATCH_END_TIME_NULL)) {
            sitcom.setSitcomWatchEndTime(null);
        }
        /*LambdaUpdateWrapper<Sitcom> wrapper = new LambdaUpdateWrapper<>();wrapper.set(Sitcom::getSitcomWatchEndTime,null).eq(Sitcom::getSitcomId,sitcomId);*/
        int b = sitcomMapper.updateById(sitcom);
        if (b < 1) {
            log.warn("修改连续剧失败！连续剧id:" + sitcomId);
            throw new ShopException("修改失败！");
        }
        log.info("修改连续剧成功！连续剧id:" + sitcomId);
        return RestResponse.makeOkRsp("修改成功！");
    }

    @Transactional(rollbackFor = {ShopException.class})
    @Override
    public RestObject<String> deleteSitcomById(String sitcomId) {
        int b = sitcomMapper.deleteById(sitcomId);

        // 查询当前sitcom_id的sitcom_number的数量
        QueryWrapper<SitcomNumber> wrapper = new QueryWrapper<>();
        wrapper.eq("sitcom_id", sitcomId);
        Long aLong = sitcomNumberMapper.selectCount(wrapper);

        int i = sitcomNumberMapper.delete(wrapper);

        if (!(b > 0 && (i > 0 || aLong == 0))) {
            log.warn("删除连续剧失败！连续剧id:" + sitcomId);
            throw new ShopException("删除失败！");
        }
        log.info("删除连续剧成功！连续剧id:" + sitcomId);
        return RestResponse.makeOkRsp("删除成功！");
    }
}
