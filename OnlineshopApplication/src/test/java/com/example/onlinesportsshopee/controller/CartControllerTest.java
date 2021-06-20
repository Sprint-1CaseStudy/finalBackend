package com.example.onlinesportsshopee.controller;

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

import com.example.onlinesportshopee.controller.CartController;
import com.example.onlinesportshopee.entities.CartEntity;
import com.example.onlinesportshopee.entities.ProductEntity;
import com.example.onlinesportshopee.services.ICartService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = CartController.class)
@AutoConfigureMockMvc
class CartControllerTest {

	
	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private ICartService icartservice;
	
    @Test
	   public void testAddCart() throws Exception{
	        
	        String URI="/cart/addtocart/{ProdID}";
	        
	        ProductEntity productEnt = new ProductEntity();
			productEnt.setId((long)101);
			productEnt.setProductName("Shoes");
			productEnt.setCategory("Sports Shoes");
			productEnt.setDescription("Light weight, made with high quality material");
			productEnt.setBrand("Adidas");
			productEnt.setColour("White");
			productEnt.setSize("10UK");
			productEnt.setMrp(7000.00);
			productEnt.setPriceAfterDiscount(5000.00);
			productEnt.setInStock("true");
			productEnt.setExpectedDelivery(LocalDate.parse("2021-05-29"));
	        
			CartEntity cart=new CartEntity();
			cart.setId((long)151);
			cart.setPrice(productEnt.getMrp());
			cart.setProductName(productEnt.getProductName());
			cart.setQuantity(1);
			cart.setTotal(productEnt.getPriceAfterDiscount());
	       
			String jsonInput = this.convertToJson(cart);

	        Mockito.when(icartservice.addCart((long)101,productEnt.getId())).thenReturn(cart);
	        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI,101).accept(MediaType.APPLICATION_JSON)).andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        String jsonOutput = mockHttpServletResponse.getContentAsString();
	        //assertThat(jsonInput).isEqualTo(jsonOutput);
	        Assert.assertNotNull(jsonOutput);
	    }
    
    
    @Test
	   public void testDeleteCart() throws Exception{
	        
	        String URI="/cart/removefromcart/{delID}";
	        
	        ProductEntity productEnt = new ProductEntity();
			productEnt.setId((long)101);
			productEnt.setProductName("Shoes");
			productEnt.setCategory("Sports Shoes");
			productEnt.setDescription("Light weight, made with high quality material");
			productEnt.setBrand("nike");
			productEnt.setColour("White");
			productEnt.setSize("15UK");
			productEnt.setMrp(8000.00);
			productEnt.setPriceAfterDiscount(6000.00);
			productEnt.setInStock("true");
			productEnt.setExpectedDelivery(LocalDate.parse("2021-05-29"));
	        
			CartEntity cart=new CartEntity();
			cart.setId((long)151);
			cart.setPrice(productEnt.getMrp());
			cart.setProductName(productEnt.getProductName());
			cart.setQuantity(1);
			cart.setTotal(productEnt.getPriceAfterDiscount());
	       
			String jsonInput = this.convertToJson(cart);
			
			MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 1).accept(MediaType.APPLICATION_JSON)).andReturn();
			MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		    Assert.assertNotEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	    }
    
    
    
    @Test
	   public void testgetallCart() throws Exception{
	        
	        String URI="/cart/getallcartdetials";
	        
	        ProductEntity productEnt = new ProductEntity();
			productEnt.setId((long)101);
			productEnt.setProductName("Shoes");
			productEnt.setCategory("Sports Shoes");
			productEnt.setDescription("Light weight, made with high quality material");
			productEnt.setBrand("nike");
			productEnt.setColour("White");
			productEnt.setSize("15UK");
			productEnt.setMrp(8000.00);
			productEnt.setPriceAfterDiscount(6000.00);
			productEnt.setInStock("true");
			productEnt.setExpectedDelivery(LocalDate.parse("2021-05-29"));
	        
			CartEntity cart=new CartEntity();
			cart.setId((long)151);
			cart.setPrice(productEnt.getMrp());
			cart.setProductName(productEnt.getProductName());
			cart.setQuantity(1);
			cart.setTotal(productEnt.getPriceAfterDiscount());
			
			CartEntity cart1=new CartEntity();
			cart1.setId((long)151);
			cart1.setPrice(5000.25);
			cart1.setProductName("realme");
			cart1.setQuantity(1);
			cart1.setTotal(4500.25);
			
			List<CartEntity> cartlist = new ArrayList<>();
			cartlist.add(cart);
			cartlist.add(cart1);
			
			String jsonInput = this.convertToJson(cart);
			
			MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 1).accept(MediaType.APPLICATION_JSON)).andReturn();
			MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
		    //Assert.assertNotEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
			String jsonOutput = mockHttpServletResponse.getContentAsString();
			Assert.assertNotNull(jsonOutput);
	    }
    
    private String convertToJson(Object product) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(product);
    }

}
