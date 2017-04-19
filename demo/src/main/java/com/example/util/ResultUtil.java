package com.example.util;

import com.example.entity.Result;
import com.example.entity.User;

public class ResultUtil {

	public static Result<User> errorResult(Integer code,String message){
		Result<User> rs=new Result<User>();
		rs.setCode(code);
		rs.setMessage(message);
		return rs;
	}
	public static Result<User> successResult(User u,Integer code,String message){
		Result<User> rs=new Result<User>();
		rs.setCode(code);
		rs.setMessage(message);
		rs.setData(u);
		return rs;
	}
}
