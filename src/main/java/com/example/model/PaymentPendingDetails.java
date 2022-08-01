package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PaymentPendingDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int slno;
	
	String postid;
	String employeeid;
	String DEPARTMENT_ID;
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
	String GRN;
	String AMOUNT;
	String BANKCODE;
	String BANKCIN;
	String PRN;
	String TRANSCOMPLETIONDATETIME;
	String STATUS;
	String PARTYNAME;	
	String TAXID;
	String BANKNAME;
	String ENTRY_DATE;
	public String getDEPARTMENT_ID() {
		return DEPARTMENT_ID;
	}
	public void setDEPARTMENT_ID(String dEPARTMENT_ID) {
		DEPARTMENT_ID = dEPARTMENT_ID;
	}
	public String getGRN() {
		return GRN;
	}
	public void setGRN(String gRN) {
		GRN = gRN;
	}
	public String getAMOUNT() {
		return AMOUNT;
	}
	public void setAMOUNT(String aMOUNT) {
		AMOUNT = aMOUNT;
	}
	public String getBANKCODE() {
		return BANKCODE;
	}
	public void setBANKCODE(String bANKCODE) {
		BANKCODE = bANKCODE;
	}
	public String getBANKCIN() {
		return BANKCIN;
	}
	public void setBANKCIN(String bANKCIN) {
		BANKCIN = bANKCIN;
	}
	public String getPRN() {
		return PRN;
	}
	public void setPRN(String pRN) {
		PRN = pRN;
	}
	public String getTRANSCOMPLETIONDATETIME() {
		return TRANSCOMPLETIONDATETIME;
	}
	public void setTRANSCOMPLETIONDATETIME(String tRANSCOMPLETIONDATETIME) {
		TRANSCOMPLETIONDATETIME = tRANSCOMPLETIONDATETIME;
	}
	public String getSTATUS() {
		return STATUS;
	}
	public void setSTATUS(String sTATUS) {
		STATUS = sTATUS;
	}
	public String getPARTYNAME() {
		return PARTYNAME;
	}
	public void setPARTYNAME(String pARTYNAME) {
		PARTYNAME = pARTYNAME;
	}
	public String getTAXID() {
		return TAXID;
	}
	public void setTAXID(String tAXID) {
		TAXID = tAXID;
	}
	public String getBANKNAME() {
		return BANKNAME;
	}
	public void setBANKNAME(String bANKNAME) {
		BANKNAME = bANKNAME;
	}
	public String getENTRY_DATE() {
		return ENTRY_DATE;
	}
	public void setENTRY_DATE(String eNTRY_DATE) {
		ENTRY_DATE = eNTRY_DATE;
	}

}
