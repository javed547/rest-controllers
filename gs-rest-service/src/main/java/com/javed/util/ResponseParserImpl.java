/**
 * 
 */
package com.javed.util;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.javed.dto.ListUser;
import com.javed.dto.SingleUser;
import com.javed.dto.User;

/**
 * @author Mohd Javed
 *
 */
@Repository("responseParser")
public class ResponseParserImpl implements ResponseParser{
	
	@Autowired
	ObjectMapper objectMapper;
	
	public ListUser parseListUser(String response) throws JsonParseException, JsonMappingException, IOException{
		ListUser listUser = objectMapper.readValue(response, ListUser.class);
		return listUser;
	}
	
	public SingleUser parseSingleUser(String response) throws JsonParseException, JsonMappingException, IOException{
		SingleUser singleUser = objectMapper.readValue(response, SingleUser.class);
		return singleUser;
	}
}
