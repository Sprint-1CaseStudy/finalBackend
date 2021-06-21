package com.example.onlinesportshopee.services;

import com.example.onlinesportshopee.entities.OrderEntity;

import com.example.onlinesportshopee.exception.OrderNotFoundException;
import java.util.List;

public interface IOrderService {
public OrderEntity addOrder(Long cartID) throws OrderNotFoundException;
public OrderEntity updateOrder(Long id,OrderEntity order)throws OrderNotFoundException;
public OrderEntity deleteOrder(Long id) throws OrderNotFoundException;
public List<OrderEntity> getAllOrders();
public List<OrderEntity> getOrders(Long custId)throws OrderNotFoundException;

}
