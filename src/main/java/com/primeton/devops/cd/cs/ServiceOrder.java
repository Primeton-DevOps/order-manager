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
	
	public static final String STATUS_OPEND = "OPEND";
	public static final String STATUS_SUBMIT = "SUBMIT";
	public static final String STATUS_REJECT = "REJECT";
	public static final String STATUS_DELETE = "DELETE";

	private List<OrderItem> items;
	
	/**
	 * @see {@link ServiceOrder#STATUS_OPEND} <br>
	 * @see {@link ServiceOrder#STATUS_DELETE} <br>
	 * @see {@link ServiceOrder#STATUS_SUBMIT} <br>
	 * @see {@link ServiceOrder#STATUS_REJECT} <br>
	 */
	private String status;

	/**
	 * Default. <br>
	 */
	public ServiceOrder() {
		super();
	}
	
	/**
	 * @param items
	 * @param status
	 */
	public ServiceOrder(List<OrderItem> items, String status) {
		super();
		this.items = items;
		this.status = status;
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

	/**
	 * @return Returns the status.
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status The status to set.
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ServiceOrder [items=" + items + ", status=" + status + "]";
	}

}
