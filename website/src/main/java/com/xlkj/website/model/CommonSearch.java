package com.xlkj.website.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class CommonSearch implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "当前页码", name = "currentPage")
    private Integer currentPage = 1;

    @ApiModelProperty(value = "每页数据量", name = "pageSize")
    private Integer pageSize = 10;

    @ApiModelProperty(value = "关键词", name = "keyWords")
    private String keyWords;

}
