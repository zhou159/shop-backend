package com.zhou.shop.api.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 周雄
 * @since 2021-08-26
 */
@TableName("issue")
@ApiModel("Issue对象")
public class Issue implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("问题id")
    @TableId(value = "issue_id", type = IdType.ASSIGN_ID)
    private String issueId;

    @ApiModelProperty("问题创建时间")
    @TableField("issue_create_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime issueCreateTime;

    @ApiModelProperty("问题描述")
    @TableField("issue_description")
    private String issueDescription;

    @ApiModelProperty("问题类型")
    @TableField("issue_type")
    private String issueType;

    @ApiModelProperty("问题模块")
    @TableField("issue_module")
    private String issueModule;

    @ApiModelProperty("问题状态（0：未解决；1：已解决；2：无法解决；3：暂缓解决）")
    @TableField("issue_status")
    private String issueStatus;

    @ApiModelProperty("问题解决时间")
    @TableField("issue_solve_time")
    private LocalDateTime issueSolveTime;

    @ApiModelProperty("问题关闭时间")
    @TableField("issue_close_time")
    private LocalDateTime issueCloseTime;

    @ApiModelProperty("问题提出人")
    @TableField("issue_create_by")
    private String issueCreateBy;

    @TableLogic
    @ApiModelProperty("问题逻辑删除")
    @TableField("issue_deleted")
    private Integer issueDeleted;

    public Issue(
            String issueId,
            LocalDateTime issueCreateTime,
            String issueDescription,
            String issueType,
            String issueModule,
            String issueStatus,
            LocalDateTime issueSolveTime,
            LocalDateTime issueCloseTime,
            String issueCreateBy) {
        this.issueId = issueId;
        this.issueCreateTime = issueCreateTime;
        this.issueDescription = issueDescription;
        this.issueType = issueType;
        this.issueModule = issueModule;
        this.issueStatus = issueStatus;
        this.issueSolveTime = issueSolveTime;
        this.issueCloseTime = issueCloseTime;
        this.issueCreateBy = issueCreateBy;
    }

    public Issue() {}

    public String getIssueStatus() {
        return issueStatus;
    }

    public Issue setIssueStatus(String issueStatus) {
        this.issueStatus = issueStatus;
        return this;
    }

    public String getIssueId() {
        return issueId;
    }

    public Issue setIssueId(String issueId) {
        this.issueId = issueId;
        return this;
    }

    public LocalDateTime getIssueCreateTime() {
        return issueCreateTime;
    }

    public Issue setIssueCreateTime(LocalDateTime issueCreateTime) {
        this.issueCreateTime = issueCreateTime;
        return this;
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public Issue setIssueDescription(String issueDescription) {
        this.issueDescription = issueDescription;
        return this;
    }

    public String getIssueType() {
        return issueType;
    }

    public Issue setIssueType(String issueType) {
        this.issueType = issueType;
        return this;
    }

    public String getIssueModule() {
        return issueModule;
    }

    public Issue setIssueModule(String issueModule) {
        this.issueModule = issueModule;
        return this;
    }

    public LocalDateTime getIssueSolveTime() {
        return issueSolveTime;
    }

    public Issue setIssueSolveTime(LocalDateTime issueSolveTime) {
        this.issueSolveTime = issueSolveTime;
        return this;
    }

    public LocalDateTime getIssueCloseTime() {
        return issueCloseTime;
    }

    public Issue setIssueCloseTime(LocalDateTime issueCloseTime) {
        this.issueCloseTime = issueCloseTime;
        return this;
    }

    public String getIssueCreateBy() {
        return issueCreateBy;
    }

    public Issue setIssueCreateBy(String issueCreateBy) {
        this.issueCreateBy = issueCreateBy;
        return this;
    }

    @Override
    public String toString() {
        return "Issue{"
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
                + ", issueModule='"
                + issueModule
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
                + '}';
    }
}
