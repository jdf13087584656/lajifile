package com.xlkj.website.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class GarbageBagDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "垃圾袋id", name = "bagId")
    private Integer bagId;

    @ApiModelProperty(value = "垃圾袋编号", name = "bagCodes")
    private List<String> bagCodes;

    @ApiModelProperty(value = "垃圾袋编号", name = "bagCode")
    private String bagCode;

    @ApiModelProperty(value = "订单id", name = "oid")
    private Integer oid;
}
