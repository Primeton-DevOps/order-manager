/*******************************************************************************
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on Nov 16, 2016 8:21:53 PM
 *******************************************************************************/

package com.primeton.devops.cd.cs.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * AbstractTestCase.
 *
 * @author ZhongWen Li (mailto:lizw@primeton.com)
 */
public abstract class AbstractTestCase {
	
	protected static final String PATH_PREFIX = "classpath:"; //$NON-NLS-1$

	@Before
	public void init() {
	}
	
	@Test
	public abstract void test() throws Exception;

	@After
	public void clean() {
	}
	
	/**
	 * 
	 * @param filePath
	 * @return
	 * @throws FileNotFoundException
	 */
	protected InputStream getResourceAsStream(String filePath) throws FileNotFoundException {
		if (StringUtils.isBlank(filePath)) {
			return null;
		}
		if (filePath.startsWith(PATH_PREFIX) && filePath.length() > PATH_PREFIX.length()) {
			filePath = filePath.substring(PATH_PREFIX.length());
			return AbstractTestCase.class.getResourceAsStream(filePath);
		} else {
			return new FileInputStream(filePath);
		}
	}
	
	/**
	 * 
	 * @param filePath
	 * @param encoding
	 * @return
	 * @throws FileNotFoundException
	 */
	protected String getResourceAsString(String filePath, String encoding) throws FileNotFoundException {
		InputStream in = getResourceAsStream(filePath);
		if (null == in) {
			return null;
		}
		try {
			return IOUtils.toString(in, Charset.forName(null == encoding || encoding.trim().isEmpty() ? "utf-8" : encoding)); //$NON-NLS-1$
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			IOUtils.closeQuietly(in);
		}
		return null;
	}
	
	/**
	 * 
	 * @param filePath
	 * @return
	 * @throws FileNotFoundException
	 */
	protected String getResourceAsString(String filePath) throws FileNotFoundException {
		return getResourceAsString(filePath, null);
	}

}
