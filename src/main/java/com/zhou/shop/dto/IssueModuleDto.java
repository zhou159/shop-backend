package com.zhou.shop.dto;

/**
 * 问题模块数据返回对象
 *
 * @author 周雄
 */
public class IssueModuleDto {
    private static final long serialVersionUID = 1L;

    private String issueModuleCh;
    private String issueModuleEn;

    public IssueModuleDto() {}

    public IssueModuleDto(String issueModuleCh, String issueModuleEn) {
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
        return "IssueModuleDto{"
                + "IssueModuleCh='"
                + issueModuleCh
                + '\''
                + ", IssueModuleEn='"
                + issueModuleEn
                + '\''
                + '}';
    }
}
