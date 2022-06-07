package com.zhou.shop.apiServer.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhou.shop.api.entity.Log;
import com.zhou.shop.apiServer.mapper.LogMapper;
import com.zhou.shop.apiServer.service.ILogService;
import org.springframework.stereotype.Service;

/**
 * 服务实现类
 *
 * @author 周雄
 * @since 2021-09-04
 */
@Service
public class LogServiceImpl extends ServiceImpl<LogMapper, Log> implements ILogService {}
