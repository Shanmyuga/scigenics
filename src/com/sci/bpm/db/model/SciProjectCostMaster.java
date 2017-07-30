package com.sci.bpm.db.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * SciProjectCostMaster entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SCI_PROJECT_COST_MASTER", schema = "SCIGENICS")
public class SciProjectCostMaster implements java.io.Serializable {

	// Fields

	private Long seqProjCostId;
	private Long seqWorkId;
	private String insertedBy;
	private String updatedBy;
	private Date updatedDate;
	private Integer totalCost;
	private String approvedBy;
	private Date insertDate;
	private String costCategory;
	private String costRemarks;

	// Constructors

	/** default constructor */
	public SciProjectCostMaster() {
	}

	/** minimal constructor */
	public SciProjectCostMaster(Long seqProjCostId, Long seqWorkId,
			String insertedBy, String updatedBy, Date updatedDate,
			Date insertDate, String costCategory) {
		this.seqProjCostId = seqProjCostId;
		this.seqWorkId = seqWorkId;
		this.insertedBy = insertedBy;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.insertDate = insertDate;
		this.costCategory = costCategory;
	}

	/** full constructor */
	public SciProjectCostMaster(Long seqProjCostId, Long seqWorkId,
			String insertedBy, String updatedBy, Date updatedDate,
			Integer totalCost, String approvedBy, Date insertDate,
			String costCategory, String costRemarks) {
		this.seqProjCostId = seqProjCostId;
		this.seqWorkId = seqWorkId;
		this.insertedBy = insertedBy;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.totalCost = totalCost;
		this.approvedBy = approvedBy;
		this.insertDate = insertDate;
		this.costCategory = costCategory;
		this.costRemarks = costRemarks;
	}
	@Id
	@Column(name = "SEQ_PROJ_COST_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SCI_PROJ_COST_MASTER_SEQ")
	@SequenceGenerator(allocationSize=1, sequenceName="SCI_PROJ_COST_MASTER_SEQ" ,name="SCI_PROJ_COST_MASTER_SEQ" )
	// Property accessors

	public Long getSeqProjCostId() {
		return this.seqProjCostId;
	}

	public void setSeqProjCostId(Long seqProjCostId) {
		this.seqProjCostId = seqProjCostId;
	}

	@Column(name = "SEQ_WORK_ID", nullable = false, precision = 0)
	public Long getSeqWorkId() {
		return this.seqWorkId;
	}

	public void setSeqWorkId(Long seqWorkId) {
		this.seqWorkId = seqWorkId;
	}

	@Column(name = "INSERTED_BY", nullable = false, length = 20)
	public String getInsertedBy() {
		return this.insertedBy;
	}

	public void setInsertedBy(String insertedBy) {
		this.insertedBy = insertedBy;
	}

	@Column(name = "UPDATED_BY", nullable = false, length = 20)
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Column(name = "UPDATED_DATE", nullable = false, length = 7)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name = "TOTAL_COST", precision = 9, scale = 0)
	public Integer getTotalCost() {
		return this.totalCost;
	}

	public void setTotalCost(Integer totalCost) {
		this.totalCost = totalCost;
	}

	@Column(name = "APPROVED_BY", length = 20)
	public String getApprovedBy() {
		return this.approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	@Column(name = "INSERT_DATE", nullable = false, length = 7)
	public Date getInsertDate() {
		return this.insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

	@Column(name = "COST_CATEGORY", nullable = false, length = 100)
	public String getCostCategory() {
		return this.costCategory;
	}

	public void setCostCategory(String costCategory) {
		this.costCategory = costCategory;
	}

	@Column(name = "COST_REMARKS", length = 150)
	public String getCostRemarks() {
		return this.costRemarks;
	}

	public void setCostRemarks(String costRemarks) {
		this.costRemarks = costRemarks;
	}

}