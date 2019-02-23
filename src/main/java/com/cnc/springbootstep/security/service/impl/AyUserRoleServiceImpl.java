package com.cnc.springbootstep.security.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cnc.springbootstep.security.bean.AyUserRoleRel;
import com.cnc.springbootstep.security.repository.AyUserRoleRelRepository;
import com.cnc.springbootstep.security.service.AyUserRoleRelService;

/** 
* @author yj 
* @date 2019-02-24 
*/
@Service
public class AyUserRoleServiceImpl implements AyUserRoleRelService {
	
	@Resource
	private AyUserRoleRelRepository ayUserRoleRelRepository;

	@Override
	public List<AyUserRoleRel> findByUserId(String userId) {
		return ayUserRoleRelRepository.findByUserId(userId);
	}

}
