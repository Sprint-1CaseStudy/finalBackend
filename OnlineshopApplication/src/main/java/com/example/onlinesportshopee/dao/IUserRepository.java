package com.example.onlinesportshopee.dao;



import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.onlinesportshopee.entities.UserEntity;


@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long> {
	@Query(value = "SELECT * FROM users u WHERE u.gmail = ?1",nativeQuery = true)
	UserEntity findByGmail(String gmail);
	
	@Modifying(clearAutomatically = true)     
	@Transactional
	@Query(value = "update users set password = ?2 WHERE id = ?1",nativeQuery = true)
	void updateById(Long id,String password);

}
