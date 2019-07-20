package com.xlkj.website.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
public class GetCargoDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "当前页码", name = "currentPage")
    private Integer currentPage = 1;

    @ApiModelProperty(value = "每页数据量", name = "pageSize")
    private Integer pageSize = 10;

    @ApiModelProperty(value = "关键字", name = "keywords")
    private String keywords;

    @ApiModelProperty(value = "货物类型(1,个人 2,商家)", name = "cargoType")
    private Integer cargoType;
}
