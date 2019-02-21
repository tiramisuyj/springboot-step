package com.cnc.springbootstep;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cnc.springbootstep.mongodb.AyUserAttachmentRel;
import com.cnc.springbootstep.mongodb.AyUserAttachmentRelService;

/** 
* @author yj 
* @date 2019-02-21 
*/
@SpringBootTest
@RunWith(SpringRunner.class)
public class MongodbTest {
	
	@Resource
	private AyUserAttachmentRelService ayUserAttachmentRelService;
	
	@Test
	public void testMongoDB() {
		AyUserAttachmentRel ayUserAttachmentRel = new AyUserAttachmentRel();
		ayUserAttachmentRel.setId("1");
		ayUserAttachmentRel.setFileName("gerenjianli.doc");
		ayUserAttachmentRel.setUserIdString("1");
		ayUserAttachmentRelService.save(ayUserAttachmentRel);
	}

}
