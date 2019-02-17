package com.cnc.springbootstep.mail;

import java.util.List;

import com.cnc.springbootstep.jpa.entity.AyUser;

/** 
* @author yj 
* @date 2019-02-17 
*/
public interface SendJunkMailService {
	
	boolean sendJunkMail(List<AyUser> ayUser);

}
