package com.example.onlinesportshopee.services;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.example.onlinesportshopee.entities.ProductEntity;
import com.example.onlinesportshopee.exception.ProductNotFoundException;



public interface IProductService {

	public ProductEntity addProduct(ProductEntity product) throws ProductNotFoundException;
	public boolean removeProduct(Long productId) throws ProductNotFoundException;
	public ProductEntity updateProduct(Long productId, ProductEntity product) throws ProductNotFoundException;
	public ProductEntity getProduct(Long productId) throws ProductNotFoundException;
	public List<ProductEntity> getAllProduct() throws ProductNotFoundException;
	
	List<ProductEntity> getProductsByName(String name) throws ProductNotFoundException;
	List<ProductEntity> getProductsBySize(String size) throws ProductNotFoundException;
	List<ProductEntity> getProductsByPrice(Double price) throws ProductNotFoundException;
	List<ProductEntity> getProductsByColor(String color) throws ProductNotFoundException;	
	
}
