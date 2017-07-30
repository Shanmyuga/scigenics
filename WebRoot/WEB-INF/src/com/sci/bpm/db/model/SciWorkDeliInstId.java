package com.sci.bpm.db.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SciWorkDeliInstId entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Embeddable
public class SciWorkDeliInstId implements java.io.Serializable {

	// Fields

	private Long seqWorkId;
	private Long delLovId;

	// Constructors

	/** default constructor */
	public SciWorkDeliInstId() {
	}

	/** full constructor */
	public SciWorkDeliInstId(Long seqWorkId, Long delLovId) {
		this.seqWorkId = seqWorkId;
		this.delLovId = delLovId;
	}

	// Property accessors

	@Column(name = "SEQ_WORK_ID", unique = false, nullable = true, insertable = true, updatable = true, precision = 22, scale = 0)
	public Long getSeqWorkId() {
		return this.seqWorkId;
	}

	public void setSeqWorkId(Long seqWorkId) {
		this.seqWorkId = seqWorkId;
	}

	@Column(name = "DEL_LOV_ID", unique = false, nullable = true, insertable = true, updatable = true, precision = 22, scale = 0)
	public Long getDelLovId() {
		return this.delLovId;
	}

	public void setDelLovId(Long delLovId) {
		this.delLovId = delLovId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof SciWorkDeliInstId))
			return false;
		SciWorkDeliInstId castOther = (SciWorkDeliInstId) other;

		return ((this.getSeqWorkId() == castOther.getSeqWorkId()) || (this
				.getSeqWorkId() != null
				&& castOther.getSeqWorkId() != null && this.getSeqWorkId()
				.equals(castOther.getSeqWorkId())))
				&& ((this.getDelLovId() == castOther.getDelLovId()) || (this
						.getDelLovId() != null
						&& castOther.getDelLovId() != null && this
						.getDelLovId().equals(castOther.getDelLovId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getSeqWorkId() == null ? 0 : this.getSeqWorkId().hashCode());
		result = 37 * result
				+ (getDelLovId() == null ? 0 : this.getDelLovId().hashCode());
		return result;
	}

}