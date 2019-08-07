package com.xlkj.website.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class SumDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单数", name = "orderSum")
    private Integer orderSum;

    @ApiModelProperty(value = "总重量", name = "weightSum")
    private BigDecimal weightSum;

    @ApiModelProperty(value = "金额", name = "priceSum")
    private BigDecimal priceSum;

    @ApiModelProperty(value = "总金额", name = "allPrice")
    private BigDecimal allPrice;

    @ApiModelProperty(value = "总扣款", name = "deductMoneyAll")
    private BigDecimal deductMoneyAll;

    @ApiModelProperty(value = "货物名", name = "priceSum")
    private String cargoName;

    @ApiModelProperty(value = "货物id", name = "cargoId")
    private Integer cargoId;

}
