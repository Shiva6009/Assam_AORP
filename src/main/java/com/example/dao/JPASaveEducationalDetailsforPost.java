package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.model.ApplyPostEducationalQualification;
import com.example.model.ApplyPostFinalData;

public interface JPASaveEducationalDetailsforPost extends JpaRepository<ApplyPostEducationalQualification, Integer> {

	
	@Query(value = "select * from apply_post_educational_qualification where employeeid = :employeeid and postid = :postid" , nativeQuery = true)
	ApplyPostEducationalQualification[] fetchapplyposteducationdetails(int employeeid , int postid);
	
	
	@Modifying
	@Query(value = "delete from apply_post_educational_qualification where employeeid = :employeeid and postid = :postid" , nativeQuery = true)
	void deletefromapplyposteducationdetails(int employeeid , int postid);
	
	@Query(value = "select COUNT(*) from apply_post_educational_qualification where employeeid = :employeeid and postid = :postid" , nativeQuery = true)
	int takeCount(int employeeid , int postid);
	
}
