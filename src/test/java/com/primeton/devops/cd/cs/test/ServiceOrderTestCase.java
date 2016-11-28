/*******************************************************************************
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on Nov 28, 2016 11:23:58 AM
 *******************************************************************************/

package com.primeton.devops.cd.cs.test;

import com.primeton.devops.cd.cs.ContainerResource;
import com.primeton.devops.cd.cs.JsonUtil;
import com.primeton.devops.cd.cs.OrderItem;
import com.primeton.devops.cd.cs.PmResource;
import com.primeton.devops.cd.cs.ServiceOrder;
import com.primeton.devops.cd.cs.ServiceType;
import com.primeton.devops.cd.cs.VmResource;

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
		item1.setResourceSize(2);
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
		item2.setResourceType(ServiceType.PM.name());
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
		System.err.println("\n\n");
		
		//
		// 审批之后
		//
		
		VmResource resource11 = new VmResource();
		item1.addResource(resource11);
		
		resource11.setHostDomain("project1.devops.region");
		resource11.setHostModel("tiny");
		resource11.setHostName("uuid");
		resource11.setIpAddress("192.168.2.23");
		resource11.setMacAddress("02:79:60:0c:3e:16");
		resource11.setOsUser("zhangsan");
		resource11.setOsPass("devops@cloud.com");
		resource11.setRootPass("devops@cloud.com");
		
		VmResource resource12 = new VmResource();
		item1.addResource(resource12);
		
		resource12.setHostDomain("project1.devops.region");
		resource12.setHostModel("tiny");
		resource12.setHostName("uuid");
		resource12.setIpAddress("192.168.2.24");
		resource12.setMacAddress("02:79:60:0c:3e:17");
		resource12.setOsUser("zhangsan");
		resource12.setOsPass("devops@cloud.com");
		resource12.setRootPass("devops@cloud.com");
		
		//

		PmResource resource21 = new PmResource();
		item2.addResource(resource21);
		
		resource21.setHostDomain("project1.devops.region");
		resource21.setHostModel("tiny");
		resource21.setHostName("uuid");
		resource21.setIpAddress("192.168.2.23");
		resource21.setMacAddress("02:79:60:0c:3e:16");
		resource21.setOsUser("zhangsan");
		resource21.setOsPass("devops@cloud.com");
		resource21.setRootPass("devops@cloud.com");
		
		PmResource resource22 = new PmResource();
		item2.addResource(resource22);
		
		resource22.setHostDomain("project1.devops.region");
		resource22.setHostModel("tiny");
		resource22.setHostName("uuid");
		resource22.setIpAddress("192.168.2.24");
		resource22.setMacAddress("02:79:60:0c:3e:17");
		resource22.setOsUser("zhangsan");
		resource22.setOsPass("devops@cloud.com");
		resource22.setRootPass("devops@cloud.com");
		
		PmResource resource31 = new PmResource();
		item3.addResource(resource31);
		
		resource31.setHostDomain("project1.devops.region");
		resource31.setHostModel("tiny");
		resource31.setHostName("uuid");
		resource31.setIpAddress("192.168.2.23");
		resource31.setMacAddress("02:79:60:0c:3e:16");
		resource31.setOsUser("zhangsan");
		resource31.setOsPass("devops@cloud.com");
		resource31.setRootPass("devops@cloud.com");
		
		PmResource resource32 = new PmResource();
		item3.addResource(resource32);
		
		resource32.setHostDomain("project1.devops.region");
		resource32.setHostModel("tiny");
		resource32.setHostName("uuid");
		resource32.setIpAddress("192.168.2.24");
		resource32.setMacAddress("02:79:60:0c:3e:17");
		resource32.setOsUser("zhangsan");
		resource32.setOsPass("devops@cloud.com");
		resource32.setRootPass("devops@cloud.com");
		
		ContainerResource resource41 = new ContainerResource();
		item4.addResource(resource41);
		
		resource41.setCgroup("default");
		resource41.setDescription("Kubernetes");
		resource41.setFlavor("4C16G");
		resource41.setNamespace("product-region-123456");
		resource41.setRegion("shanghai");
		
		json = JsonUtil.toJson(order, true);
		System.out.println(json);
		System.out.println("\n\n");
	}

}
