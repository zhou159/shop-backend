package com.zhou.shop.api.entity.privates;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author 周雄
 * @since 2021-07-20
 */
@TableName("specification")
@ApiModel(value = "Specification对象")
public class Specification {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "规格id")
    @TableId(value = "specification_id", type = IdType.ASSIGN_ID)
    private String specificationId;

    @ApiModelProperty(value = "规格名字")
    @TableField("specification_name")
    private String specificationName;

    @ApiModelProperty(value = "规格说明")
    @TableField("specification_label")
    private String specificationLabel;

    @TableLogic
    @ApiModelProperty(value = "规格说明")
    @TableField("specification_deleted")
    private Integer specificationDeleted;

    public Specification() {}

    public Specification(
            String specificationId, String specificationName, String specificationLabel) {
        this.specificationId = specificationId;
        this.specificationName = specificationName;
        this.specificationLabel = specificationLabel;
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

    @Override
    public String toString() {
        return "Specification{"
                + "specificationId="
                + specificationId
                + ", specificationName='"
                + specificationName
                + '\''
                + ", specificationLabel='"
                + specificationLabel
                + '\''
                + '}';
    }
}
