package com.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.ResearchPapersDetails;
import com.example.model.UnderGradutionDetails;

@Repository
public interface JPASaveEducationalResearchPaperDetails extends JpaRepository<ResearchPapersDetails, Integer> {

	@Query(value = "select * from user_educational_research_paper_details where employeeid = :employeeid", nativeQuery = true)
	ResearchPapersDetails[] fetchDetails(int employeeid);
}
