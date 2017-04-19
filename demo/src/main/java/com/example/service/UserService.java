package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.UserDao;
import com.example.entity.Result;
import com.example.entity.User;
import com.example.exception.UserException;
import com.example.util.ResultUtil;

@Service(value="userService")
public class UserService {

	@Autowired
	private UserDao userDao;
	
	public Result<User> regist(User u){
		isValidate(u);
		Result<User> rs=ResultUtil.successResult(u, 102, "注册成功");
		userDao.save(u);
		return rs;
	}
	public void isValidate(User u){
		if((u.getUsername()).equals("zzh")){
			throw new UserException(101,"炸制化和狗不得入内");
		}
	}
}