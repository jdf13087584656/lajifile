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

    @ApiModelProperty(value = "订单id,修改时传", name = "oids")
    private List<Integer> oids;

    @ApiModelProperty(value = "订单号", name = "orderCode")
    private String orderCode;

    @ApiModelProperty(value = "openId", name = "openId")
    private String openId;

    @ApiModelProperty(value = "回收员id", name = "receiveId")
    private Integer receiveId;

    @ApiModelProperty(value = "回收员姓名", name = "userName")
    private String userName;

    @ApiModelProperty(value = "回收员电话", name = "cellNumber")
    private String cellNumber;

    @ApiModelProperty(value = "验收员id", name = "checkId")
    private Integer checkId;

    @ApiModelProperty(value = "验收员姓名", name = "checkName")
    private String checkName;

    @ApiModelProperty(value = "验收员电话", name = "checkNumber")
    private String checkNumber;

    @ApiModelProperty(value = "管理员id", name = "adminId")
    private Integer adminId;

    @ApiModelProperty(value = "回收站id", name = "eid")
    private Integer eid;

    @ApiModelProperty(value = "管理员姓名", name = "adminName")
    private String adminName;

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

    @ApiModelProperty(value = "订单派单时间", name = "orderSendTime")
    private String orderSendTime;

    @ApiModelProperty(value = "取件时间", name = "orderGetTime")
    private String orderGetTime;

    @ApiModelProperty(value = "完成时间", name = "orderFinishTime")
    private String orderFinishTime;

    @ApiModelProperty(value = "创建人id", name = "createUserId")
    private Integer createUserId;

    @ApiModelProperty(value = "修改人id", name = "modifyUserId")
    private Integer modifyUserId;

    @ApiModelProperty(value = "订单状态(1,创建 2,派单, 3,已揽件, 4,完成, 5,异常 6,驳回 ,7,取消)", name = "orderState")
    private Integer orderState;

    @ApiModelProperty(value = "审核状态(1,草稿 2,待审核 3,审核通过 4,审核驳回)", name = "spState")
    private Integer spState;

    @ApiModelProperty(value = "驳回意见", name = "spMsg")
    private String spMsg;

//    @ApiModelProperty(value = "垃圾袋编号", name = "rubbishBagCodes")
//    private List<String> rubbishBagCodes;

    @ApiModelProperty(value = "总价", name = "allPrice")
    private BigDecimal allPrice;

    @ApiModelProperty(value = "扣款", name = "deductMoney")
    private BigDecimal deductMoney;

    @ApiModelProperty(value = "扣款原因", name = "deductMsg")
    private String deductMsg;

    @ApiModelProperty(value = "订单类型(1,上门订单  2,回收站订单)", name = "orderType")
    private Integer orderType;

    @ApiModelProperty(value = "备注", name = "memo")
    private String memo;

    @ApiModelProperty(value = "省名", name = "provinceName")
    private String provinceName;

    @ApiModelProperty(value = "市名", name = "cityName")
    private String cityName;

    @ApiModelProperty(value = "县区名", name = "areaName")
    private String areaName;

    @ApiModelProperty(value = "订单客户名", name = "addressee")
    private String addressee;

    @ApiModelProperty(value = "订单详细地址", name = "address")
    private String address;

    @ApiModelProperty(value = "订单电话", name = "addresseeTel")
    private String addresseeTel;

    @ApiModelProperty(value = "垃圾袋编号", name = "bagCode")
    private String bagCode;

    @ApiModelProperty(value = "个人还是商户(1,个人  2,商户)", name = "individualOrMerchant")
    private String individualOrMerchant;

    @ApiModelProperty(value = "订单货物详情", name = "listOrderDetails")
    List<BagCargoDto> listOrderDetails;

}
