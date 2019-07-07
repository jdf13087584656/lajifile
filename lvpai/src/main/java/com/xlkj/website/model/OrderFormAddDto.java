package com.xlkj.website.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderFormAddDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单id,修改时传", name = "oid")
    private Integer oid;

    @ApiModelProperty(value = "订单号", name = "orderCode")
    private String orderCode;

    @ApiModelProperty(value = "openId", name = "openId")
    private Integer openId;

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

    @ApiModelProperty(value = "订单状态(1,草稿 2,正在执行, 3,已揽件, 4,完成, 5,异常)", name = "orderState")
    private Integer orderState;

    @ApiModelProperty(value = "审核状态(1,草稿 2,待审核 3,审核通过 4,审核驳回)", name = "spState")
    private Integer spState;

    @ApiModelProperty(value = "审核意见", name = "spMsg")
    private String spMsg;

//    @ApiModelProperty(value = "垃圾袋编号", name = "rubbishBagCodes")
//    private List<String> rubbishBagCodes;

    @ApiModelProperty(value = "总价", name = "allPrice")
    private BigDecimal allPrice;

    @ApiModelProperty(value = "扣款", name = "deductMoney")
    private BigDecimal deductMoney;

    @ApiModelProperty(value = "扣款原因", name = "deductMsg")
    private String deductMsg;


}
