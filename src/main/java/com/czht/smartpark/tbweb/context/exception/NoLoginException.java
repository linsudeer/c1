package com.czht.smartpark.tbweb.context.exception;
/**
 * 没有登录异常
 * @author lisonglin
 * @date 2018年3月27日 下午4:29:50
 */
public class NoLoginException extends BizException{

	private static final long serialVersionUID = 4098474399030522822L;

	public NoLoginException() {
		super(ExceptionEnum.NO_LOGIN);
	}
	

}
