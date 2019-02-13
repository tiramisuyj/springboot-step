package com.cnc.springbootstep;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import com.cnc.springbootstep.jpa.entity.AyUser;
import com.cnc.springbootstep.jpa.service.AyUserService;

/** 
* @author yj 
* @date 2019-02-13 
*/

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaTest {

	@Resource
	private AyUserService ayUserService;
	
	@Test
	public void testRepository() {
		//查询所有的数据
		List<AyUser> userList = ayUserService.findAll();
		System.out.println("findAll() : " + userList.size());
		//通过name查询数据
		List<AyUser> userList2 = ayUserService.findByName("阿毅");
		System.out.println("findByName() : " + userList2.size());
		Assert.isTrue(userList2.get(0).getName().equals("阿毅"),"data error!");
		//通过name模糊查询
		List<AyUser> userList3 = ayUserService.findByNameLike("%毅%");
		System.out.println("findByNameLike() : " + userList3.size());
		Assert.isTrue(userList3.get(0).getName().equals("阿毅"),"data error!");
		//通过Id查询
		List<String> ids = new ArrayList<String>();
		ids.add("1");
		ids.add("2");
		List<AyUser> userList4 = ayUserService.findByIdIn(ids);
		System.out.println("findByIdIn() : " + userList4.size());
		//分页查询
		PageRequest pageRequest = new PageRequest(0, 10);
		Page<AyUser> userList5 = ayUserService.findAll(pageRequest);
		System.out.println("Page findAll() : " + userList5.getTotalPages() + "/" + userList5.getSize());
		//新增数据
		AyUser ayUser = new AyUser();
		ayUser.setId("3");
		ayUser.setName("test");
		ayUser.setPassword("123");
		ayUserService.save(ayUser);
		//删除数据
		ayUserService.delete("3");
	}
}
