package com.cnc.springbootstep.security.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/** 
 * 描述：用户角色关联
* @author yj 
* @date 2019-02-23 
*/
@Entity
@Table(name = "ay_user_role_rel")
public class AyUserRoleRel {

	@Id
	private String userId;
	private String roleId;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
	
}
