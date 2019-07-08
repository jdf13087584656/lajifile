package com.xlkj.website.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Auther: Admin
 * @Date: 2019/7/7 17:58
 * @Description:
 */
@Data
public class FileInfo {

    @ApiModelProperty(value = "文件id", name = "fileid")
    private Integer fileid;
    @ApiModelProperty(value = "文件路径", name = "filepath")
    private String  filepath;
    @ApiModelProperty(value = "文件描述", name = "memo")
    private String  memo;
    @ApiModelProperty(value = "文件类型(1.首页轮播图,2活动图)", name = "type")
    private Integer type;
    @ApiModelProperty(value = "活动链接", name = "hurl")
    private Integer hurl;
    @ApiModelProperty(value = "上传时间", name = "createtime")
    private String createtime;
    @ApiModelProperty(value = "文件名称", name = "filename")
    private String filename;
    @ApiModelProperty(value = "文件状态", name = "filestate")
    private Integer filestate;
}
