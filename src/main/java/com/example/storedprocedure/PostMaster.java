package com.example.storedprocedure;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.persistence.metamodel.StaticMetamodel;

import org.springframework.stereotype.Component;

@Entity
public class PostMaster {

	@Id
	private int PostSlNo;
	private String AddName;
	private String StartDate;
	private String EndDate;
	private String PaymentEndDate;
	private int ApplyFlag;
	

	public int getPostSlNo() {
		return PostSlNo;
	}

	public void setPostSlNo(int postSlNo) {
		PostSlNo = postSlNo;
	}

	public String getAddName() {
		return AddName;
	}

	public void setAddName(String addName) {
		AddName = addName;
	}

	public String getStartDate() {
		return StartDate;
	}

	public void setStartDate(String startDate) {
		StartDate = startDate;
	}

	public String getEndDate() {
		return EndDate;
	}

	public void setEndDate(String endDate) {
		EndDate = endDate;
	}

	public String getPaymentEndDate() {
		return PaymentEndDate;
	}

	public void setPaymentEndDate(String paymentEndDate) {
		PaymentEndDate = paymentEndDate;
	}

	public int isApplyFlag() {
		return ApplyFlag;
	}

	public void setApplyFlag(int applyFlag) {
		ApplyFlag = applyFlag;
	}	
}
