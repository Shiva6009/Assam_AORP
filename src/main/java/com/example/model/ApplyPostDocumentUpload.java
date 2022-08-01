package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ApplyPostDocumentUpload {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int slno;
	private String employeeid;
	private String postid;
	private String certificatetype;
	private String certificatename;
	private String issuedate;
	private String issueauthority;
	private String filelocation;
	
	
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
	public String getCertificatetype() {
		return certificatetype;
	}
	public void setCertificatetype(String certificatetype) {
		this.certificatetype = certificatetype;
	}
	public String getCertificatename() {
		return certificatename;
	}
	public void setCertificatename(String certificatename) {
		this.certificatename = certificatename;
	}
	public String getIssuedate() {
		return issuedate;
	}
	public void setIssuedate(String issuedate) {
		this.issuedate = issuedate;
	}
	public String getIssueauthority() {
		return issueauthority;
	}
	public void setIssueauthority(String issueauthority) {
		this.issueauthority = issueauthority;
	}
	public String getFilelocation() {
		return filelocation;
	}
	public void setFilelocation(String filelocation) {
		this.filelocation = filelocation;
	}
	
	
	
}
