package com.zhou.shop.api.entity.privates;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author 周雄
 * @since 2021-07-20
 */
@TableName("unit")
@ApiModel("单位")
public class Unit {
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

    public Unit() {}

    public Unit(String unitId, String unitName, Integer unitDeleted, String userId) {
        this.unitId = unitId;
        this.unitName = unitName;
        this.unitDeleted = unitDeleted;
        this.userId = userId;
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

    @Override
    public String toString() {
        return "Unit{"
                + "unitId='"
                + unitId
                + '\''
                + ", unitName='"
                + unitName
                + '\''
                + ", unitDeleted="
                + unitDeleted
                + ", userId='"
                + userId
                + '\''
                + '}';
    }
}
