package com.zhou.shop.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author 周雄
 * @since 2021-06-24
 */
@TableName("item")
@ApiModel(value = "Item对象")
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

    @ApiModelProperty(value = "商品备注")
    @TableField("item_remark")
    private String itemRemark;

    @ApiModelProperty(value = "商品价格")
    @TableField("price")
    private BigDecimal price;

    @TableField(fill = FieldFill.UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime itemUpdateTime;

    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime itemCreateTime;

    @ApiModelProperty(value = "商品图片")
    @TableField("item_picture")
    private String itemPicture;

    public Item(
            Integer itemId,
            String itemName,
            Integer shopId,
            Integer unitId,
            Integer specificationId,
            Double itemUnitQuantity,
            String itemRemark,
            BigDecimal price,
            LocalDateTime itemUpdateTime,
            LocalDateTime itemCreateTime,
            String itemPicture) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.shopId = shopId;
        this.unitId = unitId;
        this.specificationId = specificationId;
        this.itemUnitQuantity = itemUnitQuantity;
        this.itemRemark = itemRemark;
        this.price = price;
        this.itemUpdateTime = itemUpdateTime;
        this.itemCreateTime = itemCreateTime;
        this.itemPicture = itemPicture;
    }

    public Item() {}

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getUnitId() {
        return unitId;
    }

    public void setUnitId(Integer unitId) {
        this.unitId = unitId;
    }

    public Integer getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(Integer specificationId) {
        this.specificationId = specificationId;
    }

    public Double getItemUnitQuantity() {
        return itemUnitQuantity;
    }

    public void setItemUnitQuantity(Double itemUnitQuantity) {
        this.itemUnitQuantity = itemUnitQuantity;
    }

    public String getItemRemark() {
        return itemRemark;
    }

    public void setItemRemark(String itemRemark) {
        this.itemRemark = itemRemark;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDateTime getItemUpdateTime() {
        return itemUpdateTime;
    }

    public void setItemUpdateTime(LocalDateTime itemUpdateTime) {
        this.itemUpdateTime = itemUpdateTime;
    }

    public LocalDateTime getItemCreateTime() {
        return itemCreateTime;
    }

    public void setItemCreateTime(LocalDateTime itemCreateTime) {
        this.itemCreateTime = itemCreateTime;
    }

    public String getItemPicture() {
        return itemPicture;
    }

    public void setItemPicture(String itemPicture) {
        this.itemPicture = itemPicture;
    }

    @Override
    public String toString() {
        return "Item{"
                + "itemId="
                + itemId
                + ", itemName='"
                + itemName
                + '\''
                + ", shopId="
                + shopId
                + ", unitId="
                + unitId
                + ", specificationId="
                + specificationId
                + ", itemUnitQuantity="
                + itemUnitQuantity
                + ", itemRemark='"
                + itemRemark
                + '\''
                + ", price="
                + price
                + ", itemUpdateTime="
                + itemUpdateTime
                + ", itemCreateTime="
                + itemCreateTime
                + ", itemPicture='"
                + itemPicture
                + '\''
                + '}';
    }
}
