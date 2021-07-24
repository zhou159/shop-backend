package com.zhou.shop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.time.LocalDate;

/**
 * <p>
 *
 * </p>
 *
 * @author 周雄
 * @since 2021-07-24
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("updateLog")
@ApiModel(value="update对象", description="")
public class UpdateLog implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "更新日志表id")
    @TableId(value = "update_log_id", type = IdType.AUTO)
    private Integer updateLogId;

    @ApiModelProperty(value = "更新日志创建时间")
    @JsonFormat(pattern="yyyy年MM月dd日")
    @TableField("update_log_create_time")
    private LocalDate updateLogCreateTime;

    @ApiModelProperty(value = "更新版本号")
    @TableField("update_log_version")
    private String updateLogVersion;

    @ApiModelProperty(value = "更新日志描述")
    @TableField("update_log_description")
    private String updateLogDescription;
}
