package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserRegistrationDataSpecialCategory {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int slno;
	private int employeeid;
	private int specialcategoryid;
	
	
	public int getSlno() {
		return slno;
	}
	public void setSlno(int slno) {
		this.slno = slno;
	}
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public int getSpecialcategoryid() {
		return specialcategoryid;
	}
	public void setSpecialcategoryid(int specialcategoryid) {
		this.specialcategoryid = specialcategoryid;
	}
	
}
