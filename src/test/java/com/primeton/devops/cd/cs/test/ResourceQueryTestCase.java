/*******************************************************************************
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on Nov 28, 2016 4:36:39 PM
 *******************************************************************************/

package com.primeton.devops.cd.cs.test;

import java.util.ArrayList;
import java.util.List;

import com.primeton.devops.cd.cs.ContainerResource;
import com.primeton.devops.cd.cs.CsResource;
import com.primeton.devops.cd.cs.CsType;
import com.primeton.devops.cd.cs.JsonUtil;
import com.primeton.devops.cd.cs.OrderItem;
import com.primeton.devops.cd.cs.PmResource;
import com.primeton.devops.cd.cs.ServiceOrder;
import com.primeton.devops.cd.cs.VmResource;

/**
 * ResourceQueryTestCase.
 *
 * @author ZhongWen Li (mailto:lizw@primeton.com)
 */
public class ResourceQueryTestCase extends AbstractTestCase {

	/* (non-Javadoc)
	 * @see com.primeton.devops.cd.cs.test.AbstractTestCase#test()
	 */
	@Override
	public void test() throws Exception {
		String json = getResourceAsString("classpath:/order-response.json");
		
		System.err.println(json);
		
		ServiceOrder order = JsonUtil.toObject(json, ServiceOrder.class);
		
		List<OrderItem> items = order.getItems();
		
		List<VmResource> vmResources = new ArrayList<>();
		List<PmResource> pmResources = new ArrayList<>();
		List<ContainerResource> containerResources = new ArrayList<>();
		
		//
		// 按资源分类查询
		//
		
		for (OrderItem item : items) {
			for (CsResource resource : item.getResources()) {
				if (CsType.PM.name().equalsIgnoreCase(resource.getType())) {
					pmResources.add(resource.toTarget(PmResource.class));
				} else if (CsType.VM.name().equalsIgnoreCase(resource.getType())) {
					vmResources.add(resource.toTarget(VmResource.class));
				} else if (CsType.CONTAINER.name().equalsIgnoreCase(resource.getType())) {
					containerResources.add(resource.toTarget(ContainerResource.class));
				}
			}
		}
		
		System.out.println(pmResources);
		System.out.println(vmResources);
		System.out.println(containerResources);
		
		//
		// 按环境分类 + 资源分类查询
		//
		
		//List<VmResource> devVmResources = new ArrayList<>();
		//List<VmResource> testVmResources = new ArrayList<>();
		// TODO
	}

}
