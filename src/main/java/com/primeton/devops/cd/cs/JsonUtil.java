/**
 * 
 */
package com.primeton.devops.cd.cs;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author ZhongWen (mailto:lizhongwen1989@gmail.com)
 *
 */
public class JsonUtil {
	
	private JsonUtil(){}
	
	/**
	 * 
	 * @param obj
	 * @param prettyOutput
	 * @return
	 */
	public static String toJson(Object obj, boolean prettyOutput) {
		if (null == obj) {
			return null;
		}
		try {
			if (prettyOutput) {
				return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(obj);
			} else {
				return new ObjectMapper().writeValueAsString(obj);
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 
	 * @param obj
	 * @return
	 */
	public static String toJson(Object obj) {
		return toJson(obj, false);
	}
	
	/**
	 * 
	 * @param json
	 * @return
	 */
	public static <T> T toObject(String json, Class<T> clazz) {
		if (StringUtils.isBlank(json)) {
			return null;
		}
		try {
			return new ObjectMapper().readValue(json, clazz);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
