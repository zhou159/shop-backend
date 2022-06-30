package com.zhou.shop.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author zhouxiong
 * @description:
 * @version: v1.0-2022/6/28 15:37-zhouxiong： 创建此类
 * @since 2022/6/28 15:37
 */
@ApiModel("后端返回问题对象")
public class IssueDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("问题id")
    private String issueId;

    @ApiModelProperty("问题创建时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime issueCreateTime;

    @ApiModelProperty("问题描述")
    private String issueDescription;

    @ApiModelProperty("问题类型")
    private String issueType;

    @ApiModelProperty("问题类型显示名字")
    private String issueTypeName;

    @ApiModelProperty("问题模块")
    private String issueModule;

    @ApiModelProperty("问题类型显示名字")
    private String issueModuleName;

    @ApiModelProperty("问题状态（0：未解决；1：已解决；2：无法解决；3：暂缓解决）")
    private String issueStatus;

    @ApiModelProperty("问题解决时间")
    private LocalDateTime issueSolveTime;

    @ApiModelProperty("问题关闭时间")
    private LocalDateTime issueCloseTime;

    @ApiModelProperty("问题提出人")
    private String issueCreateBy;

    @ApiModelProperty("问题逻辑删除")
    private Integer issueDeleted;

    public IssueDTO() {}

    public IssueDTO(
            String issueId,
            LocalDateTime issueCreateTime,
            String issueDescription,
            String issueType,
            String issueTypeName,
            String issueModule,
            String issueModuleName,
            String issueStatus,
            LocalDateTime issueSolveTime,
            LocalDateTime issueCloseTime,
            String issueCreateBy,
            Integer issueDeleted) {
        this.issueId = issueId;
        this.issueCreateTime = issueCreateTime;
        this.issueDescription = issueDescription;
        this.issueType = issueType;
        this.issueTypeName = issueTypeName;
        this.issueModule = issueModule;
        this.issueModuleName = issueModuleName;
        this.issueStatus = issueStatus;
        this.issueSolveTime = issueSolveTime;
        this.issueCloseTime = issueCloseTime;
        this.issueCreateBy = issueCreateBy;
        this.issueDeleted = issueDeleted;
    }

    public String getIssueId() {
        return issueId;
    }

    public void setIssueId(String issueId) {
        this.issueId = issueId;
    }

    public LocalDateTime getIssueCreateTime() {
        return issueCreateTime;
    }

    public void setIssueCreateTime(LocalDateTime issueCreateTime) {
        this.issueCreateTime = issueCreateTime;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
    }

    public String getIssueType() {
        return issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public String getIssueTypeName() {
        return issueTypeName;
    }

    public void setIssueTypeName(String issueTypeName) {
        this.issueTypeName = issueTypeName;
    }

    public String getIssueModule() {
        return issueModule;
    }

    public void setIssueModule(String issueModule) {
        this.issueModule = issueModule;
    }

    public String getIssueModuleName() {
        return issueModuleName;
    }

    public void setIssueModuleName(String issueModuleName) {
        this.issueModuleName = issueModuleName;
    }

    public String getIssueStatus() {
        return issueStatus;
    }

    public void setIssueStatus(String issueStatus) {
        this.issueStatus = issueStatus;
    }

    public LocalDateTime getIssueSolveTime() {
        return issueSolveTime;
    }

    public void setIssueSolveTime(LocalDateTime issueSolveTime) {
        this.issueSolveTime = issueSolveTime;
    }

    public LocalDateTime getIssueCloseTime() {
        return issueCloseTime;
    }

    public void setIssueCloseTime(LocalDateTime issueCloseTime) {
        this.issueCloseTime = issueCloseTime;
    }

    public String getIssueCreateBy() {
        return issueCreateBy;
    }

    public void setIssueCreateBy(String issueCreateBy) {
        this.issueCreateBy = issueCreateBy;
    }

    public Integer getIssueDeleted() {
        return issueDeleted;
    }

    public void setIssueDeleted(Integer issueDeleted) {
        this.issueDeleted = issueDeleted;
    }

    @Override
    public String toString() {
        return "IssueDTO{"
                + "issueId='"
                + issueId
                + '\''
                + ", issueCreateTime="
                + issueCreateTime
                + ", issueDescription='"
                + issueDescription
                + '\''
                + ", issueType='"
                + issueType
                + '\''
                + ", issueTypeName='"
                + issueTypeName
                + '\''
                + ", issueModule='"
                + issueModule
                + '\''
                + ", issueModuleName='"
                + issueModuleName
                + '\''
                + ", issueStatus='"
                + issueStatus
                + '\''
                + ", issueSolveTime="
                + issueSolveTime
                + ", issueCloseTime="
                + issueCloseTime
                + ", issueCreateBy='"
                + issueCreateBy
                + '\''
                + ", issueDeleted="
                + issueDeleted
                + '}';
    }
}
