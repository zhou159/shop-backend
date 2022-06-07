package com.zhou.shop.api.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author 周雄
 * @since 2021-08-21
 */
@TableName("sitcom")
@ApiModel(value = "Sitcom对象")
public class Sitcom {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "连续剧id")
    @TableId(value = "sitcom_id", type = IdType.ASSIGN_ID)
    private String sitcomId;

    @ApiModelProperty(value = "连续剧名称")
    @TableField(value = "sitcom_name")
    private String sitcomName;

    @ApiModelProperty(value = "开始观看日期")
    @TableField(value = "sitcom_watch_start_time")
    // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private String sitcomWatchStartTime;

    @ApiModelProperty(value = "结束观看时间")
    @TableField(value = "sitcom_watch_end_time", updateStrategy = FieldStrategy.IGNORED)
    // @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private String sitcomWatchEndTime;

    @ApiModelProperty(value = "连续剧更新状态（0：完结；1：连载；2：断更）")
    @TableField(value = "sitcom_update_status")
    private String sitcomUpdateStatus;

    @ApiModelProperty(value = "连续剧封面图")
    @TableField(value = "sitcom_picture")
    private String sitcomPicture;

    @ApiModelProperty(value = "连续剧链接")
    @TableField(value = "sitcom_url")
    private String sitcomUrl;

    @ApiModelProperty(value = "备注")
    @TableField(value = "sitcom_remark")
    private String sitcomRemark;

    @ApiModelProperty(value = "连续剧观看状态（0：看完；1：观看中；2：放弃）")
    @TableField(value = "sitcom_watch_status")
    private String sitcomWatchStatus;

    @ApiModelProperty(value = "连续剧国家")
    @TableField(value = "sitcom_country")
    private String sitcomCountry;

    @ApiModelProperty(value = "连续剧导演")
    @TableField(value = "sitcom_director")
    private String sitcomDirector;

    @ApiModelProperty(value = "连续剧类型")
    @TableField(value = "sitcom_type")
    private String sitcomType;

    @ApiModelProperty(value = "连续剧风格")
    @TableField(value = "sitcom_style")
    private String sitcomStyle;

    @ApiModelProperty(value = "连续剧简介")
    @TableField(value = "sitcom_intro")
    private String sitcomIntro;

    @TableLogic
    @ApiModelProperty(value = "连续剧逻辑删除")
    @TableField(value = "sitcom_deleted")
    private Integer sitcomDeleted;

    public Sitcom() {}

    public Sitcom(
            String sitcomId,
            String sitcomName,
            String sitcomWatchStartTime,
            String sitcomWatchEndTime,
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

    public Sitcom setSitcomId(String sitcomId) {
        this.sitcomId = sitcomId;
        return this;
    }

    public String getSitcomName() {
        return sitcomName;
    }

    public Sitcom setSitcomName(String sitcomName) {
        this.sitcomName = sitcomName;
        return this;
    }

    public String getSitcomWatchStartTime() {
        return sitcomWatchStartTime;
    }

    public Sitcom setSitcomWatchStartTime(String sitcomWatchStartTime) {
        this.sitcomWatchStartTime = sitcomWatchStartTime;
        return this;
    }

    public String getSitcomWatchEndTime() {
        return sitcomWatchEndTime;
    }

    public Sitcom setSitcomWatchEndTime(String sitcomWatchEndTime) {
        this.sitcomWatchEndTime = sitcomWatchEndTime;
        return this;
    }

    public String getSitcomUpdateStatus() {
        return sitcomUpdateStatus;
    }

    public Sitcom setSitcomUpdateStatus(String sitcomUpdateStatus) {
        this.sitcomUpdateStatus = sitcomUpdateStatus;
        return this;
    }

    public String getSitcomPicture() {
        return sitcomPicture;
    }

    public Sitcom setSitcomPicture(String sitcomPicture) {
        this.sitcomPicture = sitcomPicture;
        return this;
    }

    public String getSitcomUrl() {
        return sitcomUrl;
    }

    public Sitcom setSitcomUrl(String sitcomUrl) {
        this.sitcomUrl = sitcomUrl;
        return this;
    }

    public String getSitcomRemark() {
        return sitcomRemark;
    }

    public Sitcom setSitcomRemark(String sitcomRemark) {
        this.sitcomRemark = sitcomRemark;
        return this;
    }

    public String getSitcomWatchStatus() {
        return sitcomWatchStatus;
    }

    public Sitcom setSitcomWatchStatus(String sitcomWatchStatus) {
        this.sitcomWatchStatus = sitcomWatchStatus;
        return this;
    }

    public String getSitcomCountry() {
        return sitcomCountry;
    }

    public Sitcom setSitcomCountry(String sitcomCountry) {
        this.sitcomCountry = sitcomCountry;
        return this;
    }

    public String getSitcomDirector() {
        return sitcomDirector;
    }

    public Sitcom setSitcomDirector(String sitcomDirector) {
        this.sitcomDirector = sitcomDirector;
        return this;
    }

    public String getSitcomType() {
        return sitcomType;
    }

    public Sitcom setSitcomType(String sitcomType) {
        this.sitcomType = sitcomType;
        return this;
    }

    public String getSitcomStyle() {
        return sitcomStyle;
    }

    public Sitcom setSitcomStyle(String sitcomStyle) {
        this.sitcomStyle = sitcomStyle;
        return this;
    }

    public String getSitcomIntro() {
        return sitcomIntro;
    }

    public Sitcom setSitcomIntro(String sitcomIntro) {
        this.sitcomIntro = sitcomIntro;
        return this;
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
