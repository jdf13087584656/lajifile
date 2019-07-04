package com.xlkj.website.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 王明
 * @date 2018/3/8 用户相关工具类
 */
public class UserUtils {
	private static Logger logger = LoggerFactory.getLogger(UserUtils.class);

	/**
	 * 获取请求中token
	 *
	 * @param httpServletRequest
	 *            request
	 * @return token
	 */
	public static String getToken(HttpServletRequest httpServletRequest) {
		String authorization = httpServletRequest.getHeader("Authorization");
		if(!"".equals(authorization) && null != authorization && !"null".equals(authorization)) {
			String s=authorization;
			return s;
		}
		return null;
	}



}
