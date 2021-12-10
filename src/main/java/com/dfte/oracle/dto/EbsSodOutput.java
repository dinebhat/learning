package com.dfte.oracle.dto;

import java.io.Serializable;

/**
 * @author dinebhat
 *
 */
public class EbsSodOutput implements Serializable {

	private static final long serialVersionUID = 1L;
	private String objectName;
	private String objectType;
	private String ruleName;
	private String activity;
	private String userFunctionName;
	private String technicalFunctionName;
	private String navigationPath;
	private String responsibilityName;
	private String sodObjectType;
	private String fieldAddress;
	private String rulePriority;
	private String ruleDescription;
	private String ruleImpact;

	public String getObjectName() {
		return objectName;
	}

	public void setObjectName(String objectName) {
		this.objectName = objectName;
	}

	public String getObjectType() {
		return objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public String getRuleName() {
		return ruleName;
	}

	public void setRuleName(String ruleName) {
		this.ruleName = ruleName;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getUserFunctionName() {
		return userFunctionName;
	}

	public void setUserFunctionName(String userFunctionName) {
		this.userFunctionName = userFunctionName;
	}

	public String getTechnicalFunctionName() {
		return technicalFunctionName;
	}

	public void setTechnicalFunctionName(String technicalFunctionName) {
		this.technicalFunctionName = technicalFunctionName;
	}

	public String getNavigationPath() {
		return navigationPath;
	}

	public void setNavigationPath(String navigationPath) {
		this.navigationPath = navigationPath;
	}

	public String getResponsibilityName() {
		return responsibilityName;
	}

	public void setResponsibilityName(String responsibilityName) {
		this.responsibilityName = responsibilityName;
	}

	public String getSodObjectType() {
		return sodObjectType;
	}

	public void setSodObjectType(String sodObjectType) {
		this.sodObjectType = sodObjectType;
	}

	public String getFieldAddress() {
		return fieldAddress;
	}

	public void setFieldAddress(String fieldAddress) {
		this.fieldAddress = fieldAddress;
	}

	public String getRulePriority() {
		return rulePriority;
	}

	public void setRulePriority(String rulePriority) {
		this.rulePriority = rulePriority;
	}

	public String getRuleDescription() {
		return ruleDescription;
	}

	public void setRuleDescription(String ruleDescription) {
		this.ruleDescription = ruleDescription;
	}

	public String getRuleImpact() {
		return ruleImpact;
	}

	public void setRuleImpact(String ruleImpact) {
		this.ruleImpact = ruleImpact;
	}

	@Override
	public String toString() {
		return "EbsSodOutput [objectName=" + objectName + ", objectType=" + objectType + ", ruleName=" + ruleName
				+ ", activity=" + activity + ", userFunctionName=" + userFunctionName + ", technicalFunctionName="
				+ technicalFunctionName + ", navigationPath=" + navigationPath + ", responsibilityName="
				+ responsibilityName + ", sodObjectType=" + sodObjectType + ", fieldAddress=" + fieldAddress
				+ ", rulePriority=" + rulePriority + ", ruleDescription=" + ruleDescription + ", ruleImpact="
				+ ruleImpact + "]";
	}

}
