package com.sci.bpm.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "SCI_RAW_MI_DETAILS", schema = "SCIGENICS", uniqueConstraints = {})
public class SciRawMIDetails implements java.io.Serializable {

	private Long seqRawMIid;
	
	private Long seqOrigMIID;
	
	private Long seqSubContMIID;

	
	@Id
	@Column(name = "SEQ_RAW_MI_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 9, scale = 0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SCI_RAW_MI_SEQ")
	@SequenceGenerator(allocationSize=1, sequenceName="SCI_RAW_MI_SEQ" ,name="SCI_RAW_MI_SEQ" )
	public Long getSeqRawMIid() {
		return seqRawMIid;
	}

	public void setSeqRawMIid(Long seqRawMIid) {
		this.seqRawMIid = seqRawMIid;
	}
	
	@Column(name = "SEQ_ORIG_MI_ID", unique = false, nullable = false, insertable = true, updatable = true, precision = 9, scale = 0)

	public Long getSeqOrigMIID() {
		return seqOrigMIID;
	}

	public void setSeqOrigMIID(Long seqOrigMIID) {
		this.seqOrigMIID = seqOrigMIID;
	}

	@Column(name = "SEQ_SUB_CONT_MI_ID", unique = false, nullable = false, insertable = true, updatable = true, precision = 9, scale = 0)
	public Long getSeqSubContMIID() {
		return seqSubContMIID;
	}

	public void setSeqSubContMIID(Long seqSubContMIID) {
		this.seqSubContMIID = seqSubContMIID;
	}
	
	
	
}
