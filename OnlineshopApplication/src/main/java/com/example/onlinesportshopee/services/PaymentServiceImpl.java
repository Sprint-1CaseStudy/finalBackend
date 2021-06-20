package com.example.onlinesportshopee.services;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.onlinesportshopee.dao.IPaymentRepository;
import com.example.onlinesportshopee.entities.PaymentEntity;
import com.example.onlinesportshopee.exception.PaymentNotFoundException;

@Service
public class PaymentServiceImpl implements IPaymentService{
	
    static final Logger LOGGER = LoggerFactory.getLogger(PaymentServiceImpl.class);
    
    static String paymentNotFound = "Payment not found for given Id";
    
    static String validateSuccessful = "Validation Succesful";
     
	@Autowired
	private IPaymentRepository iPaymentRepository;
	
	@Override
	public PaymentEntity addPayment(PaymentEntity payment) {
		LOGGER.info("addPayment() service is initiated");
		PaymentEntity paymentEntity = iPaymentRepository.save(payment);
		LOGGER.info("addPayment() service has executed");
		return paymentEntity;
	}

	@Override
	public PaymentEntity removePayment(Long paymentID) {
		LOGGER.info("removePayment() service is initiated");
		PaymentEntity paymentEntity=iPaymentRepository.findById(paymentID).get();
		iPaymentRepository.delete(paymentEntity);
		LOGGER.info("removePayment() service has executed");
		return paymentEntity;
		
	}

	@Override
	public PaymentEntity updatePayment(Long paymentID, PaymentEntity payment) {
		LOGGER.info("updatePayment() service is initiated");
		PaymentEntity paymentEntity=iPaymentRepository.findById(paymentID).get();
		PaymentEntity pay = iPaymentRepository.save(paymentEntity);
		LOGGER.info("updatePayment() service has executed");
		return pay;
		
	}

	@Override
	public PaymentEntity getPaymentDetails(Long paymentID) throws PaymentNotFoundException {
		LOGGER.info("getPaymentDetails() service is initiated");
		PaymentEntity getPaymentDetails= iPaymentRepository.findById(paymentID).get();
		if (paymentID == 0)
			throw new PaymentNotFoundException("orderNotFound");
		LOGGER.info("getPaymentDetails() service has executed");
		return getPaymentDetails;
		
	}

	@Override
	public List<PaymentEntity> getAllPaymentDetails() {
		LOGGER.info("getAllPaymentDetails() service is initiated");
		List<PaymentEntity> getAllPaymentDetails = iPaymentRepository.findAll();
		LOGGER.info("getAllPaymentDetails() service has executed");
		return getAllPaymentDetails;
	}

}
