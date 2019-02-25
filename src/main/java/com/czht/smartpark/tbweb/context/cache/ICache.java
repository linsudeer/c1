package com.czht.smartpark.tbweb.context.cache;

public interface ICache {
	
	void remove(final String key);
	
	boolean exists(final String key);
	
	Object get(final String key);
	
	void set(String key, Object value);
	
	void set(String key, Object value, long expired);
	
	void clear();

}
