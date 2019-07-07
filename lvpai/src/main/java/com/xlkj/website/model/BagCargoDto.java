package com.xlkj.website.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class BagCargoDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "垃圾袋编号", name = "bagCode")
    private String bagCode;

    @ApiModelProperty(value = "货物名称", name = "cargoName")
    private String cargoName;

    @ApiModelProperty(value = "货物单价", name = "cargoPrice")
    private BigDecimal cargoPrice;

    @ApiModelProperty(value = "货物重量", name = "cargoWeight")
    private BigDecimal cargoWeight;

}
