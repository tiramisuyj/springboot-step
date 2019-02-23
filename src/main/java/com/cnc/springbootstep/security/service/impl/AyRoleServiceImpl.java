package com.cnc.springbootstep.security.service.impl;
/** 
 * 描述：用户角色service
* @author yj 
* @date 2019-02-24 
*/

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cnc.springbootstep.security.bean.AyRole;
import com.cnc.springbootstep.security.repository.AyRoleRepository;
import com.cnc.springbootstep.security.service.AyRoleService;

@Service
public class AyRoleServiceImpl implements AyRoleService{
	
	@Resource
	private AyRoleRepository ayRoleRepository;

	@Override
	public AyRole find(String id) {
		return ayRoleRepository.findOne(id);
	}

}
