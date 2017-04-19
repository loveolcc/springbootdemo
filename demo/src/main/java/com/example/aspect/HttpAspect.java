package com.example.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class HttpAspect {

	private Logger log=LoggerFactory.getLogger(HttpAspect.class);
	@Pointcut("execution(public * com.example.controller.UserController.regist(..))")
	public void userAs(){	
	}
	@Before("userAs()")
	public void logReq(JoinPoint jp){
		ServletRequestAttributes attr=(ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request=attr.getRequest();
		log.info("url{}",request.getRequestURL());
		log.info("content-type{}",request.getContentType());
		log.info("ip{}",request.getRemoteAddr());
		log.info("class_method",jp.getSignature().getDeclaringTypeName()+"."+jp.getSignature().getName());
		log.info("args{}",jp.getArgs());
	}
	@AfterReturning(returning="object",pointcut="userAs()")
	public void logResp(Object object){
		log.info("response{}",object.toString());
	}
}
