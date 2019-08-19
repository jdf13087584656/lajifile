package com.xlkj.website.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class RoleGarbageDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键", name = "rgid")
    private Integer rgid;

    @ApiModelProperty(value = "垃圾袋编号", name = "bagCode")
    private String bagCode;

    @ApiModelProperty(value = "openid", name = "openId")
    private String openId;

    @ApiModelProperty(value = "是否删除(0,正常  1,删除)", name = "isDelete")
    private Integer isDelete;

    @ApiModelProperty(value = "地址主键", name = "aid")
    private Integer aid;











}
