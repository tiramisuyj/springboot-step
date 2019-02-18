package com.cnc.springbootstep.activemq.service.impl;

import javax.annotation.Resource;
import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cnc.springbootstep.activemq.entity.AyMood;
import com.cnc.springbootstep.activemq.producer.AyMoodProducer;
import com.cnc.springbootstep.activemq.repository.AyMoodRepository;
import com.cnc.springbootstep.activemq.service.AyMoodService;

/** 
* @author yj 
* @date 2019-02-18 
*/
@Service
public class AyMoodServiceImpl implements AyMoodService{

	@Resource
	private AyMoodRepository ayMoodRepository;
	
	@Override
	public AyMood save(AyMood ayMood) {
		return ayMoodRepository.save(ayMood);
	}

	//队列
	private static Destination destination = new ActiveMQQueue("ay.queue.asyn.save");
	@Resource
	private AyMoodProducer ayMoodProducer;
	@Override
	public String asynSave(AyMood ayMood) {
		//往队列ay.queue.asyn.save推送消息，消息内容为说说实体
		ayMoodProducer.sendMessage(destination, ayMood);
		return "success";
	}

}
