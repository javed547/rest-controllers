/**
 * 
 */
package com.javed.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.javed.dto.ListUser;
import com.javed.dto.SingleUser;
import com.javed.dto.User;
import com.javed.repository.UserRepository;

/**
 * @author Mohd Javed
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	public ListUser listUsers(Integer pageNumber) throws JsonParseException, JsonMappingException, IOException{
		ListUser listUser = userRepository.listUsers(pageNumber);
		return listUser;
	}

	@Override
	public SingleUser getSingleUser(Integer userId) throws JsonParseException, JsonMappingException, IOException {
		SingleUser singleUser = userRepository.getSingleUser(userId);
		return singleUser;
	}
}
