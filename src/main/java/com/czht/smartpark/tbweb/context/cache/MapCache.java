package com.czht.smartpark.tbweb.context.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 基于map的缓存
 * @author lisonglin
 * @date 2018年4月2日 下午1:51:00
 */
public class MapCache implements ICache{
	
	/**
	 * 默认的缓存大小
	 */
	public static final int DEFAULT_SIZE = 1024;
	
	public static final MapCache instance = new MapCache();
	
	/**
	 * 缓存容器
	 */
	public static Map<String, CacheObject> cachePool = new ConcurrentHashMap<String, CacheObject>(DEFAULT_SIZE);
	
	public static MapCache getInstance() {
		return instance;
	}
	
	private MapCache() {}
	

	@Override
	public void remove(String key) {
		cachePool.remove(key);
		
	}

	@Override
	public boolean exists(String key) {
		return cachePool.containsKey(key);
		
	}

	@Override
	public Object get(String key) {
		CacheObject cacheObject = cachePool.get(key);
		if(cacheObject != null) {
			long expired = cacheObject.getExpired();
			long cur = System.currentTimeMillis()/1000;
			if(expired<0 || expired>cur) {
				return cacheObject.getValue();
			}else {
				this.remove(key);
			}
		}
		return null;
	}
	
	@Override
	public void set(String key, Object value) {
		this.set(key, value, -1);
		
	}

	@Override
	public void set(String key, Object value, long expired) {
		expired = expired>0?System.currentTimeMillis()/1000+expired:expired;
		CacheObject cacheObject = new CacheObject(key, value, expired);
		cachePool.put(key, cacheObject);
	}
	
	@Override
	public void clear() {
		cachePool.clear();
	}

	static class CacheObject{
		private String key;
		private Object value;
		private long expired;
		
		public CacheObject(String key, Object value, long expired) {
			super();
			this.key = key;
			this.value = value;
			this.expired = expired;
		}
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public Object getValue() {
			return value;
		}
		public void setValue(Object value) {
			this.value = value;
		}
		public long getExpired() {
			return expired;
		}
		public void setExpired(long expired) {
			this.expired = expired;
		}
	}


}
