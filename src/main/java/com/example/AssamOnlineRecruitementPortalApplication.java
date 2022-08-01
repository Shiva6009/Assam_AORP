package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*" , allowedHeaders = "*")
@ComponentScan(basePackages = {"com.example.service" , "com.example.controller","com.example.dao","com.example.model"})
@SpringBootApplication
public class AssamOnlineRecruitementPortalApplication extends SpringBootServletInitializer{

	public static void main(String[] args) {
		SpringApplication.run(AssamOnlineRecruitementPortalApplication.class, args);
		System.out.println(" Hibernate Version :"+ org.hibernate.Version.getVersionString() );
		System.out.println(" INFO : Inside Main Function.." );
	}
}
	