package com.example.onlinesportshopee.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.*;

import com.example.onlinesportshopee.entities.CartEntity;

@Repository
public interface ICartRepository extends JpaRepository<CartEntity,Long>{
	
	@Query(value = "SELECT * FROM cart c WHERE c.cust_id = ?1",nativeQuery = true)
	List<CartEntity> findByCustId(Long custId);
	
	@Query(value = "DELETE FROM cart c WHERE c.cust_id = ?1",nativeQuery = true)
	List<CartEntity> deleteByCustId(Long custId);

}
