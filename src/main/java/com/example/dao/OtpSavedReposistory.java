package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.OtpSavedTable;


@Repository
public interface OtpSavedReposistory extends JpaRepository<OtpSavedTable , Integer>{

}
