package com.cnc.springbootstep.listener;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.springframework.data.redis.core.RedisTemplate;

import com.cnc.springbootstep.jpa.entity.AyUser;
import com.cnc.springbootstep.jpa.service.AyUserService;

/** 
* @author yj 
* @date 2019-02-15 
*/
@WebListener
public class AyUserListener implements ServletContextListener{
	
	@Resource
	private RedisTemplate redisTemplate;
	
	@Resource
	private AyUserService ayUserService;
	private static final String ALL_USER = "ALL_USER_LIST";

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		System.out.println("ServletContext 上下文销毁");
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		//查询数据库所有的用户
		List<AyUser> ayUserList = ayUserService.findAll();
		//清除缓存中的用户数据
		redisTemplate.delete(ALL_USER);
		//将数据存放到redis缓存中
		//redisTemplate.opsForList().leftPushAll：查询
		redisTemplate.opsForList().leftPushAll(ALL_USER, ayUserList);
		List<AyUser> queryUserList = redisTemplate.opsForList().range(ALL_USER, 0, -1);
		System.out.println("缓存中目前的用户数有：" + queryUserList.size() + " 人");
		System.out.println("ServletContext 上下文初始化");
	}

}
