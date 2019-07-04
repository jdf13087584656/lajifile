package com.xlkj.website.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserWithBLOBs {

    @ApiModelProperty(value = "用户名", name = "userName")
    private String userName;

    @ApiModelProperty(value = "openId", name = "openId")
    private String openId;

    @ApiModelProperty(value = "头像", name = "userImg")
    private String userImg;

    @ApiModelProperty(value = "性别", name = "sex")
    private Integer sex;

    @ApiModelProperty(value = "省份", name = "province")
    private String province;

    @ApiModelProperty(value = "城市", name = "city")
    private String city;

}
