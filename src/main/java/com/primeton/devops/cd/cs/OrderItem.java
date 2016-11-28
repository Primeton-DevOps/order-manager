/*******************************************************************************
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on Nov 28, 2016 10:15:52 AM
 *******************************************************************************/

package com.primeton.devops.cd.cs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 云服务申请单订单项. <br>
 *
 * @author ZhongWen Li (mailto:lizw@primeton.com)
 */
public class OrderItem implements Serializable {

	/**
	 * <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 2622005805207017063L;
	/**
	 * 订单项所属环境类型(dev, test, stage, product, etc.)
	 */
	private String aggregateName;
	/**
	 * 资源类型（VM, PM, Container, etc.）
	 */
	private String resourceType;
	/**
	 * 资源数量
	 */
	private int resourceSize;
	/**
	 * 资源属性(OS, 用户, 密码, 存储, etc.)
	 */
	//private List<ItemAttribute> attributes;
	private Map<String, Object> attributes; // value (基本类型 + string)
	
	private Map<String, Object> advances;
	
	/**
	 * 云服务开通之后资源信息(VM, PM, Container, etc.)存储
	 */
	private List<CsResource> resources;
	
	/**
	 * Default. <br>
	 */
	public OrderItem() {
		super();
	}

	/**
	 * @return Returns the aggregateName.
	 */
	public String getAggregateName() {
		return aggregateName;
	}

	/**
	 * @param aggregateName The aggregateName to set.
	 */
	public void setAggregateName(String aggregateName) {
		this.aggregateName = aggregateName;
	}

	/**
	 * @return Returns the resourceType.
	 */
	public String getResourceType() {
		return resourceType;
	}

	/**
	 * @param resourceType The resourceType to set.
	 */
	public void setResourceType(String resourceType) {
		this.resourceType = resourceType;
	}

	/**
	 * @return Returns the resourceSize.
	 */
	public int getResourceSize() {
		return resourceSize;
	}

	/**
	 * @param resourceSize The resourceSize to set.
	 */
	public void setResourceSize(int resourceSize) {
		this.resourceSize = resourceSize;
	}

	/**
	 * @return Returns the attributes.
	 */
	public Map<String, Object> getAttributes() {
		if (null == attributes) {
			attributes = new HashMap<>();
		}
		return attributes;
	}

	/**
	 * @param attributes The attributes to set.
	 */
	public void setAttributes(Map<String, Object> attributes) {
		this.attributes = attributes;
	}
	
	/**
	 * @return Returns the advances.
	 */
	public Map<String, Object> getAdvances() {
		if (null == advances) {
			advances = new HashMap<>();
		}
		return advances;
	}

	/**
	 * @param advances The advances to set.
	 */
	public void setAdvances(Map<String, Object> advances) {
		this.advances = advances;
	}

	/**
	 * 
	 * @param key
	 * @param value
	 * @param advance
	 * @return
	 */
	public OrderItem addAttribute(String key, Object value, boolean advance) {
		if (null == key || 0 == key.trim().length()) {
			return this;
		}
		if (advance) {
			getAdvances().put(key, value);
		} else {
			getAttributes().put(key, value);
		}
		return this;
	}
	
	/**
	 * 
	 * @param key
	 * @param value
	 * @return
	 */
	public OrderItem addAttribute(String key, Object value) {
		return addAttribute(key, value, false);
	}
	
