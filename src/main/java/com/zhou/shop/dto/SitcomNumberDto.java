package com.zhou.shop.dto;

/**
 * @author Administrator
 */
public class SitcomNumberDto {
    private String maxNumber;
    private Integer count;

    public SitcomNumberDto() {
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public SitcomNumberDto(String maxNumber, Integer count) {
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
        return "SitcomNumberDto{" +
                "maxNumber='" + maxNumber + '\'' +
                ", count=" + count +
                '}';
    }

}
