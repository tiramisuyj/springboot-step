package com.cnc.springbootstep;

import java.util.List;
import java.util.concurrent.Future;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cnc.springbootstep.jpa.entity.AyUser;
import com.cnc.springbootstep.jpa.service.AyUserService;

/** 
* @author yj 
* @date 2019-02-18 
*/

@SpringBootTest
@RunWith(SpringRunner.class)
public class AsyncTest {
	
	@Resource
	private AyUserService ayUserService;

	@Test
	public void testAsync() {
		long startTime = System.currentTimeMillis();
		System.out.println("第一次查询所有用户！");
		List<AyUser> ayUsers = ayUserService.findAll();
		System.out.println("第二次查询所有用户！");
		List<AyUser> ayUsers2 = ayUserService.findAll();
		System.out.println("第三次查询所有用户！");
		List<AyUser> ayUsers3 = ayUserService.findAll();
		long endTime = System.currentTimeMillis();
		System.out.println("总共消耗" + (endTime - startTime) + "ms");
	}
	
	@Test
	public void testAsync2() {
		long startTime = System.currentTimeMillis();
		System.out.println("第一次查询所有用户！");
		Future<List<AyUser>> ayUsers = ayUserService.findAsyncAll();
		System.out.println("第二次查询所有用户！");
		Future<List<AyUser>> ayUsers2 = ayUserService.findAsyncAll();
		System.out.println("第三次查询所有用户！");
		Future<List<AyUser>> ayUsers3 = ayUserService.findAsyncAll();
		while(true) {
			if(ayUsers.isDone() && ayUsers2.isDone() && ayUsers3.isDone()) {
				break;
			}else {
				try {
					Thread.sleep(10);
					System.out.println("sleep 10");
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		long endTime = System.currentTimeMillis();
		System.out.println("总共消耗" + (endTime - startTime) + "ms");
	}
}
