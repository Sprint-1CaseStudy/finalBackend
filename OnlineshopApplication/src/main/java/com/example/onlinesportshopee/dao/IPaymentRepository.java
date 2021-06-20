package com.example.onlinesportshopee.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.onlinesportshopee.entities.CustomerEntity;
import com.example.onlinesportshopee.entities.PaymentEntity;

@Repository
public interface IPaymentRepository extends JpaRepository<PaymentEntity, Long> {

}
