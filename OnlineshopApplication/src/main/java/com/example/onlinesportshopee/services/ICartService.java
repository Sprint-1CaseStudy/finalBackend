package com.example.onlinesportshopee.services;

import java.util.List;
import com.example.onlinesportshopee.entities.CartEntity;
import com.example.onlinesportshopee.exception.CartNotFoundException;

public interface ICartService {
	
		public CartEntity addCart(Long custId, Long prodID) throws CartNotFoundException;
		public CartEntity deleteCart(Long id) throws CartNotFoundException;
		public List<CartEntity> getallCartDetails();
		public List<CartEntity> getCart(Long custId);

}
