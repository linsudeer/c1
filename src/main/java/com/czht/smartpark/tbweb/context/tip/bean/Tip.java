package com.czht.smartpark.tbweb.context.tip.bean;

import java.util.List;

/**
 * 响应消息
 * @author lisonglin
 * @date 2018年4月13日 下午1:15:00
 */
public class Tip {

	protected int code;
	protected String msg;
	protected Object data;
	protected int total;
	public Tip() {}
	
	public Tip(int code, String msg, Object data, int total) {
		this.code = code;
		this.msg = msg;
		this.data = data;
		if(total == 0 ){
			if(data != null && data instanceof List) {
				this.total = ((List<?>)data).size();
			}
		}else {
			this.total = total;
		}
	}


	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
}
