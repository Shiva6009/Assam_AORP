package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class OldPaymentDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int slno;
	
	private int employeeid;
	private int postid;
	private int booleanforoldpayment;
	private String oldGRNnumber;
	
	
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
	public int getPostid() {
		return postid;
	}
	public void setPostid(int postid) {
		this.postid = postid;
	}
	public int getBooleanforoldpayment() {
		return booleanforoldpayment;
	}
	public void setBooleanforoldpayment(int booleanforoldpayment) {
		this.booleanforoldpayment = booleanforoldpayment;
	}
	public String getOldGRNnumber() {
		return oldGRNnumber;
	}
	public void setOldGRNnumber(String oldGRNnumber) {
		this.oldGRNnumber = oldGRNnumber;
	}
	
	

}
