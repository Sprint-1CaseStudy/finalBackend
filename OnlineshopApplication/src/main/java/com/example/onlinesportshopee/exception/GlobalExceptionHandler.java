package com.example.onlinesportshopee.exception;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<?> customernotfound(CustomerNotFoundException n, WebRequest req) {
		return new ResponseEntity<>(n.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<?> ordernotfound(OrderNotFoundException n, WebRequest req) {
		return new ResponseEntity<>(n.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<?> productnotfound(ProductNotFoundException n, WebRequest req) {
		return new ResponseEntity<>(n.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PaymentNotFoundException.class)
	public ResponseEntity<?> paymentnotfound(PaymentNotFoundException n, WebRequest req) {
		return new ResponseEntity<>(n.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(AddressNotFoundException.class)
	public ResponseEntity<?> addressnotfound(AddressNotFoundException n, WebRequest req) {
		return new ResponseEntity<>(n.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CardNotFoundException.class)
	public ResponseEntity<?> cardnotfound(CardNotFoundException n, WebRequest req) {
		return new ResponseEntity<>(n.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(CartNotFoundException.class)
	public ResponseEntity<?> cartnotfound(CartNotFoundException n, WebRequest req) {
		return new ResponseEntity<>(n.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<?> usernotfound(UserNotFoundException n, WebRequest req) {
		return new ResponseEntity<>(n.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InvalidCustomerIdException.class)
	public ResponseEntity<?> invalidcustomerid(InvalidCustomerIdException n, WebRequest req) {
		return new ResponseEntity<>(n.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidOrderIdException.class)
	public ResponseEntity<?> invalidorderid(InvalidOrderIdException n, WebRequest req) {
		return new ResponseEntity<>(n.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InvalidProductInputException.class)
	public ResponseEntity<?> invalidproductid(InvalidProductInputException n, WebRequest req) {
		return new ResponseEntity<>(n.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> globalExceptionHandler(Exception n,WebRequest req) {
		ErrorDetails errordetails = new ErrorDetails(new Date(), n.getMessage(), req.getDescription(false));
		return new ResponseEntity<>(errordetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
