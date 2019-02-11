package com.cnc.springbootstep.druid.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

/** 
* @author yj 
* @date 2019-02-10 
* 
* 开启监控功能：
* 方式一：使用原生Servlet,Filter方式，然后通过@ServletComponentScan启动扫描包进行处理；
* 方式二：使用代码注册Servlet和Filter的方式处理
* 这里我们使用第二种方式
*/
@Configuration
public class DruidConfiguration {

	@Bean
	public ServletRegistrationBean druidStatViewServle() {
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
		//初始化参数
		//白名单
		servletRegistrationBean.addInitParameter("allow", "127.0.0.1");
		//IP黑名单（同时存在时，deny优先于allow）
		//如果满足deny，就提示：sorry , you are not permitted to view this page
		servletRegistrationBean.addInitParameter("deny", "192.168.1.73");
		//登录查看信息的账号和密码
		servletRegistrationBean.addInitParameter("loginUsername", "admin");
		servletRegistrationBean.addInitParameter("loginPassword", "123456");
		//是否能够重置数据
		servletRegistrationBean.addInitParameter("resetEnable", "false");
		return servletRegistrationBean;
	}
	
	@Bean
	public FilterRegistrationBean druidStatFilter() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
		//添加过滤规则
		filterRegistrationBean.addUrlPatterns("/*");
		//添加需要忽略的格式信息
		filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif");
		return filterRegistrationBean;
	}
}
