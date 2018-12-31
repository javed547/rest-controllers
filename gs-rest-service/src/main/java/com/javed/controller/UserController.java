/**
 * 
 */
package com.javed.controller;

import java.io.IOException;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.javed.dto.ListUser;
import com.javed.dto.MongoUser;
import com.javed.dto.SingleUser;
import com.javed.dto.User;
import com.javed.repository.MongoUserRepository;
import com.javed.repository.UserRepository;
import com.javed.service.UserService;


/**
 * @author Mohd Javed
 *
 */
@RestController
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	@Autowired
	MongoUserRepository mongoUserRepository;

	@RequestMapping(value = "/listUsers", method = RequestMethod.POST, headers = {"Accept=application/json", "Content-Type=application/json"})
    public ListUser listUsers(@RequestParam(value="page", defaultValue="1", required = true) String pageNumber) throws JsonParseException, JsonMappingException, IOException {
		logger.debug("listUsers API called");
		return userService.listUsers(Integer.parseInt(pageNumber));
    }
	
	@RequestMapping(value = "/singleUser/{userId}", method = RequestMethod.POST, headers = {"Accept=application/json", "Content-Type=application/json"})
    public SingleUser singleUser(@PathVariable String userId) throws JsonParseException, JsonMappingException, IOException {
		logger.debug("singleUser API called");
		return userService.getSingleUser(Integer.parseInt(userId));
    }
	
	//create
	@PostMapping(value = "/addUser", headers = {"Accept=application/json", "Content-Type=application/json"}, 
			consumes = MediaType.APPLICATION_JSON_VALUE)
	public MongoUser createMongoUser(@RequestBody MongoUser mongoUser){
		return mongoUserRepository.insert(mongoUser);
	}
	
	//read
	@GetMapping(value = "/getUser/{id}", headers = {"Accept=application/json", "Content-Type=application/json"})
	public Optional<MongoUser> readMongoUser(@PathVariable String id){
		return mongoUserRepository.findById(Integer.parseInt(id));
	}

	//update
	@PutMapping(value = "/updateUser", headers = {"Accept=application/json", "Content-Type=application/json"})
	public MongoUser updateMongoUser(@RequestBody MongoUser mongoUser){
		return mongoUserRepository.save(mongoUser);
	}
	
	//delete
	@DeleteMapping(value = "/deleteUser/{id}", headers = {"Accept=application/json", "Content-Type=application/json"})
	public void removeMongoUser(@PathVariable Integer id){
		mongoUserRepository.deleteById(id);
	}
	
	//listUser
	@GetMapping(value = "/findAll", headers = {"Accept=application/json", "Content-Type=application/json"})
	public List<MongoUser> findAll(){
		return mongoUserRepository.findAll();
	}
}
