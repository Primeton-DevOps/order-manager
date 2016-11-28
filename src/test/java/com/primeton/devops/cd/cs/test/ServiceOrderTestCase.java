/*******************************************************************************
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on Nov 28, 2016 11:23:58 AM
 *******************************************************************************/

package com.primeton.devops.cd.cs.test;

import com.primeton.devops.cd.cs.JsonUtil;
import com.primeton.devops.cd.cs.OrderItem;
import com.primeton.devops.cd.cs.ServiceOrder;
import com.primeton.devops.cd.cs.ServiceType;

/**
 * ServiceOrderTestCase.
 *
 * @author ZhongWen Li (mailto:lizw@primeton.com)
 */
public class ServiceOrderTestCase extends AbstractTestCase {

	/* (non-Javadoc)
	 * @see com.primeton.devops.cd.cs.test.AbstractTestCase#test()
	 */
	@Override
	public void test() throws Exception {
		// 服务订单
		ServiceOrder order = new ServiceOrder();
		
		// 订单项 - 虚拟机
		OrderItem item1 = new OrderItem();
		order.addItem(item1);
		
		// 设置所属环境
		item1.setAggregateName("dev"); //$NON-NLS-1$
		// 设置服务类型
		item1.setResourceType(ServiceType.VM.name());
		// 设置资源数量(虚拟机数量)
		item1.setResourceSize(3);
		// 添加资源描述(OS, Flavor, etc)
		item1.addAttribute("osname", "CentOS-7.2-x86_64"); //$NON-NLS-1$ //$NON-NLS-2$
		item1.addAttribute("model", "tiny"); //$NON-NLS-1$ //$NON-NLS-2$
		item1.addAttribute("storage", "100GB"); //$NON-NLS-1$ //$NON-NLS-2$
		item1.addAttribute("osuser", "zhangsan"); //$NON-NLS-1$ //$NON-NLS-2$
		item1.addAttribute("ospass", "devops@cloud.com"); //$NON-NLS-1$ //$NON-NLS-2$
		item1.addAttribute("description", "紧急！紧急！紧急！！！重要的事说三遍！！！"); //$NON-NLS-1$ //$NON-NLS-2$
		item1.addAttribute("nettype", "flat", true); //$NON-NLS-1$ //$NON-NLS-2$
		item1.addAttribute("cgroup", "default", true); //$NON-NLS-1$ //$NON-NLS-2$
		item1.addAttribute("subnet", "11.11.11.255", true); //$NON-NLS-1$ //$NON-NLS-2$
		item1.addAttribute("region", "shanghai", true); //$NON-NLS-1$ //$NON-NLS-2$
		
		//
		
		OrderItem item2 = new OrderItem();
		order.addItem(item2);
		
		item2.setAggregateName("dev"); //$NON-NLS-1$
		item2.setResourceType(ServiceType.VM.name());
		item2.setResourceSize(2);
		
		item2.addAttribute("osname", "Ubuntu-16.04-x86_64"); //$NON-NLS-1$ //$NON-NLS-2$
		item2.addAttribute("model", "normal"); //$NON-NLS-1$ //$NON-NLS-2$
		item2.addAttribute("storage", "200GB"); //$NON-NLS-1$ //$NON-NLS-2$
		item2.addAttribute("osuser", "lisi"); //$NON-NLS-1$ //$NON-NLS-2$
		item2.addAttribute("ospass", "devops@cloud.com"); //$NON-NLS-1$ //$NON-NLS-2$
		item2.addAttribute("description", "希望申请到新采购的那批x86物理机！！！"); //$NON-NLS-1$ //$NON-NLS-2$
		item2.addAttribute("nettype", "flat", true); //$NON-NLS-1$ //$NON-NLS-2$
		item2.addAttribute("cgroup", "default", true); //$NON-NLS-1$ //$NON-NLS-2$
		item2.addAttribute("subnet", "11.11.11.255", true); //$NON-NLS-1$ //$NON-NLS-2$
		item2.addAttribute("region", "shanghai", true); //$NON-NLS-1$ //$NON-NLS-2$
		
		//
		
		OrderItem item3 = new OrderItem();
		order.addItem(item3);
		
		item3.setAggregateName("product"); //$NON-NLS-1$
		item3.setResourceType(ServiceType.PM.name());
		item3.setResourceSize(5);
		
		item3.addAttribute("osname", "CentOS-7.2-x86_64"); //$NON-NLS-1$ //$NON-NLS-2$
		item3.addAttribute("model", "normal"); //$NON-NLS-1$ //$NON-NLS-2$
		item3.addAttribute("storage", "200GB"); //$NON-NLS-1$ //$NON-NLS-2$
		item3.addAttribute("osuser", "lisi"); //$NON-NLS-1$ //$NON-NLS-2$
		item3.addAttribute("ospass", "devops@cloud.com"); //$NON-NLS-1$ //$NON-NLS-2$
		item3.addAttribute("description", "希望申请到新采购的那批x86物理机！！！"); //$NON-NLS-1$ //$NON-NLS-2$
		item3.addAttribute("nettype", "flat", true); //$NON-NLS-1$ //$NON-NLS-2$
		item3.addAttribute("cgroup", "default", true); //$NON-NLS-1$ //$NON-NLS-2$
		item3.addAttribute("subnet", "11.11.11.255", true); //$NON-NLS-1$ //$NON-NLS-2$
		item3.addAttribute("region", "shanghai", true); //$NON-NLS-1$ //$NON-NLS-2$
		
		//
		
		OrderItem item4 = new OrderItem();
		order.addItem(item4);
		
		item4.setAggregateName("product"); //$NON-NLS-1$
		item4.setResourceSize(1);
		item4.setResourceType(ServiceType.Container.name());
		
		item4.addAttribute("namespace", "product-region-123456"); //$NON-NLS-1$ //$NON-NLS-2$
		item4.addAttribute("flavor", "4C16G"); //$NON-NLS-1$ //$NON-NLS-2$
		item4.addAttribute("description", "OpenShift ..."); //$NON-NLS-1$ //$NON-NLS-2$
		item4.addAttribute("region", "beijing", true); //$NON-NLS-1$ //$NON-NLS-2$
		item4.addAttribute("cgroup", "default", true); //$NON-NLS-1$ //$NON-NLS-2$
		
		String json = JsonUtil.toJson(order, true);
		System.err.println(json);
		
		// 审批之后
	}

}
