package com.example.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class UpdatePersonalDetailsModel {
	private int employeeid;
	private String fathers_name;
	private String mothers_name;
	private String gender;
	private String d_o_b;
	private String alternative_Mobie_number;
	private String permanent_resident_of_assam;
	private String caste;
	private String special_category;
	private String[] special_category_sub_category;
	private String degree_of_dis;
	private String permanent_address;
	private String state;
	private String district;
	private String pincode;
	public int getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}
	public String getFathers_name() {
		return fathers_name;
	}
	public void setFathers_name(String fathers_name) {
		this.fathers_name = fathers_name;
	}
	public String getMothers_name() {
		return mothers_name;
	}
	public void setMothers_name(String mothers_name) {
		this.mothers_name = mothers_name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getD_o_b() {
		return d_o_b;
	}
	public void setD_o_b(String d_o_b) {
		this.d_o_b = d_o_b;
	}
	public String getAlternative_Mobie_number() {
		return alternative_Mobie_number;
	}
	public void setAlternative_Mobie_number(String alternative_Mobie_number) {
		this.alternative_Mobie_number = alternative_Mobie_number;
	}
	public String getPermanent_resident_of_assam() {
		return permanent_resident_of_assam;
	}
	public void setPermanent_resident_of_assam(String permanent_resident_of_assam) {
		this.permanent_resident_of_assam = permanent_resident_of_assam;
	}
	public String getCaste() {
		return caste;
	}
	public void setCaste(String caste) {
		this.caste = caste;
	}
	public String getSpecial_category() {
		return special_category;
	}
	public void setSpecial_category(String special_category) {
		this.special_category = special_category;
	}
	public String[] getSpecial_category_sub_category() {
		return special_category_sub_category;
	}
	public void setSpecial_category_sub_category(String[] special_category_sub_category) {
		this.special_category_sub_category = special_category_sub_category;
	}
	public String getDegree_of_dis() {
		return degree_of_dis;
	}
	public void setDegree_of_dis(String degree_of_dis) {
		this.degree_of_dis = degree_of_dis;
	}
	public String getPermanent_address() {
		return permanent_address;
	}
	public void setPermanent_address(String permanent_address) {
		this.permanent_address = permanent_address;
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
