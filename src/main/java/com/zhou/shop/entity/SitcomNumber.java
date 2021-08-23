package com.zhou.shop.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;

/**
 * @author 周雄
 * @since 2021-08-21
 */
@TableName("sitcom_number")
@ApiModel(value = "SitcomNumber对象")
public class SitcomNumber {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "集数id")
    @TableId(value = "sitcom_number_id")
    private String sitcomNumberId;

    @ApiModelProperty(value = "观看时间")
    @TableId(value = "sitcom_number_watch_time")
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    private LocalDate sitcomNumberWatchTime;

    @ApiModelProperty(value = "连续剧id")
    @TableId(value = "sitcom_id")
    private String sitcomId;

    @ApiModelProperty(value = "集数名")
    @TableId(value = "sitcom_number_name")
    private String sitcomNumberName;

    @ApiModelProperty(value = "集数链接")
    @TableId(value = "sitcom_number_url")
    private String sitcomNumberUrl;

    @ApiModelProperty(value = "集数链接备注")
    @TableId(value = "sitcom_number_url_remark")
    private String sitcomNumberUrlRemark;

    @ApiModelProperty(value = "集数备注")
    @TableId(value = "sitcom_number_remark")
    private String sitcomNumberRemark;

    @ApiModelProperty(value = "集数")
    @TableId(value = "sitcom_number_number")
    private String sitcomNumberNumber;

    public SitcomNumber() {}

    public SitcomNumber(
            String sitcomNumberId,
            LocalDate sitcomNumberWatchTime,
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

    public void setSitcomNumberId(String sitcomNumberId) {
        this.sitcomNumberId = sitcomNumberId;
    }

    public LocalDate getSitcomNumberWatchTime() {
        return sitcomNumberWatchTime;
    }

    public void setSitcomNumberWatchTime(LocalDate sitcomNumberWatchTime) {
        this.sitcomNumberWatchTime = sitcomNumberWatchTime;
    }

    public String getSitcomId() {
        return sitcomId;
    }

    public void setSitcomId(String sitcomId) {
        this.sitcomId = sitcomId;
    }

    public String getSitcomNumberName() {
        return sitcomNumberName;
    }

    public void setSitcomNumberName(String sitcomNumberName) {
        this.sitcomNumberName = sitcomNumberName;
    }

    public String getSitcomNumberUrl() {
        return sitcomNumberUrl;
    }

    public void setSitcomNumberUrl(String sitcomNumberUrl) {
        this.sitcomNumberUrl = sitcomNumberUrl;
    }

    public String getSitcomNumberUrlRemark() {
        return sitcomNumberUrlRemark;
    }

    public void setSitcomNumberUrlRemark(String sitcomNumberUrlRemark) {
        this.sitcomNumberUrlRemark = sitcomNumberUrlRemark;
    }

    public String getSitcomNumberRemark() {
        return sitcomNumberRemark;
    }

    public void setSitcomNumberRemark(String sitcomNumberRemark) {
        this.sitcomNumberRemark = sitcomNumberRemark;
    }

    public String getSitcomNumberNumber() {
        return sitcomNumberNumber;
    }

    public void setSitcomNumberNumber(String sitcomNumberNumber) {
        this.sitcomNumberNumber = sitcomNumberNumber;
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
