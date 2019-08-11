package com.xlkj.website.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
public class DesignatedDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "回收员主键", name = "receiveId")
    private Integer receiveId;

    @ApiModelProperty(value = "袋号", name = "bagCode")
    private String bagCode;
}
