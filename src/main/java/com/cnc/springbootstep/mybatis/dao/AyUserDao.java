package com.cnc.springbootstep.mybatis.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cnc.springbootstep.jpa.entity.AyUser;

/** 
* @author yj 
* @date 2019-02-17 
*/

@Mapper
public interface AyUserDao {

	//@Param注解参数，在mapper.xml配置文件中，可以采用#{}的方式对@Param注解括号内的参数进行引用
	AyUser findByNameAndPassword(@Param("name") String name,@Param("password") String password);
}
