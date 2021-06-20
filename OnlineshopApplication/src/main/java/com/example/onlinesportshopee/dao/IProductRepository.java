package com.example.onlinesportshopee.dao;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.onlinesportshopee.entities.ProductEntity;


@Repository
public interface IProductRepository extends JpaRepository<ProductEntity,Long> {

	 @Query(value = "SELECT * FROM products p WHERE p.product_name = ?1",nativeQuery = true)
	 List<ProductEntity> findByName(String name);
	 
	 @Query(value = "SELECT * FROM products p WHERE p.product_size = ?1",nativeQuery = true)
	 List<ProductEntity> findBySize(String size);

	 @Query(value = "SELECT * FROM products p WHERE p.product_mrp = ?1",nativeQuery = true)
	 List<ProductEntity> findByPrice(double price);
	 
	 @Query(value = "SELECT * FROM products p WHERE p.product_colour = ?1",nativeQuery = true)
	 List<ProductEntity> findByColor(String color);
}
