package com.narangnorang.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.narangnorang.interceptor.LoginHandlerInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {

	@Autowired
	LoginHandlerInterceptor loginHandlerInterceptor;

//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(loginHandlerInterceptor).excludePathPatterns("/main", "/login", "/logout",
//				"/sessionInvalidate", "/signUp", "/findPw" , "/**/*.css", "/**/*.js", "/checkEmail",
//				"/checkMail", "/checkName", "/generalSignUp", "/counselorSignUp", "/newPw");
//	}

	// PUT, DELETE 처리
	@Bean
	public HiddenHttpMethodFilter httpMethodFilter() {
		HiddenHttpMethodFilter hiddenHttpMethodFilter = new HiddenHttpMethodFilter();
		return hiddenHttpMethodFilter;
	}

}
