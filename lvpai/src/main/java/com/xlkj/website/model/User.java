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
	 * 用户类型  1 货主 2 承运方 4 司机 8超管 （多角色编号相加）
	 */
	@ApiModelProperty("用户类型  1 货主 2 承运方 4 司机 8超管 （多角色编号相加）")
	private int userType;
	
	@ApiModelProperty("用户类型说明  1 货主 2 承运方 4 司机 8超管 （多角色编号相加）")
	private String userTypeStr;
	/**
	 * TMS 用户号
	 */
	@ApiModelProperty("TMS用户号")
	private int TMSUserId;

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

	public String getLoginAccount() {
		return loginAccount;
	}

	public void setLoginAccount(String loginAccount) {
		this.loginAccount = loginAccount;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOpenId() {
		return openId;
	}

	public void setOpenId(String openId) {
		this.openId = openId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public int getDelFlag() {
		return delFlag;
	}

	public void setDelFlag(int delFlag) {
		this.delFlag = delFlag;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public String getUserTypeStr() {
		return userTypeStr;
	}

	public void setUserTypeStr(String userTypeStr) {
		this.userTypeStr = userTypeStr;
	}

	public int getTMSUserId() {
		return TMSUserId;
	}

	public void setTMSUserId(int TMSUserId) {
		this.TMSUserId = TMSUserId;
	}

	public int getIsToken() {
		return isToken;
	}

	public void setIsToken(int isToken) {
		this.isToken = isToken;
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}
}
