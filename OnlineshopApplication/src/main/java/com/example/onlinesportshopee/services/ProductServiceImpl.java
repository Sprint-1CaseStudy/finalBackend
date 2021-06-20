package com.example.onlinesportshopee.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinesportshopee.dao.IProductRepository;
import com.example.onlinesportshopee.entities.ProductEntity;
import com.example.onlinesportshopee.exception.ProductNotFoundException;


@Service
public class ProductServiceImpl implements IProductService {
	
	static final Logger LOGGER = LoggerFactory.getLogger(ProductServiceImpl.class);
	
	
	@Autowired 
	private IProductRepository iProductRepository;
	
	@Override
	public ProductEntity addProduct(ProductEntity product) throws ProductNotFoundException{
		LOGGER.info("addProduct() serivice is initiated");
     //ProductEntity productEntity = ProductUtils.convertToProduct(product);
     /*if(product == null)
    	 productEntity = null;
     else {*/
    	 product = iProductRepository.save(product);

     LOGGER.info("addProduct() service has executed");
     return product;
     
	}

	@Override
	public boolean removeProduct(Long productId) throws ProductNotFoundException{
		LOGGER.info("removeProduct() serivice is initiated");
		ProductEntity delProduct = iProductRepository.findById(productId).get();
		iProductRepository.delete(delProduct);
		LOGGER.info("removeProduct() service has executed");
		
		if(null == delProduct){
            return true;
        }
		return false;
	}

	
	@Override
	public ProductEntity updateProduct(Long productId, ProductEntity product)throws ProductNotFoundException {
		LOGGER.info("updateProduct() serivice is initiated");
		ProductEntity updateProduct = iProductRepository.findById(productId).orElse(null);
		if(updateProduct == null)
		{
			String prodnotfound = "Product Not Found";
			throw new ProductNotFoundException(prodnotfound);
		}	
		else {
			if(updateProduct.getProductName().equals(product.getProductName()))
			{
				iProductRepository.delete(updateProduct);
				LOGGER.info("updateProduct() service has executed");
				return iProductRepository.save(product);
			} else {
				throw new ProductNotFoundException("enter valid Productname");
			}
		}
	}

	@Override
	public ProductEntity getProduct(Long productId) throws ProductNotFoundException{
		LOGGER.info("getProduct() serivice is initiated");
		ProductEntity getProduct = iProductRepository.findById(productId).get();
		LOGGER.info("getProduct() service has executed");
		return getProduct;
	}

	@Override
	public List<ProductEntity> getAllProduct() throws ProductNotFoundException{
		LOGGER.info("getAllProduct() serivice is initiated");
		List<ProductEntity> getAllProduct = iProductRepository.findAll();
		LOGGER.info("getAllProduct() service has executed");
		return getAllProduct;
	}
	
	@Override
	public List<ProductEntity> getProductsByName(String name) throws ProductNotFoundException
	{
		LOGGER.info("getProductByName() serivice is initiated");
		List<ProductEntity> getProductName = iProductRepository.findByName(name);
		if (getProductName == null)
		{
			String namenotfound = "No products found by the name "+name;
			throw new ProductNotFoundException(namenotfound);
		}
		LOGGER.info("getProductByName() service has executed");
		return getProductName;
	}
	
	
	@Override
	public List<ProductEntity> getProductsBySize(String size) throws ProductNotFoundException
	{
		LOGGER.info("getProductBySize() serivice is initiated");
		List<ProductEntity> productSize = iProductRepository.findBySize(size);
		if (productSize == null)
		{
			String sizenotfound = "No products found by the size "+size;
			throw new ProductNotFoundException(sizenotfound);
		}
		LOGGER.info("getProductBySize() service has executed");
		return productSize;
	}
	
	@Override
	public List<ProductEntity> getProductsByPrice(Double price) throws ProductNotFoundException
	{
		LOGGER.info("getProductByPrice() serivice is initiated");
		List<ProductEntity> productPrice = iProductRepository.findByPrice(price);
		if (productPrice == null)
		{
			String pricenotfound = "No products found by the price "+price;
			throw new ProductNotFoundException(pricenotfound);
		}
		LOGGER.info("getProductByPrice() service has executed");
		return productPrice;
		
	}
	
	@Override
	public List<ProductEntity> getProductsByColor(String color) throws ProductNotFoundException
	{
		LOGGER.info("getProductByColor() serivice is initiated");
		List<ProductEntity> productColor = iProductRepository.findByColor(color);
		if (productColor == null)
		{
			String colornotfound = "No products found by the color "+color;
			throw new ProductNotFoundException(colornotfound);
		}
		LOGGER.info("getProductByColor() service has executed");
		return productColor;
	}

	
}
