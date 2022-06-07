package com.zhou.shop.apiServer.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhou.shop.api.entity.Log;
import org.apache.ibatis.annotations.Mapper;

/**
 * Mapper 接口
 *
 * @author 周雄
 * @since 2021-09-04
 */
@Mapper
public interface LogMapper extends BaseMapper<Log> {}
