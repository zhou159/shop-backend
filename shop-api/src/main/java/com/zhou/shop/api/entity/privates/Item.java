package com.zhou.shop.api.entity.privates;

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
@ApiModel("商品")
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("商品id")
    @TableId(value = "item_id", type = IdType.ASSIGN_ID)
    private String itemId;

    @ApiModelProperty("商品名字")
    @TableField("item_name")
    private String itemName;

    @ApiModelProperty("商店id")
    @TableField("shop_id")
    private String shopId;

    @ApiModelProperty("单位id")
    @TableField("unit_id")
    private String unitId;

    @ApiModelProperty("规格id")
    @TableField("specification_id")
    private String specificationId;

    @ApiModelProperty("一单位所含的数量")
    @TableField("item_unit_quantity")
    private Double itemUnitQuantity;

    @ApiModelProperty("商品备注")
    @TableField("item_remark")
    private String itemRemark;

    @ApiModelProperty("商品价格")
    @TableField("price")
    private BigDecimal price;

    @ApiModelProperty("标签id")
    @TableField("flag_id")
    private String flagId;

    @ApiModelProperty("商品更新时间")
    @TableField(fill = FieldFill.UPDATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime itemUpdateTime;

    @ApiModelProperty("商品创建时间")
    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime itemCreateTime;

    @ApiModelProperty("商品图片")
    @TableField("item_picture")
    private String itemPicture;

    @TableLogic
    @ApiModelProperty("商品逻辑删除")
    @TableField("item_deleted")
    private Integer itemDeleted;

    @ApiModelProperty("用户id")
    @TableField("user_id")
    private String userId;

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
            String itemPicture,
            Integer itemDeleted,
            String userId) {
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
        this.itemDeleted = itemDeleted;
        this.userId = userId;
    }

    public Item() {}

    public String getItemId() {
        return itemId;
    }

    public Item setItemId(String itemId) {
        this.itemId = itemId;
        return this;
    }

    public String getItemName() {
        return itemName;
    }

    public Item setItemName(String itemName) {
        this.itemName = itemName;
        return this;
    }

    public String getShopId() {
        return shopId;
    }

    public Item setShopId(String shopId) {
        this.shopId = shopId;
        return this;
    }

    public String getUnitId() {
        return unitId;
    }

    public Item setUnitId(String unitId) {
        this.unitId = unitId;
        return this;
    }

    public String getSpecificationId() {
        return specificationId;
    }

    public Item setSpecificationId(String specificationId) {
        this.specificationId = specificationId;
        return this;
    }

    public Double getItemUnitQuantity() {
        return itemUnitQuantity;
    }

    public Item setItemUnitQuantity(Double itemUnitQuantity) {
        this.itemUnitQuantity = itemUnitQuantity;
        return this;
    }

    public String getItemRemark() {
        return itemRemark;
    }

    public Item setItemRemark(String itemRemark) {
        this.itemRemark = itemRemark;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Item setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public LocalDateTime getItemUpdateTime() {
        return itemUpdateTime;
    }

    public Item setItemUpdateTime(LocalDateTime itemUpdateTime) {
        this.itemUpdateTime = itemUpdateTime;
        return this;
    }

    public LocalDateTime getItemCreateTime() {
        return itemCreateTime;
    }

    public Item setItemCreateTime(LocalDateTime itemCreateTime) {
        this.itemCreateTime = itemCreateTime;
        return this;
    }

    public String getItemPicture() {
        return itemPicture;
    }

    public Item setItemPicture(String itemPicture) {
        this.itemPicture = itemPicture;
        return this;
    }

    public String getFlagId() {
        return flagId;
    }

    public Item setFlagId(String flagId) {
        this.flagId = flagId;
        return this;
    }

    public Integer getItemDeleted() {
        return itemDeleted;
    }

    public void setItemDeleted(Integer itemDeleted) {
        this.itemDeleted = itemDeleted;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
                + ", itemDeleted="
                + itemDeleted
                + ", userId='"
                + userId
                + '\''
                + '}';
    }
}
