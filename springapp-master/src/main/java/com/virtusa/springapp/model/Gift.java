package com.virtusa.springapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.Table;

@Entity
@Table(name="gift")
public class Gift {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long giftId;
    private String giftName;
    private String giftImageUrl;
    private String giftDetails;
    private int giftPrice;
    private int giftQuantity;

    

    public Gift(Long giftId, String giftName, int giftPrice, String giftImageUrl, int giftQuantity, String giftDetails) {
		super();
		this.giftId = giftId;
		this.giftName = giftName;
		this.giftImageUrl = giftImageUrl;
		this.giftDetails = giftDetails;
		this.giftQuantity = giftQuantity;
		this.giftPrice = giftPrice;
	}
    
    public Gift() {
    	
    }


	public Long getGiftId() {
		return giftId;
	}
	public void setGiftId(Long giftId) {
		this.giftId = giftId;
	}
	public String getGiftName() {
		return giftName;
	}
	public void setGiftName(String giftName) {
		this.giftName = giftName;
	}
	public int getGiftPrice() {
		return giftPrice;
	}
	public void setGiftPrice(int giftPrice) {
		this.giftPrice = giftPrice;
	}
	public String getGiftImageUrl() {
		return giftImageUrl;
	}
	public void setGiftImageUrl(String giftImageUrl) {
		this.giftImageUrl = giftImageUrl;
	}
	public int getGiftQuantity() {
		return giftQuantity;
	}
	public void setGiftQuantity(int giftQuantity) {
		this.giftQuantity = giftQuantity;
	}
	public String getGiftDetails() {
		return giftDetails;
	}
	public void setGiftDetails(String giftDetails) {
		this.giftDetails = giftDetails;
	}

	@Override
	public String toString() {
		return "Gift [giftId=" + giftId + ", giftName=" + giftName + ", giftImageUrl=" + giftImageUrl + ", giftDetails="
				+ giftDetails + ", giftPrice=" + giftPrice + ", giftQuantity=" + giftQuantity + "]";
	}
	
	
}

