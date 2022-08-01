package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.UnderGradutionDetails;
import com.example.model.Workexperiences;


@Repository
public interface JPASaveWorkExperienceDetails extends JpaRepository<Workexperiences, Integer>{	
	
	@Query(value = "select * from user_work_experience_details where employeeid = :employeeid", nativeQuery = true)
	Workexperiences[] fetchDetails(int employeeid);
	
}
