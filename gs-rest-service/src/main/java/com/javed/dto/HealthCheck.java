/**
 * 
 */
package com.javed.dto;

/**
 * @author Mohd Javed
 *
 */
public class HealthCheck {
	
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HealthCheck(String message) {
		super();
		this.message = message;
	}
	
}