	/**
	 * 
	 * @param key
	 * @param advance
	 * @return
	 */
	public OrderItem removeAttribute(String key, boolean advance) {
		if (null == key || 0 == key.trim().length()) {
			return this;
		}
		if (advance) {
			getAdvances().remove(key);
		} else {
			getAttributes().remove(key);
		}
		return this;
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public OrderItem removeAttribute(String key) {
		return removeAttribute(key, false);
	}
	
	/**
	 * 
	 * @param key
	 * @param defaultValue
	 * @param advance
	 * @return
	 */
	public Object getAttributeValue(String key, Object defaultValue, boolean advance) {
		if (null == key || 0 == key.trim().length()) {
			return defaultValue;
		}
		Object value = advance ? getAdvances().get(key) : getAttributes().get(key);
		return null == value ? defaultValue : value;
	}
	
	/**
	 * 
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public Object getAttributeValue(String key, Object defaultValue) {
		return getAttributeValue(key, defaultValue, false);
	}
	
	/**
	 * 
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public String getAttributeStringValue(String key, String defaultValue, boolean advance) {
		Object value = getAttributeValue(key, defaultValue, advance);
		if (null == value) {
			return defaultValue;
		}
		return value instanceof String ? (String)value : value.toString();
	}
	
	/**
	 * 
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public String getAttributeStringValue(String key, String defaultValue) {
		return getAttributeStringValue(key, defaultValue, false);
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public String getAttributeStringValue(String key) {
		return getAttributeStringValue(key, null, false);
	}

	/**
	 * 
	 * @param key
	 * @param defaultValue
	 * @param advance
	 * @return
	 */
	public long getAttributeLongValue(String key, long defaultValue, boolean advance) {
		Object value = getAttributeValue(key, defaultValue, advance);
		if (null == value) {
			return defaultValue;
		}
		return value instanceof Long ? (long)value : Long.parseLong(value.toString());
	}
	
	/**
	 * 
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public long getAttributeLongValue(String key, long defaultValue) {
		return getAttributeLongValue(key, defaultValue, false);
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public long getAttributeLongValue(String key) {
		return getAttributeLongValue(key, 0L, false);
	}
	
	/**
	 * 
	 * @param key
	 * @param defaultValue
	 * @param advance
	 * @return
	 */
	public int getAttributeIntValue(String key, int defaultValue, boolean advance) {
		Object value = getAttributeValue(key, defaultValue, advance);
		if (null == value) {
			return defaultValue;
		}
		return value instanceof Integer ? (int)value : Integer.parseInt(value.toString());
	}
	
	/**
	 * 
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public int getAttributeIntValue(String key, int defaultValue) {
		return getAttributeIntValue(key, defaultValue, false);
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public int getAttributeIntValue(String key) {
		return getAttributeIntValue(key, 0, false);
	}
	
	/**
	 * 
	 * @param key
	 * @param defaultValue
	 * @param advance
	 * @return
	 */
	public byte getAttributeByteValue(String key, byte defaultValue, boolean advance) {
		Object value = getAttributeValue(key, defaultValue, advance);
		if (null == value) {
			return defaultValue;
		}
		return value instanceof Byte ? (byte)value : Byte.parseByte(value.toString());
	}
	
	/**
	 * 
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public byte getAttributeByteValue(String key, byte defaultValue) {
		return getAttributeByteValue(key, defaultValue, false);
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public byte getAttributeByteValue(String key) {
		return getAttributeByteValue(key, (byte)0, false);
	}
	
	/**
	 * 
	 * @param key
	 * @param defaultValue
	 * @param advance
	 * @return
	 */
	public float getAttributeFloatValue(String key, float defaultValue, boolean advance) {
		Object value = getAttributeValue(key, defaultValue, advance);
		if (null == value) {
			return defaultValue;
		}
		return value instanceof Float ? (float)value : Float.parseFloat(value.toString());
	}
	
	/**
	 * 
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public float getAttributeFloatValue(String key, float defaultValue) {
		return getAttributeFloatValue(key, defaultValue, false);
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public float getAttributeFloatValue(String key) {
		return getAttributeFloatValue(key, 0F, false);
	}
	
	/**
	 * 
	 * @param key
	 * @param defaultValue
	 * @param advance
	 * @return
	 */
	public double getAttributeDoubleValue(String key, double defaultValue, boolean advance) {
		Object value = getAttributeValue(key, defaultValue, advance);
		if (null == value) {
			return defaultValue;
		}
		return value instanceof Double ? (double)value : Double.parseDouble(value.toString());
	}
	
	/**
	 * 
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public double getAttributeDoubleValue(String key, double defaultValue) {
		return getAttributeDoubleValue(key, defaultValue, false);
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public double getAttributeDoubleValue(String key) {
		return getAttributeDoubleValue(key, 0D, false);
	}
	
	/**
	 * 
	 * @param key
	 * @param defaultValue
	 * @param advance
	 * @return
	 */
	public boolean getAttributeBooleanValue(String key, boolean defaultValue, boolean advance) {
		Object value = getAttributeValue(key, defaultValue, advance);
		if (null == value) {
			return defaultValue;
		}
		return value instanceof Boolean ? (boolean)value : Boolean.parseBoolean(value.toString());
	}
	
	/**
	 * 
	 * @param key
	 * @param defaultValue
	 * @return
	 */
	public boolean getAttributeBooleanValue(String key, boolean defaultValue) {
		return getAttributeBooleanValue(key, defaultValue, false);
	}
	
	/**
	 * 
	 * @param key
	 * @return
	 */
	public boolean getAttributeBooleanValue(String key) {
		return getAttributeBooleanValue(key, false, false);
	}
	
	/**
	 * @return Returns the resources.
	 */
	public List<CsResource> getResources() {
		if (null == resources) {
			resources = new ArrayList<>();
		}
		return resources;
	}

	/**
	 * @param resources The resources to set.
	 */
	public void setResources(List<CsResource> resources) {
		this.resources = resources;
	}
	
	/**
	 * 
	 * @param resource
	 * @return
	 */
	public OrderItem addResource(CsResource resource) {
		if (null == resource) {
			return this;
		}
		getResources().add(resource);
		return this;
	}
	
	/**
	 * 
	 * @param resource
	 * @return
	 */
	public OrderItem removeResource(CsResource resource) {
		if (null == resource) {
			return this;
		}
		getResources().remove(resource);
		return this;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "OrderItem [aggregateName=" + aggregateName + ", resourceType=" + resourceType + ", resourceSize="
				+ resourceSize + ", attributes=" + attributes + ", resources=" + resources + "]";
	}

}
