package com.sci.bpm.db.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "SCI_MINIMUM_MAT_LIST", schema = "SCIGENICS")
public class SciMinimumMatList implements Serializable {

	private String matCode;
	
	private String minimumQty;
	
	private String minimumCnt;

	@Id
	@Column(name = "MAT_CODE", unique = true, nullable = false, length=20)
	public String getMatCode() {
		return matCode;
	}

	public void setMatCode(String matCode) {
		this.matCode = matCode;
	}

	@Column(name = "MINIMUM_QTY", length = 100)
	public String getMinimumQty() {
		return minimumQty;
	}

	public void setMinimumQty(String minimumQty) {
		this.minimumQty = minimumQty;
	}

	@Column(name = "MINIMUM_CNT", length = 20)
	public String getMinimumCnt() {
		return minimumCnt;
	}

	public void setMinimumCnt(String minimumCnt) {
		this.minimumCnt = minimumCnt;
	}
	
	
	
}
