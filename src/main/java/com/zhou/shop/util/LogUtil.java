package com.zhou.shop.util;

import com.zhou.shop.entity.Log;
import com.zhou.shop.service.ILogService;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * 日志工具类
 * @author 周雄
 */
@Component
public class LogUtil {
    final ILogService iLogService;

    public LogUtil(ILogService iLogService) {
        this.iLogService = iLogService;
    }

    public void log(String info,String status){
        Log log = new Log();
        log.setLogTime(LocalDateTime.now());
        log.setLogInfo(info);
        log.setLogStatus(status);
        iLogService.save(log);
    }
}
