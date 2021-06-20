package com.example.onlinesportsshopee.service;

import java.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.onlinesportshopee.dao.ICustomerRepository;
import com.example.onlinesportshopee.entities.CustomerEntity;
import com.example.onlinesportshopee.exception.CustomerNotFoundException;
import com.example.onlinesportshopee.exception.InvalidCustomerIdException;
import com.example.onlinesportshopee.services.CustomerServiceImpl;
import com.example.onlinesportshopee.services.ICustomerService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CustomerServiceImpl.class)
class CustomerServiceImplTest {
//
		@MockBean
		ICustomerRepository iCustomerRepository;
		
		@Autowired
		ICustomerService iCustomerService;
		
		@Test
		void testaddCustomer01() throws CustomerNotFoundException,InvalidCustomerIdException {
			CustomerEntity customerentity = new CustomerEntity();
			customerentity.setId((long)123);
	        customerentity.setName("Babu");
	        customerentity.setGmail("Babu@gmail.com");
	        customerentity.setContactNo("9567893321");
	        customerentity.setDoB(LocalDate.parse("1997-10-12"));
			
			Mockito.when(iCustomerRepository.save(customerentity)).thenReturn(customerentity);
	        Assert.assertNotNull(customerentity);
		}
		
		@Test
		void testremoveCustomer01() throws InvalidCustomerIdException {
			CustomerEntity customerentity = new CustomerEntity();
			customerentity.setId((long)124);
	        customerentity.setName("Chakri");
	        customerentity.setGmail("Chakri@gmail.com");
	        customerentity.setContactNo("9354698711");
	        customerentity.setDoB(LocalDate.parse("1998-06-21"));
	        
	        Mockito.when(iCustomerRepository.save(customerentity)).thenReturn(customerentity);
	        iCustomerRepository.deleteById(customerentity.getId());
	        Assert.assertNotEquals(customerentity, new CustomerEntity());
		}
		
		@Test
		void testUpdateCustomer01() throws CustomerNotFoundException,InvalidCustomerIdException {
			CustomerEntity customerentity = new CustomerEntity();
			customerentity.setId((long)125);
	        customerentity.setName("Azeem");
	        customerentity.setGmail("Azeem@gmail.com");
	        customerentity.setContactNo("9564237891");
	        customerentity.setDoB(LocalDate.parse("1997-01-31"));
	        
	        iCustomerRepository.save(customerentity);
	        Assert.assertNotNull(customerentity);
		}
		
		@Test
		void testgetCustomer01() throws InvalidCustomerIdException {
			CustomerEntity customerentity = new CustomerEntity();
			//customerentity.setId((long)126);
			customerentity.setName("Pooja");
	        customerentity.setGmail("pooja@gmail.com");
	        customerentity.setContactNo("9654789912");
	        customerentity.setDoB(LocalDate.parse("1998-12-19"));
	        
	        CustomerEntity customerentity2 = iCustomerRepository.save(customerentity);
	        Assert.assertNotEquals(customerentity2,customerentity);
		}
		
		@Test
		void testgetAllCustomers01() {
			CustomerEntity customerentity1 = new CustomerEntity();
			customerentity1.setId((long)125);
	        customerentity1.setName("Azeem");
	        customerentity1.setGmail("Azeem@gmail.com");
	        customerentity1.setContactNo("9564237891");
	        customerentity1.setDoB(LocalDate.parse("1997-01-31"));
	        
	        CustomerEntity customerentity2 = new CustomerEntity();
			customerentity2.setId((long)125);
	        customerentity2.setName("Azeem");
	        customerentity2.setGmail("Azeem@gmail.com");
	        customerentity2.setContactNo("9564237891");
	        customerentity2.setDoB(LocalDate.parse("1997-01-31"));
	        
	        List<CustomerEntity> customerlist = new ArrayList();
	        customerlist.add(customerentity1);
	        customerlist.add(customerentity2);
	        Mockito.when(iCustomerRepository.findAll()).thenReturn(customerlist);
		}

}
//