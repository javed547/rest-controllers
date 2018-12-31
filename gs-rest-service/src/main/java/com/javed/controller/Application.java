package com.javed.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.javed.repository.MongoUserRepository;

@SpringBootApplication(scanBasePackages = { "com.javed.controller", 
											"com.javed.service", "com.javed.repository",
											"com.javed.dto", "com.javed.util" })
@EnableMongoRepositories(basePackageClasses = MongoUserRepository.class)
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}
