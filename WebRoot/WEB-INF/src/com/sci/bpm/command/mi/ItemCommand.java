package com.sci.bpm.command.mi;

import java.io.Serializable;
import java.util.Date;

public class ItemCommand implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String itemDescription;
	private String itemDimen;
	private Float itemEstimatedCost;
	private String itemQty;
	private Long itemStatus;
	private Date itemOrderDate;
	private Long itemType;
	private String itemDenom;
	private String rawmiid;
	
	private String[] itemlist;
	
	private String[] seqMIids;
	
	private String[] micost;
	private String[] miremarks;
	
	
	public Long getItemStatus() {
		return itemStatus;
	}
	public void setItemStatus(Long itemStatus) {
		this.itemStatus = itemStatus;
	}
	public String getItemQty() {
		return itemQty;
	}
	public void setItemQty(String itemQty) {
		this.itemQty = itemQty;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public String getItemDimen() {
		return itemDimen;
	}
	public void setItemDimen(String itemDimen) {
		this.itemDimen = itemDimen;
	}
	public Float getItemEstimatedCost() {
		return itemEstimatedCost;
	}
	public void setItemEstimatedCost(Float itemEstimatedCost) {
		this.itemEstimatedCost = itemEstimatedCost;
	}
	public Date getItemOrderDate() {
		return itemOrderDate;
	}
	public void setItemOrderDate(Date itemOrderDate) {
		this.itemOrderDate = itemOrderDate;
	}
	public String[] getSeqMIids() {
		return seqMIids;
	}
	public void setSeqMIids(String[] seqMIids) {
		this.seqMIids = seqMIids;
	}
	public String[] getMicost() {
		return micost;
	}
	public void setMicost(String[] micost) {
		this.micost = micost;
	}
	public String[] getItemlist() {
		return itemlist;
	}
	public void setItemlist(String[] itemlist) {
		this.itemlist = itemlist;
	}
	public Long getItemType() {
		return itemType;
	}
	public void setItemType(Long itemType) {
		this.itemType = itemType;
	}
	public String[] getMiremarks() {
		return miremarks;
	}
	public void setMiremarks(String[] miremarks) {
		this.miremarks = miremarks;
	}
	public String getRawmiid() {
		return rawmiid;
	}
	public void setRawmiid(String rawmiid) {
		this.rawmiid = rawmiid;
	}
	public String getItemDenom() {
		return itemDenom;
	}
	public void setItemDenom(String itemDenom) {
		this.itemDenom = itemDenom;
	}
	
	
	
}
