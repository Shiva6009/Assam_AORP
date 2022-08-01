package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.OldPaymentDetails;

@Repository
public interface OldPaymentDetailsReposistory extends JpaRepository<OldPaymentDetails, Integer> {

	@Query(value = "select COUNT(*) from old_payment_details where oldgrnnumber = :grnnumber" , nativeQuery = true)
	public int verifyGRNnumber(String grnnumber);
	
	@Query(value = "select * from old_payment_details where employeeid = :employeeid and postid = :postid" , nativeQuery = true)
	public OldPaymentDetails fetchOldPaymentDetails(int employeeid , int postid);
}
