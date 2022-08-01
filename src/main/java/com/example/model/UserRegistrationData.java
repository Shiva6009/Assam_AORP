package com.example.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnTransformer;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Entity
@Table(name = "UserBasicsDetails")
public class UserRegistrationData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int employeeid;
	private String full_name;
	private String fathers_name;
	private String mothers_name;
	private String gender;
	private String d_o_b;

	@Column(unique = true)
	private String mobile;
	private String alternative_Mobie_number;
	@Column(unique = true)
	private String email;

	private String nationality;

	private String permanent_resident_of_assam;

	private String caste;

	private int special_category;

	private String degree_of_dis;

	private String permanent_address;

	private String country;

	public int getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(int employeeid) {
		this.employeeid = employeeid;
	}

	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAlternative_Mobie_number() {
		return alternative_Mobie_number;
	}

	public void setAlternative_Mobie_number(String alternative_Mobie_number) {
		this.alternative_Mobie_number = alternative_Mobie_number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
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


	public int getSpecial_category() {
		return special_category;
	}

	public void setSpecial_category(int special_category) {
		this.special_category = special_category;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public boolean isOtrfinished() {
		return otrfinished;
	}

	public void setOtrfinished(boolean otrfinished) {
		this.otrfinished = otrfinished;
	}

	private String state;

	private String district;

	private String pincode;

	private String password;

	private String photo;
	private String signature;

	private boolean otrfinished;

}
