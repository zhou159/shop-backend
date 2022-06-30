package com.zhou.shop.api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 商品数据返回对象
 *
 * @author 周雄
 */
@ApiModel("后端返回商品对象")
public class ItemDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("商品id")
    private String itemId;

    @ApiModelProperty("商品名字")
    private String itemName;

    @ApiModelProperty("商店id")
    private String shopId;

    @ApiModelProperty("商店名字")
    private String shopName;

    @ApiModelProperty("商店地址")
    private String shopAddress;

    @ApiModelProperty("商品备注")
    private String itemRemark;

    @ApiModelProperty("单位id")
    private String unitId;

    @ApiModelProperty("单位名字")
    private String unitName;

    @ApiModelProperty("商品价格")
    private BigDecimal price;

    @ApiModelProperty("规格id")
    private String specificationId;

    @ApiModelProperty("规格名字")
    private String specificationName;

    @ApiModelProperty("一单位所含的数量")
    private Double itemUnitQuantity;

    @ApiModelProperty("展示的数据 规格+数量")
    private String showQuantity;

    @ApiModelProperty("商品更新时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime itemUpdateTime;

    @ApiModelProperty("商品创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime itemCreateTime;

    @ApiModelProperty("商品图片")
    private String itemPicture;

    @ApiModelProperty("标签id")
    private String flagId;

    @ApiModelProperty("标签名字")
    private String flagName;

    public ItemDTO() {}

    public ItemDTO(
            String itemId,
            String itemName,
            String shopId,
            String shopName,
            String shopAddress,
            String itemRemark,
            String unitId,
            String unitName,
            BigDecimal price,
            String specificationId,
            String specificationName,
            Double itemUnitQuantity,
            String showQuantity,
            LocalDateTime itemUpdateTime,
            LocalDateTime itemCreateTime,
            String itemPicture,
            String flagId,
            String flagName) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.shopId = shopId;
        this.shopName = shopName;
        this.shopAddress = shopAddress;
        this.itemRemark = itemRemark;
        this.unitId = unitId;
        this.unitName = unitName;
        this.price = price;
        this.specificationId = specificationId;
        this.specificationName = specificationName;
        this.itemUnitQuantity = itemUnitQuantity;
        this.showQuantity = showQuantity;
        this.itemUpdateTime = itemUpdateTime;
        this.itemCreateTime = itemCreateTime;
        this.itemPicture = itemPicture;
        this.flagId = flagId;
        this.flagName = flagName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getItemPicture() {
        return itemPicture;
    }

    public void setItemPicture(String itemPicture) {
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

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public String getItemRemark() {
        return itemRemark;
    }

    public void setItemRemark(String itemRemark) {
        this.itemRemark = itemRemark;
    }

    public String getUnitId() {
        return unitId;
    }

    public void setUnitId(String unitId) {
        this.unitId = unitId;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
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

    public Double getItemUnitQuantity() {
        return itemUnitQuantity;
    }

    public void setItemUnitQuantity(Double itemUnitQuantity) {
        this.itemUnitQuantity = itemUnitQuantity;
    }

    public String getShowQuantity() {
        return showQuantity;
    }

    public void setShowQuantity(String showQuantity) {
        this.showQuantity = showQuantity;
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

    public String getFlagId() {
        return flagId;
    }

    public void setFlagId(String flagId) {
        this.flagId = flagId;
    }

    public String getFlagName() {
        return flagName;
    }

    public void setFlagName(String flagName) {
        this.flagName = flagName;
    }

    @Override
    public String toString() {
        return "ItemDTO{"
                + "itemId='"
                + itemId
                + '\''
                + ", itemName='"
                + itemName
                + '\''
                + ", shopId='"
                + shopId
                + '\''
                + ", shopName='"
                + shopName
                + '\''
                + ", shopAddress='"
                + shopAddress
                + '\''
                + ", itemRemark='"
                + itemRemark
                + '\''
                + ", unitId='"
                + unitId
                + '\''
                + ", unitName='"
                + unitName
                + '\''
                + ", price="
                + price
                + ", specificationId='"
                + specificationId
                + '\''
                + ", specificationName='"
                + specificationName
                + '\''
                + ", itemUnitQuantity="
                + itemUnitQuantity
                + ", showQuantity='"
                + showQuantity
                + '\''
                + ", itemUpdateTime="
                + itemUpdateTime
                + ", itemCreateTime="
                + itemCreateTime
                + ", itemPicture='"
                + itemPicture
                + '\''
                + ", flagId='"
                + flagId
                + '\''
                + ", flagName='"
                + flagName
                + '\''
                + '}';
    }
}
