package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.model.ApplyPostDocumentUpload;
import com.example.model.ApplyPostFinalData;
public interface JPASaveDocumentsforApplyPost extends JpaRepository<ApplyPostDocumentUpload, Integer>{

	
	@Query(value = "select * from apply_post_document_upload where employeeid = :employeeid and postid = :postid" , nativeQuery = true)
	ApplyPostDocumentUpload[] fetchapplypostdocumentupload(int employeeid , int postid);


	@Modifying
	@Query(value = "delete from  apply_post_document_upload where employeeid = :employeeid and postid = :postid" , nativeQuery = true)
	void deletedocumentfromapplypost(int employeeid , int postid);
	
	@Query(value = "select COUNT(*) from apply_post_document_upload where employeeid = :employeeid and postid = :postid" , nativeQuery = true)
	int takeCount(int employeeid , int postid);
}
