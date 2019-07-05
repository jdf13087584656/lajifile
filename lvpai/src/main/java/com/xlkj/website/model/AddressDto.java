package com.xlkj.website.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AddressDto {

    @ApiModelProperty(value = "id", name = "id")
    private Integer id;

    @ApiModelProperty(value = "名称", name = "name")
    private String name;

    @ApiModelProperty(value = "编码", name = "code")
    private Integer code;

    @ApiModelProperty(value = "省码", name = "provinceCode")
    private Integer provinceCode;

    @ApiModelProperty(value = "市码", name = "cityCode")
    private Integer cityCode;
}
