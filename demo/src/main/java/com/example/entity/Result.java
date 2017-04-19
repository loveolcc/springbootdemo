package com.example.entity;

public class Result<H> {

	private Integer code;
	private String message;
	private H data;
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
	public H getData() {
		return data;
	}
	public void setData(H data) {
		this.data = data;
	}
	
}
