package com.example.onlinesportsshopee.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.onlinesportshopee.dao.IPaymentRepository;
import com.example.onlinesportshopee.entities.CardEntity;
import com.example.onlinesportshopee.entities.PaymentEntity;
import com.example.onlinesportshopee.exception.PaymentNotFoundException;
import com.example.onlinesportshopee.services.PaymentServiceImpl;
import com.example.onlinesportshopee.services.IPaymentService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PaymentServiceImpl.class)
class PaymentServiceImplTest {
	
		@MockBean
		IPaymentRepository iPaymentRepository;
		
		@Autowired
		IPaymentService iPaymentService;		
		
		@Test
		void testAddPayment01() {
			PaymentEntity paymentEntity = new PaymentEntity();
			paymentEntity.setId((long)23);
	        paymentEntity.setType("Online");
	        paymentEntity.setStatus("Sucess");
	        paymentEntity.setCardEntity(null);
			
			Mockito.when(iPaymentRepository.save(paymentEntity)).thenReturn(paymentEntity);
	        Assert.assertNull(paymentEntity);
		}
		
		@Test
		void testRemovePayment01() throws PaymentNotFoundException{
			PaymentEntity paymentEntity = new PaymentEntity();
			paymentEntity.setId((long)23);
	        paymentEntity.setType("Online");
	        paymentEntity.setStatus("Sucess");
	        paymentEntity.setCardEntity(null);
	        
	        Mockito.when(iPaymentRepository.save(paymentEntity)).thenReturn(paymentEntity);
	        iPaymentRepository.deleteById(paymentEntity.getId());
	        Assert.assertNull(paymentEntity);
		}
		
		@Test
		void testUpdatPayment01() throws PaymentNotFoundException{
			PaymentEntity paymentEntity = new PaymentEntity();
			paymentEntity.setId((long)23);
	        paymentEntity.setType("Online");
	        paymentEntity.setStatus("Sucess");
	        paymentEntity.setCardEntity(null);
	        
	        iPaymentRepository.save(paymentEntity);
	        paymentEntity.setStatus("Not Sucess");
			iPaymentRepository.save(paymentEntity);
	        
	        Assert.assertNull(paymentEntity);
		}
		
		@Test
		void testGetPaymentDetails01() throws PaymentNotFoundException{
			PaymentEntity paymentEntity = new PaymentEntity();
			paymentEntity.setId((long)23);
	        paymentEntity.setType("Online");
	        paymentEntity.setStatus("Sucess");
	        paymentEntity.setCardEntity(null);
	        
			iPaymentRepository.save(paymentEntity);
		    iPaymentRepository.findById(23L);
		    Assert.assertNotEquals(paymentEntity,new PaymentEntity());
		}
		
		@Test
		void testGetAllPaymentDetails01() {
			PaymentEntity paymentEntity1 = new PaymentEntity();
			paymentEntity1.setId((long)23);
	        paymentEntity1.setType("Online");
	        paymentEntity1.setStatus("Sucess");
	        paymentEntity1.setCardEntity(null);
	        
	        PaymentEntity paymentEntity2 = new PaymentEntity();
			paymentEntity2.setId((long)24);
	        paymentEntity2.setType("NetBanking");
	        paymentEntity2.setStatus("Sucess");
	        paymentEntity2.setCardEntity(null);
	        
	        List<PaymentEntity> paymentList= new ArrayList<>();
	        paymentList.add(paymentEntity1);
	        paymentList.add(paymentEntity2);
	        
	        Mockito.when(iPaymentRepository.findAll()).thenReturn(paymentList);
			Assert.assertEquals(paymentList, new PaymentEntity());
		}
		
}