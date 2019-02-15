package com.cnc.springbootstep.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/** 
* @author yj 
* @date 2019-02-15 
*/
@WebListener
public class AyUserListener implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("ServletContext 上下文销毁");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		System.out.println("ServletContext 上下文初始化");
	}

}
