package com.zhou.shop.api.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 周雄
 * @date 2022/5/17 18:17
 * @description
 */
@ApiModel("码表")
@TableName("pub_code")
public class PubCode implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("码表主键")
    @TableId(value = "pub_code_id", type = IdType.ASSIGN_ID)
    private String pubCodeId;

    @ApiModelProperty("码表名字")
    @TableField("pub_code_name")
    private String pubCodeName;

    @ApiModelProperty("码表类型")
    @TableField("pub_code_type_id")
    private String pubCodeTypeId;

    @ApiModelProperty("码表说明")
    @TableField("pub_code_description")
    private String pubCodeDescription;

    @ApiModelProperty("码表创建时间")
    @TableField("pub_code_create_time")
    private LocalDateTime pubCodeCreateTime;

    @ApiModelProperty("码表更新时间")
    @TableField("pub_code_update_time")
    private LocalDateTime pubCodeUpdateTime;

    @ApiModelProperty("逻辑删除")
    @TableField("deleted")
    @TableLogic
    private Integer deleted;

    public PubCode() {}

    public PubCode(
            String pubCodeId,
            String pubCodeName,
            String pubCodeTypeId,
            String pubCodeDescription,
            LocalDateTime pubCodeCreateTime,
            LocalDateTime pubCodeUpdateTime,
            Integer deleted) {
        this.pubCodeId = pubCodeId;
        this.pubCodeName = pubCodeName;
        this.pubCodeTypeId = pubCodeTypeId;
        this.pubCodeDescription = pubCodeDescription;
        this.pubCodeCreateTime = pubCodeCreateTime;
        this.pubCodeUpdateTime = pubCodeUpdateTime;
        this.deleted = deleted;
    }

    public String getPubCodeId() {
        return pubCodeId;
    }

    public void setPubCodeId(String pubCodeId) {
        this.pubCodeId = pubCodeId;
    }

    public String getPubCodeName() {
        return pubCodeName;
    }

    public void setPubCodeName(String pubCodeName) {
        this.pubCodeName = pubCodeName;
    }

    public String getPubCodeTypeId() {
        return pubCodeTypeId;
    }

    public void setPubCodeTypeId(String pubCodeTypeId) {
        this.pubCodeTypeId = pubCodeTypeId;
    }

    public String getPubCodeDescription() {
        return pubCodeDescription;
    }

    public void setPubCodeDescription(String pubCodeDescription) {
        this.pubCodeDescription = pubCodeDescription;
    }

    public LocalDateTime getPubCodeCreateTime() {
        return pubCodeCreateTime;
    }

    public void setPubCodeCreateTime(LocalDateTime pubCodeCreateTime) {
        this.pubCodeCreateTime = pubCodeCreateTime;
    }

    public LocalDateTime getPubCodeUpdateTime() {
        return pubCodeUpdateTime;
    }

    public void setPubCodeUpdateTime(LocalDateTime pubCodeUpdateTime) {
        this.pubCodeUpdateTime = pubCodeUpdateTime;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "PubCode{"
                + "pubCodeId='"
                + pubCodeId
                + '\''
                + ", pubCodeName='"
                + pubCodeName
                + '\''
                + ", pubCodeTypeId='"
                + pubCodeTypeId
                + '\''
                + ", pubCodeDescription='"
                + pubCodeDescription
                + '\''
                + ", pubCodeCreateTime="
                + pubCodeCreateTime
                + ", pubCodeUpdateTime="
                + pubCodeUpdateTime
                + ", deleted="
                + deleted
                + '}';
    }
}
