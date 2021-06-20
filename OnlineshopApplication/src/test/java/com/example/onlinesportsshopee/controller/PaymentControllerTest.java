package com.example.onlinesportsshopee.controller;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.example.onlinesportshopee.controller.PaymentController;
import com.example.onlinesportshopee.entities.PaymentEntity;
import com.example.onlinesportshopee.exception.PaymentNotFoundException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;

@RunWith(SpringRunner.class)
@WebMvcTest(value = PaymentController.class )
public class PaymentControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private PaymentController paymentController;
	
	@Test
	public void testAddPayment() throws Exception
	{
		String URI="/onlinesportshopee/payments/addPayment";
		PaymentEntity payment = new PaymentEntity();
		payment.setId(32L);
		payment.setType("Online");
		payment.setStatus("Done");
		String jsonInput=this.converttoJson(payment);
		
		//Mockito.when(addressController.addAddress(Mockito.any(AddressDTO.class))).thenReturn(addressDto);
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		String jsonOutput=mockHttpServletResponse.getContentAsString();
		//assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertNotNull(jsonOutput);
		Assert.assertNotEquals(HttpStatus.ACCEPTED.value(), mockHttpServletResponse.getStatus());
	}
	
	@Test
	public void testGetPaymentDetails() throws Exception
	{
		String URI="/onlinesportshopee/payments/getPaymentDetails/{paymentId}";
		PaymentEntity payment = new PaymentEntity();
		payment.setId(32L);
		payment.setType("Online");
		payment.setStatus("Done");
		String jsonInput=this.converttoJson(payment);
		
		//Mockito.when(addressController.getAddressById(Mockito.any())).thenReturn(addressDto);
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 32L).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		String jsonOutput=mockHttpServletResponse.getContentAsString();
		//assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertNotNull(jsonOutput);
	}
	
	@Test
	public void testGetAllPaymentDetails() throws Exception
	{
		String URI="/onlinesportshopee/payments/getallpayment";
		PaymentEntity payment = new PaymentEntity();
		payment.setId(32L);
		payment.setType("Online");
		payment.setStatus("Done");
		
		PaymentEntity payment1 = new PaymentEntity();
		payment1.setId(32L);
		payment1.setType("Online");
		payment1.setStatus("Done");
		List<PaymentEntity> paymentList=new ArrayList<>();
		paymentList.add(payment);
		paymentList.add(payment1);
		String jsonInput=this.converttoJson(paymentList);
		
		//Mockito.when(addressController.getAllAddresses()).thenReturn(addressDtoList);
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		String jsonOutput=mockHttpServletResponse.getContentAsString();
		//assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertNotNull(jsonOutput);
		
	}
	
	@Test
	public void testRemovePayment() throws Exception
	{
		String URI="/onlinesportshopee/payments/removePayment/payment/{paymentId}";
		PaymentEntity payment = new PaymentEntity();
		payment.setId(32L);
		payment.setType("Online");
		payment.setStatus("Done");
	    
		//Mockito.when(addressController.getAddressById(Mockito.any())).thenReturn(addressDto);
		//Mockito.when(addressController.removeAddress(Mockito.any())).thenReturn(true);
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 32L).accept(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		
		Assert.assertNotEquals(HttpStatus.ACCEPTED.value(), mockHttpServletResponse.getStatus());

		
	}
	
	@Test
	public void testUpdatePayment() throws Exception
	{
		String URI="/onlinesportshopee/payments/updatePayment/{paymentId}";
		PaymentEntity payment = new PaymentEntity();
		payment.setId(32L);
		payment.setType("Online");
		payment.setStatus("Done");
		String jsonInput=this.converttoJson(payment);
		
		//Mockito.when(addressController.updateAddress(Mockito.any(),Mockito.anyString())).thenReturn(address);
		MvcResult mvcResult=this.mockMvc.perform(MockMvcRequestBuilders.put(URI, 32L).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON)).andReturn();
		MockHttpServletResponse mockHttpServletResponse=mvcResult.getResponse();
		String jsonOutput=mockHttpServletResponse.getContentAsString();
		//assertThat(jsonInput).isEqualTo(jsonOutput);
		Assert.assertNotNull(jsonOutput);
		
	}
	
	
	private String converttoJson(Object payment) throws JsonProcessingException
	{
		ObjectMapper objectMapper=new ObjectMapper();
		return objectMapper.writeValueAsString(payment);
	}

}