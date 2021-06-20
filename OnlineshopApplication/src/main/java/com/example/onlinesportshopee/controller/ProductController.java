package com.example.onlinesportshopee.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.onlinesportshopee.entities.ProductEntity;
import com.example.onlinesportshopee.exception.InvalidProductInputException;
import com.example.onlinesportshopee.exception.ProductNotFoundException;
import com.example.onlinesportshopee.services.IProductService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/onlinesportshopee")
public class ProductController {
	
	static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private IProductService iProductService;
	
	@PostMapping("/products/addproduct")
	public ProductEntity addProduct(@RequestBody ProductEntity product) throws ProductNotFoundException
	{
		LOGGER.info("addProduct URL is opened");
		LOGGER.info("addProduct() is initiated");
		ProductEntity addProduct = iProductService.addProduct(product);
		LOGGER.info("addProduct() has Executed");
		return addProduct;
		
	}
	
	@DeleteMapping("/products/removeproduct/product/{productId}")
	public boolean removeProduct(@PathVariable long productId) throws ProductNotFoundException, InvalidProductInputException
	{
		LOGGER.info("removeProduct URL is opened");
		LOGGER.info("removeProduct() is initiated");
		boolean deleteProduct = iProductService.removeProduct(productId);
		LOGGER.info("removeProduct() has Executed");
		return deleteProduct;
	 
	}
	
	@PutMapping("/products/updateproduct")

	public ProductEntity updateProduct(@PathVariable Long productId, @RequestBody ProductEntity product) throws ProductNotFoundException, InvalidProductInputException
	{
		LOGGER.info("updateProduct URL is opened");
		LOGGER.info("updateProduct() is initiated");
		ProductEntity updateProduct = iProductService.updateProduct(productId, product);
		LOGGER.info("updateProduct() has Executed");
		return updateProduct;
		
	}
	
	@GetMapping("/products/getproduct/{productId}")
	public ProductEntity getProduct(@PathVariable Long productId) throws ProductNotFoundException, InvalidProductInputException
	{
		LOGGER.info("getProduct URL is opened");
		LOGGER.info("getProduct() is initiated");
		ProductEntity getProduct = iProductService.getProduct(productId);
		LOGGER.info("getProduct() has Executed");
		return getProduct;
	}
	
	@GetMapping("/products/getallproduct")
	public List<ProductEntity> getAllProduct() throws ProductNotFoundException
	{
		LOGGER.info("getAllProducts URL is opened");
		List<ProductEntity> getAllProducts = iProductService.getAllProduct();
		LOGGER.info("getAllProducts() is initiated");
		return getAllProducts;
	}
	
	
	@GetMapping("/products/byname/{name}")
	public List<ProductEntity> getProductsByName(@PathVariable String name) throws ProductNotFoundException, InvalidProductInputException
	{
		LOGGER.info("Productbyname URL is opened");
		LOGGER.info("Productbyname() is initiated");
			List<ProductEntity> getProductsByName = iProductService.getProductsByName(name);
		LOGGER.info("Productbyname() has Executed");
		return getProductsByName;
	}
	
	@GetMapping("/products/bysize/{size}")
	public List<ProductEntity> getProductsBySize(@PathVariable String size) throws ProductNotFoundException
	{
		LOGGER.info("Productbysize URL is opened");
		LOGGER.info("Productbysize() is initiated");
		List<ProductEntity> getProductBySize = iProductService.getProductsBySize(size);

		LOGGER.info("Productbysize() has Executed");
		return getProductBySize;
	}
	
	@GetMapping("/products/byprice/{price}")
	public List<ProductEntity> getProductsByPrice(@PathVariable double price) throws ProductNotFoundException
	{
		LOGGER.info("Productbyprice URL is opened");
		LOGGER.info("Productbyprice() is initiated");
		List<ProductEntity> getProductByPrice = iProductService.getProductsByPrice(price);
		LOGGER.info("Productbyprice() has Executed");
		return getProductByPrice;
	}
	
	@GetMapping("/products/bycolor/{color}")
	public List<ProductEntity> getProductsByColor(@PathVariable String color) throws ProductNotFoundException
	{
		LOGGER.info("Productbycolor URL is opened");
		LOGGER.info("Productbycolor() is initiated");
		List<ProductEntity> getProductByColor = iProductService.getProductsByColor(color);
		
		LOGGER.info("Productbycolor() has Executed");
		return getProductByColor;
	}
}
