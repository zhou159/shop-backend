package com.zhou.shop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author 周雄
 * @date 2022/5/17 18:17
 * @description
 */
@TableName("pubcode")
public class PubCode implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "码表主键")
    @TableId(value = "pubcode_id", type = IdType.ASSIGN_ID)
    private String pubcodeId;

    @ApiModelProperty(value = "码表名字")
    @TableField("pubcode_name")
    private String pubcodeName;

    @ApiModelProperty(value = "码表类型")
    @TableField("pubcode_class_id")
    private String pubcodeClassId;

    public PubCode() {}

    public PubCode(String pubcodeId, String pubcodeName, String pubcodeClassId) {
        this.pubcodeId = pubcodeId;
        this.pubcodeName = pubcodeName;
        this.pubcodeClassId = pubcodeClassId;
    }

    public String getPubcodeId() {
        return pubcodeId;
    }

    public void setPubcodeId(String pubcodeId) {
        this.pubcodeId = pubcodeId;
    }

    public String getPubcodeName() {
        return pubcodeName;
    }

    public void setPubcodeName(String pubcodeName) {
        this.pubcodeName = pubcodeName;
    }

    public String getPubcodeClassId() {
        return pubcodeClassId;
    }

    public void setPubcodeClassId(String pubcodeClassId) {
        this.pubcodeClassId = pubcodeClassId;
    }

    @Override
    public String toString() {
        return "PubCode{"
                + "pubcodeId='"
                + pubcodeId
                + '\''
                + ", pubcodeName='"
                + pubcodeName
                + '\''
                + ", pubcodeClassId='"
                + pubcodeClassId
                + '\''
                + '}';
    }
}
