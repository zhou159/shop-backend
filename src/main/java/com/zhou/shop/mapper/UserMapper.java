package com.zhou.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zhou.shop.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * Mapper 接口
 *
 * @author 周雄
 * @since 2021-06-24
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {}
