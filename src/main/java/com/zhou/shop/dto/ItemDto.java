package com.zhou.shop.dto;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 商品数据返回对象
 *
 * @author 周雄
 */
public class ItemDto {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商品id")
    @TableId(value = "item_id", type = IdType.AUTO)
    private String itemId;

    @ApiModelProperty(value = "商品名字")
    @TableField("item_name")
    private String itemName;

    @ApiModelProperty(value = "商店id")
    @TableField("shop_id")
    private String shopId;

    @ApiModelProperty(value = "商店名字")
    private String shopName;

    @ApiModelProperty(value = "商店地址")
    private String shopAddress;

    @ApiModelProperty(value = "商品备注")
    private String itemRemark;

    @ApiModelProperty(value = "单位id")
    @TableField("unit_id")
    private String unitId;

    @ApiModelProperty(value = "单位名字")
    private String unitName;

    @ApiModelProperty(value = "商品价格")
    @TableField("price")
    private BigDecimal price;

    @ApiModelProperty(value = "规格id")
    @TableField("specification_id")
    private String specificationId;

    @ApiModelProperty(value = "规格名字")
    private String specificationName;

    @ApiModelProperty(value = "一单位所含的数量")
    @TableField("item_unit_quantity")
    private Double itemUnitQuantity;

    @ApiModelProperty(value = "展示的数据 规格+数量")
    private String showQuantity;

    @TableField(fill = FieldFill.UPDATE)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime itemUpdateTime;

    @TableField(fill = FieldFill.INSERT)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime itemCreateTime;

    @ApiModelProperty(value = "商品图片")
    private String itemPicture;

    @ApiModelProperty(value = "标签id")
    @TableField("flag_id")
    private String flagId;

    @ApiModelProperty(value = "标签名字")
    @TableField("flag_name")
    private String flagName;

    public ItemDto() {}

    public ItemDto(
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
        return "ItemDto{"
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
