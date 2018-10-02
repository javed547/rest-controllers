/**
 * 
 */
package com.javed.repository;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.javed.dto.ListUser;
import com.javed.dto.SingleUser;
import com.javed.dto.User;
import com.javed.util.CallRestAPI;
import com.javed.util.ResponseParser;

/**
 * @author Mohd Javed
 *
 */
@Repository("userRepository")
public class UserRepositoryImpl implements UserRepository{

	@Autowired
	CallRestAPI callRestAPI;
	
	@Autowired
	ResponseParser responseParser;
	
	@Value("${target.domain}")
	private String targetDomain;

	@Value("${list.users}")
	private String userList;
	
	@Value("${single.user}")
	private String singleUser; 
	
	public ListUser listUsers(Integer pageNumber) throws JsonParseException, JsonMappingException, IOException{
		String response = callRestAPI.getAPICalls(targetDomain + userList + pageNumber);
		ListUser listUser = responseParser.parseListUser(response);
		
		return listUser;
	}

	@Override
	public SingleUser getSingleUser(Integer userId) throws JsonParseException, JsonMappingException, IOException {
		String response = callRestAPI.getAPICalls(targetDomain + singleUser + userId);
		SingleUser singleUser = responseParser.parseSingleUser(response);
		
		return singleUser;
	}
}
