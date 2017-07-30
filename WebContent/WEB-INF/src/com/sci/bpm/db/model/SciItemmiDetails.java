package com.sci.bpm.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * SciItemmiDetails entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SCI_ITEMMI_DETAILS", schema = "SCIGENICS", uniqueConstraints = {})
public class SciItemmiDetails implements java.io.Serializable {

	// Fields

	private Long seqItemmiId;
	private SciPurchItemMaster sciPurchItemMaster;
	private Long seqMiId;

	// Constructors

	/** default constructor */
	public SciItemmiDetails() {
	}

	/** full constructor */
	public SciItemmiDetails(Long seqItemmiId,
			SciPurchItemMaster sciPurchItemMaster, Long seqMiId) {
		this.seqItemmiId = seqItemmiId;
		this.sciPurchItemMaster = sciPurchItemMaster;
		this.seqMiId = seqMiId;
	}

	// Property accessors
	@Id
	@Column(name = "SEQ_ITEMMI_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SCI_ITEMMI_DETAILS_SEQ")
	@SequenceGenerator(allocationSize=1, sequenceName="SCI_ITEMMI_DETAILS_SEQ" ,name="SCI_ITEMMI_DETAILS_SEQ" )
	public Long getSeqItemmiId() {
		return this.seqItemmiId;
	}

	public void setSeqItemmiId(Long seqItemmiId) {
		this.seqItemmiId = seqItemmiId;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.EAGER)
	@JoinColumn(name = "SEQ_PURITEM_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public SciPurchItemMaster getSciPurchItemMaster() {
		return this.sciPurchItemMaster;
	}

	public void setSciPurchItemMaster(SciPurchItemMaster sciPurchItemMaster) {
		this.sciPurchItemMaster = sciPurchItemMaster;
	}

	@Column(name = "SEQ_MI_ID", unique = false, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	public Long getSeqMiId() {
		return this.seqMiId;
	}

	public void setSeqMiId(Long seqMiId) {
		this.seqMiId = seqMiId;
	}

}