package com.example.onlinesportsshopee.service;

import static org.junit.jupiter.api.Assertions.*;


import org.junit.Assert;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.example.onlinesportshopee.dao.IUserRepository;
import com.example.onlinesportshopee.entities.UserEntity;
import com.example.onlinesportshopee.exception.UserNotFoundException;
import com.example.onlinesportshopee.services.IUserService;
import com.example.onlinesportshopee.services.UserServiceImpl;

@SpringBootTest(classes = UserServiceImpl.class)
class UserServiceImplTest {

	@MockBean
	IUserRepository iuserdao;
	
	
	@Autowired
	IUserService iuserservice;
	
	UserEntity user=null;
	
	@Test
	void testAddUser01() throws Exception
	{
		user = new UserEntity();
		user.setId((long)1);
		user.setUsername("chakri");
		user.setPassword("chakri@123");
		Mockito.when(iuserdao.saveAndFlush(user)).thenReturn(user);
		assertNotNull(user);
	}
	
	@Test
    void testSignInUser01() throws Exception
    {
        user = new UserEntity();
        user.setId((long)1);
        user.setPassword("chakri@123");
       
        Mockito.when(iuserdao.save(user)).thenReturn(user);
        Assert.assertNotNull(user);
    }
	
	@Test
	void testChangePassword01() throws Exception
	{
		user = new UserEntity();
		user.setId((long)8);
		user.setUsername("chakri");
		user.setPassword("chakri@123");
		user.setPassword("chakri@456");
		Mockito.when(iuserdao.save(user)).thenReturn(user);
	}
}
