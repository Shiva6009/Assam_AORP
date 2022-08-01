package com.example.model;

import org.springframework.web.multipart.MultipartFile;

public class TestClass {
	
	private String personaldetails;
	private String experiencedetails;
	private String  educationdetails;
	
	public MultipartFile getDocumentforsmallfamilnorms() {
		return documentforsmallfamilnorms;
	}
	public void setDocumentforsmallfamilnorms(MultipartFile documentforsmallfamilnorms) {
		this.documentforsmallfamilnorms = documentforsmallfamilnorms;
	}
	public MultipartFile getDocumentforuploaddocument() {
		return documentforuploaddocument;
	}
	public void setDocumentforuploaddocument(MultipartFile documentforuploaddocument) {
		this.documentforuploaddocument = documentforuploaddocument;
	}
	private MultipartFile documentforeducation;
	private MultipartFile documentforsmallfamilnorms;
	private MultipartFile documentforuploaddocument;
	private MultipartFile document;
	
	public MultipartFile getDocument() {
		return document;
	}
	public void setDocument(MultipartFile document) {
		this.document = document;
	}
	
	public String getPersonaldetails() {
		return personaldetails;
	}
	public void setPersonaldetails(String personaldetails) {
		this.personaldetails = personaldetails;
	}
	public String getExperiencedetails() {
		return experiencedetails;
	}
	public void setExperiencedetails(String experiencedetails) {
		this.experiencedetails = experiencedetails;
	}
	public String getEducationdetails() {
		return educationdetails;
	}
	public void setEducationdetails(String educationdetails) {
		this.educationdetails = educationdetails;
	}
	public MultipartFile getDocumentforeducation() {
		return documentforeducation;
	}
	public void setDocumentforeducation(MultipartFile documentforeducation) {
		this.documentforeducation = documentforeducation;
	}
	
}
