package com.example.onlinesportshopee.controller;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.onlinesportshopee.entities.CartEntity;
import com.example.onlinesportshopee.entities.OrderEntity;
import com.example.onlinesportshopee.exception.CartNotFoundException;
import com.example.onlinesportshopee.exception.OrderNotFoundException;
import com.example.onlinesportshopee.services.IOrderService;
import com.example.onlinesportshopee.services.OrderServiceImpl;

 
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/onlinesportshopee")
public class OrderController {

    static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
    //
    @Autowired
    private IOrderService iOrderService;
    
    @PostMapping("/add-order/{custID}")
    public  ResponseEntity<OrderEntity> addOrder(@PathVariable Long custID)throws OrderNotFoundException{
        LOGGER.info("add-order URL is opened");
        LOGGER.info("addOrderEntity() is initiated");
        OrderEntity orderDTO = iOrderService.addOrder(custID);
        LOGGER.info("addOrder() has executed");
        return new ResponseEntity<OrderEntity>(orderDTO, HttpStatus.ACCEPTED);
    }

    @PutMapping("/update-order/{orderID}")
    public ResponseEntity<OrderEntity> updateOrder(@PathVariable Long orderID, @RequestBody OrderEntity order)throws OrderNotFoundException{
        LOGGER.info("update-order URL is opened");
        LOGGER.info("updateOrderEntity() is initiated");
        OrderEntity orderDTO = iOrderService.updateOrder(orderID,order);
        LOGGER.info("updateOrder() has executed");
        return new ResponseEntity<OrderEntity>(orderDTO, HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/remove-order/{orderID}")
    public ResponseEntity<OrderEntity> deleteOrder(@PathVariable long orderID)throws OrderNotFoundException{
        LOGGER.info("delete-order URL is opened");
        LOGGER.info("deleteOrderEntity() is initiated");
        OrderEntity orderDTO=iOrderService.deleteOrder(orderID);
        LOGGER.info("deleteOrderEntity() has executed");
        return new ResponseEntity<OrderEntity>(orderDTO, HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-all-order")
    public List<OrderEntity> getAllOrder(){
    
        LOGGER.info("getallorders URL is opened");
        LOGGER.info("getAllOrder() is initiated");
        LOGGER.info("getAllOrder() has executed");
        return iOrderService.getAllOrders();
     }
    
    @GetMapping("/getOrder/{custId}")
	public List<OrderEntity> getCartdetails(@PathVariable Long custId) throws OrderNotFoundException {
    	LOGGER.info("getById URL is opened");
        LOGGER.info("getById() is initiated");
        LOGGER.info("getOrderById() has executed");
	    return iOrderService.getOrders(custId);
	}
    
}