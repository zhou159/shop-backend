package com.zhou.shop.api.entity.privates;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author 周雄
 * @since 2021-07-20
 */
@TableName("unit")
@ApiModel("单位")
public class Unit implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("单位id")
    @TableId(value = "unit_id", type = IdType.ASSIGN_ID)
    private String unitId;

    @ApiModelProperty("单位名字")
    @TableField("unit_name")
    private String unitName;

    @TableLogic
    @ApiModelProperty("单位逻辑删除")
    @TableField("unit_deleted")
    private Integer unitDeleted;

    @ApiModelProperty("用户id")
    @TableField("user_id")
    private String userId;

    @ApiModelProperty("单位创建时间")
    @TableField("unit_create_time")
    private LocalDateTime unitCreateTime;

    @ApiModelProperty("单位更新时间")
    @TableField("unit_update_time")
    private LocalDateTime unitUpdateTime;

    public Unit() {}

    public Unit(String unitId, String unitName, Integer unitDeleted, String userId, LocalDateTime unitCreateTime, LocalDateTime unitUpdateTime) {
        this.unitId = unitId;
        this.unitName = unitName;
        this.unitDeleted = unitDeleted;
        this.userId = userId;
        this.unitCreateTime = unitCreateTime;
        this.unitUpdateTime = unitUpdateTime;
    }

    public String getUnitId() {
        return unitId;
    }

    public Unit setUnitId(String unitId) {
        this.unitId = unitId;
        return this;
    }

    public String getUnitName() {
        return unitName;
    }

    public Unit setUnitName(String unitName) {
        this.unitName = unitName;
        return this;
    }

    public Integer getUnitDeleted() {
        return unitDeleted;
    }

    public void setUnitDeleted(Integer unitDeleted) {
        this.unitDeleted = unitDeleted;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDateTime getUnitCreateTime() {
        return unitCreateTime;
    }

    public void setUnitCreateTime(LocalDateTime unitCreateTime) {
        this.unitCreateTime = unitCreateTime;
    }

    public LocalDateTime getUnitUpdateTime() {
        return unitUpdateTime;
    }

    public void setUnitUpdateTime(LocalDateTime unitUpdateTime) {
        this.unitUpdateTime = unitUpdateTime;
    }

    @Override
    public String toString() {
        return "Unit{" +
                "unitId='" + unitId + '\'' +
                ", unitName='" + unitName + '\'' +
                ", unitDeleted=" + unitDeleted +
                ", userId='" + userId + '\'' +
                ", unit_create_time='" + unitCreateTime + '\'' +
                ", unitUpdateTime='" + unitUpdateTime + '\'' +
                '}';
    }
}
