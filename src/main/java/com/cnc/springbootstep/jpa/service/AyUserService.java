package com.cnc.springbootstep.jpa.service;
/** 
* @author yj 
* @date 2019-02-12 
*/

import java.util.Collection;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cnc.springbootstep.jpa.entity.AyUser;

public interface AyUserService {

	AyUser findById(String id);
	List<AyUser> findAll();
	AyUser save(AyUser ayUser);
	void delete(String id);
	//分页
	Page<AyUser> findAll(Pageable pageable);
	List<AyUser> findByName(String name);
	List<AyUser> findByNameLike(String name);
	List<AyUser> findByIdIn(Collection<String> ids);
}
