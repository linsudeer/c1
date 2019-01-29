package com.czht.smartpark.tbweb.context.exception;

public class BizException extends RuntimeException implements ExceptionBean{
	
	private static final long serialVersionUID = -2368700051330704005L;
	
	private Integer code;
	private String message;
	
	public BizException() {};
	
	public BizException(ExceptionEnum e) {
		this.code = e.getCode();
		this.message = e.getMessage();
	}
	
	public BizException(Integer code, String message) {
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
