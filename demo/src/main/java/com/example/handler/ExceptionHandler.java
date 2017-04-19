package com.example.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.entity.Result;
import com.example.entity.User;
import com.example.exception.UserException;
import com.example.util.ResultUtil;
@RestControllerAdvice
public class ExceptionHandler {

	private static final Logger log=LoggerFactory.getLogger(ExceptionHandler.class);
	@org.springframework.web.bind.annotation.ExceptionHandler(value=Exception.class)
	public Result<User> handle(Exception e){
		log.error("exception[]{}", e);
		if(e instanceof UserException){
			UserException ue=(UserException)e;
			return ResultUtil.errorResult(ue.getCode(),ue.getMessage());
		}else{
			return ResultUtil.errorResult(0, "未知错误");
		}
	}
}
