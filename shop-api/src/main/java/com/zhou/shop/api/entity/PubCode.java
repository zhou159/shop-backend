package com.zhou.shop.api.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author 周雄
 * @date 2022/5/17 18:17
 * @description
 */
@ApiModel("码表")
@TableName("pub_code")
public class PubCode implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("码表主键")
    @TableId(value = "pub_code_id", type = IdType.ASSIGN_ID)
    private String pubCodeId;

    @ApiModelProperty("码表名字")
    @TableField("pub_code_name")
    private String pubCodeName;

    @ApiModelProperty("码表类型")
    @TableField("pub_code_class_id")
    private String pubCodeClassId;

    @ApiModelProperty("码表说明")
    @TableField("pub_code_description")
    private String pubCodeDescription;

    public PubCode() {}

    public PubCode(
            String pubCodeId,
            String pubCodeName,
            String pubCodeClassId,
            String pubCodeDescription) {
        this.pubCodeId = pubCodeId;
        this.pubCodeName = pubCodeName;
        this.pubCodeClassId = pubCodeClassId;
        this.pubCodeDescription = pubCodeDescription;
    }

    public String getPubCodeId() {
        return pubCodeId;
    }

    public void setPubCodeId(String pubCodeId) {
        this.pubCodeId = pubCodeId;
    }

    public String getPubCodeName() {
        return pubCodeName;
    }

    public void setPubCodeName(String pubCodeName) {
        this.pubCodeName = pubCodeName;
    }

    public String getPubCodeClassId() {
        return pubCodeClassId;
    }

    public void setPubCodeClassId(String pubCodeClassId) {
        this.pubCodeClassId = pubCodeClassId;
    }

    public String getPubCodeDescription() {
        return pubCodeDescription;
    }

    public void setPubCodeDescription(String pubCodeDescription) {
        this.pubCodeDescription = pubCodeDescription;
    }

    @Override
    public String toString() {
        return "PubCode{"
                + "pubCodeId='"
                + pubCodeId
                + '\''
                + ", pubCodeName='"
                + pubCodeName
                + '\''
                + ", pubCodeClassId='"
                + pubCodeClassId
                + '\''
                + ", pubCodeDescription='"
                + pubCodeDescription
                + '\''
                + '}';
    }
}
