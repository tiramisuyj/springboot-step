package com.cnc.springbootstep.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cnc.springbootstep.security.bean.AyRole;

/** 
 * 描述：用户角色repository
* @author yj 
* @date 2019-02-23 
*/
public interface AyRoleRepository extends JpaRepository<AyRole, String> {

}
