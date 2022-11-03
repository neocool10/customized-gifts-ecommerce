package com.virtusa.springapp.service;

import org.springframework.stereotype.Component;

import com.virtusa.springapp.model.Delivery;

@Component
public interface DeliveryServiceInterface {
	public Delivery addDelivery(Delivery delivery);
}
