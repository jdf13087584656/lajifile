package com.xlkj.website.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderDetailsDto implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "did", name = "did")
    private Integer did;

    @ApiModelProperty(value = "垃圾袋编号", name = "bagCode")
    private String bagCode;

    @ApiModelProperty(value = "货物id", name = "cid")
    private Integer cid;

    @ApiModelProperty(value = "货物id", name = "cids")
    private List<Integer> cids;

    @ApiModelProperty(value = "货物单价", name = "cargoPrice")
    private BigDecimal cargoPrice;

    @ApiModelProperty(value = "货物重量", name = "cargoWeight")
    private BigDecimal cargoWeight;

    @ApiModelProperty(value = "货物重量", name = "cargoWeights")
    private List<BigDecimal> cargoWeights;



}