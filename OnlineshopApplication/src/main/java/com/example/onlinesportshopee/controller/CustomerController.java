package com.example.onlinesportshopee.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.onlinesportshopee.entities.CustomerEntity;
import com.example.onlinesportshopee.entities.UserEntity;
import com.example.onlinesportshopee.exception.CustomerNotFoundException;
import com.example.onlinesportshopee.exception.UserNotFoundException;
import com.example.onlinesportshopee.services.ICustomerService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/onlinesportshopee")
public class CustomerController 
{
	static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	private ICustomerService iCustomerService;
	
	@PostMapping("/customers/addCustomer")
	public ResponseEntity<CustomerEntity> addCustomer(@RequestBody CustomerEntity customer) throws CustomerNotFoundException {
		LOGGER.info("addCustomer URL is opened");
		LOGGER.info("addCustomer() is initiated");
		CustomerEntity customerDTO = null;
		ResponseEntity<CustomerEntity> customerResponse = null;
		customerDTO = iCustomerService.addCustomer(customer);
		customerResponse = new ResponseEntity<CustomerEntity>(customerDTO, HttpStatus.ACCEPTED);
		LOGGER.info("addCustomer() is executed");
		return customerResponse;
	}
	
	@DeleteMapping("/customers/removeCustomer/Customer/{custId}")
	public ResponseEntity<CustomerEntity> removeCustomer(@PathVariable Long custId) throws CustomerNotFoundException {
		LOGGER.info("removeCustomer URL is opened");
		LOGGER.info("removeCustomer() is initiated");
		CustomerEntity customerDTO = null;
		ResponseEntity<CustomerEntity> customerResponse = null;
		customerDTO = iCustomerService.removeCustomer(custId);
		customerResponse = new ResponseEntity<CustomerEntity>(customerDTO, HttpStatus.ACCEPTED);
		LOGGER.info("removeCustomer() is executed");
		return customerResponse;
	}

	@PutMapping("/customers/updateCustomer/{custId}")
	public ResponseEntity<CustomerEntity> updateCustomer(@PathVariable Long custId,@RequestBody CustomerEntity customer) throws CustomerNotFoundException {
		LOGGER.info("updateCustomer URL is opened");
		LOGGER.info("updateCustomer() is initiated");
		CustomerEntity customerDTO = null;
		ResponseEntity<CustomerEntity> customerResponse = null;
		customerDTO = iCustomerService.updateCustomer(custId, customer);
		customerResponse = new ResponseEntity<CustomerEntity>(customerDTO, HttpStatus.ACCEPTED);
		LOGGER.info("updateCustomer() is executed");
		return customerResponse;
	}

	@GetMapping("/customers/getCustomerDetails/{custId}")
	public ResponseEntity<CustomerEntity> getCustomer(@PathVariable Long custId) throws CustomerNotFoundException {
		LOGGER.info("getCustomerDetails URL is opened");
		LOGGER.info("getCustomer() is initiated");
		CustomerEntity customerDTO = null;
		ResponseEntity<CustomerEntity> customerResponse = null;
		customerDTO = iCustomerService.getCustomer(custId);
		customerResponse = new ResponseEntity<CustomerEntity>(customerDTO, HttpStatus.ACCEPTED);
		LOGGER.info("getCustomer() is executed");
		return customerResponse;
	}

	@GetMapping("/customers/Customers")
    public List<CustomerEntity> getAllCustomers() {
        LOGGER.info("Customers URL is opened");
        LOGGER.info("getAllCustomers() is initiated");
        LOGGER.info("getAllCustomers() has executed");
        //ResponseEntity<Object> customerResponse = null;
        return (List<CustomerEntity>)iCustomerService.getAllCustomers();
	}
	
	@PostMapping("/customers/login")
	public ResponseEntity<CustomerEntity> login(@RequestBody CustomerEntity customer) throws CustomerNotFoundException {
		LOGGER.info("login URL is opened");
		LOGGER.info("login() is initiated");
		CustomerEntity customerDTO = iCustomerService.login(customer);
		LOGGER.info("login() is executed");
		return new ResponseEntity<CustomerEntity>(customerDTO, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/customers/signout")
    public ResponseEntity<String> signOut() throws CustomerNotFoundException
    {
        LOGGER.info("sign-out URL is opened");
        LOGGER.info("signout() is initiated");
        String signout = iCustomerService.signOut(); 
        LOGGER.info("signout() has Executed");
        return new ResponseEntity<String>(signout,HttpStatus.ACCEPTED);
    }
	
	@PutMapping("/customers/changepassword")
    public ResponseEntity<CustomerEntity> changePassword(@RequestBody CustomerEntity User) throws UserNotFoundException, CustomerNotFoundException
    {
        LOGGER.info("changepassword URL is opened");
        LOGGER.info("changepassword() is initiated");
        CustomerEntity user = iCustomerService.changePassword(User);
        LOGGER.info("changepassword() has Executed");
        return new ResponseEntity<CustomerEntity>(user,HttpStatus.ACCEPTED);
    }
}
