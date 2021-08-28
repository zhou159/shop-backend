package com.zhou.shop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 *
 * </p>
 *
 * @author 周雄
 * @since 2021-07-20
 */

@TableName("specification")
@ApiModel(value="Specification对象")
public class Specification {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "规格id")
    @TableId(value = "specification_id", type = IdType.ID_WORKER_STR)
    private String specificationId;

    @ApiModelProperty(value = "规格名字")
    @TableField("specification_name")
    private String specificationName;

    @ApiModelProperty(value = "规格说明")
    @TableField("specification_label")
    private String specificationLabel;

    public Specification() {
    }

    public Specification(String specificationId, String specificationName, String specificationLabel) {
        this.specificationId = specificationId;
        this.specificationName = specificationName;
        this.specificationLabel = specificationLabel;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(String specificationId) {
        this.specificationId = specificationId;
    }

    public String getSpecificationName() {
        return specificationName;
    }

    public void setSpecificationName(String specificationName) {
        this.specificationName = specificationName;
    }

    public String getSpecificationLabel() {
        return specificationLabel;
    }

    public void setSpecificationLabel(String specificationLabel) {
        this.specificationLabel = specificationLabel;
    }

    @Override
    public String toString() {
        return "Specification{" +
                "specificationId=" + specificationId +
                ", specificationName='" + specificationName + '\'' +
                ", specificationLabel='" + specificationLabel + '\'' +
                '}';
    }
}
