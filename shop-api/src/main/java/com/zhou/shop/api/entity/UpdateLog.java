package com.zhou.shop.api.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author 周雄
 * @since 2021-07-24
 */
@TableName("updateLog")
@ApiModel("更新日志")
public class UpdateLog implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("更新日志表id")
    @TableId(value = "update_log_id", type = IdType.AUTO)
    private Integer updateLogId;

    @ApiModelProperty("更新日志创建时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @TableField("update_log_create_time")
    private LocalDate updateLogCreateTime;

    @ApiModelProperty("更新版本号")
    @TableField("update_log_version")
    private String updateLogVersion;

    @ApiModelProperty("更新日志描述")
    @TableField("update_log_description")
    private String updateLogDescription;

    @ApiModelProperty("更新日志逻辑删除")
    @TableLogic
    @TableField("update_log_deleted")
    private Integer updateLogDeleted;

    @ApiModelProperty("更新日志更新时间")
    @TableField("update_log_update_time")
    private LocalDateTime updateLogUpdateTime;

    public UpdateLog() {
    }

    public UpdateLog(Integer updateLogId, LocalDate updateLogCreateTime, String updateLogVersion, String updateLogDescription, Integer updateLogDeleted, LocalDateTime updateLogUpdateTime) {
        this.updateLogId = updateLogId;
        this.updateLogCreateTime = updateLogCreateTime;
        this.updateLogVersion = updateLogVersion;
        this.updateLogDescription = updateLogDescription;
        this.updateLogDeleted = updateLogDeleted;
        this.updateLogUpdateTime = updateLogUpdateTime;
    }

    public Integer getUpdateLogId() {
        return updateLogId;
    }

    public UpdateLog setUpdateLogId(Integer updateLogId) {
        this.updateLogId = updateLogId;
        return this;
    }

    public LocalDate getUpdateLogCreateTime() {
        return updateLogCreateTime;
    }

    public UpdateLog setUpdateLogCreateTime(LocalDate updateLogCreateTime) {
        this.updateLogCreateTime = updateLogCreateTime;
        return this;
    }

    public String getUpdateLogVersion() {
        return updateLogVersion;
    }

    public UpdateLog setUpdateLogVersion(String updateLogVersion) {
        this.updateLogVersion = updateLogVersion;
        return this;
    }

    public String getUpdateLogDescription() {
        return updateLogDescription;
    }

    public UpdateLog setUpdateLogDescription(String updateLogDescription) {
        this.updateLogDescription = updateLogDescription;
        return this;
    }

    public Integer getUpdateLogDeleted() {
        return updateLogDeleted;
    }

    public void setUpdateLogDeleted(Integer updateLogDeleted) {
        this.updateLogDeleted = updateLogDeleted;
    }

    public LocalDateTime getUpdateLogUpdateTime() {
        return updateLogUpdateTime;
    }

    public UpdateLog setUpdateLogUpdateTime(LocalDateTime updateLogUpdateTime) {
        this.updateLogUpdateTime = updateLogUpdateTime;
        return this;
    }

    @Override
    public String toString() {
        return "UpdateLog{" +
                "updateLogId=" + updateLogId +
                ", updateLogCreateTime=" + updateLogCreateTime +
                ", updateLogVersion='" + updateLogVersion + '\'' +
                ", updateLogDescription='" + updateLogDescription + '\'' +
                ", updateLogDeleted=" + updateLogDeleted +
                ", updateLogUpdateTime=" + updateLogUpdateTime +
                '}';
    }
}
