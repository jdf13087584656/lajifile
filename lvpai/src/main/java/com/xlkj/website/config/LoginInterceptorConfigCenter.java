package com.xlkj.website.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * 登录拦截配置
 * @author 刘佳	
 *
 */
//@Configuration
public class LoginInterceptorConfigCenter extends WebMvcConfigurerAdapter {

	@Bean
    public LoginInterceptor securityInterceptor() {
        return new LoginInterceptor();
    }
	
    public void addInterceptors(InterceptorRegistry registry) {
    	//,"/system/**" /**
        registry.addInterceptor(securityInterceptor()).addPathPatterns("/**")
		//不拦截 静态资源、swagger 等 登录相关
		.excludePathPatterns(
				"/user/**",
				"/swagger**",
				"/v2/**",
				"/images/**",
				"/",
				"/**/*.css",
				"/**/*.js", 
				"/**/*.png", 
				"/**/*.jpg", 
				"/**/*.jpeg",
				"/configuration/**",
				"/**/login/login",
				"/**/login"
		);
    }

}
