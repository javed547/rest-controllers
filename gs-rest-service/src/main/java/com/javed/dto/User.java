/**
 * 
 */
package com.javed.dto;

import org.springframework.stereotype.Component;

/**
 * @author Mohd Javed
 *
 */
@Component
public class User {

	public Integer id;
	public String first_name;
	public String last_name;
	public String avatar;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
}
