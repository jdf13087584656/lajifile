
package com.xlkj.website.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 返回统一码
 *
 * @author 王明
 */
@Data
@ApiModel(value = "统一返回类型", description = "统一返回类型")
public class ResultVo<T> {

    /**
     * 返回统一值
     */
    @ApiModelProperty(value = "请求成功失败标识 true 成功 false 失败", name = "success", example = "true")
    private boolean success = true;

    /**
     * 返回信息
     */
    @ApiModelProperty(value = "返回信息 当success错误时 返回错误信息", name = "msg", example = "请输入密码！")
    private String msg = "success";

    /**
     * 返回数据
     */
    @ApiModelProperty(value = "返回数据", name = "data")
    private T data;

    /**
     * 分页总数
     */
    @ApiModelProperty(value = "分页总数 默认0", name = "total", example = "100")
    private int total = 0;


    public void resultFail(String msg) {
        this.success = false;
        if (msg.contains("NullPointerException")){
            msg="空指针异常，请联系管理员";
        }
        if (msg.contains("TooManyResultsException")){
            msg="查询到多条数据，请联系管理员";
        }
        this.msg = msg;
    }

    public void resultSuccess(T obj) {
        this.success = true;
        this.data = obj;
    }

    /**
     * 自定义flag返回方法
     */
    public void resultFlag(ResultVo<Integer> result, Integer flag, String trueDesc, String falseDesc) {
        if (flag > 0) {
            result.setSuccess(true);
            result.setMsg(trueDesc);
            result.setTotal(flag);
        } else {
            result.setSuccess(false);
            result.setMsg(falseDesc);
            result.setTotal(flag);
        }
    }

}
