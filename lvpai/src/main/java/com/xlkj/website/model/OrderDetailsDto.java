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

    @ApiModelProperty(value = "订单id", name = "oid")
    private Integer oid;

    @ApiModelProperty(value = "openId", name = "openId")
    private String openId;

    @ApiModelProperty(value = "垃圾袋编号", name = "bagCode")
    private String bagCode;

    @ApiModelProperty(value = "货物id", name = "cid")
    private Integer cid;

    @ApiModelProperty(value = "货物重量", name = "cargoWeight")
    private BigDecimal cargoWeight;

    @ApiModelProperty(value = "货物重量价格对应", name = "CargoQuality")
    private List<CargoQuality> cargoQuality;

    @ApiModelProperty(value = "是否已绑定垃圾袋标识(1,未绑定)", name = "isBound")
    private Integer isBound;

}
