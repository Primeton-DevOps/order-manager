/*******************************************************************************
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on Nov 28, 2016 10:05:45 AM
 *******************************************************************************/

package com.primeton.devops.cd.cs;

import java.io.Serializable;

/**
 * ItemAttribute.
 *
 * @author ZhongWen Li (mailto:lizw@primeton.com)
 */
@Deprecated
public class ItemAttribute implements Serializable {
	
	/**
	 * <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -161119219654701555L;
	
	public static final String UNIT_STORAGE_BYTE = "B";
	public static final String UNIT_STORAGE_KB = "KB";
	public static final String UNIT_STORAGE_MB = "MB";
	public static final String UNIT_STORAGE_GB = "GB";
	public static final String UNIT_STORAGE_TB = "TB";
	public static final String UNIT_STORAGE_PB = "PB";
	
	public static final String UNIT_CLOCK_MHZ = "MHZ";
	public static final String UNIT_CLOCK_GHZ = "GHZ";
	
	private String name;
	private String value;
	private String unit;
	private String description;
	
	/**
	 * Default. <br>
	 */
	public ItemAttribute() {
		super();
	}

	/**
	 * @return Returns the name.
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name The name to set.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return Returns the value.
	 */
	public String getValue() {
		return value;
	}

	/**
	 * @param value The value to set.
	 */
	public void setValue(String value) {
		this.value = value;
	}

	/**
	 * @return Returns the unit.
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * @param unit The unit to set.
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}

	/**
	 * @return Returns the description.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description The description to set.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ItemAttribute [name=" + name + ", value=" + value + ", unit=" + unit + ", description=" + description
				+ "]";
	}
	
}
