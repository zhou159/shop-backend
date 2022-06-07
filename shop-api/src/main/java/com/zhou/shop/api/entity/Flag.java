package com.zhou.shop.api.entity;

import com.baomidou.mybatisplus.annotation.*;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author 周雄
 * @since 2021-06-24
 */
@TableName("flag")
@ApiModel(value = "Flag对象")
public class Flag implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "标签id")
    @TableId(value = "flag_id", type = IdType.ASSIGN_ID)
    private String flagId;

    @ApiModelProperty(value = "标签名字")
    @TableField("flag_name")
    private String flagName;

    @TableLogic
    @ApiModelProperty(value = "标签逻辑删除")
    @TableField("flag_deleted")
    private Integer flagDeleted;

    public Flag() {}

    public Flag(String flagId, String flagName) {
        this.flagId = flagId;
        this.flagName = flagName;
    }

    public String getFlagId() {
        return flagId;
    }

    public Flag setFlagId(String flagId) {
        this.flagId = flagId;
        return this;
    }

    public String getFlagName() {
        return flagName;
    }

    public Flag setFlagName(String flagName) {
        this.flagName = flagName;
        return this;
    }

    @Override
    public String toString() {
        return "Flag{" + "flagId=" + flagId + ", flagName='" + flagName + '\'' + '}';
    }
}
