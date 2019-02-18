package com.cnc.springbootstep.activemq.producer;
/** 
 * 生产者
* @author yj 
* @date 2019-02-18 
*/

import javax.annotation.Resource;
import javax.jms.Destination;

import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import com.cnc.springbootstep.activemq.entity.AyMood;

@Service
public class AyMoodProducer {

	/**
	 * jmsMessagingTemplate:发消息的工具类，也可以注入JmsTemplate，jmsMessagingTemplate对
	 * JmsTemplate进行封装，参数destination是发送到队列，message是待发送的消息
	 */
	@Resource
	private JmsMessagingTemplate jmsMessagingTemplate;
	
	public void sendMessage(Destination destination,final String message) {
		jmsMessagingTemplate.convertAndSend(destination,message);
	}
	
	public void sendMessage(Destination destination,final AyMood ayMood) {
		jmsMessagingTemplate.convertAndSend(destination,ayMood);
	}
}
