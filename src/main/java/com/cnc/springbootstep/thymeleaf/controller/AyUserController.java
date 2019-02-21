package com.cnc.springbootstep.thymeleaf.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cnc.springbootstep.error.BusinessException;
import com.cnc.springbootstep.jpa.entity.AyUser;
import com.cnc.springbootstep.jpa.service.AyUserService;

/** 
* @author yj 
* @date 2019-02-13 
*/
@Controller
@RequestMapping("/ayUser")
public class AyUserController {

	@Resource
	private AyUserService ayUserService;
	
	@RequestMapping("/test")
	public String test(Model model) {
		//查询数据库所有用户
		List<AyUser> ayUser = ayUserService.findAll();
		model.addAttribute("users", ayUser);
		return "ayUser";
	}
	
	@RequestMapping("/findAll")
	public String findAll(Model model) {
		//查询数据库所有用户
		List<AyUser> ayUser = ayUserService.findAll();
		model.addAttribute("users", ayUser);
		throw new BusinessException("业务异常");
	}
}
