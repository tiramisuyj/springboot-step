package com.cnc.springbootstep.activemq.service;
/** 
 * 微信说说服务层
* @author yj 
* @date 2019-02-18 
*/

import com.cnc.springbootstep.activemq.entity.AyMood;

public interface AyMoodService {
	
	AyMood save(AyMood ayMood);
	String asynSave(AyMood ayMood);

}
