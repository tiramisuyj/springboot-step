package com.cnc.springbootstep.mail;

import java.util.List;

import javax.annotation.Resource;
import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.cnc.springbootstep.jpa.entity.AyUser;
import com.cnc.springbootstep.jpa.service.AyUserService;

/** 
* @author yj 
* @date 2019-02-17 
*/
@Service
public class SendJunkMailServiceImpl implements SendJunkMailService{
	
	@Autowired
	JavaMailSender javaMailSender;
	
	@Resource
	private AyUserService ayUserService;
	
	@Value("${spring.mail.username}")
	private String from;
	
	public static final Logger logger = LogManager.getLogger(SendJunkMailServiceImpl.class);

	@Override
	public boolean sendJunkMail(List<AyUser> ayUserList) {
		try {
			if(ayUserList == null || ayUserList.size() <= 0) {
				return Boolean.FALSE;
			}
			for(AyUser ayUser : ayUserList) {
				MimeMessage mimeMessage = this.javaMailSender.createMimeMessage();
				MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
				//邮件发送方
				mimeMessageHelper.setFrom(from);
				//邮件主题
				mimeMessageHelper.setSubject("地瓜今日特卖");
				//邮件收件方
				mimeMessageHelper.setTo("test111@163.com");
				//邮件内容
				mimeMessageHelper.setText(ayUser.getName() + "你知道吗？厦门地瓜今日特卖，一斤只要9元");
				//发送邮件
				this.javaMailSender.send(mimeMessage);
			}
		} catch (Exception e) {
			logger.error("",e);
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

}
