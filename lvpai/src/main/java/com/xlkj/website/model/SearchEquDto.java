package com.xlkj.website.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class SearchEquDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备状态(1正常  2暂停)", name = "eState")
    private String eState;

}
