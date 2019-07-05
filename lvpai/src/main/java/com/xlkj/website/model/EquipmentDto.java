package com.xlkj.website.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class EquipmentDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "设备id", name = "eId")
    private Integer eId;

    @ApiModelProperty(value = "设备名称", name = "eName")
    private String eName;

    @ApiModelProperty(value = "设备位置", name = "eAddress")
    private String eAddress;

    @ApiModelProperty(value = "创建人", name = "createUserId")
    private Integer createUserId;

    @ApiModelProperty(value = "修改人", name = "modifyUserId")
    private Integer modifyUserId;

    @ApiModelProperty(value = "创建时间", name = "createTime")
    private String createTime;

    @ApiModelProperty(value = "修改时间", name = "modifyTime")
    private String modifyTime;

    @ApiModelProperty(value = "设备状态(1,正在使用.2,暂停使用)", name = "eState")
    private Integer eState;

    @ApiModelProperty(value = "备注", name = "memo")
    private String memo;
}
