package com.xlkj.website.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
public class PictureDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "文件", name = "picName")
    private String picName;

    @ApiModelProperty(value = "类型(1 轮播图   2活动图)", name = "type")
    private Integer type;

    @ApiModelProperty(value = "图片路径", name = "hurl")
    private String hurl;
}
