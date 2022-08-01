package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.OtherQualificationDetails;
import com.example.model.Schoolingdetails;

@Repository
public interface JPASaveEducationalOtherQualificationsDetails extends JpaRepository<OtherQualificationDetails, Integer> {

	
	@Query(value = "select * from user_educational_other_qualifications_details where employeeid = :employeeid", nativeQuery = true)
	OtherQualificationDetails[] fetchDetails(int employeeid);
}
