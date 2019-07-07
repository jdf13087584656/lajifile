package com.xlkj.website.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class searchCargoDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "垃圾袋编号", name = "bagCode")
    private String bagCode;

    @ApiModelProperty(value = "货物id", name = "oid")
    private Integer oid;


}
