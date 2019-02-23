package com.cnc.springbootstep.security.repository;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import com.cnc.springbootstep.security.bean.AyUserRoleRel;

/** 
 * 
 * 描述：用户角色关联
* @author yj 
* @date 2019-02-23 
*/
public interface AyUserRoleRelRepository extends JpaRepository<AyUserRoleRel, String>{

	List<AyUserRoleRel> findByUserId(@Param("userId")String userID);
}
