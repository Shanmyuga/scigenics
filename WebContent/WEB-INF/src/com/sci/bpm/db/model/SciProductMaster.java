package com.sci.bpm.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * SciProductMaster entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SCI_PRODUCT_MASTER", schema = "SCIGENICS")
public class SciProductMaster implements java.io.Serializable {

	// Fields

	private Long seqProductId;
	private String productId;
	private String productCat;
	private String productSpec;

	// Constructors

	/** default constructor */
	public SciProductMaster() {
	}

	/** minimal constructor */
	public SciProductMaster(Long seqProductId) {
		this.seqProductId = seqProductId;
	}

	/** full constructor */
	public SciProductMaster(Long seqProductId, String productId,
			String productCat, String productSpec) {
		this.seqProductId = seqProductId;
		this.productId = productId;
		this.productCat = productCat;
		this.productSpec = productSpec;
	}

	// Property accessors
	@Id
	@Column(name = "SEQ_PRODUCT_ID", unique = true, nullable = false, precision = 22, scale = 0)
	public Long getSeqProductId() {
		return this.seqProductId;
	}

	public void setSeqProductId(Long seqProductId) {
		this.seqProductId = seqProductId;
	}

	@Column(name = "PRODUCT_ID", length = 20)
	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	@Column(name = "PRODUCT_CAT", length = 20)
	public String getProductCat() {
		return this.productCat;
	}

	public void setProductCat(String productCat) {
		this.productCat = productCat;
	}

	@Column(name = "PRODUCT_SPEC", length = 100)
	public String getProductSpec() {
		return this.productSpec;
	}

	public void setProductSpec(String productSpec) {
		this.productSpec = productSpec;
	}

}