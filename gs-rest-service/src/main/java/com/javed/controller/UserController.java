/**
 * 
 */
package com.javed.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.javed.dto.ListUser;
import com.javed.dto.SingleUser;
import com.javed.dto.User;
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
}
