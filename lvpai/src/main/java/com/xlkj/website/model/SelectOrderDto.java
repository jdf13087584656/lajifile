package com.xlkj.website.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SelectOrderDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单类型", name = "orderType")
    private Integer orderType;

    @ApiModelProperty(value = "开始时间", name = "startTime")
    private String startTime;

    @ApiModelProperty(value = "结束时间", name = "endTime")
    private String endTime;

    @ApiModelProperty(value = "当前页码", name = "currentPage")
    private Integer currentPage = 1;

    @ApiModelProperty(value = "每页数据量", name = "pageSize")
    private Integer pageSize = 10;

    @ApiModelProperty(value = "订单状态(1,正在执行. 2,取消. 3,已完成)", name = "orderState")
    private List<Integer> orderState;

    @ApiModelProperty(value = "删除标志(1,正常. 2,已删除)", name = "isDeleted")
    private Integer isDeleted;

    @ApiModelProperty(value = "回收员Id", name = "uid")
    private Integer uid;

    @ApiModelProperty(value = "验收员Id", name = "checkId")
    private Integer checkId;

    @ApiModelProperty(value = "openId", name = "openId")
    private String openId;

    @ApiModelProperty(value = "订单id", name = "oid")
    private Integer oid;

    @ApiModelProperty(value = "关键字", name = "keywords")
    private String keywords;
}
