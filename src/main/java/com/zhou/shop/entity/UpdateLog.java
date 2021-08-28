package com.zhou.shop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 *
 * </p>
 *
 * @author 周雄
 * @since 2021-07-24
 */

@TableName("updateLog")
@ApiModel(value="update对象")
public class UpdateLog implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "更新日志表id")
    @TableId(value = "update_log_id", type = IdType.AUTO)
    private Integer updateLogId;

    @ApiModelProperty(value = "更新日志创建时间")
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
    @TableField("update_log_create_time")
    private LocalDate updateLogCreateTime;

    @ApiModelProperty(value = "更新版本号")
    @TableField("update_log_version")
    private String updateLogVersion;

    @ApiModelProperty(value = "更新日志描述")
    @TableField("update_log_description")
    private String updateLogDescription;

    public UpdateLog() {
    }

    public UpdateLog(Integer updateLogId, LocalDate updateLogCreateTime, String updateLogVersion, String updateLogDescription) {
        this.updateLogId = updateLogId;
        this.updateLogCreateTime = updateLogCreateTime;
        this.updateLogVersion = updateLogVersion;
        this.updateLogDescription = updateLogDescription;
    }

    public Integer getUpdateLogId() {
        return updateLogId;
    }

    public void setUpdateLogId(Integer updateLogId) {
        this.updateLogId = updateLogId;
    }

    public LocalDate getUpdateLogCreateTime() {
        return updateLogCreateTime;
    }

    public void setUpdateLogCreateTime(LocalDate updateLogCreateTime) {
        this.updateLogCreateTime = updateLogCreateTime;
    }

    public String getUpdateLogVersion() {
        return updateLogVersion;
    }

    public void setUpdateLogVersion(String updateLogVersion) {
        this.updateLogVersion = updateLogVersion;
    }

    public String getUpdateLogDescription() {
        return updateLogDescription;
    }

    public void setUpdateLogDescription(String updateLogDescription) {
        this.updateLogDescription = updateLogDescription;
    }

    @Override
    public String toString() {
        return "UpdateLog{" +
                "updateLogId=" + updateLogId +
                ", updateLogCreateTime=" + updateLogCreateTime +
                ", updateLogVersion='" + updateLogVersion + '\'' +
                ", updateLogDescription='" + updateLogDescription + '\'' +
                '}';
    }
}
