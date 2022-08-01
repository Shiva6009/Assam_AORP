package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UserWorkExperienceDetails")
public class Workexperiences {
	
	
	public int getSlno() {
		return slno;
	}
	public void setSlno(int slno) {
		this.slno = slno;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int slno;
	private String employeeid;
	private String nameofemployer;
	private String postheld;
	private String enddate;
	private String iscurrentorganization;
	private String  typeoforganization;
	private String naturofwork;
	private String startdata;
	
	public String getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}
	public String getNameofemployer() {
		return nameofemployer;
	}
	public void setNameofemployer(String nameofemployer) {
		this.nameofemployer = nameofemployer;
	}
	public String getPostheld() {
		return postheld;
	}
	public void setPostheld(String postheld) {
		this.postheld = postheld;
	}
	public String getNaturofwork() {
		return naturofwork;
	}
	public void setNaturofwork(String naturofwork) {
		this.naturofwork = naturofwork;
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

}
