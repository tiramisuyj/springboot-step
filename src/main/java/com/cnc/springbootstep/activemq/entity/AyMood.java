package com.cnc.springbootstep.activemq.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/** 
* @author yj 
* @date 2019-02-17 
*/
@Entity
@Table(name="ay_mood")
public class AyMood implements Serializable{
	
	@Id
	private String id;
	//说说内容
	private String content;
	//用户Id
	private String userId;
	//点赞数量
	private Integer praiseNum;
	//发表时间
	private Date publishTime;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Integer getPraiseNum() {
		return praiseNum;
	}
	public void setPraiseNum(Integer praiseNum) {
		this.praiseNum = praiseNum;
	}
	public Date getPublishTime() {
		return publishTime;
	}
	public void setPublishTime(Date publishTime) {
		this.publishTime = publishTime;
	}
	
}
