package com.example.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.model.ApplyPostFinalData;
import com.example.model.ApplyPostUserData;


@Transactional
public interface JPASaveApplypostFinalData extends JpaRepository<ApplyPostFinalData, Integer>{

	@Query(value = "select * from apply_post_final_data where employeeid = :employeeid" , nativeQuery = true)
	ApplyPostFinalData[] fetchActivitySeaction(int employeeid);
	

	@Query(value = "select * from apply_post_final_data where employeeid = :employeeid and postid = :postid" , nativeQuery = true)
	ApplyPostFinalData fetchapplypostfinaldata(int employeeid , int postid);
	
	@Modifying
	@Query(value = "delete from apply_post_final_data where employeeid = :employeeid and postid = :postid" , nativeQuery = true)
	void deletefromapplypostfinaldata(int employeeid , int postid);
	
	@Query(value = "select COUNT(*) from apply_post_user_data where employeeid = :employeeid and postid = :postid" , nativeQuery = true)
	int takeCount(int employeeid , int postid);
}
