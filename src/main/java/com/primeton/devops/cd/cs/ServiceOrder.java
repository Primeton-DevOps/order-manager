/*******************************************************************************
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on Nov 28, 2016 10:21:00 AM
 *******************************************************************************/

package com.primeton.devops.cd.cs;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * ServiceOrder.
 *
 * @author ZhongWen Li (mailto:lizw@primeton.com)
 */
public class ServiceOrder implements Serializable {

	/**
	 * <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 7627128131884039443L;

	private List<OrderItem> items;

	/**
	 * Default. <br>
	 */
	public ServiceOrder() {
		super();
	}
	
	/**
	 * 
	 * @param item
	 * @return
	 */
	public ServiceOrder addItem(OrderItem item) {
		if (null == item) {
			return this;
		}
		getItems().add(item);
		return this;
	}
	
	/**
	 * 
	 * @param item
	 * @return
	 */
	public ServiceOrder removeItem(OrderItem item) {
		if (null == item) {
			return this;
		}
		getItems().remove(item);
		return this;
	}

	/**
	 * @return Returns the items.
	 */
	public List<OrderItem> getItems() {
		if (null == items) {
			items = new ArrayList<>();
		}
		return items;
	}

	/**
	 * @param items The items to set.
	 */
	public void setItems(List<OrderItem> items) {
		this.items = items;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ServiceOrder [items=" + items + "]";
	}
	
}
