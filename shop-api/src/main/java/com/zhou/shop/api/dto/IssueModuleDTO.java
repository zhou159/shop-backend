package com.zhou.shop.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * 问题模块数据返回对象
 *
 * @author 周雄
 */
@ApiModel("后端返回问题模块对象")
public class IssueModuleDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("问题模块中文")
    private String issueModuleCh;

    @ApiModelProperty("问题模块英文")
    private String issueModuleEn;

    public IssueModuleDTO() {}

    public IssueModuleDTO(String issueModuleCh, String issueModuleEn) {
        this.issueModuleCh = issueModuleCh;
        this.issueModuleEn = issueModuleEn;
    }

    public String getIssueModuleCh() {
        return issueModuleCh;
    }

    public void setIssueModuleCh(String issueModuleCh) {
        this.issueModuleCh = issueModuleCh;
    }

    public String getIssueModuleEn() {
        return issueModuleEn;
    }

    public void setIssueModuleEn(String issueModuleEn) {
        this.issueModuleEn = issueModuleEn;
    }

    @Override
    public String toString() {
        return "IssueModuleDTO{"
                + "IssueModuleCh='"
                + issueModuleCh
                + '\''
                + ", IssueModuleEn='"
                + issueModuleEn
                + '\''
                + '}';
    }
}
