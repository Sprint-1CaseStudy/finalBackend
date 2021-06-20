package com.example.onlinesportshopee.services;

import java.util.List;

import com.example.onlinesportshopee.entities.CustomerEntity;
import com.example.onlinesportshopee.entities.UserEntity;
import com.example.onlinesportshopee.exception.CustomerNotFoundException;
import com.example.onlinesportshopee.exception.UserNotFoundException;

public interface ICustomerService {

		public CustomerEntity addCustomer(CustomerEntity customer) throws CustomerNotFoundException;
		public CustomerEntity removeCustomer(Long custId) throws CustomerNotFoundException;
		public CustomerEntity updateCustomer(Long custId,CustomerEntity customer) throws CustomerNotFoundException;
		public CustomerEntity getCustomer(Long custId) throws CustomerNotFoundException;
		public List<CustomerEntity> getAllCustomers(); 
		public CustomerEntity login(CustomerEntity customer) throws CustomerNotFoundException;
		public String signOut();
		public CustomerEntity changePassword(CustomerEntity customer) throws CustomerNotFoundException;
}
