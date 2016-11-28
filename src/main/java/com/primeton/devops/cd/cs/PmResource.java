/*******************************************************************************
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on Nov 28, 2016 10:31:18 AM
 *******************************************************************************/

package com.primeton.devops.cd.cs;

/**
 * PmResource.
 *
 * @author ZhongWen Li (mailto:lizw@primeton.com)
 */
public class PmResource extends CsResource {

	/**
	 * <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -8835401640785472678L;

	public static final String IP_ADDRESS = "ipAddress";
	public static final String MAC_ADDRESS = "macAddress";
	public static final String HOST_NAME = "hostName";
	public static final String HOST_DOMAIN = "hostDomain";
	public static final String HOST_MODEL = "hostModel";
	public static final String OS_USER = "osUser";
	public static final String OS_PASS = "osPass";
	public static final String ROOT_PASS = "rootPass";
	
	/**
	 * @param type
	 */
	public PmResource() {
		super(ServiceType.PM.name());
	}

	/**
	 * 
	 * @return
	 */
	public String getIpAddress() {
		return getStringValue(IP_ADDRESS);
	}
	
	/**
	 * 
	 * @param ipAddress
	 */
	public void setIpAddress(String ipAddress) {
		setValue(IP_ADDRESS, ipAddress);
	}
	
	/**
	 * 
	 * @return
	 */
	public String getMacAddress() {
		return getStringValue(MAC_ADDRESS);
	}
	
	/**
	 * 
	 * @param macAddress
	 */
	public void setMacAddress(String macAddress) {
		setValue(MAC_ADDRESS, macAddress);
	}
	
	/**
	 * 
	 * @return
	 */
	public String getHostName() {
		return getStringValue(HOST_NAME);
	}
	
	/**
	 * 
	 * @param hostName
	 */
	public void setHostName(String hostName) {
		setValue(HOST_NAME, hostName);
	}
	
	/**
	 * 
	 * @return
	 */
	public String getHostDomain() {
		return getStringValue(HOST_DOMAIN);
	}
	
	/**
	 * 
	 * @param hostDomain
	 */
	public void setHostDomain(String hostDomain) {
		setValue(HOST_DOMAIN, hostDomain);
	}
	
	/**
	 * 
	 * @return
	 */
	public String getHostModel() {
		return getStringValue(HOST_MODEL);
	}
	
	/**
	 * 
	 * @param hostModel
	 */
	public void setHostModel(String hostModel) {
		setValue(HOST_MODEL, hostModel);
	}
	
	/**
	 * 
	 * @return
	 */
	public String getOsUser() {
		return getStringValue(OS_USER);
	}
	
	/**
	 * 
	 * @param user
	 */
	public void setOsUser(String user) {
		setValue(OS_USER, user);
	}
	
	/**
	 * 
	 * @return
	 */
	public String getOsPass() {
		return getStringValue(OS_PASS);
	}
	
	/**
	 * 
	 * @param pass
	 */
	public void setOsPass(String pass) {
		setValue(OS_PASS, pass);
	}
	
	/**
	 * 
	 * @return
	 */
	public String getRootPass() {
		return getStringValue(ROOT_PASS);
	}
	
	/**
	 * 
	 * @param pass
	 */
	public void setRootPass(String pass) {
		setValue(ROOT_PASS, pass);
	}
	
}
