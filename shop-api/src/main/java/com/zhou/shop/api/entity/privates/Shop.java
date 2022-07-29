package com.zhou.shop.api.entity.privates;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 周雄
 * @since 2021-06-24
 */
@TableName("shop")
@ApiModel("商店")
public class Shop implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("商家表id")
    @TableId(value = "shop_id", type = IdType.ASSIGN_ID)
    private String shopId;

    @ApiModelProperty("商家店铺，超市名字")
    @TableField("shop_name")
    private String shopName;

    @ApiModelProperty("地址")
    @TableField("shop_address")
    private String shopAddress;

    @ApiModelProperty("备注")
    @TableField("shop_remark")
    private String shopRemark;

    @ApiModelProperty("地址")
    @TableField("shop_status")
    private String shopStatus;

    @ApiModelProperty("商店图片")
    @TableField("shop_picture")
    private String shopPicture;

    @TableLogic
    @ApiModelProperty("商店逻辑删除")
    @TableField("shop_deleted")
    private Integer shopDeleted;

    @ApiModelProperty("用户id")
    @TableField("user_id")
    private String userId;

    @ApiModelProperty("商店创建时间")
    @TableField("shop_create_time")
    private LocalDateTime shopCreateTime;

    @ApiModelProperty("商店更新时间")
    @TableField("shop_update_time")
    private LocalDateTime shopUpdateTime;

    public Shop() {}

    public Shop(String shopId, String shopName, String shopAddress, String shopRemark, String shopStatus, String shopPicture, Integer shopDeleted, String userId, LocalDateTime shopCreateTime, LocalDateTime shopUpdateTime) {
        this.shopId = shopId;
        this.shopName = shopName;
        this.shopAddress = shopAddress;
        this.shopRemark = shopRemark;
        this.shopStatus = shopStatus;
        this.shopPicture = shopPicture;
        this.shopDeleted = shopDeleted;
        this.userId = userId;
        this.shopCreateTime = shopCreateTime;
        this.shopUpdateTime = shopUpdateTime;
    }

    public String getShopId() {
        return shopId;
    }

    public Shop setShopId(String shopId) {
        this.shopId = shopId;
        return this;
    }

    public String getShopName() {
        return shopName;
    }

    public Shop setShopName(String shopName) {
        this.shopName = shopName;
        return this;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public Shop setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
        return this;
    }

    public String getShopRemark() {
        return shopRemark;
    }

    public Shop setShopRemark(String shopRemark) {
        this.shopRemark = shopRemark;
        return this;
    }

    public String getShopStatus() {
        return shopStatus;
    }

    public Shop setShopStatus(String shopStatus) {
        this.shopStatus = shopStatus;
        return this;
    }

    public String getShopPicture() {
        return shopPicture;
    }

    public Shop setShopPicture(String shopPicture) {
        this.shopPicture = shopPicture;
        return this;
    }

    public Integer getShopDeleted() {
        return shopDeleted;
    }

    public void setShopDeleted(Integer shopDeleted) {
        this.shopDeleted = shopDeleted;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDateTime getShopCreateTime() {
        return shopCreateTime;
    }

    public void setShopCreateTime(LocalDateTime shopCreateTime) {
        this.shopCreateTime = shopCreateTime;
    }

    public LocalDateTime getShopUpdateTime() {
        return shopUpdateTime;
    }

    public void setShopUpdateTime(LocalDateTime shopUpdateTime) {
        this.shopUpdateTime = shopUpdateTime;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "shopId='" + shopId + '\'' +
                ", shopName='" + shopName + '\'' +
                ", shopAddress='" + shopAddress + '\'' +
                ", shopRemark='" + shopRemark + '\'' +
                ", shopStatus='" + shopStatus + '\'' +
                ", shopPicture='" + shopPicture + '\'' +
                ", shopDeleted=" + shopDeleted +
                ", userId='" + userId + '\'' +
                ", shopCreateTime='" + shopCreateTime + '\'' +
                ", shopUpdateTime='" + shopUpdateTime + '\'' +
                '}';
    }
}
