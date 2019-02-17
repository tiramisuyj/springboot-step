package com.cnc.springbootstep.jpa.service.impl;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Id;

import org.apache.catalina.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.cnc.springbootstep.jpa.entity.AyUser;
import com.cnc.springbootstep.jpa.repository.AyUserRepository;
import com.cnc.springbootstep.jpa.service.AyUserService;
import com.cnc.springbootstep.mybatis.dao.AyUserDao;

/** 
* @author yj 
* @date 2019-02-12 
*/
@Service
public class AyUserServiceImpl implements AyUserService{
	
	@Resource
	private AyUserRepository ayUserRepository;
	
	@Resource
	private RedisTemplate redisTemplate;
	private static final String ALL_USER = "ALL_USER_LIST";
	
	@Resource
	private AyUserDao ayUserDao;

	@Override
	public AyUser findById(String id) {
//		return ayUserRepository.getOne(id);//版本1
		//修改：如果在redis缓存中查不到数据，再到数据库中查找
		List<AyUser> ayUserList = redisTemplate.opsForList().range(ALL_USER, 0, -1);
		if(ayUserList != null && ayUserList.size() > 0) {
			for(AyUser ayUser : ayUserList) {
				if(ayUser.getId().equals(id)) {
					return ayUser;
				}
			}
		}
		
		AyUser ayUser = ayUserRepository.getOne(id);
		if(ayUser != null) {
			redisTemplate.opsForList().leftPush(ALL_USER, ayUser);
		}
		return ayUser;
	}

	@Override
	public List<AyUser> findAll() {
		return ayUserRepository.findAll();
	}

	@Override
	public AyUser save(AyUser ayUser) {
		return ayUserRepository.save(ayUser);
	}

	@Override
	public void delete(String id) {
		ayUserRepository.delete(id);
	}

	@Override
	public Page<AyUser> findAll(Pageable pageable) {
		return ayUserRepository.findAll(pageable);
	}

	@Override
	public List<AyUser> findByName(String name) {
		return ayUserRepository.findByName(name);
	}

	@Override
	public List<AyUser> findByNameLike(String name) {
		return ayUserRepository.findByNameLike(name);
	}

	@Override
	public List<AyUser> findByIdIn(Collection<String> ids) {
		return ayUserRepository.findByIdIn(ids);
	}

	@Override
	public AyUser findByNameAndPassword(String name, String password) {
		return ayUserDao.findByNameAndPassword(name, password);
	}

}
