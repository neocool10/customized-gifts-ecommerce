package com.virtusa.springapp.tempmodel;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.virtusa.springapp.model.Delivery;
import com.virtusa.springapp.model.Gift;
import com.virtusa.springapp.model.Theme;
import com.virtusa.springapp.model.User;


public class TempOrder {

    int orderId;
    int orderPrice;
    
    @ManyToOne()
    @JoinColumn(name="delivery_id")
    Delivery delivery;

    @ManyToOne()
    @JoinColumn(name="gift_id")
    Gift gift;

    @ManyToOne()
    @JoinColumn(name="user_id")
    User user;
    
    @ManyToOne()
    @JoinColumn(name="theme_id")
    Theme theme;
    
    

    public TempOrder() {
    }

    public TempOrder(int orderId, int orderPrice, Delivery delivery, Gift gift, User user, Theme theme) {
        this.orderId = orderId;
        this.orderPrice = orderPrice;
        this.delivery = delivery;
        this.gift = gift;
        this.user = user;
        this.theme = theme;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(int orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	public Gift getGift() {
        return gift;
    }

    public void setGift(Gift gift) {
        this.gift = gift;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public Theme getTheme() {
		return theme;
	}

	public void setTheme(Theme theme) {
		this.theme = theme;
	}

	@Override
	public String toString() {
		return "TempOrder [orderId=" + orderId + ", orderPrice=" + orderPrice + ", delivery=" + delivery + ", gift="
				+ gift + ", user=" + user + ", theme=" + theme + "]";
	}

	
    
}