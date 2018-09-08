/**
 * 
 */
package com.javed.repository;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.javed.dto.ListUser;
import com.javed.dto.SingleUser;

/**
 * @author Mohd Javed
 *
 */
public interface UserRepository {

	public ListUser listUsers(Integer pageNumber) throws JsonParseException, JsonMappingException, IOException;

	public SingleUser getSingleUser(Integer userId) throws JsonParseException, JsonMappingException, IOException;
	
}
