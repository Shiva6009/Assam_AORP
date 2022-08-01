package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ApplyPostUserData {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int slno;
	private String postid;
	private String postname;
	public String getPostname() {
		return postname;
	}
	public void setPostname(String postname) {
		this.postname = postname;
	}
	private String employeeid;
	private String examinationzone;
	private String presentaddress;
	private String age;
	private String country;
    private String state;
    private String district;
    private String pincode;
    private String scribe;
    private String typeofscribe;
    private String submitteddate;
    private String advtno;
    private String cardeposition;
    private String currentposition;
    

	public String getCardeposition() {
		return cardeposition;
	}
	public void setCardeposition(String cardeposition) {
		this.cardeposition = cardeposition;
	}
	public String getCurrentposition() {
		return currentposition;
	}
	public void setCurrentposition(String currentposition) {
		this.currentposition = currentposition;
	}
	public String getAdvtno() {
		return advtno;
	}
	public void setAdvtno(String advtno) {
		this.advtno = advtno;
	}
	public String getSubmitteddate() {
		return submitteddate;
	}
	public void setSubmitteddate(String submitteddate) {
		this.submitteddate = submitteddate;
	}
	public String getScribe() {
		return scribe;
	}
	public void setScribe(String scribe) {
		this.scribe = scribe;
	}
	public String getTypeofscribe() {
		return typeofscribe;
	}
	public void setTypeofscribe(String typeofscribe) {
		this.typeofscribe = typeofscribe;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public int getSlno() {
		return slno;
	}
	public void setSlno(int slno) {
		this.slno = slno;
	}
	public String getPostid() {
		return postid;
	}
	public void setPostid(String postid) {
		this.postid = postid;
	}
	public String getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}
	public String getExaminationzone() {
		return examinationzone;
	}
	public void setExaminationzone(String examinationzone) {
		this.examinationzone = examinationzone;
	}
	public String getPresentaddress() {
		return presentaddress;
	}
	public void setPresentaddress(String presentaddress) {
		this.presentaddress = presentaddress;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
      
}
