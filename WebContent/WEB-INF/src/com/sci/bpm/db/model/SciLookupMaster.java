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
import javax.persistence.UniqueConstraint;

/**
 * SciLookupMaster entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SCI_LOOKUP_MASTER", schema = "SCIGENICS", uniqueConstraints = { @UniqueConstraint(columnNames = { "LOV_NAME" }) })
public class SciLookupMaster implements java.io.Serializable {

	// Fields

	private Long seqLovId;
	private String lovName;
	private String lovType;
	private String lovDescription;
	private Date updatedDt;
	private String updatedBy;

	// Constructors

	/** default constructor */
	public SciLookupMaster() {
	}

	/** minimal constructor */
	public SciLookupMaster(Long seqLovId) {
		this.seqLovId = seqLovId;
	}

	/** full constructor */
	public SciLookupMaster(Long seqLovId, String lovName, String lovType,
			String lovDescription, Date updatedDt, String updatedBy) {
		this.seqLovId = seqLovId;
		this.lovName = lovName;
		this.lovType = lovType;
		this.lovDescription = lovDescription;
		this.updatedDt = updatedDt;
		this.updatedBy = updatedBy;
	}

	// Property accessors
	@Id
	@Column(name = "SEQ_LOV_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SCI_LOOKUP_MASTER_SEQ")
	@SequenceGenerator(allocationSize=1, sequenceName="SCI_LOOKUP_MASTER_SEQ" ,name="SCI_LOOKUP_MASTER_SEQ" )
	public Long getSeqLovId() {
		return this.seqLovId;
	}

	public void setSeqLovId(Long seqLovId) {
		this.seqLovId = seqLovId;
	}

	@Column(name = "LOV_NAME", unique = true, nullable = true, insertable = true, updatable = true, length = 20)
	public String getLovName() {
		return this.lovName;
	}

	public void setLovName(String lovName) {
		this.lovName = lovName;
	}

	@Column(name = "LOV_TYPE", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public String getLovType() {
		return this.lovType;
	}

	public void setLovType(String lovType) {
		this.lovType = lovType;
	}

	@Column(name = "LOV_DESCRIPTION", unique = false, nullable = true, insertable = true, updatable = true, length = 200)
	public String getLovDescription() {
		return this.lovDescription;
	}

	public void setLovDescription(String lovDescription) {
		this.lovDescription = lovDescription;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DT", unique = false, nullable = true, insertable = true, updatable = true, length = 7)
	public Date getUpdatedDt() {
		return this.updatedDt;
	}

	public void setUpdatedDt(Date updatedDt) {
		this.updatedDt = updatedDt;
	}

	@Column(name = "UPDATED_BY", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

}