package com.zhou.shop.api.vo.user.login;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Objects;

/**
 * @author zhouxiong
 * @description:
 * @version: v1.0
 * @since 2022/6/11 11:50
 */
@ApiModel("前端用户登录uuid对象")
public class UserLoginUuidVO implements Serializable {
    private static final long serialVersionUID = 1L;

    @NotBlank(message = "uuid不能为空")
    @ApiModelProperty("uuid")
    private String uuid;

    public UserLoginUuidVO() {
    }

    public UserLoginUuidVO(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserLoginUuidVO that = (UserLoginUuidVO) o;
        return uuid.equals(that.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }

    @Override
    public String toString() {
        return "UserLoginUuidVO{" + "uuid='" + uuid + '\'' + '}';
    }
}
