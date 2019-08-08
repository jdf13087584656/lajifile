package com.xlkj.website.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;


@Data
public class CargoQuality implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "货物类别id", name = "cid")
    private Integer cid;

    @ApiModelProperty(value = "货物单价", name = "cargoPrice")
    private BigDecimal cargoPrice;

    @ApiModelProperty(value = "货物重量", name = "cargoWeight")
    private BigDecimal cargoWeight;
}
