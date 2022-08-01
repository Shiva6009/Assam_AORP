package com.example.model;

public class ProfileData {
	
	private UserRegistrationDataInput personaldetails;
	private EducationalQualifications educationalqualifications;
	private WorkExperience profileworkexperience;
	private OTRdocuments otrdocuments;

	
	
	public UserRegistrationDataInput getPersonaldetails() {
		return personaldetails;
	}
	public void setPersonaldetails(UserRegistrationDataInput personaldetails) {
		this.personaldetails = personaldetails;
	}
	public EducationalQualifications getEducationalqualifications() {
		return educationalqualifications;
	}
	public void setEducationalqualifications(EducationalQualifications educationalqualifications) {
		this.educationalqualifications = educationalqualifications;
	}
	public WorkExperience getProfileworkexperience() {
		return profileworkexperience;
	}
	public void setProfileworkexperience(WorkExperience profileworkexperience) {
		this.profileworkexperience = profileworkexperience;
	}
	public OTRdocuments getOtrdocuments() {
		return otrdocuments;
	}
	public void setOtrdocuments(OTRdocuments otrdocuments) {
		this.otrdocuments = otrdocuments;
	}
	
	
}
