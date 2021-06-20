package com.example.onlinesportshopee.services;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinesportshopee.controller.CartController;
import com.example.onlinesportshopee.dao.ICartRepository;
import com.example.onlinesportshopee.dao.IProductRepository;
import com.example.onlinesportshopee.entities.CartEntity;
import com.example.onlinesportshopee.entities.ProductEntity;
import com.example.onlinesportshopee.exception.CartNotFoundException;

@Service
public class CartServiceImpl implements ICartService {
	
	static final Logger LOGGER = LoggerFactory.getLogger(CartController.class);
	
	@Autowired 
	private ICartRepository iCartRepository;
	
	@Autowired 
	private IProductRepository iProductRepository;
	
	
	@Override
	public CartEntity addCart(Long custId, Long prodID) throws CartNotFoundException {
		LOGGER.info("addtocart() service is initiated"); 
		ProductEntity proEntity = iProductRepository.findById(prodID).orElse(null);
		CartEntity carEntity = null;
		if(proEntity==null)
			throw new CartNotFoundException("No products found by id");
		else {
			CartEntity cartEntity = new CartEntity(proEntity.getProductName(),1,proEntity.getMrp(),proEntity.getPriceAfterDiscount(),custId);;
			carEntity = iCartRepository.save(cartEntity);
		}
		LOGGER.info("addtocart() service has Executed");
		return carEntity;
	}

	@Override
	public CartEntity deleteCart(Long id) throws CartNotFoundException {
		LOGGER.info("deletecart() service is initiated");
		CartEntity carEntity = iCartRepository.findById(id).orElse(null);
		if (carEntity == null)
			throw new CartNotFoundException("CartNotFound");
		else
			iCartRepository.delete(carEntity);
		LOGGER.info("deletecart() service has Executed");
		return carEntity;
	}


	@Override
	public List<CartEntity> getallCartDetails() {
		LOGGER.info("getallcartdetails() service is initiated");
		List<CartEntity> cartList = iCartRepository.findAll();
		LOGGER.info("getallcartdetails() has Executed");
		return cartList;
	}

	@Override
	public List<CartEntity> getCart(Long custId) {
		LOGGER.info("getCart() service is initiated");
		List<CartEntity> carEntity = iCartRepository.findByCustId(custId);
		LOGGER.info("getcartdetails() has Executed");
		return carEntity;
	}

}
