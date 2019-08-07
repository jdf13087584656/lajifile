package com.xlkj.website.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class CommonSearchDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "开始时间", name = "startTime")
    private String startTime;

    @ApiModelProperty(value = "结束时间", name = "endTime")
    private String endTime;

    @ApiModelProperty(value = "账号", name = "account")
    private String account;

    @ApiModelProperty(value = "当前页", name = "currentPage")
    private Integer currentPage;

    @ApiModelProperty(value = "每页数量", name = "pageSize")
    private Integer pageSize;
}
