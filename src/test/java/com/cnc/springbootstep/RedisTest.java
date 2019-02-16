package com.cnc.springbootstep;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.cnc.springbootstep.jpa.entity.AyUser;
import com.cnc.springbootstep.jpa.service.AyUserService;

/** 
* @author yj 
* @date 2019-02-16 
*/

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

	@Resource 
	private RedisTemplate redisTemplate;
	
	@Resource
	private StringRedisTemplate stringRedisTemplate;
	
	@Resource
	private AyUserService ayUserService;
	
	@Test
	public void testRedis() {
		redisTemplate.opsForValue().set("name", "ay");
		String name = (String)redisTemplate.opsForValue().get("name");
		System.out.println(name);
		
		redisTemplate.delete("name");
		
		redisTemplate.opsForValue().set("name", "al");
		
		name = stringRedisTemplate.opsForValue().get("name");
		System.out.println(name);
	}
	
	@Test
	public void testFindById() {
		Long redisUserSizeLong = 0L;
		//查询 id =1的数据，该数据存在于redis缓存中
		AyUser ayUser = ayUserService.findById("1");
		redisUserSizeLong = redisTemplate.opsForList().size("ALL_USER_LIST");
		System.out.println("目前缓存中用户数量为：" + redisUserSizeLong);
		System.out.println("--->>> id : " + ayUser.getId() + " name:" + ayUser.getName());
		//查询id=2的数据，该数据存在于redis缓存中
		AyUser ayUser2 = ayUserService.findById("2");
		redisUserSizeLong = redisTemplate.opsForList().size("ALL_USER_LIST");
		System.out.println("目前缓存中用户数量为：" + redisUserSizeLong);
		System.out.println("--->>> id : " + ayUser2.getId() + " name:" + ayUser2.getName());
	}
}
