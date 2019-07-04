package com.xlkj.website.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户实体
 * @author wangming
 *
 */
@ApiModel("用户实体")
@Data
public class User implements Serializable{
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 */
	@ApiModelProperty("主键")
	private int id;


	@ApiModelProperty("登录名")
	private String loginAccount;

	@ApiModelProperty("登录名")
	private String username;
	
	/**
	 * 微信唯一标识
	 */
	@ApiModelProperty("微信唯一标识")
	private String openId;

	/**
	 * 用户名
	 */
	@ApiModelProperty("用户名")
	private String userName;
	/**
	 * 密码
	 */
	@ApiModelProperty("密码")
	private String password;
	/**
	 * 电话
	 */
	@ApiModelProperty("电话")
	private String telephone;
	/**
	 * 是否在线 1 不在线  2在线
	 */
	@ApiModelProperty("是否在线 1：不在线，2：在线")
	private int isActive;
	/**
	 * 是否被删 1 OK 2  被删
	 */
	@ApiModelProperty("是否被删 1:OK，2：被删")
	private int delFlag;
	/**
	 * 创建时间
	 */
	@ApiModelProperty("创建时间")
	private String createTime;



	/**
	 * 是否认证
	 */
	@ApiModelProperty("是否认证")
	
	private int isToken;
	/**
	 * 组织机构id
	 */
	@ApiModelProperty("组织机构id")
	private int deptId;

}
