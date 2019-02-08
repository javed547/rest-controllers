/**
 * 
 */
package com.javed.service.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import com.javed.dto.MongoUser;
import com.javed.repository.MongoUserRepository;
import com.javed.service.MongoUserServiceImpl;

import org.junit.Assert;

/**
 * @author Mohd Javed
 *
 */
@RunWith(SpringRunner.class)	
public class MongoUserServiceTest {
	
	@InjectMocks
	private MongoUserServiceImpl testSubject = new MongoUserServiceImpl();
	
	@Mock
	private MongoUserRepository mongoUserRepository;
	
	@Before
	public void setup(){
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void test_create_user_service(){
		MongoUser mongoUser = getUserInstance();
		Mockito.when(mongoUserRepository.insert(mongoUser)).thenReturn(mongoUser);
		
		MongoUser mongoUserResult = testSubject.createMongoUser(mongoUser);
		Assert.assertEquals("Mohd Javed", mongoUserResult.getFirstName());
	}
	
	@Test
	public void test_update_user_service(){
		MongoUser mongoUser = getUserInstance();
		Mockito.when(mongoUserRepository.save(mongoUser)).thenReturn(mongoUser);
		
		MongoUser mongoUserResult = testSubject.updateMongoUser(mongoUser);
		Assert.assertEquals("Mohd Javed", mongoUserResult.getFirstName());
	}
	
	@Test
	public void test_delete_user_service(){
		Mockito.doNothing().when(mongoUserRepository).deleteById(1);
		
		testSubject.removeMongoUser(1);
	}
	
	@Test
	public void test_list_users_service(){
		Mockito.when(mongoUserRepository.findAll()).thenReturn(getUserInstanceList());
		
		List<MongoUser> mongoUsers = testSubject.findAll();
		Assert.assertEquals(4, mongoUsers.size());
	}
	
	private List<MongoUser> getUserInstanceList() {
		List<MongoUser> mongoUsers = new ArrayList<MongoUser>();
		
		MongoUser mongoUser = new MongoUser(1, "Mohd Javed", "Khan", "jal90javed@gmail.com");
		MongoUser mongoUser2 = new MongoUser(2, "Berd", "Leno", "berdLeno@gmail.com");
		MongoUser mongoUser3 = new MongoUser(3, "Laurient", "Koscielny", "laurient@gmail.com");
		MongoUser mongoUser4 = new MongoUser(4, "Socratis", "Papasthapoulus", "sokratis@gmail.com");
		
		mongoUsers.add(mongoUser);
		mongoUsers.add(mongoUser2);
		mongoUsers.add(mongoUser3);
		mongoUsers.add(mongoUser4);
		
		return mongoUsers;
	}

	private MongoUser getUserInstance() {
		MongoUser mongoUser = new MongoUser(1, "Mohd Javed", "Khan", "jal90javed@gmail.com");
		return mongoUser;
	}
}
