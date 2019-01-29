package com.czht.smartpark.tbweb.context.tip;

import com.czht.smartpark.tbweb.context.exception.ExceptionEnum;
import com.czht.smartpark.tbweb.context.tip.bean.Tip;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import java.util.List;

/**
 * 响应消息
 * @author lisonglin
 * @date 2018年4月13日 下午1:31:10
 */
public class ResultTip {
	
	private static final int OK = 200;
	
	private static final String MESSAGE = "操作成功";
	
	public static Tip success() {
		return success(OK, MESSAGE, null, 0);
	}
	
	public static Tip success(Object data) {
		return success(OK, MESSAGE, data, 0);
	}

	public static Tip success(Object data, Integer total) {
		return success(OK, MESSAGE, data, total);
	}

	public static Tip success(String message, Object data){
		return success(OK, message, data, 0);
	}
	
	public static Tip success(int code, String message) {
		return success(code, message, null, 0);
	}
	
	public static Tip success(int code, String message, Object data, Integer total) {
		return new Tip(code, message, data, total);
	}

	public static Tip error(ExceptionEnum exception){
		return error(exception.getCode(), exception.getMessage());
	}
	
	public static Tip error(int code, String message) {
		return new Tip(code, message, null, 0);
	}

	public static Tip error(BindingResult signResult) {
		StringBuilder msg = new StringBuilder();
		List<ObjectError> allErrors = signResult.getAllErrors();
		for (ObjectError objectError : allErrors) {
			msg.append(objectError.getDefaultMessage()).append(",");
		}
		return error(400, msg.subSequence(0, msg.length()-1).toString());
	}
}
