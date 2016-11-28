/*******************************************************************************
 *
 * Copyright (c) 2001-2016 Primeton Technologies, Ltd.
 * All rights reserved.
 * 
 * Created on Nov 28, 2016 10:31:46 AM
 *******************************************************************************/

package com.primeton.devops.cd.cs;

/**
 * ContainerResource.
 *
 * @author ZhongWen Li (mailto:lizw@primeton.com)
 */
public class ContainerResource extends CsResource {

	/**
	 * <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = -6080180482791173760L;
	
	public static final String NAME_SPACE = "namespace";
	public static final String FLAVOR = "flavor";
	public static final String DESCRIPTION = "description";
	public static final String REGION = "region";
	public static final String CGROUP = "cgroup";

	/**
	 * 
	 * @return
	 */
	public String getNamespace() {
		return getStringValue(NAME_SPACE);
	}
	
	/**
	 * 
	 * @param namespace
	 */
	public void setNamespace(String namespace) {
		setValue(NAME_SPACE, namespace);
	}
	
	/**
	 * 
	 * @return
	 */
	public String getFlavor() {
		return getStringValue(FLAVOR);
	}
	
	/**
	 * 
	 * @param flavor
	 */
	public void setFlavor(String flavor) {
		setValue(FLAVOR, flavor);
	}
	
	/**
	 * 
	 * @return
	 */
	public String getDescription() {
		return getStringValue(DESCRIPTION);
	}
	
	/**
	 * 
	 * @param description
	 */
	public void setDescription(String description) {
		setValue(DESCRIPTION, description);
	}
	
	/**
	 * 
	 * @return
	 */
	public String getRegion() {
		return getStringValue(REGION);
	}
	
	/**
	 * 
	 * @param region
	 */
	public void setRegion(String region) {
		setValue(REGION, region);
	}
	
	/**
	 * 
	 * @return
	 */
	public String getCgroup() {
		return getStringValue(CGROUP);
	}
	
	/**
	 * 
	 * @param cgroup
	 */
	public void setCgroup(String cgroup) {
		setValue(CGROUP, cgroup);
	}
	
}
