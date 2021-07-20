package com.zhou.shop.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
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
 * @since 2021-06-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("item")
@ApiModel(value="Item对象", description="")
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品id")
    @TableId(value = "item_id", type = IdType.AUTO)
    private Integer itemId;

    @ApiModelProperty(value = "商品名字")
    @TableField("item_name")
    private String itemName;

    @ApiModelProperty(value = "商店id")
    @TableField("shop_id")
    private Integer shopId;

    @ApiModelProperty(value = "单位id")
    @TableField("unit_id")
    private Integer unitId;

    @ApiModelProperty(value = "规格id")
    @TableField("specification_id")
    private Integer specificationId;

    @ApiModelProperty(value = "一单位所含的数量")
    @TableField("item_unit_quantity")
    private Double itemUnitQuantity;

    @ApiModelProperty(value = "商品价格")
    @TableField("price")
    private BigDecimal price;

    @TableField(fill = FieldFill.UPDATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime itemUpdateTime;

    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime itemCreateTime;




}
