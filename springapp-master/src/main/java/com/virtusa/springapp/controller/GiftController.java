package com.virtusa.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.virtusa.springapp.model.Gift;
import com.virtusa.springapp.service.GiftServiceInterface;
import com.virtusa.springapp.tempmodel.TempGift;
@CrossOrigin(origins="http://localhost:3000/")
@RestController
public class GiftController {
    
    @Autowired
    private GiftServiceInterface giftService;
   
   @GetMapping("/admin/getGift")
   public List<Gift> getGift(){
    return this.giftService.getGift();
   }
   
   @GetMapping("/user/getGiftById/{giftId}")
   public Gift getGiftById(@PathVariable(value="giftId") Long id) {
	   return this.giftService.getGiftById(id);
   }
   @PostMapping("/admin/addGift")
   public Gift addGift(@RequestBody TempGift gift) throws NullPointerException{
	   Gift g = new Gift();
	   g.setGiftId(gift.getGiftId());
       g.setGiftDetails(gift.getGiftDetails());
       g.setGiftImageUrl(gift.getGiftImageUrl());
       g.setGiftName(gift.getGiftName());
       g.setGiftPrice(gift.getGiftPrice());
       g.setGiftQuantity(gift.getGiftQuantity());
	   return this.giftService.addGift(g);
   }
   @DeleteMapping("/admin/deleteGift/{giftId}")
   public String deleteGift(@PathVariable(value="giftId") Long id){
       return this.giftService.deleteGift(id);
   }
   @PutMapping("/admin/editGift/{giftId}")
   public String editGift(@PathVariable(value="giftId") Long id,@RequestBody TempGift gift){
	   Gift g = new Gift();
	   g.setGiftId(gift.getGiftId());
       g.setGiftDetails(gift.getGiftDetails());
       g.setGiftImageUrl(gift.getGiftImageUrl());
       g.setGiftName(gift.getGiftName());
       g.setGiftPrice(gift.getGiftPrice());
       g.setGiftQuantity(gift.getGiftQuantity());
       return this.giftService.editGift(id,g);
   }
   @PutMapping("/user/editGiftQuantity/{giftId}+{giftQuantity}")
   public String editGiftQuantity(@PathVariable(value="giftId") Long id,@PathVariable(value="giftQuantity") int giftQuantity) {
	   return this.giftService.editGiftQuantity(id,giftQuantity);
   }
}