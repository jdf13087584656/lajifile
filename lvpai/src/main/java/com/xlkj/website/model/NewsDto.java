package com.xlkj.website.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther: Admin
 * @Date: 2019/8/7 17:17
 * @Description:
 */
@Data
@ApiModel
public class NewsDto {

    @ApiModelProperty(value = "cid", name = "cid")
    private Integer cid;

    @ApiModelProperty(value = "标题", name = "tital")
    private String tital;

    @ApiModelProperty(value = "部分内容", name = "content")
    private String content;
    @ApiModelProperty(value = "创建时间", name = "createtime")
    private String createtime;


    @ApiModelProperty(value = "图片链接", name = "urls")
    private String urls;
    @ApiModelProperty(value = "文章链接", name = "url")
    private String url;


}
