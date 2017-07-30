package com.sci.bpm.db.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SciWorkInspectionId entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Embeddable
public class SciWorkInspectionId implements java.io.Serializable {

	// Fields

	private Long seqWorkId;
	private Long inspectionLovId;

	// Constructors

	/** default constructor */
	public SciWorkInspectionId() {
	}

	/** full constructor */
	public SciWorkInspectionId(Long seqWorkId, Long inspectionLovId) {
		this.seqWorkId = seqWorkId;
		this.inspectionLovId = inspectionLovId;
	}

	// Property accessors

	@Column(name = "SEQ_WORK_ID", unique = false, nullable = true, insertable = true, updatable = true, precision = 22, scale = 0)
	public Long getSeqWorkId() {
		return this.seqWorkId;
	}

	public void setSeqWorkId(Long seqWorkId) {
		this.seqWorkId = seqWorkId;
	}

	@Column(name = "INSPECTION_LOV_ID", unique = false, nullable = true, insertable = true, updatable = true, precision = 22, scale = 0)
	public Long getInspectionLovId() {
		return this.inspectionLovId;
	}

	public void setInspectionLovId(Long inspectionLovId) {
		this.inspectionLovId = inspectionLovId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SciWorkInspectionId))
			return false;
		SciWorkInspectionId castOther = (SciWorkInspectionId) other;

		return ((this.getSeqWorkId() == castOther.getSeqWorkId()) || (this
				.getSeqWorkId() != null
				&& castOther.getSeqWorkId() != null && this.getSeqWorkId()
				.equals(castOther.getSeqWorkId())))
				&& ((this.getInspectionLovId() == castOther
						.getInspectionLovId()) || (this.getInspectionLovId() != null
						&& castOther.getInspectionLovId() != null && this
						.getInspectionLovId().equals(
								castOther.getInspectionLovId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getSeqWorkId() == null ? 0 : this.getSeqWorkId().hashCode());
		result = 37
				* result
				+ (getInspectionLovId() == null ? 0 : this.getInspectionLovId()
						.hashCode());
		return result;
	}

}