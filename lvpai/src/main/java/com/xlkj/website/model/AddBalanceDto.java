package com.xlkj.website.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class AddBalanceDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "bid", name = "bid")
    private Integer bid;

    @ApiModelProperty(value = "openId", name = "openId")
    private String openId;

    @ApiModelProperty(value = "余额", name = "balance")
    private BigDecimal balance;

    @ApiModelProperty(value = "变化值", name = "change")
    private BigDecimal change;
}
