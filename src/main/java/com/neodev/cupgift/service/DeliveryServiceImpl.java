package com.neodev.cupgift.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.neodev.cupgift.model.Delivery;
import com.neodev.cupgift.model.Order;
import com.neodev.cupgift.repository.DeliveryRepository;
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
