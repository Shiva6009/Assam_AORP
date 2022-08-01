package com.example.model;

public class ApplyPost {

	
	private int previouspayment;
	private String grnnumber;
	
	private ApplyPostUserData personaldetails;
	private ApplyPostWorkExperienceDetails[] workexperiences;
	private ApplyPostEducationalQualification[] educationqualification;
	private ApplyPostDynamicOptions[] dynamicoptionsarray;
	private ApplyPostDocumentUpload[] documentupload;
	
	public ApplyPostEducationalQualification[] getEducationqualification() {
		return educationqualification;
	}
	public void setEducationqualification(ApplyPostEducationalQualification[] educationqualification) {
		this.educationqualification = educationqualification;
	}
	public ApplyPostUserData getPersonaldetails() {
		return personaldetails;
	}
	public void setPersonaldetails(ApplyPostUserData personaldetails) {
		this.personaldetails = personaldetails;
	}
	public ApplyPostWorkExperienceDetails[] getWorkexperiences() {
		return workexperiences;
	}
	public void setWorkexperiences(ApplyPostWorkExperienceDetails[] workexperiences) {
		this.workexperiences = workexperiences;
	}
	public ApplyPostDocumentUpload[] getDocumentupload() {
		return documentupload;
	}
	public void setDocumentupload(ApplyPostDocumentUpload[] documentupload) {
		this.documentupload = documentupload;
	}
	public ApplyPostDynamicOptions[] getDynamicoptionsarray() {
		return dynamicoptionsarray;
	}
	public void setDynamicoptionsarray(ApplyPostDynamicOptions[] dynamicoptionsarray) {
		this.dynamicoptionsarray = dynamicoptionsarray;
	}
	
	
	
	public int getPreviouspayment() {
		return previouspayment;
	}
	public void setPreviouspayment(int previouspayment) {
		this.previouspayment = previouspayment;
	}
	
	
	public String getGrnnumber() {
		return grnnumber;
	}
	public void setGrnnumber(String grnnumber) {
		this.grnnumber = grnnumber;
	}		
}
