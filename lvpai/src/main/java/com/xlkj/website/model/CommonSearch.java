package com.xlkj.website.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class CommonSearch implements Serializable {
    private static final long serialVersionUID = 1L;


    @ApiModelProperty(value = "关键词", name = "keyWords")
    private String keyWords;

}
