package com.xlkj.website.model;

import lombok.Data;

/**
 * @Auther: Admin
 * @Date: 2019/7/7 17:58
 * @Description:
 */
@Data
public class FileInfo {

    private Integer fileid;
    private String  filepath;
    private String  memo;
    private Integer type;
    private Integer hurl;
    private String createtime;
    private String filename;
}
