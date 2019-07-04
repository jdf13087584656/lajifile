package com.xlkj.website.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 结果响应超类
 * @author Administrator
 */
@Data
public class ResultSuper {
	/**
	 * 返回统一值
	 */
	@ApiModelProperty("返回是否成功")
	private boolean success = true;
	/**
	 * 返回信息
	 */
	@ApiModelProperty("返回成功与否信息")
	private String msg="success";
	
	/**
	 * 分页总数
	 */
	@ApiModelProperty("返回数据总数")
	private int total = 0;

	/**
	 * 设置错误信息
	 * @param msg
	 */
	public void resultFail(String msg) {
		this.success = false;
		this.msg = msg;
	}
	
	/**
	 * 设置成功信息
	 */
	public void resultSucc(String msg) {
		this.success = true;
		this.msg = msg;
	}

}
