package com.xlkj.website.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class AddAddress implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "aid", name = "aid")
    private Integer aid;

    @ApiModelProperty(value = "openId", name = "openId")
    private String openId;

    @ApiModelProperty(value = "用户姓名", name = "addressee")
    private String addressee;

    @ApiModelProperty(value = "用户电话", name = "addresseeTel")
    private String addresseeTel;

    @ApiModelProperty(value = "省code", name = "provinceCode")
    private Integer provinceCode;

    @ApiModelProperty(value = "市code", name = "cityCode")
    private Integer cityCode;

    @ApiModelProperty(value = "县区code", name = "areaCode")
    private Integer areaCode;

    @ApiModelProperty(value = "详细住址", name = "address")
    private String address;

    @ApiModelProperty(value = "是否默认(1,是 0,否)", name = "isDefault")
    private Integer isDefault;

    @ApiModelProperty(value = "是否删除(1,是 0,否)", name = "isDeleted")
    private Integer isDeleted;

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
