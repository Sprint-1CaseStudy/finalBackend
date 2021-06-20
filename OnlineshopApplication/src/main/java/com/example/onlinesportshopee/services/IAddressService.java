package com.example.onlinesportshopee.services;

import java.util.List;

import com.example.onlinesportshopee.entities.AddressEntity;

import com.example.onlinesportshopee.exception.AddressNotFoundException;

public interface IAddressService {
	public AddressEntity addAddress(AddressEntity address) throws AddressNotFoundException;
	public AddressEntity removeAddress(long custId) throws AddressNotFoundException;
	public AddressEntity updateAddress(long custId, AddressEntity address) throws AddressNotFoundException;
	public List<AddressEntity> getaddress(Long custId) throws AddressNotFoundException;
	public List<AddressEntity> getAllAddress() throws AddressNotFoundException;
	public AddressEntity getbyaddressId(Long addressId) throws AddressNotFoundException;
	
}
//