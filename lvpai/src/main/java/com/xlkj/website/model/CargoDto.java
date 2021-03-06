package com.xlkj.website.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class CargoDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "cid", name = "cid")
    private Integer cid;

    @ApiModelProperty(value = "货物名称", name = "cargoName")
    private String cargoName;

    @ApiModelProperty(value = "货物单价", name = "cargoPrice")
    private BigDecimal cargoPrice;

    @ApiModelProperty(value = "状态(0,正常 1,删除)", name = "isDeleted")
    private Integer isDeleted;

    @ApiModelProperty(value = "货物类型(1,个人 2,商家)", name = "cargoType")
    private Integer cargoType;

    @ApiModelProperty(value = "父id", name = "pId")
    private Integer pId;

    @ApiModelProperty(value = "图标", name = "icon")
    private String icon;

    @ApiModelProperty("递归下属集合")
    private List<CargoDto> children;
}
