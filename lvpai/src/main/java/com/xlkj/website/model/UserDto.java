package com.xlkj.website.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
public class UserDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "账号主键", name = "uid")
    private Integer uid;

    @ApiModelProperty(value = "账号", name = "account")
    private String account;

    @ApiModelProperty(value = "密码", name = "password")
    private String password;

    @ApiModelProperty(value = "姓名", name = "userName")
    private String userName;

    @ApiModelProperty(value = "手机号", name = "cellNumber")
    private String cellNumber;

    @ApiModelProperty(value = "类型(1,管理员  2,回收员)", name = "type")
    private Integer type;

    @ApiModelProperty(value = "备注", name = "memo")
    private String memo;

    @ApiModelProperty(value = "是否删除(0 正常   1删除)", name = "isDeleted")
    private Integer isDeleted;

    @ApiModelProperty(value = "回收员已完成数量", name = "quantityCompletion")
    private Integer quantityCompletion;

    @ApiModelProperty(value = "回收员未完成数量", name = "unfinished")
    private Integer unfinished;

    @JsonFormat(pattern = "yyyy/MM/dd HH:mm:ss", timezone = "GMT+8")
    @ApiModelProperty(value = "创建时间", name = "createTime")
    private String createTime;

    public void setUid(Integer uid){this.uid=uid;}
    public void setAccount(String account){this.account=account;}
    public void setPassword(String password){this.password=password;}
    public void setUserName(String userName){this.userName=userName;}
    public void setCellNumber(String cellNumber){this.cellNumber = cellNumber; }
    public void setType(Integer type) {this.type = type;}
    public void setMemo(String memo) {this.memo = memo;}
    public void setIsDeleted(Integer isDeleted){this.isDeleted = isDeleted;}
    public void setQuantityCompletion(Integer quantityCompletion) {
        this.quantityCompletion = quantityCompletion;
    }
    public void setUnfinished(Integer unfinished) {
        this.unfinished = unfinished;
    }
    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }
    //    public UserDto(Integer uid, String account, String password, String userName, String cellNumber, Integer type, String memo, Integer isDeleted, Integer quantityCompletion, Integer unfinished, String createTime) {
//        this.uid = uid;
//        this.account = account;
//        this.password = password;
//        this.userName = userName;
//        this.cellNumber = cellNumber;
//        this.type = type;
//        this.memo = memo;
//        this.isDeleted = isDeleted;
//        this.quantityCompletion = quantityCompletion;
//        this.unfinished = unfinished;
//        this.createTime = createTime;
//    }
}
