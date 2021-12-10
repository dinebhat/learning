package com.dfte.oracle.dto;

import java.io.Serializable;

/**
 * @author dinebhat
 *
 */
public class SodRules implements Serializable {

	private static final long serialVersionUID = 1L;
	private String ruleName;
	private String priority;
	private String description;
	private String impact;
	private String approvedBy;
	private String activityName;

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImpact() {
		return impact;
	}

	public void setImpact(String impact) {
		this.impact = impact;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	@Override
	public String toString() {
		return "SodRules [ruleName=" + ruleName + ", priority=" + priority + ", description=" + description
				+ ", impact=" + impact + ", approvedBy=" + approvedBy + ", activityName=" + activityName + "]";
	}

}
