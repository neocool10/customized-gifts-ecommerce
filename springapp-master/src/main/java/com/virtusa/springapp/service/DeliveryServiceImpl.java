package com.virtusa.springapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.virtusa.springapp.model.Delivery;
import com.virtusa.springapp.model.Order;
import com.virtusa.springapp.repository.DeliveryRepository;
import java.util.Collections;

@Component
public class DeliveryServiceImpl implements OrderServiceInterface{
	
	@Autowired
	DeliveryRepository deliveryRepo;
	
	public Delivery addDelivery(Delivery delivery) {
		return (deliveryRepo.save(delivery));
	}

	@Override
	public Order addOrder(Order order) {
		return null;
	}

	@Override
	public List<Order> getAllOrders() {
		return Collections.emptyList();
	}

	@Override
	public List<Order> getOrderByUserId(int id) {
		return Collections.emptyList();
	}

	@Override
	public Order getOrderById(int id) {
		return null;
	}

	@Override
	public void deleteOrder(int id) {
		
	}

	@Override
	public void editOrder(Order order) {
		
	}
}
