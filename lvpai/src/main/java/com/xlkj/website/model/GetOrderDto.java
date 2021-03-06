package com.xlkj.website.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
public class GetOrderDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单id", name = "oid")
    private Integer oid;

    @ApiModelProperty(value = "垃圾袋编号", name = "bagCode")
    private String bagCode;
}
