package com.xlkj.website.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
public class UserDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "账号主键", name = "uid")
    private Integer uid;

    @ApiModelProperty(value = "账号", name = "account")
    private String account;

    @ApiModelProperty(value = "密码", name = "password")
    private String password;

    @ApiModelProperty(value = "姓名", name = "userName")
    private String userName;

    @ApiModelProperty(value = "手机号", name = "cellNumber")
    private String cellNumber;

    @ApiModelProperty(value = "类型(1,管理员  2,回收员)", name = "type")
    private Integer type;
}
