package com.zhou.shop.api.dto;

import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author zhouxiong
 * @version v0.1
 * @since 2022/7/29 10:41
 */
@ApiModel("后端返回连续剧对象")
public class SitcomDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("连续剧id")
    private String sitcomId;

    @ApiModelProperty("连续剧名称")
    private String sitcomName;

    @ApiModelProperty("开始观看日期")
    private String sitcomWatchStartTime;

    @ApiModelProperty("结束观看时间")
    private String sitcomWatchEndTime;

    @ApiModelProperty("连续剧更新状态（0：完结；1：连载；2：断更）")
    private String sitcomUpdateStatus;

    @ApiModelProperty("连续剧封面图")
    private String sitcomPicture;

    @ApiModelProperty("连续剧链接")
    private String sitcomUrl;

    @ApiModelProperty("备注")
    private String sitcomRemark;

    @ApiModelProperty("连续剧观看状态（0：看完；1：观看中；2：放弃）")
    private String sitcomWatchStatus;

    @ApiModelProperty("连续剧国家")
    private String sitcomCountry;

    @ApiModelProperty("连续剧国家显示")
    private String sitcomCountryName;

    @ApiModelProperty("连续剧导演")
    private String sitcomDirector;

    @ApiModelProperty("连续剧类型")
    private String sitcomType;

    @ApiModelProperty("连续剧类型显示名字")
    private String sitcomTypeName;

    @ApiModelProperty("连续剧风格")
    private String sitcomStyle;

    @ApiModelProperty("连续剧简介")
    private String sitcomIntro;

    @TableLogic
    @ApiModelProperty("连续剧逻辑删除")
    private Integer sitcomDeleted;

    @ApiModelProperty("用户id")
    private String userId;

    @ApiModelProperty("连续剧创建时间")
    private LocalDateTime sitcomCreateTime;

    @ApiModelProperty("连续剧更新时间")
    private LocalDateTime sitcomUpdateTime;

    public SitcomDTO() {
    }

    public SitcomDTO(String sitcomId, String sitcomName, String sitcomWatchStartTime, String sitcomWatchEndTime, String sitcomUpdateStatus, String sitcomPicture, String sitcomUrl, String sitcomRemark, String sitcomWatchStatus, String sitcomCountry, String sitcomCountryName, String sitcomDirector, String sitcomType, String sitcomTypeName, String sitcomStyle, String sitcomIntro, Integer sitcomDeleted, String userId, LocalDateTime sitcomCreateTime, LocalDateTime sitcomUpdateTime) {
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
        this.sitcomCountryName = sitcomCountryName;
        this.sitcomDirector = sitcomDirector;
        this.sitcomType = sitcomType;
        this.sitcomTypeName = sitcomTypeName;
        this.sitcomStyle = sitcomStyle;
        this.sitcomIntro = sitcomIntro;
        this.sitcomDeleted = sitcomDeleted;
        this.userId = userId;
        this.sitcomCreateTime = sitcomCreateTime;
        this.sitcomUpdateTime = sitcomUpdateTime;
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

    public String getSitcomWatchStartTime() {
        return sitcomWatchStartTime;
    }

    public void setSitcomWatchStartTime(String sitcomWatchStartTime) {
        this.sitcomWatchStartTime = sitcomWatchStartTime;
    }

    public String getSitcomWatchEndTime() {
        return sitcomWatchEndTime;
    }

    public void setSitcomWatchEndTime(String sitcomWatchEndTime) {
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

    public String getSitcomCountryName() {
        return sitcomCountryName;
    }

    public void setSitcomCountryName(String sitcomCountryName) {
        this.sitcomCountryName = sitcomCountryName;
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

    public String getSitcomTypeName() {
        return sitcomTypeName;
    }

    public void setSitcomTypeName(String sitcomTypeName) {
        this.sitcomTypeName = sitcomTypeName;
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

    public Integer getSitcomDeleted() {
        return sitcomDeleted;
    }

    public void setSitcomDeleted(Integer sitcomDeleted) {
        this.sitcomDeleted = sitcomDeleted;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDateTime getSitcomCreateTime() {
        return sitcomCreateTime;
    }

    public void setSitcomCreateTime(LocalDateTime sitcomCreateTime) {
        this.sitcomCreateTime = sitcomCreateTime;
    }

    public LocalDateTime getSitcomUpdateTime() {
        return sitcomUpdateTime;
    }

    public void setSitcomUpdateTime(LocalDateTime sitcomUpdateTime) {
        this.sitcomUpdateTime = sitcomUpdateTime;
    }

    @Override
    public String toString() {
        return "SitcomDTO{" +
                "sitcomId='" + sitcomId + '\'' +
                ", sitcomName='" + sitcomName + '\'' +
                ", sitcomWatchStartTime='" + sitcomWatchStartTime + '\'' +
                ", sitcomWatchEndTime='" + sitcomWatchEndTime + '\'' +
                ", sitcomUpdateStatus='" + sitcomUpdateStatus + '\'' +
                ", sitcomPicture='" + sitcomPicture + '\'' +
                ", sitcomUrl='" + sitcomUrl + '\'' +
                ", sitcomRemark='" + sitcomRemark + '\'' +
                ", sitcomWatchStatus='" + sitcomWatchStatus + '\'' +
                ", sitcomCountry='" + sitcomCountry + '\'' +
                ", sitcomCountryName='" + sitcomCountryName + '\'' +
                ", sitcomDirector='" + sitcomDirector + '\'' +
                ", sitcomType='" + sitcomType + '\'' +
                ", sitcomTypeName='" + sitcomTypeName + '\'' +
                ", sitcomStyle='" + sitcomStyle + '\'' +
                ", sitcomIntro='" + sitcomIntro + '\'' +
                ", sitcomDeleted=" + sitcomDeleted +
                ", userId='" + userId + '\'' +
                ", sitcomCreateTime=" + sitcomCreateTime +
                ", sitcomUpdateTime=" + sitcomUpdateTime +
                '}';
    }
}
