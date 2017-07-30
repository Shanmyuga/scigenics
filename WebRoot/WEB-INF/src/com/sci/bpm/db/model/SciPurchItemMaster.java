package com.sci.bpm.db.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 * SciPurchItemMaster entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SCI_PURCH_ITEM_MASTER", schema = "SCIGENICS", uniqueConstraints = {})
public class SciPurchItemMaster implements java.io.Serializable {

	// Fields

	private Long seaPuritemId;
	private String itemDescription;
	private String itemDimen;
	private Float itemEstimatedCost;
	private Date itemOrderDate;
	private Long itemStatus;
	private Date itemReceivedDate;
	private Long itemActualCost;
	private String updatedBy;
	private Date updatedDate;
	private String itemQty;
	private String itemQtymod = "0.0";
	private Long itemType;
	private String itemCode;
	private String rawmis;
	
	private String itemDenom;
	
	
	private Set<SciItemmiDetails> sciItemmiDetailses = new HashSet<SciItemmiDetails>(
			0);

	// Constructors

	/** default constructor */
	public SciPurchItemMaster() {
	}

	/** minimal constructor */
	public SciPurchItemMaster(Long seaPuritemId, String itemDescription,
			Float itemEstimatedCost, Date itemOrderDate, Long itemStatus,
			Date itemReceivedDate, String updatedBy, Date updatedDate,
			String itemQty) {
		this.seaPuritemId = seaPuritemId;
		this.itemDescription = itemDescription;
		this.itemEstimatedCost = itemEstimatedCost;
		this.itemOrderDate = itemOrderDate;
		this.itemStatus = itemStatus;
		this.itemReceivedDate = itemReceivedDate;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.itemQty = itemQty;
	}

	/** full constructor */
	public SciPurchItemMaster(Long seaPuritemId, String itemDescription,
			String itemDimen, Float itemEstimatedCost, Date itemOrderDate,
			Long itemStatus, Date itemReceivedDate, Long itemActualCost,
			String updatedBy, Date updatedDate, String itemQty,
			Set<SciItemmiDetails> sciItemmiDetailses) {
		this.seaPuritemId = seaPuritemId;
		this.itemDescription = itemDescription;
		this.itemDimen = itemDimen;
		this.itemEstimatedCost = itemEstimatedCost;
		this.itemOrderDate = itemOrderDate;
		this.itemStatus = itemStatus;
		this.itemReceivedDate = itemReceivedDate;
		this.itemActualCost = itemActualCost;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.itemQty = itemQty;
		this.sciItemmiDetailses = sciItemmiDetailses;
	}

	// Property accessors
	@Id
	@Column(name = "SEA_PURITEM_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SCI_PURCH_ITEM_MASTER_SEQ")
	@SequenceGenerator(allocationSize=1, sequenceName="SCI_PURCH_ITEM_MASTER_SEQ" ,name="SCI_PURCH_ITEM_MASTER_SEQ" )
	public Long getSeaPuritemId() {
		return this.seaPuritemId;
	}

	public void setSeaPuritemId(Long seaPuritemId) {
		this.seaPuritemId = seaPuritemId;
	}

	@Column(name = "ITEM_DESCRIPTION", unique = false, nullable = false, insertable = true, updatable = true, length = 1000)
	public String getItemDescription() {
		return this.itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	@Column(name = "ITEM_DIMEN", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public String getItemDimen() {
		return this.itemDimen;
	}

	public void setItemDimen(String itemDimen) {
		this.itemDimen = itemDimen;
	}

	@Column(name = "ITEM_ESTIMATED_COST", unique = false, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	public Float getItemEstimatedCost() {
		return this.itemEstimatedCost;
	}

	public void setItemEstimatedCost(Float itemEstimatedCost) {
		this.itemEstimatedCost = itemEstimatedCost;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ITEM_ORDER_DATE", unique = false, nullable = false, insertable = true, updatable = true, length = 7)
	public Date getItemOrderDate() {
		return this.itemOrderDate;
	}

	public void setItemOrderDate(Date itemOrderDate) {
		this.itemOrderDate = itemOrderDate;
	}

	@Column(name = "ITEM_STATUS", unique = false, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	public Long getItemStatus() {
		return this.itemStatus;
	}

	public void setItemStatus(Long itemStatus) {
		this.itemStatus = itemStatus;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "ITEM_RECEIVED_DATE", unique = false, nullable = true, insertable = true, updatable = true, length = 7)
	public Date getItemReceivedDate() {
		return this.itemReceivedDate;
	}

	public void setItemReceivedDate(Date itemReceivedDate) {
		this.itemReceivedDate = itemReceivedDate;
	}

	@Column(name = "ITEM_ACTUAL_COST", unique = false, nullable = true, insertable = true, updatable = true, precision = 22, scale = 0)
	public Long getItemActualCost() {
		return this.itemActualCost;
	}

	public void setItemActualCost(Long itemActualCost) {
		this.itemActualCost = itemActualCost;
	}

	@Column(name = "UPDATED_BY", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DATE", unique = false, nullable = false, insertable = true, updatable = true, length = 7)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name = "ITEM_QTY_MOD", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public String getItemQty() {
		return this.itemQty;
	}

	public void setItemQty(String itemQty) {
		this.itemQty = itemQty;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER, mappedBy = "sciPurchItemMaster")
	public Set<SciItemmiDetails> getSciItemmiDetailses() {
		return this.sciItemmiDetailses;
	}

	public void setSciItemmiDetailses(Set<SciItemmiDetails> sciItemmiDetailses) {
		this.sciItemmiDetailses = sciItemmiDetailses;
	}
	
	public void addMidetails(SciItemmiDetails details) {
		this.sciItemmiDetailses.add(details);
	}

	@Column(name = "ITEM_TYPE", unique = false, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	public Long getItemType() {
		return itemType;
	}

	public void setItemType(Long itemType) {
		this.itemType = itemType;
	}
	@Column(name = "ITEM_CODE", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}
	@Column(name = "ITEM_QTY", unique = false, nullable = true, insertable = true, updatable = true, length = 4)
	public String getItemQtymod() {
		return itemQtymod;
	}

	public void setItemQtymod(String itemQtymod) {
		this.itemQtymod = itemQtymod;
	}

	@Transient
	public String getRawmis() {
		return rawmis;
	}

	public void setRawmis(String rawmis) {
		this.rawmis = rawmis;
	}
	@Column(name = "ITEM_DENOMINATION", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public String getItemDenom() {
		return itemDenom;
	}

	public void setItemDenom(String itemDenom) {
		this.itemDenom = itemDenom;
	}
	
	

}