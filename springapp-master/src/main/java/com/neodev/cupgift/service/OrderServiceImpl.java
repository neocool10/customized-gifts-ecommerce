package com.neodev.cupgift.service;

import java.util.List;
import java.util.Optional;

import com.neodev.cupgift.model.Order;
import com.neodev.cupgift.repository.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderServiceInterface{

    @Autowired
    OrderRepository orderRepo;
    
    public Order addOrder(Order order) {
        return (orderRepo.save(order));
    }

    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }
    public List<Order> getOrderByUserId(int id) {
    	return orderRepo.findbyUserId(id);
    }
    public Order getOrderById(int id) {
        Optional<Order> order = orderRepo.findById(id);
        if(order.isPresent())
        	return order.get();
        else
        	return null; 
    }

    public void deleteOrder(int id) {
        Optional<Order> order = orderRepo.findById(id);
        if (order.isPresent())
        	orderRepo.delete(order.get());  
    }

    public void editOrder(Order order) {

        orderRepo.save(order); 
    }
}