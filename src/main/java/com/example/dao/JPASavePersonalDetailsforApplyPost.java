package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.model.ApplyPostUserData;

public interface JPASavePersonalDetailsforApplyPost extends JpaRepository<ApplyPostUserData, Integer>{

	@Query(value = "select * from apply_post_user_data where employeeid = :employeeid and postid = :postid" , nativeQuery = true)
	ApplyPostUserData fetchapplypostuserdata(int employeeid , int postid);
	
	@Modifying
	@Query(value = "delete from apply_post_user_data  where employeeid = :employeeid and postid = :postid" , nativeQuery = true)
	void deletefromapplypostuserdata(int employeeid , int postid);
	
	@Query(value = "select COUNT(*) from apply_post_user_data where employeeid = :employeeid and postid =:postid" , nativeQuery = true)
	int takeCount(int employeeid , int postid);
}
