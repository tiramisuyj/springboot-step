package com.cnc.springbootstep.security.bean;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/** 
 * 描述：用户角色实体
* @author yj 
* @date 2019-02-23 
*/
@Entity
@Table(name="ay_role")
public class AyRole {

	@Id
	private String id;
	private String name;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
