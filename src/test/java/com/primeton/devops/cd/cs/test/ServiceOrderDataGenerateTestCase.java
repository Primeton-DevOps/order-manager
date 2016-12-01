/*******************************************************************************
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on Nov 28, 2016 11:23:58 AM
 *******************************************************************************/

package com.primeton.devops.cd.cs.test;

import org.junit.Test;

import com.primeton.devops.cd.cs.ContainerResource;
import com.primeton.devops.cd.cs.CsType;
import com.primeton.devops.cd.cs.JsonUtil;
import com.primeton.devops.cd.cs.OrderItem;
import com.primeton.devops.cd.cs.PmResource;
import com.primeton.devops.cd.cs.ServiceOrder;

/**
 * ServiceOrderTestCase.
 *
 * @author ZhongWen Li (mailto:lizw@primeton.com)
 */
public class ServiceOrderDataGenerateTestCase extends AbstractTestCase {

	/* (non-Javadoc)
	 * @see com.primeton.devops.cd.cs.test.AbstractTestCase#test()
	 */
	@Override
	public void test() throws Exception {
		// Auto-generated method stub
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	public void test1() throws Exception {
		// 服务订单
		ServiceOrder order = new ServiceOrder();
		order.setStatus(ServiceOrder.STATUS_SUBMIT);
		
		// 订单项 - 虚拟机
		OrderItem item1 = new OrderItem();
		order.addItem(item1);
		
		// 设置服务类型
		item1.setResourceType(CsType.PM.name());
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
		
		item2.setResourceType(CsType.PM.name());
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
		
		String json = JsonUtil.toJson(order, true);
		System.err.println(json);
		System.err.println("\n\n");
		
		//
		// 审批之后
		//
		
		order.setStatus(ServiceOrder.STATUS_OPEND);
		
		PmResource resource11 = new PmResource();
		item1.addResource(resource11);
		
		resource11.setHostDomain("domain11");
		resource11.setHostModel("tiny");
		resource11.setHostName("uuid");
		resource11.setIpAddress("192.168.2.11");
		resource11.setMacAddress("02:79:60:0c:3e:11");
		resource11.setOsName("CentOS-7.2-x86_64");
		resource11.setOsUser("zhangsan");
		resource11.setOsPass("devops@cloud.com");
		resource11.setRootPass("devops@cloud.com");
		
		PmResource resource12 = new PmResource();
		item1.addResource(resource12);
		
		resource12.setHostDomain("domain12");
		resource12.setHostModel("tiny");
		resource12.setHostName("uuid");
		resource12.setIpAddress("192.168.2.12");
		resource12.setMacAddress("02:79:60:0c:3e:12");
		resource12.setOsName("CentOS-7.2-x86_64");
		resource12.setOsUser("zhangsan");
		resource12.setOsPass("devops@cloud.com");
		resource12.setRootPass("devops@cloud.com");
		
		//

		PmResource resource21 = new PmResource();
		item2.addResource(resource21);
		
		resource21.setHostDomain("domain21");
		resource21.setHostModel("normal");
		resource21.setHostName("uuid");
		resource21.setIpAddress("192.168.44.21");
		resource21.setMacAddress("02:79:60:0c:4e:21");
		resource21.setOsName("Ubuntu-16.04-x86_64");
		resource21.setOsUser("zhangsan");
		resource21.setOsPass("devops@cloud.com");
		resource21.setRootPass("devops@cloud.com");
		
		PmResource resource22 = new PmResource();
		item2.addResource(resource22);
		
		resource22.setHostDomain("domain22");
		resource22.setHostModel("normal");
		resource22.setHostName("uuid");
		resource22.setIpAddress("192.168.44.22");
		resource22.setMacAddress("02:79:60:0c:4e:22");
		resource22.setOsName("Ubuntu-16.04-x86_64");
		resource22.setOsUser("zhangsan");
		resource22.setOsPass("devops@cloud.com");
		resource22.setRootPass("devops@cloud.com");
		
		json = JsonUtil.toJson(order, true);
		System.out.println(json);
		System.out.println("\n\n");
		
		System.err.println(JsonUtil.toJson(order));
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	public void test2() throws Exception {
		// 服务订单
		ServiceOrder order = new ServiceOrder();
		order.setStatus(ServiceOrder.STATUS_SUBMIT);
		
		// 订单项 - 虚拟机
		OrderItem item1 = new OrderItem();
		order.addItem(item1);
		
		// 设置服务类型
		item1.setResourceType(CsType.VM.name());
		// 设置资源数量(虚拟机数量)
		item1.setResourceSize(2);
		// 添加资源描述(OS, Flavor, etc)
		item1.addAttribute("osname", "CoreOS-Latest-x86_64"); //$NON-NLS-1$ //$NON-NLS-2$
		item1.addAttribute("model", "tiny"); //$NON-NLS-1$ //$NON-NLS-2$
		item1.addAttribute("storage", "100GB"); //$NON-NLS-1$ //$NON-NLS-2$
		item1.addAttribute("osuser", "zhangsan"); //$NON-NLS-1$ //$NON-NLS-2$
		item1.addAttribute("ospass", "devops@cloud.com"); //$NON-NLS-1$ //$NON-NLS-2$
		item1.addAttribute("description", "VM, 紧急！紧急！紧急！！！重要的事说三遍！！！"); //$NON-NLS-1$ //$NON-NLS-2$
		item1.addAttribute("nettype", "flat", true); //$NON-NLS-1$ //$NON-NLS-2$
		item1.addAttribute("cgroup", "default", true); //$NON-NLS-1$ //$NON-NLS-2$
		item1.addAttribute("subnet", "11.11.11.255", true); //$NON-NLS-1$ //$NON-NLS-2$
		item1.addAttribute("region", "shanghai", true); //$NON-NLS-1$ //$NON-NLS-2$
		
		//
		
		OrderItem item2 = new OrderItem();
		order.addItem(item2);
		
		item2.setResourceType(CsType.PM.name());
		item2.setResourceSize(2);
		
		item2.addAttribute("osname", "SUSE-12G-SP2-x86_64"); //$NON-NLS-1$ //$NON-NLS-2$
		item2.addAttribute("model", "normal"); //$NON-NLS-1$ //$NON-NLS-2$
		item2.addAttribute("storage", "200GB"); //$NON-NLS-1$ //$NON-NLS-2$
		item2.addAttribute("osuser", "lisi"); //$NON-NLS-1$ //$NON-NLS-2$
		item2.addAttribute("ospass", "devops@cloud.com"); //$NON-NLS-1$ //$NON-NLS-2$
		item2.addAttribute("description", "希望申请到新部署的云主机OpenStack！！！"); //$NON-NLS-1$ //$NON-NLS-2$
		item2.addAttribute("nettype", "flat", true); //$NON-NLS-1$ //$NON-NLS-2$
		item2.addAttribute("cgroup", "default", true); //$NON-NLS-1$ //$NON-NLS-2$
		item2.addAttribute("subnet", "11.11.11.255", true); //$NON-NLS-1$ //$NON-NLS-2$
		item2.addAttribute("region", "shanghai", true); //$NON-NLS-1$ //$NON-NLS-2$
		
		String json = JsonUtil.toJson(order, true);
		System.err.println(json);
		System.err.println("\n\n");
		
		//
		// 审批之后
		//
		
		order.setStatus(ServiceOrder.STATUS_OPEND);
		
		PmResource resource11 = new PmResource();
		item1.addResource(resource11);
		
		resource11.setHostDomain("domain11");
		resource11.setHostModel("tiny");
		resource11.setHostName("uuid");
		resource11.setIpAddress("192.168.2.11");
		resource11.setMacAddress("02:79:60:0c:3e:11");
		resource11.setOsName("CoreOS-Latest-x86_64");
		resource11.setOsUser("zhangsan");
		resource11.setOsPass("devops@cloud.com");
		resource11.setRootPass("devops@cloud.com");
		
		PmResource resource12 = new PmResource();
		item1.addResource(resource12);
		
		resource12.setHostDomain("domain12");
		resource12.setHostModel("tiny");
		resource12.setHostName("uuid");
		resource12.setIpAddress("192.168.2.12");
		resource12.setMacAddress("02:79:60:0c:3e:12");
		resource12.setOsName("CoreOS-Latest-x86_64");
		resource12.setOsUser("zhangsan");
		resource12.setOsPass("devops@cloud.com");
		resource12.setRootPass("devops@cloud.com");
		
		//

		PmResource resource21 = new PmResource();
		item2.addResource(resource21);
		
		resource21.setHostDomain("domain21");
		resource21.setHostModel("normal");
		resource21.setHostName("uuid");
		resource21.setIpAddress("192.168.44.21");
		resource21.setMacAddress("02:79:60:0c:4e:21");
		resource21.setOsName("SUSE-12G-SP2-x86_64");
		resource21.setOsUser("zhangsan");
		resource21.setOsPass("devops@cloud.com");
		resource21.setRootPass("devops@cloud.com");
		
		PmResource resource22 = new PmResource();
		item2.addResource(resource22);
		
		resource22.setHostDomain("domain22");
		resource22.setHostModel("normal");
		resource22.setHostName("uuid");
		resource22.setIpAddress("192.168.44.22");
		resource22.setMacAddress("02:79:60:0c:4e:22");
		resource22.setOsName("SUSE-12G-SP2-x86_64");
		resource22.setOsUser("zhangsan");
		resource22.setOsPass("devops@cloud.com");
		resource22.setRootPass("devops@cloud.com");
		
		json = JsonUtil.toJson(order, true);
		System.out.println(json);
		System.out.println("\n\n");
		
		System.err.println(JsonUtil.toJson(order));
	}
	
	/**
	 * 
	 * @throws Exception
	 */
	@Test
	public void test3() throws Exception {
		// 服务订单
		ServiceOrder order = new ServiceOrder();
		order.setStatus(ServiceOrder.STATUS_SUBMIT);
		
		OrderItem item1 = new OrderItem();
		order.addItem(item1);
		
		item1.setResourceSize(1);
		item1.setResourceType(CsType.CONTAINER.name());
		
		item1.addAttribute("namespace", "product-region-123456"); //$NON-NLS-1$ //$NON-NLS-2$
		item1.addAttribute("flavor", "4C16G"); //$NON-NLS-1$ //$NON-NLS-2$
		item1.addAttribute("description", "OpenShift ..."); //$NON-NLS-1$ //$NON-NLS-2$
		item1.addAttribute("region", "beijing", true); //$NON-NLS-1$ //$NON-NLS-2$
		item1.addAttribute("cgroup", "default", true); //$NON-NLS-1$ //$NON-NLS-2$
		
		String json = JsonUtil.toJson(order, true);
		System.err.println(json);
		System.err.println("\n\n");
		
		//
		// 审批之后
		//
		
		order.setStatus(ServiceOrder.STATUS_OPEND);
		
		ContainerResource resource11 = new ContainerResource();
		item1.addResource(resource11);
		
		resource11.setCgroup("default");
		resource11.setDescription("Kubernetes");
		resource11.setFlavor("4C16G");
		resource11.setNamespace("product-region-123456");
		resource11.setRegion("shanghai");
		
		json = JsonUtil.toJson(order, true);
		System.out.println(json);
		System.out.println("\n\n");
		
		System.err.println(JsonUtil.toJson(order));
	}

}
