package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.web.multipart.MultipartFile;


@Entity
public class ApplyPostWorkExperienceDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int slno;
	private String employeeid;
	private String postid;
	private String experiencetype;
	private String nameofemployer;
	private String naturofwork;
	private String postheld;
	private String startdata;
	private String enddate;
	private String iscurrentorganization;
	private String typeoforganization;
	private String documentupload;
	
	
	public String getExperiencetype() {
		return experiencetype;
	}
	public void setExperiencetype(String experiencetype) {
		this.experiencetype = experiencetype;
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
	public String getNameofemployer() {
		return nameofemployer;
	}
	public void setNameofemployer(String nameofemployer) {
		this.nameofemployer = nameofemployer;
	}
	public String getNaturofwork() {
		return naturofwork;
	}
	public void setNaturofwork(String naturofwork) {
		this.naturofwork = naturofwork;
	}
	public String getPostheld() {
		return postheld;
	}
	public void setPostheld(String postheld) {
		this.postheld = postheld;
	}
	public String getStartdata() {
		return startdata;
	}
	public void setStartdata(String startdata) {
		this.startdata = startdata;
	}
	public String getEnddate() {
		return enddate;
	}
	public void setEnddate(String enddate) {
		this.enddate = enddate;
	}
	public String getIscurrentorganization() {
		return iscurrentorganization;
	}
	public void setIscurrentorganization(String iscurrentorganization) {
		this.iscurrentorganization = iscurrentorganization;
	}
	public String getTypeoforganization() {
		return typeoforganization;
	}
	public void setTypeoforganization(String typeoforganization) {
		this.typeoforganization = typeoforganization;
	}
	public int getSlno() {
		return slno;
	}
	public void setSlno(int slno) {
		this.slno = slno;
	}
	public String getDocumentupload() {
		return documentupload;
	}
	public void setDocumentupload(String documentupload) {
		this.documentupload = documentupload;
	}
	
	
	
}
