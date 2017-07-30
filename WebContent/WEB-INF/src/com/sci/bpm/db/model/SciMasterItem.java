package com.sci.bpm.db.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SciMasterItem entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SCI_MASTER_ITEM", schema = "SCIGENICS")
public class SciMasterItem implements java.io.Serializable {

	// Fields

	private Long seqMsitemId;
	private String itemType;
	private String itemDescription;
	private Date updatedDt;
	private String updatedBy;

	// Constructors

	/** default constructor */
	public SciMasterItem() {
	}

	/** full constructor */
	public SciMasterItem(Long seqMsitemId, String itemType,
			String itemDescription, Date updatedDt, String updatedBy) {
		this.seqMsitemId = seqMsitemId;
		this.itemType = itemType;
		this.itemDescription = itemDescription;
		this.updatedDt = updatedDt;
		this.updatedBy = updatedBy;
	}
	@Id
	@Column(name = "SEQ_MSITEM_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SCI_MASTER_ITEM_SEQ")
	@SequenceGenerator(allocationSize=1, sequenceName="SCI_MASTER_ITEM_SEQ" ,name="SCI_MASTER_ITEM_SEQ" )
	// Property accessors
	
	public Long getSeqMsitemId() {
		return this.seqMsitemId;
	}

	public void setSeqMsitemId(Long seqMsitemId) {
		this.seqMsitemId = seqMsitemId;
	}

	@Column(name = "ITEM_TYPE", unique = true, nullable = false, length = 100)
	public String getItemType() {
		return this.itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}


	@Column(name = "ITEM_DESCRIPTION", nullable = false, length = 100)
	public String getItemDescription() {
		return this.itemDescription;
	}

	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DT", nullable = false, length = 7)
	public Date getUpdatedDt() {
		return this.updatedDt;
	}

	public void setUpdatedDt(Date updatedDt) {
		this.updatedDt = updatedDt;
	}

	@Column(name = "UPDATED_BY", nullable = false, length = 20)
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

}