package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Schoolingdetails;
import com.example.model.UnderGradutionDetails;

@Repository
public interface JPASaveEducationalUndergraduationDetails extends JpaRepository<UnderGradutionDetails, Integer> {

	@Query(value = "select * from user_educational_undergraduation_details where employeeid = :employeeid", nativeQuery = true)
	UnderGradutionDetails[] fetchDetails(int employeeid);
}
