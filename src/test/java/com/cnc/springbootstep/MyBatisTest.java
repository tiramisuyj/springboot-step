package com.cnc.springbootstep;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cnc.springbootstep.jpa.entity.AyUser;
import com.cnc.springbootstep.jpa.service.AyUserService;
import com.cnc.springbootstep.mybatis.dao.AyUserDao;

/**
 * @author yj
 * @date 2019-02-17
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MyBatisTest {

	@Resource
	private AyUserService ayUserService;

	@Test
	public void testMyBatis() {
		try {

			AyUser ayUser = ayUserService.findByNameAndPassword("阿毅", "123456");
			System.out.println(ayUser.getId() + ayUser.getName());
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
