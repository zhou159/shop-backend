package com.zhou.shop.api.vo.user;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Objects;

public class UserVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty("用户id")
    private int id;

    @ApiModelProperty("用户身份证号")
    private String idNumber;

    @ApiModelProperty("用户真实姓名")
    private String trueName;

    @ApiModelProperty("用户姓名")
    private String username;

    @ApiModelProperty("用户电话")
    private String tel;

    @ApiModelProperty("用户密码")
    private String password;

    @ApiModelProperty("用户昵称")
    private String nickname;

    @ApiModelProperty("用户性别")
    private String gender;

    @ApiModelProperty("用户地址")
    private String address;

    @ApiModelProperty("用户头像")
    private String picture;

    @ApiModelProperty("验证码")
    private String checkCode; // 验证码

    @ApiModelProperty("用户状态")
    private String status;

    @ApiModelProperty(value = "用户信誉值")
    private Integer creditScore;

    public UserVO() {}

    public UserVO(
            int id,
            String idNumber,
            String trueName,
            String username,
            String tel,
            String password,
            String nickname,
            String gender,
            String address,
            String picture,
            String checkCode,
            String status,
            Integer creditScore) {
        this.id = id;
        this.idNumber = idNumber;
        this.trueName = trueName;
        this.username = username;
        this.tel = tel;
        this.password = password;
        this.nickname = nickname;
        this.gender = gender;
        this.address = address;
        this.picture = picture;
        this.checkCode = checkCode;
        this.status = status;
        this.creditScore = creditScore;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(Integer creditScore) {
        this.creditScore = creditScore;
    }

    @Override
    public String toString() {
        return "UserLoginVO{"
                + "id="
                + id
                + ", idNumber='"
                + idNumber
                + '\''
                + ", trueName='"
                + trueName
                + '\''
                + ", username='"
                + username
                + '\''
                + ", tel='"
                + tel
                + '\''
                + ", password='"
                + password
                + '\''
                + ", nickname='"
                + nickname
                + '\''
                + ", gender='"
                + gender
                + '\''
                + ", address='"
                + address
                + '\''
                + ", picture='"
                + picture
                + '\''
                + ", checkCode='"
                + checkCode
                + '\''
                + ", status='"
                + status
                + '\''
                + ", creditScore="
                + creditScore
                + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserVO that = (UserVO) o;
        return id == that.id
                && idNumber.equals(that.idNumber)
                && trueName.equals(that.trueName)
                && username.equals(that.username)
                && tel.equals(that.tel)
                && password.equals(that.password)
                && nickname.equals(that.nickname)
                && gender.equals(that.gender)
                && address.equals(that.address)
                && picture.equals(that.picture)
                && checkCode.equals(that.checkCode)
                && status.equals(that.status)
                && creditScore.equals(that.creditScore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                id,
                idNumber,
                trueName,
                username,
                tel,
                password,
                nickname,
                gender,
                address,
                picture,
                checkCode,
                status,
                creditScore);
    }
}
