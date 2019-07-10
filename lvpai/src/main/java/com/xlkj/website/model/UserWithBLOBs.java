package com.xlkj.website.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UserWithBLOBs {

    @ApiModelProperty(value = "id", name = "id")
    private Integer id;

    @ApiModelProperty(value = "唯一识别码", name = "openId")
    private String openId;

    @ApiModelProperty(value = "密码", name = "pwd")
    private String pwd;

    @ApiModelProperty(value = "传入code", name = "code")
    private String code;

    @ApiModelProperty(value = "传入appId", name = "appId")
    private String appId;

    @ApiModelProperty(value = "传入secret", name = "secret")
    private String secret;

    @ApiModelProperty(value = "姓名", name = "name")
    private String name;

    @ApiModelProperty(value = "昵称", name = "nickName")
    private String nickName;

    @ApiModelProperty(value = "头像", name = "avatarUrl")
    private String avatarUrl;

    @ApiModelProperty(value = "传入角色编码(1,管理员.2,回收员.3,客户)", name = "roleCode")
    private Integer roleCode;

    @ApiModelProperty(value = "手机号", name = "telephone")
    private String telephone;

    @ApiModelProperty(value = "性别(1,男.2,女)", name = "gender")
    private Integer gender;

    @ApiModelProperty(value = "省份", name = "province")
    private String province;

    @ApiModelProperty(value = "城市", name = "city")
    private String city;

    @ApiModelProperty(value = "国家", name = "country")
    private String country;

    @ApiModelProperty(value = "创建时间", name = "createTime")
    private String createTime;

    @ApiModelProperty(value = "修改时间", name = "modifyTime")
    private String modifyTime;

    @ApiModelProperty(value = "用户已完成数量", name = "quantityCompletion")
    private Integer quantityCompletion;

}
