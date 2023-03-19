package com.neodev.cupgift.service;

import org.springframework.stereotype.Component;

import com.neodev.cupgift.model.Delivery;

@Component
public interface DeliveryServiceInterface {
	public Delivery addDelivery(Delivery delivery);
}
