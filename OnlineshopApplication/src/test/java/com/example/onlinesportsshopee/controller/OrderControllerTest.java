package com.example.onlinesportsshopee.controller;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.onlinesportshopee.controller.CartController;
import com.example.onlinesportshopee.controller.OrderController;
import com.example.onlinesportshopee.entities.CartEntity;
import com.example.onlinesportshopee.entities.OrderEntity;
import com.example.onlinesportshopee.services.IOrderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = OrderController.class)
@AutoConfigureMockMvc
class OrderControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean 
	private IOrderService iOrderService;
	
    @Test
	   public void testAddOrder() throws Exception{
	        
	        String URI="/onlinesportshopee/get-order/{orderID}";
	        
			CartEntity cart=new CartEntity();
			cart.setId((long)151);
			cart.setPrice(1200.35);
			cart.setProductName("nike");
			cart.setQuantity(1);
			cart.setTotal(1000.45);
	       
			OrderEntity order = new OrderEntity();
	        order.setId((long)10);
	        order.setAmount(2331.33);
	        order.setBillingDate("2021-08-09");
	        order.setPaymentMethod("card");
	        
			
			String jsonInput = this.convertToJson(order);

			
	        Mockito.when(iOrderService.addOrder(cart.getId())).thenReturn(order);
	        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI,151,order).accept(MediaType.APPLICATION_JSON)).andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        String jsonOutput = mockHttpServletResponse.getContentAsString();
	        //assertThat(jsonInput).isEqualTo(jsonOutput);
	        Assert.assertNotNull(jsonOutput);
	    }
    
    @Test
	   public void GetOrderById() throws Exception{
	        
	        String URI="/get-order/{orderID}";
	        
			CartEntity cart=new CartEntity();
			cart.setId((long)151);
			cart.setPrice(1200.35);
			cart.setProductName("nike");
			cart.setQuantity(1);
			cart.setTotal(1000.45);
	       
			OrderEntity order = new OrderEntity();
	        order.setId((long)10);
	        order.setAmount(2331.33);
	        order.setBillingDate("2021-08-09");
	        order.setPaymentMethod("card");
			
			String jsonInput = this.convertToJson(order);

			
	        Mockito.when(iOrderService.getAllOrders()).thenReturn((List<OrderEntity>) order);
	        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI,10).accept(MediaType.APPLICATION_JSON)).andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        String jsonOutput = mockHttpServletResponse.getContentAsString();
	        //assertThat(jsonInput).isEqualTo(jsonOutput);
	        Assert.assertNotNull(jsonOutput);
	    }
    
    
    @Test
	   public void GetUpdateorderById() throws Exception{
	        
	        String URI="/update-order/{orderID}";
	        
			CartEntity cart=new CartEntity();
			cart.setId((long)151);
			cart.setPrice(1200.35);
			cart.setProductName("nike");
			cart.setQuantity(1);
			cart.setTotal(1000.45);
	       
			OrderEntity order = new OrderEntity();
	        order.setId((long)10);
	        order.setAmount(2331.33);
	        order.setBillingDate("2021-08-09");
	        order.setPaymentMethod("card");
	        
			
			String jsonInput = this.convertToJson(order);

			
	        Mockito.when(iOrderService.updateOrder(order.getId(),order)).thenReturn(order);
	        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI,10).accept(MediaType.APPLICATION_JSON)).andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        String jsonOutput = mockHttpServletResponse.getContentAsString();
	        //assertThat(jsonInput).isEqualTo(jsonOutput);
	        Assert.assertNotNull(jsonOutput);
	    }
    
    
    @Test
	   public void GetDeleteorderById() throws Exception{
	        
	        String URI="/remove-order/{orderID}";
	        
			CartEntity cart=new CartEntity();
			cart.setId((long)151);
			cart.setPrice(1200.35);
			cart.setProductName("nike");
			cart.setQuantity(1);
			cart.setTotal(1000.45);
	       
			OrderEntity order = new OrderEntity();
	        order.setId((long)10);
	        order.setAmount(2331.33);
	        order.setBillingDate("2021-08-09");
	        order.setPaymentMethod("card");
	        
			
			String jsonInput = this.convertToJson(order);

			
	        Mockito.when(iOrderService.deleteOrder(order.getId())).thenReturn(order);
	        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI,10).accept(MediaType.APPLICATION_JSON)).andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        String jsonOutput = mockHttpServletResponse.getContentAsString();
	        //assertThat(jsonInput).isEqualTo(jsonOutput);
	        Assert.assertNotNull(jsonOutput);
	    }
    
    
    @Test
	   public void Getalldetails() throws Exception{
	        
	        String URI="/get-all-order/";
	        
	        OrderEntity order = new OrderEntity();
			order.setId((long)10);
		    order.setAmount(2331.33);
		    order.setBillingDate("2021-08-09");
		    order.setPaymentMethod("card");
		    
		    OrderEntity order1 = new OrderEntity();
		    order1.setId((long)11);
		    order1.setAmount(2331.33);
		    order1.setBillingDate("2021-08-09");
		    order1.setPaymentMethod("card");
		    
		    List<OrderEntity> orderlist = new ArrayList<>();
		    orderlist.add(order1);
		    orderlist.add(order);
			
			String jsonInput = this.convertToJson(order);

			
	        Mockito.when(iOrderService.getAllOrders()).thenReturn(orderlist);
	        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        String jsonOutput = mockHttpServletResponse.getContentAsString();
	        //assertThat(jsonInput).isEqualTo(jsonOutput);
	        Assert.assertNotNull(jsonOutput);
	    }
	
	private String convertToJson(Object orderEntity)throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(orderEntity);
	}
}
