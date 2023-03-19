package com.neodev.cupgift.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.neodev.cupgift.model.Order;
import com.neodev.cupgift.service.DeliveryServiceImpl;
import com.neodev.cupgift.service.OrderServiceImpl;
import com.neodev.cupgift.tempmodel.TempOrder;

@RestController
@CrossOrigin
public class OrderController {
    @Autowired
    OrderServiceImpl orderServ;
    
    @Autowired
    DeliveryServiceImpl deliveryServ;
    
    @PostMapping("/user/addOrder")
    public Order addOrder(@RequestBody TempOrder order){
    	order.setOrderPrice(order.getDelivery().getOrderQuantity()*(order.getGift().getGiftPrice()+order.getTheme().getThemePrice())); 
    	this.deliveryServ.addDelivery(order.getDelivery());
    	Order o = new Order();
    	o.setGift(order.getGift());
    	o.setOrderPrice(order.getOrderPrice());
    	o.setDelivery(order.getDelivery());
    	o.setTheme(order.getTheme());
    	o.setUser(order.getUser());
    	return this.orderServ.addOrder(o);   
    }
    @GetMapping("/user/myOrder")
    public List<Order> getMyOrders(){
        return orderServ.getAllOrders();
    }
    
    @GetMapping("/user/myOrderonly/{userId}")
    public List<Order> getorderbyId(@PathVariable int userId){
        return orderServ.getOrderByUserId(userId);
    }
    
    @GetMapping("/users/editOrder/{orderId}")
    public Order editOrderByUser(@PathVariable int orderId) {
    	return orderServ.getOrderById(orderId);
    }
    
    @DeleteMapping("/user/deleteOrder/{orderId}")
    public void deleteOrderByUser(@PathVariable int orderId){
        orderServ.deleteOrder(orderId);
    }
    
    @PreAuthorize("hasRole('Admin')")
    @GetMapping("/admin/getAllOrders")
    public List<Order> getAllOrders(){
        return orderServ.getAllOrders();
    } 
    @PutMapping("/admin/editOrder/{orderId}")
    public void editOrder(@RequestBody TempOrder order, @PathVariable int orderId){
    	Order o = new Order();
    	o.setGift(order.getGift());
    	o.setOrderPrice(order.getOrderPrice());
    	o.setDelivery(order.getDelivery());
    	o.setTheme(order.getTheme());
    	o.setUser(order.getUser());
        orderServ.editOrder(o);
    }

    
    @DeleteMapping("/admin/deleteOrder/{orderId}")
    public void deleteOrder(@PathVariable int orderId){
        orderServ.deleteOrder(orderId);
    }
    
}
