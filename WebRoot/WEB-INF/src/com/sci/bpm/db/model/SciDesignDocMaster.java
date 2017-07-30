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
import javax.persistence.Transient;

/**
 * SciDesignDocMaster entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SCI_DESIGN_DOC_MASTER", schema = "SCIGENICS")
public class SciDesignDocMaster implements java.io.Serializable {

	// Fields

	private Long seqDesDocId;
	private String docNum;
	private String docuDesc;
private String docuName;
	// Constructors

	/** default constructor */
	public SciDesignDocMaster() {
	}

	/** minimal constructor */
	public SciDesignDocMaster(Long seqDesDocId) {
		this.seqDesDocId = seqDesDocId;
	}

	/** full constructor */
	public SciDesignDocMaster(Long seqDesDocId, String docNum,
			String docuDesc) {
		this.seqDesDocId = seqDesDocId;
		this.docNum = docNum;
		this.docuDesc = docuDesc;
	}
	
	@Id
	@Column(name = "SEQ_DES_DOC_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SCI_DESDOC_MASTER_SEQ")
	@SequenceGenerator(allocationSize=1, sequenceName="SCI_DESDOC_MASTER_SEQ" ,name="SCI_DESDOC_MASTER_SEQ" )

	public Long getSeqDesDocId() {
		return this.seqDesDocId;
	}

	public void setSeqDesDocId(Long seqDesDocId) {
		this.seqDesDocId = seqDesDocId;
	}

	@Column(name = "DOC_NUM", length = 10)
	public String getDocNum() {
		return this.docNum;
	}

	public void setDocNum(String docNum) {
		this.docNum = docNum;
	}

	@Column(name = "DOCU_DESC", length = 200)
	public String getDocuDesc() {
		return this.docuDesc;
	}

	public void setDocuDesc(String docuDesc) {
		this.docuDesc = docuDesc;
	}

	@Transient
	public String getDocnumDesc() {
		return this.docNum + " - "+ this.docuDesc;
	}
	
	private String insertedBy;
	
	private Date insertedDate;
	@Column(name = "INSERTED_BY", length = 20)
	public String getInsertedBy() {
		return insertedBy;
	}

	public void setInsertedBy(String insertedBy) {
		this.insertedBy = insertedBy;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "INSERTED_DATE", nullable = true, length = 7)
	public Date getInsertedDate() {
		return insertedDate;
	}

	public void setInsertedDate(Date insertedDate) {
		this.insertedDate = insertedDate;
	}
	@Column(name = "DOCU_NAME", length = 200)
	public String getDocuName() {
		return docuName;
	}

	public void setDocuName(String docuName) {
		this.docuName = docuName;
	}

}