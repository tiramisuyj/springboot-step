package com.cnc.springbootstep.mongodb.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cnc.springbootstep.mongodb.AyUserAttachmentRel;
import com.cnc.springbootstep.mongodb.AyUserAttachmentRelRepository;
import com.cnc.springbootstep.mongodb.AyUserAttachmentRelService;

/** 
* @author yj 
* @date 2019-02-21 
*/
@Service
public class AyUserAttachmentRelServiceImpl implements AyUserAttachmentRelService{

	@Resource
	private AyUserAttachmentRelRepository ayUserAttachmentRelRepository;
	
	@Override
	public AyUserAttachmentRel save(AyUserAttachmentRel ayUserAttachmentRel) {
		return ayUserAttachmentRelRepository.save(ayUserAttachmentRel);
	}

}
