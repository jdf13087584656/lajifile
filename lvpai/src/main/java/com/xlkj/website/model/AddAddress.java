package com.xlkj.website.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AddAddress {

    @ApiModelProperty(value = "id", name = "aid")
    private Integer aid;

    @ApiModelProperty(value = "用户id", name = "roleId")
    private Integer roleId;

    @ApiModelProperty(value = "收件人姓名", name = "addressee")
    private String addressee;

    @ApiModelProperty(value = "收件人电话", name = "addresseeTel")
    private Integer addresseeTel;

    @ApiModelProperty(value = "省id", name = "provinceId")
    private Integer provinceId;

    @ApiModelProperty(value = "市id", name = "cityId")
    private Integer cityId;

    @ApiModelProperty(value = "县区id", name = "areaId")
    private Integer areaId;

    @ApiModelProperty(value = "详细住址", name = "address")
    private String address;

    @ApiModelProperty(value = "是否默认(1,是 0,否)", name = "isDefault")
    private Integer isDefault;

    @ApiModelProperty(value = "创建时间", name = "createTime")
    private String createTime;

    @ApiModelProperty(value = "修改时间", name = "modifyTime")
    private String modifyTime;

    @ApiModelProperty(value = "省名", name = "provinceName")
    private String provinceName;

    @ApiModelProperty(value = "市名", name = "cityName")
    private String cityName;

    @ApiModelProperty(value = "县区名", name = "areaName")
    private String areaName;
}
