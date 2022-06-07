package com.zhou.shop.api.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * @author 周雄
 * @since 2021-07-24
 */
@TableName("updateLog")
@ApiModel(value = "update对象")
public class UpdateLog implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "更新日志表id")
    @TableId(value = "update_log_id", type = IdType.AUTO)
    private Integer updateLogId;

    @ApiModelProperty(value = "更新日志创建时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @TableField("update_log_create_time")
    private LocalDate updateLogCreateTime;

    @ApiModelProperty(value = "更新版本号")
    @TableField("update_log_version")
    private String updateLogVersion;

    @ApiModelProperty(value = "更新日志描述")
    @TableField("update_log_description")
    private String updateLogDescription;

    @ApiModelProperty(value = "更新日志逻辑删除")
    @TableLogic
    @TableField("update_log_deleted")
    private Integer updateLogDeleted;

    public UpdateLog() {}

    public UpdateLog(
            Integer updateLogId,
            LocalDate updateLogCreateTime,
            String updateLogVersion,
            String updateLogDescription) {
        this.updateLogId = updateLogId;
        this.updateLogCreateTime = updateLogCreateTime;
        this.updateLogVersion = updateLogVersion;
        this.updateLogDescription = updateLogDescription;
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

    @Override
    public String toString() {
        return "UpdateLog{"
                + "updateLogId="
                + updateLogId
                + ", updateLogCreateTime="
                + updateLogCreateTime
                + ", updateLogVersion='"
                + updateLogVersion
                + '\''
                + ", updateLogDescription='"
                + updateLogDescription
                + '\''
                + '}';
    }
}
