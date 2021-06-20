package com.example.onlinesportsshopee.controller;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.onlinesportshopee.controller.UserController;
import com.example.onlinesportshopee.entities.UserEntity;
import com.example.onlinesportshopee.services.IUserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = UserController.class)
@AutoConfigureMockMvc
class UserControllerTest {

	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private IUserService iuserservice;
	
    @Test
	public void testAddUser() throws Exception{
	        
	        String URI="/onlinesportshopee/login/add-user";
	 	        
			UserEntity user=new UserEntity();
			user.setId((long)123);
			user.setUsername("chinnu");
			user.setPassword("chakri@143");
			
			String jsonInput = this.convertToJson(user);

	        Mockito.when(iuserservice.addUser(Mockito.any(UserEntity.class))).thenReturn(user);
	        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        String jsonOutput = mockHttpServletResponse.getContentAsString();
	        Assert.assertNotNull(jsonOutput);
	    }
    
    @Test
	public void testSignInUser() throws Exception{
	        
	        String URI="/onlinesportshopee/login/signin/{userId}/{password}";
	 	        
	        UserEntity user=new UserEntity();
			user.setId((long)123);
			user.setUsername("Babu");
			user.setPassword("Babu@143");
			
			String jsonInput = this.convertToJson(user);

	        Mockito.when(iuserservice.addUser(Mockito.any(UserEntity.class))).thenReturn(user);
	        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI,123,"Babu@123").accept(MediaType.APPLICATION_JSON)).andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        String jsonOutput = mockHttpServletResponse.getContentAsString();
	        Assert.assertNotNull(jsonOutput);
	    }
    
    @Test
	public void testChangePasswordUser() throws Exception{
	        
	        String URI="/onlinesportshopee/login/changepassword/{userId}";
	 	        
	        UserEntity user=new UserEntity();
			user.setId((long)123);
			user.setUsername("Babu");
			user.setPassword("Babu@143");
			
			String jsonInput = this.convertToJson(user);

	        Mockito.when(iuserservice.addUser(Mockito.any(UserEntity.class))).thenReturn(user);
	        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI,123).accept(MediaType.APPLICATION_JSON).content(jsonInput).accept(MediaType.APPLICATION_JSON)).andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        String jsonOutput = mockHttpServletResponse.getContentAsString();
	        Assert.assertNotNull(jsonOutput);
	    }    
    
    private String convertToJson(Object product) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(product);
    }

}
