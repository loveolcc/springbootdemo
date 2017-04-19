package com.example.exception;

public class UserException extends RuntimeException{

	private Integer code;
	private String message;
	public UserException(Integer code, String message) {
		super(message);
		this.code = code;
		this.message = message;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
