package com.example.onlinesportshopee.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinesportshopee.dao.ICustomerRepository;
import com.example.onlinesportshopee.entities.CustomerEntity;
import com.example.onlinesportshopee.entities.UserEntity;
import com.example.onlinesportshopee.exception.CustomerNotFoundException;
import com.example.onlinesportshopee.exception.UserNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class CustomerServiceImpl implements ICustomerService {
//
	static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);
		
	@Autowired
	private ICustomerRepository icustomerRepository;
	
	public CustomerEntity addCustomer(CustomerEntity customer) throws CustomerNotFoundException {
		LOGGER.info("addCustomer() service is initiated");
		/*if(customer == null)
			customerentity = null;
		else {*/
		CustomerEntity customerentity = icustomerRepository.save(customer);
		LOGGER.info("addCustomer() service has executed");
		return customerentity;
	}

	@Override
	public CustomerEntity removeCustomer(Long custId) throws CustomerNotFoundException{
		LOGGER.info("removeCustomer() service is initiated");
		CustomerEntity existcustomer = icustomerRepository.findById(custId).orElse(null);
			icustomerRepository.delete(existcustomer);
		LOGGER.info("removeCustomer() service has executed");
		return existcustomer;
	}

	@Override
	public CustomerEntity updateCustomer(Long custId, CustomerEntity customer) throws CustomerNotFoundException{
		// TODO Auto-generated method stub
		LOGGER.info("updateCustomer() service is initiated");
		CustomerEntity updatecustomer = icustomerRepository.findById(custId).orElse(null);
		if(updatecustomer == null)
		{
			String custnotfound = "Customer Not Found";
			throw new CustomerNotFoundException(custnotfound);
		}	
		else {
			if(updatecustomer.getGmail().equals(customer.getGmail()) && updatecustomer.getPassword().equals(customer.getPassword()))
			{
				icustomerRepository.updateById(updatecustomer.getId(), customer.getContactNo(), customer.getDoB());
				LOGGER.info("updateCustomer() service has executed");
				return icustomerRepository.findById(updatecustomer.getId()).orElse(null);
			} else {
				throw new CustomerNotFoundException("enter valid username");
			}
		}
	}

	@Override
	public CustomerEntity getCustomer(Long custId) throws CustomerNotFoundException{
		LOGGER.info("getCustomer() service is initiated");
		CustomerEntity getCustomer = icustomerRepository.findById(custId).orElse(null);
		if(getCustomer == null)
		{
			throw new CustomerNotFoundException("CustomerNotFound");
		}
		LOGGER.info("getCustomer() service has executed");
		return getCustomer;
	}

	@Override
	public List<CustomerEntity> getAllCustomers() {
		LOGGER.info("getAllCustomer() service is initiated");
		List<CustomerEntity> custlist = icustomerRepository.findAll();
		LOGGER.info("getAllCustomer() service has executed");
		return custlist;
	}

	@Override
	public CustomerEntity login(CustomerEntity customer) throws CustomerNotFoundException {
		LOGGER.info("login() service is initiated");
		CustomerEntity customerentity = icustomerRepository.findByGmail(customer.getGmail());
		if (customerentity == null)
        {
            String customernotfound = "No customer found by the userid "+customer.getGmail();
            throw new CustomerNotFoundException(customernotfound);
        }
        else 
        {
            if(customer.getGmail().equals(customerentity.getGmail()) && customer.getPassword().equals(customerentity.getPassword())) 
            {
                LOGGER.info("login() service has Executed");
                return customerentity;
            }
            else {
                throw new CustomerNotFoundException("User name and password are invalid");
            }
        }
	}

	@Override
	public String signOut() {
		LOGGER.info("signout() service is initiated");
        return "Signout Successfully";
	}	
	
	@Override
    public CustomerEntity changePassword(CustomerEntity customer) throws CustomerNotFoundException {
        LOGGER.info("changepassword() service is initiated");
        CustomerEntity changePassword = icustomerRepository.findByGmail(customer.getGmail());
        if(changePassword == null)
        {
            String custnotfound = "No user found by the userid ";
            throw new CustomerNotFoundException(custnotfound);
        }
        else
        {
        	if(changePassword.getName().equals(customer.getName()))
        	{
        		
        		icustomerRepository.updateByPassword(changePassword.getId(),customer.getPassword());
        		LOGGER.info("changepassword() service has Executed");
                return icustomerRepository.findById(changePassword.getId()).orElse(null);
        	}
        	else
        	{
        		throw new CustomerNotFoundException("enter valid username");
        	}
        }
        
    }
}
