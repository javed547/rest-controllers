/**
 * 
 */
package com.javed.util;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.javed.dto.ListUser;
import com.javed.dto.SingleUser;

/**
 * @author Mohd Javed
 *
 */
public interface ResponseParser {

	public ListUser parseListUser(String response) throws JsonParseException, JsonMappingException, IOException;
	
	public SingleUser parseSingleUser(String response) throws JsonParseException, JsonMappingException, IOException;
}
