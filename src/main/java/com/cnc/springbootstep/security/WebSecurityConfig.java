package com.cnc.springbootstep.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.cnc.springbootstep.security.service.CustomUserService;

/** 
 * 描述：security配置类
* @author yj 
* @date 2019-02-22 
*/
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Bean
	public CustomUserService customUserService() {
		return new CustomUserService();
	};
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//路由策略和访问权限的简单配置
		http.
		formLogin().//启用默认登录界面
		failureUrl("/login?error").//登录失败返回url：/login?error
		defaultSuccessUrl("/ayUser/test").//登录成功跳转url，这里跳转到用户首页
		permitAll();//登录页面全部权限可访问
		super.configure(http);
	}
	
	/**
	 * 配置内存用户
	 */
	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth.inMemoryAuthentication().withUser("阿毅").password("123456").roles("ADMIN").
//		and().withUser("阿兰").password("123456").roles("USER");
		auth.userDetailsService(customUserService());
	}

}
