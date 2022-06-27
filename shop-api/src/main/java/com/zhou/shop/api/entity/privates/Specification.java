package com.zhou.shop.api.entity.privates;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author 周雄
 * @since 2021-07-20
 */
@TableName("specification")
@ApiModel("规格")
public class Specification {
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

    public Specification() {}

    public Specification(
            String specificationId,
            String specificationName,
            String specificationLabel,
            Integer specificationDeleted,
            String userId) {
        this.specificationId = specificationId;
        this.specificationName = specificationName;
        this.specificationLabel = specificationLabel;
        this.specificationDeleted = specificationDeleted;
        this.userId = userId;
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

    @Override
    public String toString() {
        return "Specification{"
                + "specificationId='"
                + specificationId
                + '\''
                + ", specificationName='"
                + specificationName
                + '\''
                + ", specificationLabel='"
                + specificationLabel
                + '\''
                + ", specificationDeleted="
                + specificationDeleted
                + ", userId='"
                + userId
                + '\''
                + '}';
    }
}
