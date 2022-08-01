package com.example.storedprocedure;

public interface PayementModuleInterface {

	Float getApplicaitonFee();
	Float getProcessingFee();
	Float getTaxableAmount();
	Float getTotalAmount();
	String getPaymentID();
	String getBankCode();
	Float getTresuryAmount();
	Float getNonTresuryAmount();
	String getMultitransfer();
	String getNTPType();
	Integer getPaymentFlag();
	
}
