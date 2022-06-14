package com.zhou.shop.api.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 商品前端传入对象 个人理解的是vo是页面对象，也就是返回给前端的对象
 *
 * @author 周雄
 * @since 2021-08-28
 */
@TableName("item")
@ApiModel("Item对象")
public class ItemVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("商品id")
    private String itemId;

    @ApiModelProperty("商品名字")
    private String itemName;

    @ApiModelProperty("商店id")
    private String shopId;

    @ApiModelProperty("单位id")
    private String unitId;

    @ApiModelProperty("规格id")
    private String specificationId;

    @ApiModelProperty("一单位所含的数量")
    private Double itemUnitQuantity;

    @ApiModelProperty("商品备注")
    private String itemRemark;

    @ApiModelProperty("商品价格")
    private BigDecimal price;

    @ApiModelProperty("标签名")
    private String flagName;

    @ApiModelProperty("标签id")
    private String flagId;

    @ApiModelProperty("商品更新时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime itemUpdateTime;

    @ApiModelProperty("商品创建时间")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime itemCreateTime;

    @ApiModelProperty("商品图片")
    private String itemPicture;

    public ItemVO() {}

    public ItemVO(
            String itemId,
            String itemName,
            String shopId,
            String unitId,
            String specificationId,
            Double itemUnitQuantity,
            String itemRemark,
            BigDecimal price,
            String flagName,
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
        this.flagName = flagName;
        this.flagId = flagId;
        this.itemUpdateTime = itemUpdateTime;
        this.itemCreateTime = itemCreateTime;
        this.itemPicture = itemPicture;
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

    public String getFlagName() {
        return flagName;
    }

    public void setFlagName(String flagName) {
        this.flagName = flagName;
    }

    public String getFlagId() {
        return flagId;
    }

    public void setFlagId(String flagId) {
        this.flagId = flagId;
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
        return "ItemVO{"
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
                + ", flagName='"
                + flagName
                + '\''
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
