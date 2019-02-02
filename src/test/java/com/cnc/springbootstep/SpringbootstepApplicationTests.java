package com.cnc.springbootstep;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;

import com.cnc.springbootstep.jdbc.entity.AyUser;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootstepApplicationTests {
	
	@Resource
	private JdbcTemplate jdbcTemplate;

	/**
	 * RowMapper对象：RowMapper对象可以将查询出的每一行数据封装成用户定义的类，在上面的代码中，通过调用RowMapper中的mapRow方法
	 * 将数据库中的每一行数据封装成AyUser对象，并返回
	 */
	@Test
	public void jdbcTest() {
		String sql = "select id,name,password from ay_user";
		List<AyUser> userList = (List<AyUser>) jdbcTemplate.query(sql, new RowMapper<AyUser>() {

			@Override
			public AyUser mapRow(ResultSet rs, int rowNum) throws SQLException {
				AyUser user = new AyUser();
				user.setId(rs.getString("id"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));
				return user;
			}
		});
		
		System.out.println("查询成功：");
		for(AyUser user : userList) {
			System.out.println("【id】:" + user.getId() + ";【name】:" + user.getName());
		}
	}
	
	

}
