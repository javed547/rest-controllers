/**
 * 
 */
package com.javed.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javed.dto.HealthCheck;

/**
 * @author Mohd Javed
 *
 */
@RestController
public class HealthCheckController {
	
	private static final Logger logger = LoggerFactory.getLogger(HealthCheckController.class);
	
	@RequestMapping(value = "/healthCheck")
    public HealthCheck healthCheck() {
		logger.info("performing application health check");
		
		return new HealthCheck("Application working");
    }

}
