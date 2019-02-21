/**
 * 
 */
package com.czht.smartpark.tbweb.util;

import org.apache.commons.collections.CollectionUtils;
import org.dozer.DozerBeanMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhen.ling
 * 
 */
public class BeanUtil {

	private static final DozerBeanMapper MAPPER = new DozerBeanMapper();

	/*static {
		List<String> files = new ArrayList<String>();
		files.add("com/czht/wdp/common/converter/bean.xml");
		MAPPER.setMappingFiles(files);
	}*/

	public static <T> T convert(Object orig, Class<T> clazz) {
		if (orig == null) {
			return null;
		}
		return MAPPER.map(orig, clazz);
	}

	public static void copy(Object orig, Object dest) {
			if (orig == null) {
				return;
			}

		Object o = orig;
		MAPPER.map(o, dest);
	}


	/**
	 * 转出List
	 * @param orig
	 * @param clazz
	 * @return
	 */
	public static <T> List<T> convertList(List<?> orig, Class<T> clazz) {
		List<T> dest = null;

		if (!CollectionUtils.isEmpty(orig)) {
			dest = new ArrayList<T>();
			for (Object each : orig) {
				T destEntry = convert(each, clazz);
				dest.add(destEntry);
			}

		} else if (orig != null) {
			dest = new ArrayList<T>();
		}
		return dest;
	}
	
	


}
