package com.example.storedprocedure;

public interface SpliupPayment {

	Float getApplicaitonFee();
	Float getProcessingFee();
	Float getTaxableAmount();
	Float getTotalAmount();
	Integer getdisableflag();
	
}
