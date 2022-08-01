package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.PostGraduationDetails;
import com.example.model.Schoolingdetails;

@Repository
public interface JPASaveEducationalPostgraduationDetails extends JpaRepository<PostGraduationDetails, Integer>{

	
	@Query(value = "select * from user_educational_postgraduation_details where employeeid = :employeeid", nativeQuery = true)
    PostGraduationDetails[] fetchDetails(int employeeid);
}
