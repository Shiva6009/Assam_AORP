package com.example.model;

import org.springframework.web.multipart.MultipartFile;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

public class workexp {
	
	private String employeeid;
	private  String documentupload;
	
	
	public String getEmployeeid() {
		return employeeid;
	}
	public void setEmployeeid(String employeeid) {
		this.employeeid = employeeid;
	}
	public String getDocumentupload() {
		return documentupload;
	}
	public void setDocumentupload(String documentupload) {
		this.documentupload = documentupload;
	}
	

	
	
	

}
