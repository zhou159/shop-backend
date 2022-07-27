package com.zhou.shop.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author zhouxiong
 * @version v0.1
 * @since 2022/7/27 17:03
 */
@ApiModel("前端新增问题对象")
public class IssueAddVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @Length(min = 5,max = 250, message = "问题描述长度在5-250之间")
    @ApiModelProperty("问题描述")
    private String issueDescription;

    @NotBlank(message = "问题类型不能为空!")
    @ApiModelProperty("问题类型")
    private String issueType;

    @NotBlank(message = "问题模块不能为空!")
    @ApiModelProperty("问题模块")
    private String issueModule;

    @ApiModelProperty("问题提出人")
    private String issueCreateBy;


}
