package com.sci.bpm.command.po;

import java.io.Serializable;

public class POCollectionCommand implements Serializable {

	private String poitemIdx;
	
	private String itemDesc;

	public String getPoitemIdx() {
		return poitemIdx;
	}

	public void setPoitemIdx(String poitemIdx) {
		this.poitemIdx = poitemIdx;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}
	
	
}
