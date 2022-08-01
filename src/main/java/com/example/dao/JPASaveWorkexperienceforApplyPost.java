package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.model.ApplyPostEducationalQualification;
import com.example.model.ApplyPostUserData;
import com.example.model.ApplyPostWorkExperienceDetails;

public interface JPASaveWorkexperienceforApplyPost extends JpaRepository<ApplyPostWorkExperienceDetails, Integer>{

	@Query(value = "select * from apply_post_work_experience_details where employeeid = :employeeid and postid = :postid" , nativeQuery = true)
	ApplyPostWorkExperienceDetails[] fetchapplypostworkexperiencedetails(int employeeid , int postid);

	@Modifying
	@Query(value = "delete from apply_post_work_experience_details where employeeid = :employeeid and postid = :postid" , nativeQuery = true)
	void deleteworkexperiencefromapplypost(int employeeid , int postid);
	
	@Query(value = "select COUNT(*) from apply_post_work_experience_details where employeeid = :employeeid and postid = :postid" , nativeQuery = true)
	int takeCount(int employeeid , int postid);

}
