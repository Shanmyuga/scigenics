package com.sci.bpm.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "WORKORDER_MI_PURCHASE_VIEW", schema = "SCIGENICS", uniqueConstraints = {})
@Immutable
public class PurchaseWorkOrderView {

	
	private Long seqPurchId;
	
	private Long seqMiId;
	
	private Long seqWorkId;
	
	private Long seqItemId;

	
	@Id
	@Column(name = "SEQ_PURCH_ID")
	public Long getSeqPurchId() {
		return seqPurchId;
	}

	public void setSeqPurchId(Long seqPurchId) {
		this.seqPurchId = seqPurchId;
	}
	@Column(name="SEQ_MI_ID")
	public Long getSeqMiId() {
		return seqMiId;
	}

	public void setSeqMiId(Long seqMiId) {
		this.seqMiId = seqMiId;
	}
	@Column(name="SEQ_WORK_ID")
	public Long getSeqWorkId() {
		return seqWorkId;
	}

	public void setSeqWorkId(Long seqWorkId) {
		this.seqWorkId = seqWorkId;
	}
	@Column(name="SEA_PURITEM_ID")
	public Long getSeqItemId() {
		return seqItemId;
	}

	public void setSeqItemId(Long seqItemId) {
		this.seqItemId = seqItemId;
	}
}
