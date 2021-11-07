package com.zhou.shop.dto;

/**
 * @author Administrator
 */
public class SitcomNumberDto {
    private String maxNumber;

    public SitcomNumberDto() {
    }

    public SitcomNumberDto(String maxNumber) {
        this.maxNumber = maxNumber;
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
                '}';
    }
}
