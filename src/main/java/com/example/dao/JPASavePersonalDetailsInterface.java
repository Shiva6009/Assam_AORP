package com.example.dao;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

import javax.persistence.Column;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.example.model.ApplyPostFinalData;
import com.example.model.CasteMaster;
import com.example.model.DocumentUpload;
import com.example.model.PaymentDetails;
import com.example.model.UserRegistrationData;

@Repository
public interface JPASavePersonalDetailsInterface extends JpaRepository<UserRegistrationData, Integer>{

		@Query(value = "select CasteId from CasteMaster where CasteName = :castename" , nativeQuery =  true)
		String fetchCasteIdfromCasteName(String castename);
		
		@Query(value = "select district_id from district_master where district_name =:districtname and state_id = :stateid" , nativeQuery = true)
		String fetchDistrictIdfromDistrictName(String districtname , int stateid);
		
		@Query(value = "select state_id from state_master where state_name = :statename" , nativeQuery = true) 
		String fetchStateIdfromStateName(String statename);
		
		@Query(value = "select district_name from district_master where district_id =:districtid" , nativeQuery = true)
		String fetchDistrictNamefromDistrictId(String districtid);
		
		@Query(value = "select state_name from state_master where state_id = :stateid" , nativeQuery = true)
		String fetchStateNamefromStateId(String stateid);
		
		@Query(value = "select CasteName from CasteMaster where CasteId = :casteid" , nativeQuery = true)
		String fetchCasteNamefromCasteId(String casteid);
		
		@Query(value = "select BenchmarkdisabilitycategoryName  from Benchmarkdisabilitycategory" , nativeQuery = true)
		List<String> fetchBenchmarkCategory();
		
		@Query(value = "select Benchmarkdisabilitycategoryid from BenchMarkdisabilitycategory where benchmarkdisabilitycategoryName = :selecteddisability" , nativeQuery = true)
		String fetchBenchmarkdisabilityIdfromBenchmarkdisabilityName(String selecteddisability);
		
		@Query(value = "select BenchmarkdisabilitysubcategoryName from Benchmarkdisabilitysubcategory where BenchmarkdisabilitymaintableId = :disabilitymaintableid" , nativeQuery = true)
		List<String> fetchBenchmarkdisabilitySubcategory(int disabilitymaintableid);
		
		@Query(value = "delete  from user_registration_data_special_category where employeeid = :employeeid", nativeQuery = true)
	    void deleteemployeeidinbenchmarkdisabilitysubacategory(int employeeid);
			
		@Query(value = "select Benchmarkdisabilitysubcategoryid from Benchmarkdisabilitysubcategory where BenchmarkdisabilitysubcategoryName = :selectedsubcategory and Benchmarkdisabilitymaintableid = :maincategory" , nativeQuery = true)
		int fetchBenchmarkdisabilitysubcategoryidfromname(String selectedsubcategory , int maincategory);
		
		@Query(value = "select BenchmarkdisabilitycategoryName from Benchmarkdisabilitycategory where BenchmarkdisabilitycategoryId  =:benchmarkdisabilityid" , nativeQuery = true)
		String fetchBenchMarkdisabilityNamefromBenchMarkdisabilityId(int benchmarkdisabilityid);
		
		@Query(value = "select BenchmarkdisabilitysubcategoryName from Benchmarkdisabilitysubcategory where BenchmarkdisabilitysubcategoryId = :benmarkdisabilitysubcategoryId" , nativeQuery = true)
		String fetchBenchMarkdisabilitySubcategoryNamefromBenchMarkdisabilitysubcategoryId(int benmarkdisabilitysubcategoryId);
			
		@Query(value = "select ExZoneName from ExaminationZoneMaster" , nativeQuery = true)
		List<String> fetchExaminationZone();
		
				
		@Query(value = "select district_name from district_master where state_id in (select state_id from state_master  where state_name = :stateName)", nativeQuery = true)
	    List<String> fetchDistrict(@Param("stateName") String stateName);
		
		@Query(value = "select state_name from state_master" , nativeQuery = true)
		List<String> fetchState();
		
		@Query(value = "select UGCourseName from UGCourseMaster" , nativeQuery = true)
		List<String> fetchUGDetails();
		
		@Query(value = "select PGCourseName from PGCourseMaster" , nativeQuery = true)
		List<String> fetchPGDetails();
		
		@Query(value = "select DiplomaCourseName from DiplomaCourseMaster" , nativeQuery =  true)
		List<String> fetchDiplomaDetails();
			
		@Query(value = "select CasteName from CasteMaster" , nativeQuery =  true)
		List<String> fetchCaste();
		
		@Query(value = "select entry_date , prn , grn , amount , status from ASSAMonlinePaymentDetails where employeeid = :employeeid and postid = :postid" , nativeQuery = true)
		PaymentDetails fetchpaymentdetails(int employeeid , int postid);
	
		public UserRegistrationData findByEmail(String email);
		
        public UserRegistrationData findByMobile(String mobile);
        
        public UserRegistrationData findByemployeeid(int employeeid);
		
		@Query(value = "select photo,signature from user_basics_details where employeeid = :employeeid" , nativeQuery = true)
		public String fetchPhotoandSignature(int employeeid);
			
		@Query(value = "select * from user_basics_details where employeeid = :employeeid", nativeQuery = true)
		public UserRegistrationData fetchDetails(int employeeid);
		
		@Query(value = "select Genderid from GenderMaster where GenderName = :GenderName" , nativeQuery = true)
		public int reteriveGenderIdfromGenderName(String GenderName);
		
		@Query(value = "select COUNT(*) from MVI where PaymentGRN = :grnnumber" , nativeQuery = true)
		public int verifyGRNnumber(String grnnumber);
		
				
}
	