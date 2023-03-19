package com.neodev.cupgift.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.neodev.cupgift.model.Gift;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository

public interface GiftRepository extends JpaRepository<Gift,Long> {
    @Modifying 
    @Transactional  
    @Query(value = "delete from gift where gift_id=?1",nativeQuery=true)  
    public void deleteByGiftId(Long id);

    @Modifying 
    @Transactional  
    @Query(value = "Update gift set gift_name=?2,gift_image_url=?3,gift_details=?4,gift_price=?5,gift_quantity=?6 where gift_id=?1",nativeQuery=true)  
    public void editByGiftId(Long giftId, String giftName,String giftImageUrl, String giftDetails,int giftPrice, int giftQuantity);
    
    @Modifying
    @Transactional
    @Query(value = "Update gift set gift_quantity=?2 where gift_id=?1",nativeQuery=true)
    public void editGiftQuantity(Long giftId, int giftQuantity);
}
