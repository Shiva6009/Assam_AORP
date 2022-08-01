package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class ApplyPostEducationalQualification {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int slno;
	
	private String employeeid;
	private String postid;
	private String degree;
	private String division;
	private String percentage;
	private String duration;
	private String yop;
	private String subject;
	private String nameofschool;
	private String nameofboard;
	private String documentupload;
	
	
	public int getSlno() {
		return slno;
	}
	public void setSlno(int slno) {
		this.slno = slno;
	}
	public String getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}
	public String getPostid() {
		return postid;
	}
	public void setPostid(String postid) {
		this.postid = postid;
	}
	public String getDegree() {
		return degree;
	}
	public void setDegree(String degree) {
		this.degree = degree;
	}
	public String getDivision() {
		return division;
	}
	public void setDivision(String division) {
		this.division = division;
	}
	public String getPercentage() {
		return percentage;
	}
	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getYop() {
		return yop;
	}
	public void setYop(String yop) {
		this.yop = yop;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getNameofschool() {
		return nameofschool;
	}
	public void setNameofschool(String nameofschool) {
		this.nameofschool = nameofschool;
	}
	public String getNameofboard() {
		return nameofboard;
	}
	public void setNameofboard(String nameofboard) {
		this.nameofboard = nameofboard;
	}
	public String getDocumentupload() {
		return documentupload;
	}
	public void setDocumentupload(String documentupload) {
		this.documentupload = documentupload;
	}	
	
}
