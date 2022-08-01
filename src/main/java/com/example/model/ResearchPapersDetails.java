package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "UserEducationalResearchPaperDetails")
public class ResearchPapersDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int slno;
	private int employeeid;
	private String publicationtype;
	private String titleofpaper;
	private String journalname;
	private String issn;
	private String author;
	private String year;
	
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
	public String getPublicationtype() {
		return publicationtype;
	}
	public void setPublicationtype(String publicationtype) {
		this.publicationtype = publicationtype;
	}
	public String getTitleofpaper() {
		return titleofpaper;
	}
	public void setTitleofpaper(String titleofpaper) {
		this.titleofpaper = titleofpaper;
	}
	public String getJournalname() {
		return journalname;
	}
	public void setJournalname(String journalname) {
		this.journalname = journalname;
	}
	public String getIssn() {
		return issn;
	}
	public void setIssn(String issn) {
		this.issn = issn;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
}
