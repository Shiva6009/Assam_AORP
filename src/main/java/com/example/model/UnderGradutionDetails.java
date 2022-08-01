package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "UserEducationalUndergraduationDetails")
public class UnderGradutionDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int slno;
	private int employeeid;
	private String examination;
	private String mainsubjects;
	private String duration;
	private String yearofpassing;
	private String nameofschool;	
	private String nameofboard;
	private String markscgpa;
	private String marks;
	
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
	
	public String getExamination() {
		return examination;
	}
	public void setExamination(String examination) {
		this.examination = examination;
	}
	public String getMainsubjects() {
		return mainsubjects;
	}
	public void setMainsubjects(String mainsubjects) {
		this.mainsubjects = mainsubjects;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getYearofpassing() {
		return yearofpassing;
	}
	public void setYearofpassing(String yearofpassing) {
		this.yearofpassing = yearofpassing;
	}
	public String getNameofschool() {
		return nameofschool;
	}
	public void setNameofschool(String nameofschool) {
		this.nameofschool = nameofschool;
	}
	public String getNameofboard() {
		return nameofboard;
	}
	public void setNameofboard(String nameofboard) {
		this.nameofboard = nameofboard;
	}
	public String getMarkscgpa() {
		return markscgpa;
	}
	public void setMarkscgpa(String markscgpa) {
		this.markscgpa = markscgpa;
	}
	public String getMarks() {
		return marks;
	}
	public void setMarks(String marks) {
		this.marks = marks;
	}
}
