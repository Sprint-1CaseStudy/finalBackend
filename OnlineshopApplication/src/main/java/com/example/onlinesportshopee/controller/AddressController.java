package com.example.onlinesportshopee.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.onlinesportshopee.entities.AddressEntity;
import com.example.onlinesportshopee.exception.AddressNotFoundException;
import com.example.onlinesportshopee.services.AddressServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/onlinesportshopee")

public class AddressController {
	
	static final Logger LOGGER = LoggerFactory.getLogger(AddressController.class);
	
	@Autowired
	private AddressServiceImpl AddressServiceImpl;

	@PostMapping("/address/addAddress/{custId}")
	public ResponseEntity<Object> addAddress(@PathVariable long custId, @RequestBody AddressEntity address) throws AddressNotFoundException {
		LOGGER.info("addAddress URL is opened");
		LOGGER.info("addAddress() is initiated");
		address.setCustId(custId);
		AddressEntity addressDTO = AddressServiceImpl.addAddress(address);
		LOGGER.info("addAddress() has executed");
		return new ResponseEntity<>(addressDTO, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/address/removeAddress/Address/{custId}")
	public ResponseEntity<Object> removeAddress(@PathVariable long custId) throws AddressNotFoundException {
		LOGGER.info("removeAddress URL is opened");
		LOGGER.info("removeAddress() is initiated");
		AddressEntity addressDTO = null;
		ResponseEntity<Object> addressResponse = null;
		addressDTO = AddressServiceImpl.removeAddress(custId);
		addressResponse = new ResponseEntity<>(addressDTO, HttpStatus.ACCEPTED);
		LOGGER.info("removeAddress() has executed");
		return addressResponse;
	}

	@PutMapping("/address/updateAddress")
	public ResponseEntity<Object> updateAddress(@PathVariable long custId,@RequestBody AddressEntity address) throws AddressNotFoundException {
		LOGGER.info("updateAddress URL is opened");
		LOGGER.info("updateAddress() is initiated");
		AddressEntity addressDTO = null;
		ResponseEntity<Object> addressResponse = null;
		addressDTO = AddressServiceImpl.updateAddress(custId,address);
		addressResponse = new ResponseEntity(addressDTO, HttpStatus.ACCEPTED);
		LOGGER.info("updateAddress() has executed");
		return addressResponse;
	}

	@GetMapping("/address/getAddressDetails")
	public ResponseEntity<Object> getAddress() throws AddressNotFoundException {
		LOGGER.info("getAddressDetails URL is opened");
		LOGGER.info("getAddress() is initiated");
		List<AddressEntity> addressDTO = null;
		ResponseEntity<Object> addressResponse = null;
		addressDTO = AddressServiceImpl.getAllAddress();
		addressResponse = new ResponseEntity(addressDTO, HttpStatus.ACCEPTED);
		LOGGER.info("getAddress() has executed");
		return addressResponse;
	}
	
	@GetMapping("/address/getaddressDetails/{custId}")
	public List<AddressEntity> getCartdetails(@PathVariable Long custId) throws AddressNotFoundException {
		LOGGER.info("getaddressDetails URL is opened");
		LOGGER.info("getaddress() has Executed");
	    return AddressServiceImpl.getaddress(custId);
	}
	
	@GetMapping("/address/getaddressbyId/{addId}")
	public AddressEntity getaddressbyId(@PathVariable Long addId) throws AddressNotFoundException {
		LOGGER.info("getaddressbyId URL is opened");
		LOGGER.info("getaddressbyId() has Executed");
	    return AddressServiceImpl.getbyaddressId(addId);
	}
	
	//

}
