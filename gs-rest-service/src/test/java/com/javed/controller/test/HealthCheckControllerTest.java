/**
 * 
 */
package com.javed.controller.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import com.javed.controller.HealthCheckController;
import com.javed.dto.HealthCheck;

/**
 * @author Mohd Javed
 *
 */
@RunWith(SpringRunner.class)
public class HealthCheckControllerTest {

	@InjectMocks
	private HealthCheckController testSubject = new HealthCheckController();
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void test_application_health(){
		HealthCheck healthCheck = testSubject.healthCheck();
		Assert.assertTrue("Application is not working", healthCheck.getMessage().equalsIgnoreCase("Application working")); 
	}
}
