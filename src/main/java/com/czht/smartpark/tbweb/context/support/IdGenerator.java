package com.czht.smartpark.tbweb.context.support;

import java.util.UUID;

public class IdGenerator{

	public static long generateOId(){
		IdWorker idWorker = new IdWorker(1,1,0);
		return idWorker.nextId();
	}
	
	 /**
     * <p>
     * 获取去掉"-" UUID
     * </p>
     */
    public static synchronized String generate32UUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
