package com.cnc.springbootstep.security.service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cnc.springbootstep.error.BusinessException;
import com.cnc.springbootstep.jpa.entity.AyUser;
import com.cnc.springbootstep.jpa.service.AyUserService;
import com.cnc.springbootstep.security.bean.AyUserRoleRel;

/** 
 * 描述：用户角色关联service
* @author yj 
* @date 2019-02-24 
*/
@Service
public class CustomUserService implements UserDetailsService{

	@Resource
	private AyUserService ayUserService;
	
	@Resource
	private AyUserRoleRelService ayUserRoleRelService;
	
	@Resource
	private AyRoleService ayRoleService;

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		
		List<AyUser> ayUsers = ayUserService.findByName(arg0);
		if(ayUsers == null) {
			throw new BusinessException("用户不存在");
		}
		AyUser ayUser = ayUsers.get(0);
		//获取用户所有的关联角色
		List<AyUserRoleRel> ayRoleList = ayUserRoleRelService.findByUserId(ayUser.getId());
		List<GrantedAuthority> authorityList = new ArrayList<GrantedAuthority>();
		if(ayRoleList != null && ayRoleList.size() > 0) {
			for(AyUserRoleRel rel : ayRoleList) {
				//获取用户关联角色名称
				String roleNameString = ayRoleService.find(rel.getRoleId()).getName();
				authorityList.add(new SimpleGrantedAuthority(roleNameString));
			}
		}
		return new User(ayUser.getName(), ayUser.getPassword(), authorityList);
	}
}
