package com.zhou.shop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author 周雄
 * @since 2021-07-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("specification")
@ApiModel(value="Specification对象", description="")
public class Specification {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "规格id")
    @TableId(value = "specification_id", type = IdType.AUTO)
    private Integer specificationId;

    @ApiModelProperty(value = "规格名字")
    @TableField("specification_name")
    private String specificationName;

    @ApiModelProperty(value = "规格说明")
    @TableField("specification_label")
    private String specificationLabel;
}
