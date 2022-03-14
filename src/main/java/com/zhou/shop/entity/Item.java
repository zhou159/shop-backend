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
    @TableId(value = "item_id", type = IdType.ASSIGN_ID)
    private String itemId;

    @ApiModelProperty(value = "商品名字")
    @TableField("item_name")
    private String itemName;

    @ApiModelProperty(value = "商店id")
    @TableField("shop_id")
    private String shopId;

    @ApiModelProperty(value = "单位id")
    @TableField("unit_id")
    private String unitId;

    @ApiModelProperty(value = "规格id")
    @TableField("specification_id")
    private String specificationId;

    @ApiModelProperty(value = "一单位所含的数量")
    @TableField("item_unit_quantity")
    private Double itemUnitQuantity;

    @ApiModelProperty(value = "商品备注")
    @TableField("item_remark")
    private String itemRemark;

    @ApiModelProperty(value = "商品价格")
    @TableField("price")
    private BigDecimal price;

    @ApiModelProperty(value = "标签id")
    @TableField("flag_id")
    private String flagId;

    @TableField(fill = FieldFill.UPDATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime itemUpdateTime;

    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime itemCreateTime;

    @ApiModelProperty(value = "商品图片")
    @TableField("item_picture")
    private String itemPicture;

    public Item(
            String itemId,
            String itemName,
            String shopId,
            String unitId,
            String specificationId,
            Double itemUnitQuantity,
            String itemRemark,
            BigDecimal price,
            String flagId,
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
        this.flagId = flagId;
        this.itemUpdateTime = itemUpdateTime;
        this.itemCreateTime = itemCreateTime;
        this.itemPicture = itemPicture;
    }

    public Item() {}

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public String getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(String specificationId) {
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

    public String getFlagId() {
        return flagId;
    }

    public void setFlagId(String flagId) {
        this.flagId = flagId;
    }

    @Override
    public String toString() {
        return "Item{"
                + "itemId='"
                + itemId
                + '\''
                + ", itemName='"
                + itemName
                + '\''
                + ", shopId='"
                + shopId
                + '\''
                + ", unitId='"
                + unitId
                + '\''
                + ", specificationId='"
                + specificationId
                + '\''
                + ", itemUnitQuantity="
                + itemUnitQuantity
                + ", itemRemark='"
                + itemRemark
                + '\''
                + ", price="
                + price
                + ", flagId='"
                + flagId
                + '\''
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
