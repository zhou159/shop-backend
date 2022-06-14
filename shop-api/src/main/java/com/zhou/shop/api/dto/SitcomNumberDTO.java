package com.zhou.shop.api.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @author Administrator
 */
@ApiModel("后端剧集返回对象")
public class SitcomNumberDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty("最大集数")
    private String maxNumber;

    @ApiModelProperty("总集数")
    private Integer count;

    public SitcomNumberDTO() {}

    public SitcomNumberDTO(String maxNumber, Integer count) {
        this.maxNumber = maxNumber;
        this.count = count;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getMaxNumber() {
        return maxNumber;
    }

    public void setMaxNumber(String maxNumber) {
        this.maxNumber = maxNumber;
    }

    @Override
    public String toString() {
        return "SitcomNumberDTO{" + "maxNumber='" + maxNumber + '\'' + ", count=" + count + '}';
    }
}
