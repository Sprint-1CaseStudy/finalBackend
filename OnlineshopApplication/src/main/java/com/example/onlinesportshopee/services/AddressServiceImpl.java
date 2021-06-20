package com.example.onlinesportshopee.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.onlinesportshopee.dao.IAddressRepository;
import com.example.onlinesportshopee.entities.AddressEntity;
import com.example.onlinesportshopee.exception.AddressNotFoundException;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AddressServiceImpl implements IAddressService {
//
	static final Logger LOGGER = LoggerFactory.getLogger(AddressServiceImpl.class);
	
	@Autowired
	private IAddressRepository iaddressRepository;
	
	@Override
	public AddressEntity addAddress(AddressEntity address) throws AddressNotFoundException {
		LOGGER.info("addAddress() service is initiated");
		AddressEntity addressentity;
		if(address == null)
			addressentity = null;
		else {
			addressentity = iaddressRepository.save(address);
		}
		LOGGER.info("addAddress() service has executed");
		return addressentity;
	}
	
	@Override
	public AddressEntity removeAddress(long custId) throws AddressNotFoundException{
		LOGGER.info("removeAddress() service is initiated");
		AddressEntity existaddress = iaddressRepository.findById(custId).orElse(null);
		if(existaddress == null)
		{
			throw new AddressNotFoundException("AddressNotFound");
		}
		else {
			iaddressRepository.delete(existaddress);
		}
		LOGGER.info("removeAddress() service has executed");
		return existaddress;
	}
	
	@Override
	public AddressEntity updateAddress(long custId, AddressEntity address) throws AddressNotFoundException{
		// TODO Auto-generated method stub
		LOGGER.info("updateAddress() service is initiated");
		AddressEntity updateaddress = iaddressRepository.findById(custId).orElse(null);
		if(updateaddress == null)
		{
			String addnotfound = "Address Not Found";
			throw new AddressNotFoundException(addnotfound);
		}
		else {
			if(updateaddress.getPincode().equals(address.getPincode()))
			{
				address.setCustId(updateaddress.getCustId());
				iaddressRepository.deleteById(updateaddress.getId());
				LOGGER.info("updateAddress() service has executed");
				return iaddressRepository.save(address);
			}
			else {
				throw new AddressNotFoundException("Pincode is Invalid");
			}
		}
	}
	
	@Override
	public List<AddressEntity> getAllAddress() throws AddressNotFoundException{
		LOGGER.info("getAddress() service is initiated");
		List<AddressEntity> getAddress = iaddressRepository.findAll();;
		if(getAddress == null)
		{
			throw new AddressNotFoundException("AddressNotFound");
		}
		LOGGER.info("getAddress() service has executed");
		return getAddress;
	}
	
	@Override
	public List<AddressEntity> getaddress(Long custId) throws AddressNotFoundException{
		LOGGER.info("getCart() service is initiated");
		List<AddressEntity> addressEntity = iaddressRepository.findByCustId(custId);
		LOGGER.info("getcartdetails() has Executed");
		return addressEntity;
	}

	@Override
	public AddressEntity getbyaddressId(Long addressId) throws AddressNotFoundException {
		LOGGER.info("getbyaddressId() service is initiated");
		AddressEntity getbyaddressId = iaddressRepository.findById(addressId).orElse(null);
		if(getbyaddressId == null)
		{
			throw new AddressNotFoundException("addressNotFound");
		}
		LOGGER.info("getbyaddressId() service has executed");
		return getbyaddressId;
	}
	
}
