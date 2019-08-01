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

    @ApiModelProperty(value = "订单号", name = "orderCode")
    private String orderCode;

    @ApiModelProperty(value = "省名", name = "provinceName")
    private String provinceName;

    @ApiModelProperty(value = "市名", name = "cityName")
    private String cityName;

    @ApiModelProperty(value = "县区名", name = "areaName")
    private String areaName;

    @ApiModelProperty(value = "用户姓名", name = "addressee")
    private String addressee;

    @ApiModelProperty(value = "用户电话", name = "addresseeTel")
    private String addresseeTel;

    @ApiModelProperty(value = "详细住址", name = "address")
    private String address;

    @ApiModelProperty(value = "订单生成时间", name = "orderCreateTime")
    private String orderCreateTime;

    @ApiModelProperty(value = "订单派单时间", name = "orderSendTime")
    private String orderSendTime;

    @ApiModelProperty(value = "取件时间", name = "orderGetTime")
    private String orderGetTime;

    @ApiModelProperty(value = "完成时间", name = "orderFinishTime")
    private String orderFinishTime;

}
