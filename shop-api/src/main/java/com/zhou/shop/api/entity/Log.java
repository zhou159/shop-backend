package com.zhou.shop.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 周雄
 * @since 2021-06-24
 */
@TableName("log")
@ApiModel("日志")
public class Log implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("日志主键")
    @TableId(value = "log_id", type = IdType.ASSIGN_ID)
    private String logId;

    @ApiModelProperty("日志状态")
    @TableField("log_status")
    private String logStatus;

    @ApiModelProperty("日志信息")
    @TableField("log_info")
    private String logInfo;

    @ApiModelProperty("日志时间")
    @TableField("log_time")
    private LocalDateTime logTime;

    public Log() {}

    public Log(String logId, String logStatus, String logInfo, LocalDateTime logTime) {
        this.logId = logId;
        this.logStatus = logStatus;
        this.logInfo = logInfo;
        this.logTime = logTime;
    }

    public String getLogId() {
        return logId;
    }

    public Log setLogId(String logId) {
        this.logId = logId;
        return this;
    }

    public String getLogStatus() {
        return logStatus;
    }

    public Log setLogStatus(String logStatus) {
        this.logStatus = logStatus;
        return this;
    }

    public String getLogInfo() {
        return logInfo;
    }

    public Log setLogInfo(String logInfo) {
        this.logInfo = logInfo;
        return this;
    }

    public LocalDateTime getLogTime() {
        return logTime;
    }

    public Log setLogTime(LocalDateTime logTime) {
        this.logTime = logTime;
        return this;
    }

    @Override
    public String toString() {
        return "Log{"
                + "logId='"
                + logId
                + '\''
                + ", logStatus='"
                + logStatus
                + '\''
                + ", logInfo='"
                + logInfo
                + '\''
                + ", logTime="
                + logTime
                + '}';
    }
}
