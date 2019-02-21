package com.cnc.springbootstep.mongodb;
/** 
 * 描述：用户头像关联表
* @author yj 
* @date 2019-02-21 
*/

import javax.persistence.Id;

public class AyUserAttachmentRel {

	@Id
	private String id;
	private String userIdString;
	private String fileName;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserIdString() {
		return userIdString;
	}
	public void setUserIdString(String userIdString) {
		this.userIdString = userIdString;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
}
