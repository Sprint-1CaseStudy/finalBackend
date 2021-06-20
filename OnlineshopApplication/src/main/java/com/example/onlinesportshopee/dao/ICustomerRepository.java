package com.example.onlinesportshopee.dao;
import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.onlinesportshopee.entities.CustomerEntity;

@Repository
public interface ICustomerRepository extends JpaRepository<CustomerEntity, Long> {
	
	@Query(value = "SELECT * FROM Customer c WHERE c.gmail = ?1",nativeQuery = true)
	CustomerEntity findByGmail(String gmail);
	
	@Modifying(clearAutomatically = true)     
	@Transactional
	@Query(value = "update Customer set contactno = ?2,date_of_birth = ?3 WHERE id = ?1",nativeQuery = true)
	void updateById(Long id,String contactNo,LocalDate doB);
	
	@Modifying(clearAutomatically = true)     
	@Transactional
	@Query(value = "update Customer set password = ?2 WHERE id = ?1",nativeQuery = true)
	void updateByPassword(Long id,String password);
	
	
}
//