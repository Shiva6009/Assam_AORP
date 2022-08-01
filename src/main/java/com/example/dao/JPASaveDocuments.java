package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.DocumentUpload;
import com.example.model.Workexperiences;

@Repository
public interface JPASaveDocuments  extends JpaRepository<DocumentUpload, Integer>{
	
	@Query(value = "select * from dbo_user_document_details where employeeid = :employeeid", nativeQuery = true)
	DocumentUpload[] fetchDetails(int employeeid);

}
