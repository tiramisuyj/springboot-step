package com.cnc.springbootstep.jpa.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cnc.springbootstep.jpa.entity.AyUser;

/** 
* @author yj 
* @date 2019-02-11 
*/
public interface AyUserRepository extends JpaRepository<AyUser, String>{

	/**
	 * 描述：通过名字相等查询，参数为name
	 * 相当于：select u from ay_user u where u.name = ?
	 */
	List<AyUser> findByName(String name);
	
	/**
	 * 描述：通过名字like查询，参数为name
	 * 相当于：select u from ay_user u where u.name like ?
	 */
	List<AyUser> findByNameLike(String name);
	
	/**
	 * 描述：通过主键id集合查询，参数为id集合
	 * 相当于：select u from ay_user u where u.id in (?,?,?)
	 */
	List<AyUser> findByIdIn(Collection<String> ids);
}
