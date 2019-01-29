package com.czht.smartpark.tbweb.context.support;

import com.czht.smartpark.tbweb.modular.constant.Constant;
import com.czht.smartpark.tbweb.modular.dto.UserDTO;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class HttpServletRequestHolder {
	
	private static final String PROTOCOL = "http://";
	
	/**
	 * get request
	 * @return
	 */
	public static HttpServletRequest getHttpServletRequest() {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		return request;
	}
	
	/**
	 * 返回远程项目访问路径
	 * @return
	 */
	public static String getRemoteUrl() {
		HttpServletRequest request = getHttpServletRequest();
		String remoteAddr = request.getRemoteAddr();
		int remotePort = request.getServerPort();
		String contextPath = request.getContextPath();
		return PROTOCOL+remoteAddr + ":"+remotePort+"/"+contextPath+"/";
	}
	
	/**
	 * get session
	 * @return
	 */
	public static HttpSession getHttpSession() {
		HttpSession session = getHttpServletRequest().getSession();
		return session;
	}
	
	/**
	 * 设置session不可用，同时清空SessionInfo对象
	 */
	public static void sessionInvalidate() {
		HttpSession session = getHttpSession();
		session.setAttribute(Constant.SESSION_USER, null);
		session.invalidate();
	}
	
	/**
	 * 获取session
	 * @return
	 */
	public static UserDTO getSessionInfo() {
		HttpSession session = getHttpSession();
		return (UserDTO) session.getAttribute(Constant.SESSION_USER);
	}
	
	/**
	 * 设置session值
	 * @param sessionInfo
	 */
	public static void setSessionInfo(UserDTO sessionInfo) {
		HttpSession session = getHttpSession();
		session.setAttribute(Constant.SESSION_USER, sessionInfo);
	}
	
	/**
	 * 返回IP
	 * @return
	 */
	public static String getIp() {
		return getHttpServletRequest().getRemoteHost();
	}
	
	/**
	 * 返回当前登录用户
	 * @return
	 */
	public static UserDTO getUser() {
		UserDTO sessionInfo = getSessionInfo();
		if(sessionInfo != null) {
			return sessionInfo;
		}
		return null;
	}
	
	/**
	 * 返回当前登录的用户Id
	 * @return
	 */
	public static Integer getUserId() {
		UserDTO user = getUser();
		if(user != null) 
			return user.getUserId();
		return -1;
	}
	
	/**
	 * 返回用户昵称
	 * @return
	 */
	public static String getNickName() {
		UserDTO user = getUser();
		if(user != null) 
			return ((UserDTO) user).getUserName();
		return "";
				
	}
}
