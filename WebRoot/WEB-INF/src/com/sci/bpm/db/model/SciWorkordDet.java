package com.sci.bpm.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * SciWorkordDet entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SCI_WORKORD_DET", schema = "SCIGENICS" ,uniqueConstraints = {})
public class SciWorkordDet implements java.io.Serializable {

	// Fields

	private Long seqWorkDet;
	private Long seqWorkId;
	private String fermWorkType;
	private String totalVolume;
	private String workingVolume;
	private String quantity;
	private String desgShell;
	private String desgJacket;
	private String desgPres;
	private String desgTemp;
	private String desgClosurTop;
	private String desgClosurBott;
	private String finiInsiShell;
	private String finiInsiJacket;
	private String finiInsiPorts;
	private String finiInsiShaft;
	private String finiExtShaft;
	private String finiExtShell;
	private String finiExtPorts;
	private String finiExtJacket;

	// Constructors

	/** default constructor */
	public SciWorkordDet() {
	}

	/** minimal constructor */
	public SciWorkordDet(Long seqWorkDet) {
		this.seqWorkDet = seqWorkDet;
	}

	/** full constructor */
	public SciWorkordDet(Long seqWorkDet, Long seqWorkId, String fermWorkType,
			String totalVolume, String workingVolume, String quantity,
			String desgShell, String desgJacket, String desgPres,
			String desgTemp, String desgClosurTop, String desgClosurBott,
			String finiInsiShell, String finiInsiJacket, String finiInsiPorts,
			String finiInsiShaft, String finiExtShaft, String finiExtShell,
			String finiExtPorts, String finiExtJacket) {
		this.seqWorkDet = seqWorkDet;
		this.seqWorkId = seqWorkId;
		this.fermWorkType = fermWorkType;
		this.totalVolume = totalVolume;
		this.workingVolume = workingVolume;
		this.quantity = quantity;
		this.desgShell = desgShell;
		this.desgJacket = desgJacket;
		this.desgPres = desgPres;
		this.desgTemp = desgTemp;
		this.desgClosurTop = desgClosurTop;
		this.desgClosurBott = desgClosurBott;
		this.finiInsiShell = finiInsiShell;
		this.finiInsiJacket = finiInsiJacket;
		this.finiInsiPorts = finiInsiPorts;
		this.finiInsiShaft = finiInsiShaft;
		this.finiExtShaft = finiExtShaft;
		this.finiExtShell = finiExtShell;
		this.finiExtPorts = finiExtPorts;
		this.finiExtJacket = finiExtJacket;
	}

	// Property accessors
	@Id
	@Column(name = "SEQ_WORK_DET", unique = true, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	
	
	public Long getSeqWorkDet() {
		return this.seqWorkDet;
	}

	public void setSeqWorkDet(Long seqWorkDet) {
		this.seqWorkDet = seqWorkDet;
	}

	@Column(name = "SEQ_WORK_ID", precision = 22, scale = 0)
	public Long getSeqWorkId() {
		return this.seqWorkId;
	}

	public void setSeqWorkId(Long seqWorkId) {
		this.seqWorkId = seqWorkId;
	}

	@Column(name = "FERM_WORK_TYPE", length = 20)
	public String getFermWorkType() {
		return this.fermWorkType;
	}

	public void setFermWorkType(String fermWorkType) {
		this.fermWorkType = fermWorkType;
	}

	@Column(name = "TOTAL_VOLUME", length = 10)
	public String getTotalVolume() {
		return this.totalVolume;
	}

	public void setTotalVolume(String totalVolume) {
		this.totalVolume = totalVolume;
	}

	@Column(name = "WORKING_VOLUME", length = 10)
	public String getWorkingVolume() {
		return this.workingVolume;
	}

	public void setWorkingVolume(String workingVolume) {
		this.workingVolume = workingVolume;
	}

	@Column(name = "QUANTITY", length = 20)
	public String getQuantity() {
		return this.quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	@Column(name = "DESG_SHELL", length = 10)
	public String getDesgShell() {
		return this.desgShell;
	}

	public void setDesgShell(String desgShell) {
		this.desgShell = desgShell;
	}

	@Column(name = "DESG_JACKET", length = 20)
	public String getDesgJacket() {
		return this.desgJacket;
	}

	public void setDesgJacket(String desgJacket) {
		this.desgJacket = desgJacket;
	}

	@Column(name = "DESG_PRES", length = 10)
	public String getDesgPres() {
		return this.desgPres;
	}

	public void setDesgPres(String desgPres) {
		this.desgPres = desgPres;
	}

	@Column(name = "DESG_TEMP", length = 10)
	public String getDesgTemp() {
		return this.desgTemp;
	}

	public void setDesgTemp(String desgTemp) {
		this.desgTemp = desgTemp;
	}

	@Column(name = "DESG_CLOSUR_TOP", length = 20)
	public String getDesgClosurTop() {
		return this.desgClosurTop;
	}

	public void setDesgClosurTop(String desgClosurTop) {
		this.desgClosurTop = desgClosurTop;
	}

	@Column(name = "DESG_CLOSUR_BOTT", length = 20)
	public String getDesgClosurBott() {
		return this.desgClosurBott;
	}

	public void setDesgClosurBott(String desgClosurBott) {
		this.desgClosurBott = desgClosurBott;
	}

	@Column(name = "FINI_INSI_SHELL", length = 10)
	public String getFiniInsiShell() {
		return this.finiInsiShell;
	}

	public void setFiniInsiShell(String finiInsiShell) {
		this.finiInsiShell = finiInsiShell;
	}

	@Column(name = "FINI_INSI_JACKET", length = 20)
	public String getFiniInsiJacket() {
		return this.finiInsiJacket;
	}

	public void setFiniInsiJacket(String finiInsiJacket) {
		this.finiInsiJacket = finiInsiJacket;
	}

	@Column(name = "FINI_INSI_PORTS", length = 20)
	public String getFiniInsiPorts() {
		return this.finiInsiPorts;
	}

	public void setFiniInsiPorts(String finiInsiPorts) {
		this.finiInsiPorts = finiInsiPorts;
	}

	@Column(name = "FINI_INSI_SHAFT", length = 10)
	public String getFiniInsiShaft() {
		return this.finiInsiShaft;
	}

	public void setFiniInsiShaft(String finiInsiShaft) {
		this.finiInsiShaft = finiInsiShaft;
	}

	@Column(name = "FINI_EXT_SHAFT", length = 10)
	public String getFiniExtShaft() {
		return this.finiExtShaft;
	}

	public void setFiniExtShaft(String finiExtShaft) {
		this.finiExtShaft = finiExtShaft;
	}

	@Column(name = "FINI_EXT_SHELL", length = 10)
	public String getFiniExtShell() {
		return this.finiExtShell;
	}

	public void setFiniExtShell(String finiExtShell) {
		this.finiExtShell = finiExtShell;
	}

	@Column(name = "FINI_EXT_PORTS", length = 10)
	public String getFiniExtPorts() {
		return this.finiExtPorts;
	}

	public void setFiniExtPorts(String finiExtPorts) {
		this.finiExtPorts = finiExtPorts;
	}

	@Column(name = "FINI_EXT_JACKET", length = 10)
	public String getFiniExtJacket() {
		return this.finiExtJacket;
	}

	public void setFiniExtJacket(String finiExtJacket) {
		this.finiExtJacket = finiExtJacket;
	}

}