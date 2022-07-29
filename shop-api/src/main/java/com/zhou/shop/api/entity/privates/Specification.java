package com.zhou.shop.api.entity.privates;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 周雄
 * @since 2021-07-20
 */
@TableName("specification")
@ApiModel("规格")
public class Specification implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("规格id")
    @TableId(value = "specification_id", type = IdType.ASSIGN_ID)
    private String specificationId;

    @ApiModelProperty("规格名字")
    @TableField("specification_name")
    private String specificationName;

    @ApiModelProperty("规格说明")
    @TableField("specification_label")
    private String specificationLabel;

    @TableLogic
    @ApiModelProperty("规格说明")
    @TableField("specification_deleted")
    private Integer specificationDeleted;

    @ApiModelProperty("用户id")
    @TableField("user_id")
    private String userId;

    @ApiModelProperty("规格创建时间")
    @TableField("specification_create_time")
    private LocalDateTime specificationCreateTime;

    @ApiModelProperty("规格更新时间")
    @TableField("specification_update_time")
    private LocalDateTime specificationUpdateTime;

    public Specification() {}

    public Specification(String specificationId, String specificationName, String specificationLabel, Integer specificationDeleted, String userId, LocalDateTime specificationCreateTime, LocalDateTime specificationUpdateTime) {
        this.specificationId = specificationId;
        this.specificationName = specificationName;
        this.specificationLabel = specificationLabel;
        this.specificationDeleted = specificationDeleted;
        this.userId = userId;
        this.specificationCreateTime = specificationCreateTime;
        this.specificationUpdateTime = specificationUpdateTime;
    }

    public String getSpecificationId() {
        return specificationId;
    }

    public Specification setSpecificationId(String specificationId) {
        this.specificationId = specificationId;
        return this;
    }

    public String getSpecificationName() {
        return specificationName;
    }

    public Specification setSpecificationName(String specificationName) {
        this.specificationName = specificationName;
        return this;
    }

    public String getSpecificationLabel() {
        return specificationLabel;
    }

    public Specification setSpecificationLabel(String specificationLabel) {
        this.specificationLabel = specificationLabel;
        return this;
    }

    public Integer getSpecificationDeleted() {
        return specificationDeleted;
    }

    public void setSpecificationDeleted(Integer specificationDeleted) {
        this.specificationDeleted = specificationDeleted;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDateTime getSpecificationCreateTime() {
        return specificationCreateTime;
    }

    public void setSpecificationCreateTime(LocalDateTime specificationCreateTime) {
        this.specificationCreateTime = specificationCreateTime;
    }

    public LocalDateTime getSpecificationUpdateTime() {
        return specificationUpdateTime;
    }

    public void setSpecificationUpdateTime(LocalDateTime specificationUpdateTime) {
        this.specificationUpdateTime = specificationUpdateTime;
    }

    @Override
    public String toString() {
        return "Specification{" +
                "specificationId='" + specificationId + '\'' +
                ", specificationName='" + specificationName + '\'' +
                ", specificationLabel='" + specificationLabel + '\'' +
                ", specificationDeleted=" + specificationDeleted +
                ", userId='" + userId + '\'' +
                ", specificationCreateTime='" + specificationCreateTime + '\'' +
                ", specificationUpdateTime='" + specificationUpdateTime + '\'' +
                '}';
    }
}
