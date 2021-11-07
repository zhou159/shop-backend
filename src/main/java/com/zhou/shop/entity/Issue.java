package com.zhou.shop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
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
@ApiModel(value = "Issue对象")
public class Issue implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "问题id")
    @TableId(value = "issue_id", type = IdType.ID_WORKER_STR)
    private String issueId;

    @ApiModelProperty(value = "问题创建时间")
    @TableField("issue_create_time")
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime issueCreateTime;

    @ApiModelProperty(value = "问题描述")
    @TableField("issue_description")
    private String issueDescription;

    @ApiModelProperty(value = "问题类型")
    @TableField("issue_type")
    private String issueType;

    @ApiModelProperty(value = "问题模块")
    @TableField("issue_module")
    private String issueModule;

    @ApiModelProperty(value = "问题状态（0：未解决；1：已解决；2：无法解决；3：暂缓解决）")
    @TableField("issue_status")
    private String issueStatus;

    public Issue(
            String issueId,
            LocalDateTime issueCreateTime,
            String issueDescription,
            String issueType,
            String issueModule,
            String issueStatus) {
        this.issueId = issueId;
        this.issueCreateTime = issueCreateTime;
        this.issueDescription = issueDescription;
        this.issueType = issueType;
        this.issueModule = issueModule;
        this.issueStatus = issueStatus;
    }

    public Issue() {}

    public String getIssueStatus() {
        return issueStatus;
    }

    public void setIssueStatus(String issueStatus) {
        this.issueStatus = issueStatus;
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

    public String getIssueModule() {
        return issueModule;
    }

    public void setIssueModule(String issueModule) {
        this.issueModule = issueModule;
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
                + '}';
    }
}
