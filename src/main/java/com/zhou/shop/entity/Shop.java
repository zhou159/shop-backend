package com.zhou.shop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author 周雄
 * @since 2021-06-24
 */

@TableName("shop")
@ApiModel(value="Shop对象")
public class Shop implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "商家表id")
    @TableId(value = "shop_id", type = IdType.ID_WORKER_STR)
    private String shopId;

    @ApiModelProperty(value = "商家店铺，超市名字")
    @TableField("shop_name")
    private String shopName;

    @ApiModelProperty(value = "地址")
    @TableField("shop_address")
    private String shopAddress;

    @ApiModelProperty(value = "备注")
    @TableField("shop_remark")
    private String shopRemark;

    @ApiModelProperty(value = "地址")
    @TableField("shop_status")
    private String shopStatus;

    @ApiModelProperty(value = "商店图片")
    @TableField("shop_picture")
    private String shopPicture;

    public Shop() {
    }

    public Shop(String shopId, String shopName, String shopAddress, String shopRemark, String shopStatus, String shopPicture) {
        this.shopId = shopId;
        this.shopName = shopName;
        this.shopAddress = shopAddress;
        this.shopRemark = shopRemark;
        this.shopStatus = shopStatus;
        this.shopPicture = shopPicture;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public String getShopRemark() {
        return shopRemark;
    }

    public void setShopRemark(String shopRemark) {
        this.shopRemark = shopRemark;
    }

    public String getShopStatus() {
        return shopStatus;
    }

    public void setShopStatus(String shopStatus) {
        this.shopStatus = shopStatus;
    }

    public String getShopPicture() {
        return shopPicture;
    }

    public void setShopPicture(String shopPicture) {
        this.shopPicture = shopPicture;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "shopId=" + shopId +
                ", shopName='" + shopName + '\'' +
                ", shopAddress='" + shopAddress + '\'' +
                ", shopRemark='" + shopRemark + '\'' +
                ", shopStatus='" + shopStatus + '\'' +
                ", shopPicture='" + shopPicture + '\'' +
                '}';
    }

}