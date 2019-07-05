package com.xlkj.website.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class SelectOrderDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "垃圾袋编号", name = "rubbishBagCode")
    private String rubbishBagCode;

    @ApiModelProperty(value = "开始时间", name = "startTime")
    private String startTime;

    @ApiModelProperty(value = "结束时间", name = "endTime")
    private String endTime;

    @ApiModelProperty(value = "订单状态(1,正在执行. 2,取消. 3,已完成)", name = "orderState")
    private List<Integer> orderState;

    @ApiModelProperty(value = "删除标志(1,正常. 2,已删除)", name = "isDeleted")
    private Integer isDeleted;
}
