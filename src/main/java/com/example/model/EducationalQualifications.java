package com.example.model;

import com.example.*;

public class EducationalQualifications {

	
	private String employeeid;
	public String getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}
	private Schoolingdetails[] schoolingdetails;
    private UnderGradutionDetails[] undergraduationdetails;
    private PostGraduationDetails[] postgraduation;
	private OtherQualificationDetails[] otherqualification;
	private ResearchPapersDetails[] researchpapers;
    
    
	public Schoolingdetails[] getSchoolingdetails() {
		return schoolingdetails;
	}
	public void setSchoolingdetails(Schoolingdetails[] schoolingdetails) {
		this.schoolingdetails = schoolingdetails;
	}
	public UnderGradutionDetails[] getUndergraduationdetails() {
		return undergraduationdetails;
	}
	public void setUndergraduationdetails(UnderGradutionDetails[] undergraduationdetails) {
		this.undergraduationdetails = undergraduationdetails;
	}
	public PostGraduationDetails[] getPostgraduation() {
		return postgraduation;
	}
	public void setPostgraduation(PostGraduationDetails[] postgraduation) {
		this.postgraduation = postgraduation;
	}
	public OtherQualificationDetails[] getOtherqualification() {
		return otherqualification;
	}
	public void setOtherqualification(OtherQualificationDetails[] otherqualification) {
		this.otherqualification = otherqualification;
	}
	public ResearchPapersDetails[] getResearchpapers() {
		return researchpapers;
	}
	public void setResearchpapers(ResearchPapersDetails[] researchpapers) {
		this.researchpapers = researchpapers;
	}


	
}
