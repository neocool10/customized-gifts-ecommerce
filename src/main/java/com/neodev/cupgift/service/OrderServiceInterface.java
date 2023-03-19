package com.neodev.cupgift.service;

import java.util.List;

import com.neodev.cupgift.model.Order;

import org.springframework.stereotype.Component;

@Component
public interface OrderServiceInterface {
    public Order addOrder(Order order);
    public List<Order> getAllOrders();
    public List<Order> getOrderByUserId(int id);
    public Order getOrderById(int id);
    public void deleteOrder(int id);
    public void editOrder(Order order);
}