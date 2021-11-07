package com.zhou.shop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author 周雄
 * @since 2021-08-21
 */
@TableName("sitcom")
@ApiModel(value = "Sitcom对象")
public class Sitcom {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "连续剧id")
    @TableId(value = "sitcom_id", type = IdType.ID_WORKER_STR)
    private String sitcomId;

    @ApiModelProperty(value = "连续剧名称")
    @TableId(value = "sitcom_name")
    private String sitcomName;

    @ApiModelProperty(value = "开始观看日期")
    @TableId(value = "sitcom_watch_start_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate sitcomWatchStartTime;

    @ApiModelProperty(value = "结束观看时间")
    @TableId(value = "sitcom_watch_end_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime sitcomWatchEndTime;

    @ApiModelProperty(value = "连续剧更新状态（0：完结；1：连载；2：断更）")
    @TableId(value = "sitcom_update_status")
    private String sitcomUpdateStatus;

    @ApiModelProperty(value = "连续剧封面图")
    @TableId(value = "sitcom_picture")
    private String sitcomPicture;

    @ApiModelProperty(value = "连续剧链接")
    @TableId(value = "sitcom_url")
    private String sitcomUrl;

    @ApiModelProperty(value = "备注")
    @TableId(value = "sitcom_remark")
    private String sitcomRemark;

    @ApiModelProperty(value = "连续剧观看状态（0：看完；1：观看中；2：放弃）")
    @TableId(value = "sitcom_watch_status")
    private String sitcomWatchStatus;

    @ApiModelProperty(value = "连续剧国家")
    @TableId(value = "sitcom_country")
    private String sitcomCountry;

    @ApiModelProperty(value = "连续剧导演")
    @TableId(value = "sitcom_director")
    private String sitcomDirector;

    @ApiModelProperty(value = "连续剧类型")
    @TableId(value = "sitcom_type")
    private String sitcomType;

    @ApiModelProperty(value = "连续剧风格")
    @TableId(value = "sitcom_style")
    private String sitcomStyle;

    @ApiModelProperty(value = "连续剧简介")
    @TableId(value = "sitcom_intro")
    private String sitcomIntro;

    public Sitcom() {}

    public Sitcom(
            String sitcomId,
            String sitcomName,
            LocalDate sitcomWatchStartTime,
            LocalDateTime sitcomWatchEndTime,
            String sitcomUpdateStatus,
            String sitcomPicture,
            String sitcomUrl,
            String sitcomRemark,
            String sitcomWatchStatus,
            String sitcomCountry,
            String sitcomDirector,
            String sitcomType,
            String sitcomStyle,
            String sitcomIntro) {
        this.sitcomId = sitcomId;
        this.sitcomName = sitcomName;
        this.sitcomWatchStartTime = sitcomWatchStartTime;
        this.sitcomWatchEndTime = sitcomWatchEndTime;
        this.sitcomUpdateStatus = sitcomUpdateStatus;
        this.sitcomPicture = sitcomPicture;
        this.sitcomUrl = sitcomUrl;
        this.sitcomRemark = sitcomRemark;
        this.sitcomWatchStatus = sitcomWatchStatus;
        this.sitcomCountry = sitcomCountry;
        this.sitcomDirector = sitcomDirector;
        this.sitcomType = sitcomType;
        this.sitcomStyle = sitcomStyle;
        this.sitcomIntro = sitcomIntro;
    }

    public String getSitcomId() {
        return sitcomId;
    }

    public void setSitcomId(String sitcomId) {
        this.sitcomId = sitcomId;
    }

    public String getSitcomName() {
        return sitcomName;
    }

    public void setSitcomName(String sitcomName) {
        this.sitcomName = sitcomName;
    }

    public LocalDate getSitcomWatchStartTime() {
        return sitcomWatchStartTime;
    }

    public void setSitcomWatchStartTime(LocalDate sitcomWatchStartTime) {
        this.sitcomWatchStartTime = sitcomWatchStartTime;
    }

    public LocalDateTime getSitcomWatchEndTime() {
        return sitcomWatchEndTime;
    }

    public void setSitcomWatchEndTime(LocalDateTime sitcomWatchEndTime) {
        this.sitcomWatchEndTime = sitcomWatchEndTime;
    }

    public String getSitcomUpdateStatus() {
        return sitcomUpdateStatus;
    }

    public void setSitcomUpdateStatus(String sitcomUpdateStatus) {
        this.sitcomUpdateStatus = sitcomUpdateStatus;
    }

    public String getSitcomPicture() {
        return sitcomPicture;
    }

    public void setSitcomPicture(String sitcomPicture) {
        this.sitcomPicture = sitcomPicture;
    }

    public String getSitcomUrl() {
        return sitcomUrl;
    }

    public void setSitcomUrl(String sitcomUrl) {
        this.sitcomUrl = sitcomUrl;
    }

    public String getSitcomRemark() {
        return sitcomRemark;
    }

    public void setSitcomRemark(String sitcomRemark) {
        this.sitcomRemark = sitcomRemark;
    }

    public String getSitcomWatchStatus() {
        return sitcomWatchStatus;
    }

    public void setSitcomWatchStatus(String sitcomWatchStatus) {
        this.sitcomWatchStatus = sitcomWatchStatus;
    }

    public String getSitcomCountry() {
        return sitcomCountry;
    }

    public void setSitcomCountry(String sitcomCountry) {
        this.sitcomCountry = sitcomCountry;
    }

    public String getSitcomDirector() {
        return sitcomDirector;
    }

    public void setSitcomDirector(String sitcomDirector) {
        this.sitcomDirector = sitcomDirector;
    }

    public String getSitcomType() {
        return sitcomType;
    }

    public void setSitcomType(String sitcomType) {
        this.sitcomType = sitcomType;
    }

    public String getSitcomStyle() {
        return sitcomStyle;
    }

    public void setSitcomStyle(String sitcomStyle) {
        this.sitcomStyle = sitcomStyle;
    }

    public String getSitcomIntro() {
        return sitcomIntro;
    }

    public void setSitcomIntro(String sitcomIntro) {
        this.sitcomIntro = sitcomIntro;
    }

    @Override
    public String toString() {
        return "Sitcom{"
                + "sitcomId='"
                + sitcomId
                + '\''
                + ", sitcomName='"
                + sitcomName
                + '\''
                + ", sitcomWatchStartTime="
                + sitcomWatchStartTime
                + ", sitcomWatchEndTime="
                + sitcomWatchEndTime
                + ", sitcomUpdateStatus='"
                + sitcomUpdateStatus
                + '\''
                + ", sitcomPicture='"
                + sitcomPicture
                + '\''
                + ", sitcomUrl='"
                + sitcomUrl
                + '\''
                + ", sitcomRemark='"
                + sitcomRemark
                + '\''
                + ", sitcomWatchStatus='"
                + sitcomWatchStatus
                + '\''
                + ", sitcomCountry='"
                + sitcomCountry
                + '\''
                + ", sitcomDirector='"
                + sitcomDirector
                + '\''
                + ", sitcomType='"
                + sitcomType
                + '\''
                + ", sitcomStyle='"
                + sitcomStyle
                + '\''
                + ", sitcomIntro='"
                + sitcomIntro
                + '\''
                + '}';
    }
}
