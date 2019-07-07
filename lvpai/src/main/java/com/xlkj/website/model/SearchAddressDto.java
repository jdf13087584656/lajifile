package com.xlkj.website.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class SearchAddressDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "openId", name = "openId")
    private String openId;

    @ApiModelProperty(value = "aid", name = "aid")
    private Integer aid;

    @ApiModelProperty(value = "isDefault", name = "isDefault")
    private Integer isDefault;
}
