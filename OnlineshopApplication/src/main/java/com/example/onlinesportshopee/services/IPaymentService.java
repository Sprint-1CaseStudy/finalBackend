package com.example.onlinesportshopee.services;

import com.example.onlinesportshopee.entities.PaymentEntity;
import com.example.onlinesportshopee.exception.PaymentNotFoundException;


import java.util.List;

public interface IPaymentService {
	
	public PaymentEntity addPayment(PaymentEntity payment);
	public PaymentEntity removePayment(Long id);
	public PaymentEntity updatePayment(Long id, PaymentEntity payment);
	public PaymentEntity getPaymentDetails(Long paymentID) throws PaymentNotFoundException;	
	public List<PaymentEntity> getAllPaymentDetails();
}
