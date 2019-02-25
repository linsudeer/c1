package com.czht.smartpark.tbweb.modular.dto;

public class ScreenExtDto {

	/**
	 * 姓名
	 */
	private String userName;
	
	/**
	 * 图片路径
	 */
	private String picUrl;
	
	/**
	 * 方法，进入还是离开
	 */
	private String direct;
	
	private Long passDateTime;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getDirect() {
		return direct;
	}

	public void setDirect(String direct) {
		this.direct = direct;
	}

	public Long getPassDateTime() {
		return passDateTime;
	}

	public void setPassDateTime(Long passDateTime) {
		this.passDateTime = passDateTime;
	}
	
	
}
