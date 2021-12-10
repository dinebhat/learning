package com.dfte.oracle.dto;

import java.io.Serializable;

/**
 * @author dinebhat
 *
 */
public class SodActivityMapping implements Serializable {

	private static final long serialVersionUID = 1L;

	private String activityName;

	private String bpCycle;

	private String securityObjectGroupName;

	private String securityObjectTechnicalName;

	private String securityObjectDisplayName;

	private String displayInTheReport;

	private String securityObjectType;

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getBpCycle() {
		return bpCycle;
	}

	public void setBpCycle(String bpCycle) {
		this.bpCycle = bpCycle;
	}

	public String getSecurityObjectGroupName() {
		return securityObjectGroupName;
	}

	public void setSecurityObjectGroupName(String securityObjectGroupName) {
		this.securityObjectGroupName = securityObjectGroupName;
	}

	public String getSecurityObjectTechnicalName() {
		return securityObjectTechnicalName;
	}

	public void setSecurityObjectTechnicalName(String securityObjectTechnicalName) {
		this.securityObjectTechnicalName = securityObjectTechnicalName;
	}

	public String getSecurityObjectDisplayName() {
		return securityObjectDisplayName;
	}

	public void setSecurityObjectDisplayName(String securityObjectDisplayName) {
		this.securityObjectDisplayName = securityObjectDisplayName;
	}

	public String getDisplayInTheReport() {
		return displayInTheReport;
	}

	public void setDisplayInTheReport(String displayInTheReport) {
		this.displayInTheReport = displayInTheReport;
	}

	public String getSecurityObjectType() {
		return securityObjectType;
	}

	public void setSecurityObjectType(String securityObjectType) {
		this.securityObjectType = securityObjectType;
	}

	@Override
	public String toString() {
		return "SodActivityMapping [activityName=" + activityName + ", bpCycle=" + bpCycle
				+ ", securityObjectGroupName=" + securityObjectGroupName + ", securityObjectTechnicalName="
				+ securityObjectTechnicalName + ", securityObjectDisplayName=" + securityObjectDisplayName
				+ ", displayInTheReport=" + displayInTheReport + ", securityObjectType=" + securityObjectType + "]";
	}

}
