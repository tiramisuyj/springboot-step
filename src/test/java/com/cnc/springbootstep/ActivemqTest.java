package com.cnc.springbootstep;

import java.util.Date;

import javax.annotation.Resource;
import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cnc.springbootstep.activemq.entity.AyMood;
import com.cnc.springbootstep.activemq.producer.AyMoodProducer;
import com.cnc.springbootstep.activemq.service.AyMoodService;
import com.mysql.fabric.xmlrpc.base.Data;

/** 
* @author yj 
* @date 2019-02-18 
*/
@SpringBootTest
@RunWith(SpringRunner.class)
public class ActivemqTest {
	
	@Resource
	private AyMoodService ayMoodService;
	
	@Resource
	private AyMoodProducer ayMoodProducer;
	
//	@Test
//	public void testAyMood() {
//		AyMood ayMood = new AyMood();
//		ayMood.setId("1");
//		ayMood.setUserId("1");
//		ayMood.setPraiseNum(0);
//		ayMood.setContent("这是我的第一条微信说说");
//		ayMood.setPublishTime(new Date());
//		ayMoodService.save(ayMood);
//	}
	
	@Test
	public void testActiveMQ() {
		Destination destination = new ActiveMQQueue("ay.queue");
		ayMoodProducer.sendMessage(destination, "hello,mq!!!");
	}
	
//	@Test
//	public void testActiveMQAsynSave() {
//		AyMood ayMood = new AyMood();
//		ayMood.setId("2");
//		ayMood.setUserId("2");
//		ayMood.setPraiseNum(0);
//		ayMood.setContent("这是我的第一天微信说说");
//		ayMood.setPublishTime(new Date());
//		String msg = ayMoodService.asynSave(ayMood);
//		System.out.println("异步发表说说：" + msg);
//	}

}
