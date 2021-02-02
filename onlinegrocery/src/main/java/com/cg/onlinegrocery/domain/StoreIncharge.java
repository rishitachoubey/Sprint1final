package com.cg.onlinegrocery.domain;

public class StoreIncharge {
	private int storeInchargeId;
	private String storeInchargeName;
	
	public StoreIncharge(int storeInchargeId, String storeInchargeName) {
		super();
		this.storeInchargeId = storeInchargeId;
		this.storeInchargeName = storeInchargeName;
	}
	public int getStoreInchargeId() {
		return storeInchargeId;
	}
	public void setStoreInchargeId(int storeInchargeId) {
		this.storeInchargeId = storeInchargeId;
	}
	public String getStoreInchargeName() {
		return storeInchargeName;
	}
	public void setStoreInchargeName(String storeInchargeName) {
		this.storeInchargeName = storeInchargeName;
	}
}
