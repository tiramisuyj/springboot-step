package com.cnc.springbootstep.activemq.consumer;
/** 
 * 消费者
* @author yj 
* @date 2019-02-18 
*/

import javax.annotation.Resource;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.cnc.springbootstep.activemq.entity.AyMood;
import com.cnc.springbootstep.activemq.service.AyMoodService;

@Component
public class AyMoodConsumer {

	//使用@JmsListener配置消费者监听的队列ay.queue，其中text是接收到的消息
	@JmsListener(destination = "ay.queue")
	public void receiveQueue(String text) {
		System.out.println("用户发表说说【" + text + "】成功");
	}
	
	@Resource
	private AyMoodService ayMoodService;
	@JmsListener(destination = "ay.queue.asyn.save")
	public void receiveQueue(AyMood ayMood) {
		ayMoodService.asynSave(ayMood);
	}
}
