package com.zhou.shop.api.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 周雄
 * @date 2022/5/17 18:17
 * @description
 */
@ApiModel("码表类别")
@TableName("pub_code_type")
public class PubCodeType implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("码表主键")
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private String id;

    @ApiModelProperty("码表类别")
    @TableField("pub_code_type")
    private String pubCodeType;

    @ApiModelProperty("创建时间")
    @TableField("type_create_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime typeCreateTime;

    @ApiModelProperty("更新时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime typeUpdateTime;

    @ApiModelProperty("码表说明")
    @TableField("type_description")
    private String typeDescription;

    @ApiModelProperty("启用状态")
    @TableField("type_status")
    private Integer typeStatus;

    @ApiModelProperty("逻辑删除")
    @TableField("deleted")
    @TableLogic
    private Integer deleted;

    public PubCodeType() {}

    public PubCodeType(
            String id,
            String pubCodeType,
            LocalDateTime typeCreateTime,
            LocalDateTime typeUpdateTime,
            String typeDescription,
            Integer typeStatus,
            Integer deleted) {
        this.id = id;
        this.pubCodeType = pubCodeType;
        this.typeCreateTime = typeCreateTime;
        this.typeUpdateTime = typeUpdateTime;
        this.typeDescription = typeDescription;
        this.typeStatus = typeStatus;
        this.deleted = deleted;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPubCodeType() {
        return pubCodeType;
    }

    public void setPubCodeType(String pubCodeType) {
        this.pubCodeType = pubCodeType;
    }

    public LocalDateTime getTypeCreateTime() {
        return typeCreateTime;
    }

    public void setTypeCreateTime(LocalDateTime typeCreateTime) {
        this.typeCreateTime = typeCreateTime;
    }

    public LocalDateTime getTypeUpdateTime() {
        return typeUpdateTime;
    }

    public void setTypeUpdateTime(LocalDateTime typeUpdateTime) {
        this.typeUpdateTime = typeUpdateTime;
    }

    public String getTypeDescription() {
        return typeDescription;
    }

    public void setTypeDescription(String typeDescription) {
        this.typeDescription = typeDescription;
    }

    public Integer getTypeStatus() {
        return typeStatus;
    }

    public void setTypeStatus(Integer typeStatus) {
        this.typeStatus = typeStatus;
    }

    public Integer getDeleted() {
        return deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    @Override
    public String toString() {
        return "PubCodeType{"
                + "id='"
                + id
                + '\''
                + ", pubCodeType='"
                + pubCodeType
                + '\''
                + ", typeCreateTime='"
                + typeCreateTime
                + '\''
                + ", typeUpdateTime='"
                + typeUpdateTime
                + '\''
                + ", typeDescription='"
                + typeDescription
                + '\''
                + ", typeStatus="
                + typeStatus
                + ", deleted="
                + deleted
                + '}';
    }
}
