package com.example.onlinesportshopee.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.onlinesportshopee.entities.AddressEntity;

@Repository
public interface IAddressRepository extends JpaRepository<AddressEntity, Long> {

	@Query(value = "SELECT * FROM address a WHERE a.cust_id = ?1",nativeQuery = true)
	List<AddressEntity> findByCustId(Long custId);
}
//