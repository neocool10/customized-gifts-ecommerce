package com.virtusa.springapp.service;

import java.util.List;


import com.virtusa.springapp.model.Gift;

public interface GiftServiceInterface {
	List<Gift> getGift();
    Gift addGift(Gift gift);
    Gift getGiftById(Long id);
    String deleteGift(Long id);
    String editGift(Long id,Gift gift);
	String editGiftQuantity(Long giftId, int giftQuantity);
}
