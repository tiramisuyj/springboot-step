package com.cnc.springbootstep.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/** 
* @author yj 
* @date 2019-02-15 
*/
@WebFilter(filterName = "ayUserFilter",urlPatterns = "/*")
public class AyUserFilter implements Filter{

	@Override
	public void destroy() {
		System.out.println("------->>destory");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		System.out.println("-------->>doFilter");
		arg2.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("------->>init");
	}

}
