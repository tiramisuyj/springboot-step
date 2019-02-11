package com.cnc.springbootstep.druid.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cnc.springbootstep.jdbc.entity.AyUser;

/** 
* @author yj 
* @date 2019-02-11 
*/
@RestController
public class testSqlController {
	
	@Resource
	private JdbcTemplate jdbcTemplate;
	
	@RequestMapping("/testSqlCount")
	public void testSqlCount() {
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
