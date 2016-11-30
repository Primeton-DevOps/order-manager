/*******************************************************************************
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on Nov 28, 2016 10:28:32 AM
 *******************************************************************************/

package com.primeton.devops.cd.cs;

import java.util.HashMap;
import java.util.Map;

/**
 * CsResource.
 *
 * @author ZhongWen Li (mailto:lizw@primeton.com)
 */
public class CsResource extends HashMap<String, Object> {

	/**
	 * <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 5540109546068100563L;
	
	private String type;

	/**
	 * Default. <br>
	 */
	public CsResource() {
		super();
	}

	/**
	 * @param initialCapacity
	 * @param loadFactor
	 */
	public CsResource(int initialCapacity, float loadFactor) {
		super(initialCapacity, loadFactor);
	}

	/**
	 * @param initialCapacity
	 */
	public CsResource(int initialCapacity) {
		super(initialCapacity);
	}

	/**
	 * @param m
	 */
	public CsResource(Map<? extends String, ? extends Object> m) {
		super(m);
	}

	/**
	 * @param type
	 */
	public CsResource(String type) {
		super();
		this.type = type;
	}

	/**
	 * @return Returns the type.
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type The type to set.
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 
	 * @param key
	 * @return
	 */
	public String getStringValue(String key, String defaultValue) {
		if (null == key || key.trim().isEmpty()) {
			return defaultValue;
		}
		Object value = get(key);
		if (null == value) {
			return defaultValue;
		}
		return value instanceof String ? (String)value : value.toString();
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public String getStringValue(String key) {
		return getStringValue(key, null);
	}
	
	/**
	 * 
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public boolean getBooleanValue(String key, boolean defaultValue) {
		if (null == key || key.trim().isEmpty()) {
			return defaultValue;
		}
		Object value = get(key);
		if (null == value) {
			return defaultValue;
		}
		return value instanceof Boolean ? (Boolean)value : Boolean.parseBoolean(value.toString());
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public boolean getBooleanValue(String key) {
		return getBooleanValue(key, false);
	}
	
	/**
	 * 
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public byte getByteValue(String key, byte defaultValue) {
		if (null == key || key.trim().isEmpty()) {
			return defaultValue;
		}
		Object value = get(key);
		if (null == value) {
			return defaultValue;
		}
		return value instanceof Byte ? (byte)value : Byte.parseByte(value.toString());
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public byte getByteValue(String key) {
		return getByteValue(key, (byte)0);
	}
	
	/**
	 * 
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public int getIntValue(String key, int defaultValue) {
		if (null == key || key.trim().isEmpty()) {
			return defaultValue;
		}
		Object value = get(key);
		if (null == value) {
			return defaultValue;
		}
		return value instanceof Integer ? (int)value : Integer.parseInt(value.toString());
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public int getIntValue(String key) {
		return getIntValue(key, 0);
	}
	
	/**
	 * 
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public long getLongValue(String key, long defaultValue) {
		if (null == key || key.trim().isEmpty()) {
			return defaultValue;
		}
		Object value = get(key);
		if (null == value) {
			return defaultValue;
		}
		return value instanceof Long ? (long)value : Long.parseLong(value.toString());
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public long getLongValue(String key) {
		return getLongValue(key, 0L);
	}
	
	/**
	 * 
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public float getFloatValue(String key, float defaultValue) {
		if (null == key || key.trim().isEmpty()) {
			return defaultValue;
		}
		Object value = get(key);
		if (null == value) {
			return defaultValue;
		}
		return value instanceof Float ? (float)value : Float.parseFloat(value.toString());
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public float getFloatValue(String key) {
		return getFloatValue(key, 0F);
	}
	
	/**
	 * 
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public double getDoubleValue(String key, double defaultValue) {
		if (null == key || key.trim().isEmpty()) {
			return defaultValue;
		}
		Object value = get(key);
		if (null == value) {
			return defaultValue;
		}
		return value instanceof Double ? (double)value : Double.parseDouble(value.toString());
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public double getDoubleValue(String key) {
		return getDoubleValue(key, 0D);
	}
	
	/**
	 * 
	 * @param key
	 * @param value
	 */
	public void setValue(String key, Object value) {
		if (null == key || key.trim().isEmpty()) {
			return;
		}
		put(key, value);
	}
	
	/**
	 * 
	 * @param clazz
	 * @return
	 */
	public <T extends CsResource> T toTarget(Class<T> clazz) {
		if (null == clazz) {
			return null;
		}
		T target = null;
		try {
			target = clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			throw new RuntimeException(String.format("Can not instance object %s.", clazz.getName()));
		}
		target.putAll(this);
		return target;
	}
	
	/**
	 * 
	 * @param type
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <T extends CsResource> T toTarget(String type) {
		if (null == type || type.trim().isEmpty()) {
			return null;
		}
		if (CsType.PM.name().equalsIgnoreCase(type)) {
			PmResource resource = new PmResource();
			resource.putAll(this);
			return (T) resource;
		}
		if (CsType.VM.name().equalsIgnoreCase(type)) {
			VmResource resource = new VmResource();
			resource.putAll(this);
			return (T) resource;
		}
		if (CsType.CONTAINER.name().equalsIgnoreCase(type)) {
			ContainerResource resource = new ContainerResource();
			resource.putAll(this);
			return (T) resource;
		}
		throw new IllegalArgumentException(String.format("Illegal CLOUD_SERVICE_TYPE '%s'.", type));
	}
	
}
