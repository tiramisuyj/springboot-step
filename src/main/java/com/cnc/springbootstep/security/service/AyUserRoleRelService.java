package com.cnc.springbootstep.security.service;
/** 
 * 描述：用户角色关联service
* @author yj 
* @date 2019-02-23 
*/

import java.util.List;

import com.cnc.springbootstep.security.bean.AyUserRoleRel;

public interface AyUserRoleRelService {

	List<AyUserRoleRel> findByUserId(String userId);
}
