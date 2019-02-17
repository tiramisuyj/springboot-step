package com.cnc.springbootstep.quartz;

import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cnc.springbootstep.jpa.entity.AyUser;
import com.cnc.springbootstep.jpa.service.AyUserService;
import com.cnc.springbootstep.mail.SendJunkMailService;

/** 
* @author yj 
* @date 2019-02-17 
*/
@Component 
@Configurable //加上此注解的类相当于xml配置文件，可以被spring boot扫描初始化
@EnableScheduling //加上此注解来开启对计划任务的支持
public class SendMailQuartz {
	
	private static final Logger logger = LogManager.getLogger(SendMailQuartz.class);
	
	@Resource
	private SendJunkMailService sendJunkMailService;
	
	@Resource
	private AyUserService ayUserService;
	
	//每五秒执行一次
	@Scheduled(cron = "*/5 * * * * *")
	public void reportCurrentByCron() {
		List<AyUser> userList = ayUserService.findAll();
		if(userList == null || userList.size() <= 0) {
			return ;
		}
		//发送邮件
		sendJunkMailService.sendJunkMail(userList);
		logger.info("定时器运行了");
	}
	

}
