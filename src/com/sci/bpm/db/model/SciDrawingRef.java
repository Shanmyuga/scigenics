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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SciDrawingRef entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SCI_DRAWING_REF", schema = "SCIGENICS")
public class SciDrawingRef implements java.io.Serializable {

	// Fields

	private Long seqDrawingId;
	private SciWorkorderMaster sciWorkorderMaster;
	private String drawingDesc;
	private String documentName;
	private String updatedBy;
	private Date updatedDate;
	private String drwingRefnum;
	private SciDesignDocMaster desgDocMaster;
	private Set<SciDrwingDetails> sciDrwingDetailses = new HashSet<SciDrwingDetails>(
			0);

	// Constructors

	/** default constructor */
	public SciDrawingRef() {
	}

	/** minimal constructor */
	public SciDrawingRef(Long seqDrawingId,
			SciWorkorderMaster sciWorkorderMaster, String drawingDesc,
			String documentName, String updatedBy, Date updatedDate,
			String drwingRefnum) {
		this.seqDrawingId = seqDrawingId;
		this.sciWorkorderMaster = sciWorkorderMaster;
		this.drawingDesc = drawingDesc;
		this.documentName = documentName;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.drwingRefnum = drwingRefnum;
	}

	/** full constructor */
	public SciDrawingRef(Long seqDrawingId,
			SciWorkorderMaster sciWorkorderMaster, String drawingDesc,
			String documentName, String updatedBy, Date updatedDate,
			String drwingRefnum, Set<SciDrwingDetails> sciDrwingDetailses) {
		this.seqDrawingId = seqDrawingId;
		this.sciWorkorderMaster = sciWorkorderMaster;
		this.drawingDesc = drawingDesc;
		this.documentName = documentName;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.drwingRefnum = drwingRefnum;
		this.sciDrwingDetailses = sciDrwingDetailses;
	}

	// Property accessors
	@Id
	@Column(name = "SEQ_DRAWING_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SCI_DRAWING_REF_SEQ")
	@SequenceGenerator(allocationSize=1, sequenceName="SCI_DRAWING_REF_SEQ" ,name="SCI_DRAWING_REF_SEQ" )
	public Long getSeqDrawingId() {
		return this.seqDrawingId;
	}

	public void setSeqDrawingId(Long seqDrawingId) {
		this.seqDrawingId = seqDrawingId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SEQ_WORK_ID", nullable = false)
	public SciWorkorderMaster getSciWorkorderMaster() {
		return this.sciWorkorderMaster;
	}

	public void setSciWorkorderMaster(SciWorkorderMaster sciWorkorderMaster) {
		this.sciWorkorderMaster = sciWorkorderMaster;
	}

	@Column(name = "DRAWING_DESC", nullable = false, length = 200)
	public String getDrawingDesc() {
		return this.drawingDesc;
	}

	public void setDrawingDesc(String drawingDesc) {
		this.drawingDesc = drawingDesc;
	}

	@Column(name = "DOCUMENT_NAME", nullable = false, length = 500)
	public String getDocumentName() {
		return this.documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	@Column(name = "UPDATED_BY", nullable = false, length = 20)
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DATE", nullable = false, length = 7)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name = "DRWING_REFNUM", nullable = true, length = 20)
	public String getDrwingRefnum() {
		return this.drwingRefnum;
	}

	public void setDrwingRefnum(String drwingRefnum) {
		this.drwingRefnum = drwingRefnum;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "sciDrawingRef")
	public Set<SciDrwingDetails> getSciDrwingDetailses() {
		return this.sciDrwingDetailses;
	}

	public void setSciDrwingDetailses(Set<SciDrwingDetails> sciDrwingDetailses) {
		this.sciDrwingDetailses = sciDrwingDetailses;
	}
	
	public void adddesignDetails(SciDrwingDetails details) {
		details.setSciDrawingRef(this);
		this.sciDrwingDetailses.add(details);
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SEQ_DOC_ID", nullable = false)
	public SciDesignDocMaster getDesgDocMaster() {
		return desgDocMaster;
	}

	public void setDesgDocMaster(SciDesignDocMaster desgDocMaster) {
		this.desgDocMaster = desgDocMaster;
	}


}