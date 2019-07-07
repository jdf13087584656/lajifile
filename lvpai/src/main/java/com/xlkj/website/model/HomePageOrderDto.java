package com.xlkj.website.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class HomePageOrderDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "待审批数量(上门订单)", name = "DSPNumSM")
    private Integer DSPNum;

    @ApiModelProperty(value = "待审批数量(回收站订单)", name = "DSPNumHSZ")
    private Integer DSPNumHSZ;

    @ApiModelProperty(value = "异常订单数量", name = "YCNum")
    private Integer YCNum;
}
