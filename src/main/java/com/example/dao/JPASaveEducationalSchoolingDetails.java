package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Schoolingdetails;

@Repository
public interface JPASaveEducationalSchoolingDetails extends JpaRepository<Schoolingdetails, Integer>{
	
	@Query(value = "select * from user_educational_schooling_details where employeeid = :employeeid" , nativeQuery = true )
	Schoolingdetails[] fetchDetails(int employeeid);

}
