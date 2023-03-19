package com.neodev.cupgift.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import com.neodev.cupgift.repository.GiftRepository;

import com.neodev.cupgift.model.Gift;
import org.springframework.stereotype.Service;

@Service
public class GiftServiceImpl implements GiftServiceInterface {
	@Autowired
    private GiftRepository giftdao;
    
    @Override
    public List<Gift> getGift() {
        return giftdao.findAll();
    }
    @Override
    public Gift getGiftById(Long giftId) {
    	 Optional<Gift> g = giftdao.findById(giftId);
    	 if (g.isPresent())
    		 return g.get();
    	 else 
    		 return null;
    }
    
    @Override
    public Gift addGift(Gift gift) {
        giftdao.save(gift);
        return gift;
    }
    @Override
    public String deleteGift(Long giftId) {
        giftdao.deleteByGiftId(giftId);
        return "Gift Deleted Successfully!";
    }
    @Override
    public String editGift(Long giftId,Gift gift) {
        String giftName=gift.getGiftName();
        String giftImageUrl=gift.getGiftImageUrl();
        String giftDetails=gift.getGiftDetails();
        int giftPrice=gift.getGiftPrice();
        int giftQuantity = gift.getGiftQuantity();
        giftdao.editByGiftId(giftId,giftName,giftImageUrl,giftDetails,giftPrice,giftQuantity);
        return "Gift Updated Successfully!";
    }
    @Override
    public String editGiftQuantity(Long giftId,int giftQuantity) {
    	int giftQuant = giftQuantity;
    	giftdao.editGiftQuantity(giftId, giftQuant);
    	return "Gift Quantity Updated Sucessfully";
    }
}
