/*******************************************************************************
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on Nov 28, 2016 4:17:41 PM
 *******************************************************************************/

package com.primeton.devops.cd.cs.test;

import com.primeton.devops.cd.cs.JsonUtil;
import com.primeton.devops.cd.cs.ServiceOrder;

/**
 * SerializeTestCase.
 *
 * @author ZhongWen Li (mailto:lizw@primeton.com)
 */
public class SerializeTestCase extends AbstractTestCase {

	/* (non-Javadoc)
	 * @see com.primeton.devops.cd.cs.test.AbstractTestCase#test()
	 */
	@Override
	public void test() throws Exception {
		String json1 = getResourceAsString("classpath:/order-request.json");
		String json2 = getResourceAsString("classpath:/order-response.json");
		
		System.err.println(json1);
		System.err.println("\n");
		System.err.println(json2);
		
		ServiceOrder order1 = JsonUtil.toObject(json1, ServiceOrder.class);
		ServiceOrder order2 = JsonUtil.toObject(json2, ServiceOrder.class);
		
		System.out.println(order1);
		System.out.println(order2);
	}

}
