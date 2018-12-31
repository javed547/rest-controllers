/**
 * 
 */
package com.javed.controller.test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.javed.controller.UserController;
import com.javed.dto.ListUser;
import com.javed.dto.SingleUser;
import com.javed.dto.User;
import com.javed.service.UserService;

/**
 * @author Mohd Javed
 *
 */
@RunWith(SpringRunner.class)
public class UserControllerTest {
	
	private Integer pageNumber = 1;
	private Integer userId = 2;
	
	@InjectMocks
	private UserController testSubject = new UserController();
		
	@Mock
	private UserService userService;
	
	@Before
	public void setUp() throws JsonParseException, JsonMappingException, IOException{
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void test_user_list() throws JsonParseException, JsonMappingException, IOException{
		Mockito.when(userService.listUsers(pageNumber)).thenReturn(prepareUserList());
		
		ListUser listUser = testSubject.listUsers("1");
		Assert.assertNotNull(listUser);
	}
	
	@Test
	public void test_single_user() throws JsonParseException, JsonMappingException, IOException{
		Mockito.when(userService.getSingleUser(userId)).thenReturn(prepareSingleUser());
		
		SingleUser singleUser = testSubject.singleUser("2");
		Assert.assertNotNull(singleUser);
	}

	private SingleUser prepareSingleUser() {
		User user = new User();

		user.setId(1);
		user.setFirst_name("Test First Name");
		user.setLast_name("Test Last Name");
		user.setAvatar("Sample Avatar");
		
		SingleUser singleUser = new SingleUser();
		singleUser.setData(user);
		return singleUser;
	}

	private ListUser prepareUserList(){
		ListUser listUser = new ListUser();
		List<User> userList = new ArrayList<User>();
		User user = new User();
		
		user.setId(1);
		user.setFirst_name("Test First Name");
		user.setLast_name("Test Last Name");
		user.setAvatar("Sample Avatar");
		
		userList.add(user);
		
		listUser.setPage(1);
		listUser.setPer_page(10);
		listUser.setTotal(2);
		listUser.setTotal_pages(10);
		listUser.setData(userList);
		
		return listUser;
	}

}
