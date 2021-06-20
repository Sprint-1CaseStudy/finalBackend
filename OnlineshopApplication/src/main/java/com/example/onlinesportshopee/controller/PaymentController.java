package com.example.onlinesportshopee.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.onlinesportshopee.entities.PaymentEntity;
import com.example.onlinesportshopee.exception.PaymentNotFoundException;
import com.example.onlinesportshopee.services.IPaymentService;
import com.example.onlinesportshopee.services.PaymentServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/onlinesportshopee")

public class PaymentController {
	
	static final Logger LOGGER = LoggerFactory.getLogger(PaymentController.class);
	
	@Autowired
	private IPaymentService iPaymentService;
	
	@PostMapping("/payments/addPayment")
	public ResponseEntity<PaymentEntity> addPayment(@RequestBody PaymentEntity payment)
	{
		LOGGER.info("add-payment URL is opened");
		LOGGER.info("addpayment() is initiated");
		PaymentEntity paymentDTO = iPaymentService.addPayment(payment);
		LOGGER.info("addpayment() has executed");
		return new ResponseEntity<PaymentEntity>(paymentDTO, HttpStatus.ACCEPTED); 
	}
	
	@DeleteMapping("/payments/removePayment/payment/{paymentId}")
	public ResponseEntity<PaymentEntity> removePayment(@PathVariable long paymentId) throws PaymentNotFoundException
	{
		LOGGER.info("delete-payment URL is opened");
		LOGGER.info("deletePayment() is initiated");
		PaymentEntity paymentDTO = iPaymentService.removePayment(paymentId);
		LOGGER.info("deletePayment() has executed");
		return new ResponseEntity<PaymentEntity>(paymentDTO, HttpStatus.ACCEPTED);
		}
	
	@PutMapping("/payments/updatePayment/{paymentId}")
	public ResponseEntity<PaymentEntity> updatePayment(@PathVariable Long paymentId, @RequestBody PaymentEntity payment)  throws PaymentNotFoundException
	{
		LOGGER.info("update-payment URL is opened");
		LOGGER.info("updatePayment() is initiated");
		PaymentEntity paymentDTO = iPaymentService.updatePayment(paymentId,payment);
		LOGGER.info("updatePayment() has executed");
		return new ResponseEntity<PaymentEntity>(paymentDTO, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/payments/getPaymentDetails/{paymentId}")
	public ResponseEntity<PaymentEntity> getPaymentDetails(@PathVariable long paymentId) throws PaymentNotFoundException
	{
		LOGGER.info("getPaymentDetails URL is opened");
		LOGGER.info("getPaymentDetails() is initiated");
		PaymentEntity paymentDTO = iPaymentService.getPaymentDetails(paymentId); 
		LOGGER.info("getPaymentDetails() has executed");
		return new ResponseEntity<PaymentEntity>(paymentDTO, HttpStatus.ACCEPTED);
		}
	@GetMapping("/payments/getallpayment")
	public List<PaymentEntity> getAllPaymentDetails()
	{
		LOGGER.info("getPaymentbyname URL is opened");
		LOGGER.info("getPaymentbyname() is initiated");
		return iPaymentService.getAllPaymentDetails(); 		
	}
	
}
