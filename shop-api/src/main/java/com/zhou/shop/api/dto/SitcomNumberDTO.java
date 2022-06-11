package com.zhou.shop.api.dto;

import java.io.Serializable;

/**
 * @author Administrator
 */
public class SitcomNumberDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    private String maxNumber;
    private Integer count;

    public SitcomNumberDTO() {
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public SitcomNumberDTO(String maxNumber, Integer count) {
        this.maxNumber = maxNumber;
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
        return "SitcomNumberDTO{" +
                "maxNumber='" + maxNumber + '\'' +
                ", count=" + count +
                '}';
    }

}
