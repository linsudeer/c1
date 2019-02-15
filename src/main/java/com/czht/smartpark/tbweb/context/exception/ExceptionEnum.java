package com.czht.smartpark.tbweb.context.exception;

public enum ExceptionEnum{
	
	REQUEST_ERRO(1000, "请求有错误"),

	LOGIN_NAME_NOT_NULL(1001, "登录名不能为空"),
	LOGIN_PASSWORD_NOT_NULL(1002, "密码不能为空"),
	LOGIN_FAIL(1003, "用户名或密码不正确"),
	OLD_PWD_NOT_RIGHT(1004, "原密码不正确"),
	TWO_PWD_NOT_MATCH(1005, "两次输入密码不一致"),
	EMAIL_EXIST(1006, "邮箱已经注册过"),
	NICKNAME_EXIST(1007, "名称已经存在"),
	PARAMS_ERROR(1008, "请求参数错误"),
	NO_LOGIN(-1, "没有登陆"),
	SESSION_TIMEOUT(-2, "会话超时"),
	ACCOUNT_FREEZED(-3, "账号被冻结"),
	
	NO_PERMITION(-4, "没有权限，请检查是否已授权！"),
	
	SERVER_ERROR(-99, "服务器异常");
	
	private Integer code;
	private String message;
	
	private ExceptionEnum(Integer code, String message){
		this.code = code;
		this.message = message;
	}
	
	public void setCode(Integer code){
		this.code = code;
	}
	
	public void setMessage(String message){
		this.message = message;
	}
	
	public Integer getCode() {
		return code;
	}

	public String getMessage() {
		return message;
	}

}
