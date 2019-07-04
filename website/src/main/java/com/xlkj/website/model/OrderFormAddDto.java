package com.xlkj.website.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class OrderFormAddDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单id,修改时传", name = "oId")
    private Integer oId;

    @ApiModelProperty(value = "订单号", name = "orderCode")
    private String orderCode;

    @ApiModelProperty(value = "客户id", name = "clientId")
    private Integer clientId;

    @ApiModelProperty(value = "回收员id", name = "receiveId")
    private Integer receiveId;

    @ApiModelProperty(value = "派单员id", name = "adminId")
    private Integer adminId;

    @ApiModelProperty(value = "地址id", name = "addressId")
    private Integer addressId;

    @ApiModelProperty(value = "预约时间", name = "appointmentTime")
    private String appointmentTime;

    @ApiModelProperty(value = "是否马上到账(1,是. 2,否)", name = "isAccount")
    private Integer isAccount;

    @ApiModelProperty(value = "评估价", name = "priceEvaluation")
    private BigDecimal priceEvaluation;

    @ApiModelProperty(value = "删除标志(1,正常. 2,已删除)", name = "isDeleted")
    private Integer isDeleted;

    @ApiModelProperty(value = "订单生成时间", name = "orderCreateTime")
    private String orderCreateTime;

    @ApiModelProperty(value = "取件时间", name = "orderGetTime")
    private String orderGetTime;

    @ApiModelProperty(value = "完成时间", name = "orderFinishTime")
    private String orderFinishTime;

    @ApiModelProperty(value = "创建人id", name = "createUserId")
    private Integer createUserId;

    @ApiModelProperty(value = "修改人id", name = "modifyUserId")
    private Integer modifyUserId;

    @ApiModelProperty(value = "订单状态(1,正在执行. 2,取消. 3,已完成)", name = "orderState")
    private Integer orderState;

    @ApiModelProperty(value = "审核状态(1,草稿 2,待审核 3,审核通过 4,审核驳回)", name = "spState")
    private Integer spState;

    @ApiModelProperty(value = "垃圾袋编号", name = "rubbishBagCode")
    private String rubbishBagCode;
}