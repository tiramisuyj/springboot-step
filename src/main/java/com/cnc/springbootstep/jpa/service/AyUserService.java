package com.cnc.springbootstep.jpa.service;
/** 
* @author yj 
* @date 2019-02-12 
*/

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Future;

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
	//mybatis接口
	AyUser findByNameAndPassword(String name,String password);
	//异步查询接口
	Future<List<AyUser>> findAsyncAll();
}
