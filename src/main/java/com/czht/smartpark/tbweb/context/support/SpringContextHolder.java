package com.czht.smartpark.tbweb.context.support;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextHolder implements ApplicationContextAware {
	
	private static ApplicationContext applicationContext;

	/**
	 * 注入applicationContext
	 */
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringContextHolder.applicationContext = applicationContext;
	}
	
	public ApplicationContext getApplicationContext(){
		assertApplicationContext();
		return applicationContext;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T getBean(String beanName){
		assertApplicationContext();
		return (T) applicationContext.getBean(beanName);
	}
	
	public static <T> T getBean(Class<T> clz){
		assertApplicationContext();
		return (T) applicationContext.getBean(clz);
	}
	
	private static void assertApplicationContext(){
		if(SpringContextHolder.applicationContext == null){
			throw new RuntimeException("applicationContext属性为null，请检查是否注入了SpringContextHolder!");
		}
	}

}
