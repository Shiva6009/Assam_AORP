package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.model.ApplyPostDocumentUpload;
import com.example.model.ApplyPostDynamicOptions;

public interface JPASaveDynamicOptionsforApplyPOst  extends JpaRepository<ApplyPostDynamicOptions, Integer> {

	
	@Query(value = "select * from apply_post_dynamic_options where employeeid = :employeeid and postid = :postid" , nativeQuery = true)
	ApplyPostDynamicOptions[] fetchapplypostdynamicoptions(int employeeid , int postid);

	@Modifying
    @Query(value = "delete from apply_post_dynamic_options where employeeid = :employeeid and postid = :postid" , nativeQuery = true)
    void deletedynamicoptionfromapplypost(int employeeid , int postid);
	
	@Query(value = "select COUNT(*) from apply_post_dynamic_options where employeeid = :employeeid and postid = :postid" , nativeQuery = true)
	int takeCount(int employeeid , int postid);

}
