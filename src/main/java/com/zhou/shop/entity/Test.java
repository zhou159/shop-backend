package com.zhou.shop.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;

/** @author Administrator */
@TableName("test")
@ApiModel(value = "test对象")
public class Test {
    private String testId;
    private String testT1;
    private String testT2;
    private String testT3;
    private String testT4;
    private String testT5;
    private String testT6;
    private String testT7;
    private String testT8;
    private String testT9;
    private String testT10;

    public String getTestT4() {
        return testT4;
    }

    public void setTestT4(String testT4) {
        this.testT4 = testT4;
    }

    public String getTestT5() {
        return testT5;
    }

    public void setTestT5(String testT5) {
        this.testT5 = testT5;
    }

    public String getTestT6() {
        return testT6;
    }

    public void setTestT6(String testT6) {
        this.testT6 = testT6;
    }

    public String getTestT7() {
        return testT7;
    }

    public void setTestT7(String testT7) {
        this.testT7 = testT7;
    }

    public String getTestT8() {
        return testT8;
    }

    public void setTestT8(String testT8) {
        this.testT8 = testT8;
    }

    public String getTestT9() {
        return testT9;
    }

    public void setTestT9(String testT9) {
        this.testT9 = testT9;
    }

    public String getTestT10() {
        return testT10;
    }

    public void setTestT10(String testT10) {
        this.testT10 = testT10;
    }

    @Override
    public String toString() {
        return "Test{" +
                "testId='" + testId + '\'' +
                ", testT1='" + testT1 + '\'' +
                ", testT2='" + testT2 + '\'' +
                ", testT3='" + testT3 + '\'' +
                ", testT4='" + testT4 + '\'' +
                ", testT5='" + testT5 + '\'' +
                ", testT6='" + testT6 + '\'' +
                ", testT7='" + testT7 + '\'' +
                ", testT8='" + testT8 + '\'' +
                ", testT9='" + testT9 + '\'' +
                ", testT10='" + testT10 + '\'' +
                '}';
    }

    public Test(
            String testId,
            String testT1,
            String testT2,
            String testT3,
            String testT4,
            String testT5,
            String testT6,
            String testT7,
            String testT8,
            String testT9,
            String testT10) {
        this.testId = testId;
        this.testT1 = testT1;
        this.testT2 = testT2;
        this.testT3 = testT3;
        this.testT4 = testT4;
        this.testT5 = testT5;
        this.testT6 = testT6;
        this.testT7 = testT7;
        this.testT8 = testT8;
        this.testT9 = testT9;
        this.testT10 = testT10;
    }

    public Test() {}

    public String getTestT2() {
        return testT2;
    }

    public void setTestT2(String testT2) {
        this.testT2 = testT2;
    }

    public String getTestT3() {
        return testT3;
    }

    public void setTestT3(String testT3) {
        this.testT3 = testT3;
    }

    public String getTestId() {
        return testId;
    }

    public void setTestId(String testId) {
        this.testId = testId;
    }

    public String getTestT1() {
        return testT1;
    }

    public void setTestT1(String testT1) {
        this.testT1 = testT1;
    }
}
