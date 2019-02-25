package com.czht.smartpark.tbweb.modular.dto;

import java.util.Date;

public class ScreenDTO {
	
	private Integer userId;

	/**
	 * 通行时间
	 */
	private Date passDateTime;
	
	/**
	 * 所有总数
	 */
	private int allTotalCnt;
	
	/**
	 * 本单位总数
	 */
	private int allSelfCnt;
	
	/**
	 * 访客
	 */
	private int allOtherCnt;
	
	/**
	 * 今日总数
	 */
	private int todayTotalCnt;
	
	/**
	 * 今日本单位总数
	 */
	private int todaySelfCnt;
	
	/**
	 * 今日访客总数
	 */
	private int todayOtherCnt;
	
	/**
	 * 区域名字
	 */
	private String areaName;
	
	/**
	 * 单位名字
	 */
	private String cmpName;
	
	/**
	 * 显示标题
	 */
	private String title;

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

	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getPassDateTime() {
		return passDateTime;
	}

	public void setPassDateTime(Date passDateTime) {
		this.passDateTime = passDateTime;
	}

	public int getAllTotalCnt() {
		return allTotalCnt;
	}

	public void setAllTotalCnt(int allTotalCnt) {
		this.allTotalCnt = allTotalCnt;
	}

	public int getAllSelfCnt() {
		return allSelfCnt;
	}

	public void setAllSelfCnt(int allSelfCnt) {
		this.allSelfCnt = allSelfCnt;
	}

	public int getAllOtherCnt() {
		return allOtherCnt;
	}

	public void setAllOtherCnt(int allOtherCnt) {
		this.allOtherCnt = allOtherCnt;
	}

	public int getTodayTotalCnt() {
		return todayTotalCnt;
	}

	public void setTodayTotalCnt(int todayTotalCnt) {
		this.todayTotalCnt = todayTotalCnt;
	}

	public int getTodaySelfCnt() {
		return todaySelfCnt;
	}

	public void setTodaySelfCnt(int todaySelfCnt) {
		this.todaySelfCnt = todaySelfCnt;
	}

	public int getTodayOtherCnt() {
		return todayOtherCnt;
	}

	public void setTodayOtherCnt(int todayOtherCnt) {
		this.todayOtherCnt = todayOtherCnt;
	}

	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	public String getCmpName() {
		return cmpName;
	}

	public void setCmpName(String cmpName) {
		this.cmpName = cmpName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

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
}
