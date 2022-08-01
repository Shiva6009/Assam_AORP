package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.UserRegistrationData;
import com.example.model.UserRegistrationDataSpecialCategory;

public interface JPASavePersonalDetailsSpecialCategory extends JpaRepository<UserRegistrationDataSpecialCategory, Integer> {

	@Query(value = "select specialcategoryid from user_registration_data_special_category where employeeid = :employeeid" ,nativeQuery = true)
	int[] fetchspecailcategoryidfromemployeeid(int employeeid);
}
