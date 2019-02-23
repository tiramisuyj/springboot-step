package com.cnc.springbootstep.security.service;
/** 
 * 描述：用户角色service
* @author yj 
* @date 2019-02-23 
*/

import com.cnc.springbootstep.security.bean.AyRole;

public interface AyRoleService {

	AyRole find(String id);
}
