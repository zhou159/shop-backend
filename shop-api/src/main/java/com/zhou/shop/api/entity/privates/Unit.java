package com.zhou.shop.api.entity.privates;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author 周雄
 * @since 2021-07-20
 */
@TableName("unit")
@ApiModel(value = "Unit对象")
public class Unit {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "单位id")
    @TableId(value = "unit_id", type = IdType.ASSIGN_ID)
    private String unitId;

    @ApiModelProperty(value = "单位名字")
    @TableField("unit_name")
    private String unitName;

    @TableLogic
    @ApiModelProperty(value = "单位逻辑删除")
    @TableField("unit_deleted")
    private Integer unitDeleted;

    public Unit() {}

    public Unit(String unitId, String unitName) {
        this.unitId = unitId;
        this.unitName = unitName;
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

    @Override
    public String toString() {
        return "Unit{" + "unitId=" + unitId + ", unitName='" + unitName + '\'' + '}';
    }
}
