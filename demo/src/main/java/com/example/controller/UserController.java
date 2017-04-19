package com.example.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Result;
import com.example.entity.User;
import com.example.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService us;
	
	@RequestMapping(value="/regist",method=RequestMethod.POST)
	public Result<User> regist(User u) throws Exception{
		Result<User> rs=us.regist(u);
		return rs;
	}
}
