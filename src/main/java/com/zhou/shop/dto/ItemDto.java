package com.zhou.shop.dto;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ItemDto {

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

    @ApiModelProperty(value = "商店名字")
    private String shopName;

    @ApiModelProperty(value = "单位id")
    @TableField("unit_id")
    private Integer unitId;

    @ApiModelProperty(value = "单位名字")
    private String unitName;

    @ApiModelProperty(value = "商品价格")
    @TableField("price")
    private BigDecimal price;

    @ApiModelProperty(value = "规格id")
    @TableField("specification_id")
    private Integer specificationId;

    @ApiModelProperty(value = "规格名字")
    private String specificationName;

    @ApiModelProperty(value = "一单位所含的数量")
    @TableField("item_unit_quantity")
    private Double itemUnitQuantity;

    @ApiModelProperty(value = "展示的数据 规格+数量")
    private String showQuantity;

    @TableField(fill = FieldFill.UPDATE)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime itemUpdateTime;

    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime itemCreateTime;




}
