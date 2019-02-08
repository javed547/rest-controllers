/**
 * 
 */
package com.javed.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.javed.dto.MongoUser;
import com.javed.service.MongoUserService;

/**
 * @author Mohd Javed
 *
 */
@RestController
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private MongoUserService mongoUserService;

	//create
	@PostMapping(value = "/addUser", headers = {"Accept=application/json", "Content-Type=application/json"}, consumes = MediaType.APPLICATION_JSON_VALUE)
	public MongoUser createMongoUser(@RequestBody MongoUser mongoUser){
		logger.info("creating user in mongo database");
		return mongoUserService.createMongoUser(mongoUser);
	}
	
	//read
	@GetMapping(value = "/getUser/{id}")
	public Optional<MongoUser> readMongoUser(@PathVariable String id){
		logger.info("reading user in mongo database");
		return mongoUserService.readMongoUser(id);
	}

	//update
	@PutMapping(value = "/updateUser", headers = {"Accept=application/json", "Content-Type=application/json"}, consumes = MediaType.APPLICATION_JSON_VALUE)
	public MongoUser updateMongoUser(@RequestBody MongoUser mongoUser){
		logger.info("updating user in mongo database");
		return mongoUserService.updateMongoUser(mongoUser);
	}
	
	//delete
	@DeleteMapping(value = "/deleteUser/{id}")
	public void removeMongoUser(@PathVariable Integer id){
		logger.info("deleting user in mongo database");
		mongoUserService.removeMongoUser(id);
	}
	
	//listUser
	@GetMapping(value = "/findAll")
	public List<MongoUser> findAll(){
		logger.info("listing users in mongo database");
		return mongoUserService.findAll();
	}
	
}
