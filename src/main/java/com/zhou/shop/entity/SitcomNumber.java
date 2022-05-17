package com.zhou.shop.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author 周雄
 * @since 2021-08-21
 */
@TableName("sitcom_number")
@ApiModel(value = "SitcomNumber对象")
public class SitcomNumber {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "集数id")
    @TableId(value = "sitcom_number_id", type = IdType.ASSIGN_ID)
    private String sitcomNumberId;

    @ApiModelProperty(value = "观看时间")
    @TableField(value = "sitcom_number_watch_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private String sitcomNumberWatchTime;

    @ApiModelProperty(value = "连续剧id")
    @TableField(value = "sitcom_id")
    private String sitcomId;

    @ApiModelProperty(value = "集数名")
    @TableField(value = "sitcom_number_name")
    private String sitcomNumberName;

    @ApiModelProperty(value = "集数链接")
    @TableField(value = "sitcom_number_url")
    private String sitcomNumberUrl;

    @ApiModelProperty(value = "集数链接备注")
    @TableField(value = "sitcom_number_url_remark")
    private String sitcomNumberUrlRemark;

    @ApiModelProperty(value = "集数备注")
    @TableField(value = "sitcom_number_remark")
    private String sitcomNumberRemark;

    @ApiModelProperty(value = "集数")
    @TableField(value = "sitcom_number_number")
    private String sitcomNumberNumber;

    @TableLogic
    @ApiModelProperty(value = "集逻辑删除")
    @TableField(value = "sitcom_number_deleted")
    private Integer sitcomNumberDeleted;

    public SitcomNumber() {}

    public SitcomNumber(
            String sitcomNumberId,
            String sitcomNumberWatchTime,
            String sitcomId,
            String sitcomNumberName,
            String sitcomNumberUrl,
            String sitcomNumberUrlRemark,
            String sitcomNumberRemark,
            String sitcomNumberNumber) {
        this.sitcomNumberId = sitcomNumberId;
        this.sitcomNumberWatchTime = sitcomNumberWatchTime;
        this.sitcomId = sitcomId;
        this.sitcomNumberName = sitcomNumberName;
        this.sitcomNumberUrl = sitcomNumberUrl;
        this.sitcomNumberUrlRemark = sitcomNumberUrlRemark;
        this.sitcomNumberRemark = sitcomNumberRemark;
        this.sitcomNumberNumber = sitcomNumberNumber;
    }

    public String getSitcomNumberId() {
        return sitcomNumberId;
    }

    public SitcomNumber setSitcomNumberId(String sitcomNumberId) {
        this.sitcomNumberId = sitcomNumberId;
        return this;
    }

    public String getSitcomNumberWatchTime() {
        return sitcomNumberWatchTime;
    }

    public SitcomNumber setSitcomNumberWatchTime(String sitcomNumberWatchTime) {
        this.sitcomNumberWatchTime = sitcomNumberWatchTime;
        return this;
    }

    public String getSitcomId() {
        return sitcomId;
    }

    public SitcomNumber setSitcomId(String sitcomId) {
        this.sitcomId = sitcomId;
        return this;
    }

    public String getSitcomNumberName() {
        return sitcomNumberName;
    }

    public SitcomNumber setSitcomNumberName(String sitcomNumberName) {
        this.sitcomNumberName = sitcomNumberName;
        return this;
    }

    public String getSitcomNumberUrl() {
        return sitcomNumberUrl;
    }

    public SitcomNumber setSitcomNumberUrl(String sitcomNumberUrl) {
        this.sitcomNumberUrl = sitcomNumberUrl;
        return this;
    }

    public String getSitcomNumberUrlRemark() {
        return sitcomNumberUrlRemark;
    }

    public SitcomNumber setSitcomNumberUrlRemark(String sitcomNumberUrlRemark) {
        this.sitcomNumberUrlRemark = sitcomNumberUrlRemark;
        return this;
    }

    public String getSitcomNumberRemark() {
        return sitcomNumberRemark;
    }

    public SitcomNumber setSitcomNumberRemark(String sitcomNumberRemark) {
        this.sitcomNumberRemark = sitcomNumberRemark;
        return this;
    }

    public String getSitcomNumberNumber() {
        return sitcomNumberNumber;
    }

    public SitcomNumber setSitcomNumberNumber(String sitcomNumberNumber) {
        this.sitcomNumberNumber = sitcomNumberNumber;
        return this;
    }

    @Override
    public String toString() {
        return "SitcomNumber{"
                + "sitcomNumberId='"
                + sitcomNumberId
                + '\''
                + ", sitcomNumberWatchTime="
                + sitcomNumberWatchTime
                + ", sitcomId='"
                + sitcomId
                + '\''
                + ", sitcomNumberName='"
                + sitcomNumberName
                + '\''
                + ", sitcomNumberUrl='"
                + sitcomNumberUrl
                + '\''
                + ", sitcomNumberUrlRemark='"
                + sitcomNumberUrlRemark
                + '\''
                + ", sitcomNumberRemark='"
                + sitcomNumberRemark
                + '\''
                + ", sitcomNumberNumber='"
                + sitcomNumberNumber
                + '\''
                + '}';
    }
}
