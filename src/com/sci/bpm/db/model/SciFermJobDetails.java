package com.sci.bpm.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * SciFermJobDetails entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SCI_FERM_JOB_DETAILS", schema = "SCIGENICS")
public class SciFermJobDetails implements java.io.Serializable {

	// Fields

	private Long seqJobDetailsId;
	private SciWorkorderMaster sciWorkorderMaster;
	private Long designCode;
	private String vesselVolume;
	private Double htDiaRatio;
	private Long standardVessel;
	private Long fermBrothViscos;
	private Long densityBroth;
	private String suspendedSolids;
	private Long airFlowRate;
	private Double designShellPres;
	private Double designJackPress;
	private Double designTempShell;
	private Double designJackTemp;
	private String internalSurfFinish;
	private String extSurfFinish;
	private Long mocContptLov;
	private Long mocNoncontptLov;
	private Long supportTypeLov;
	private Long supportMocLov;
	private String agitatorType;
	private Long impellerNum;
	private Long impellerDia;
	private Long agitatorSpeed;
	private String lanternType;
	private Long motorPower;
	private Long motorSpeed;
	private String powerSupply;
	private String classProtection;
	private String transmissionBy;
	private String mechanicalSeal;
	private Long equispacedBaffles;
	private String vfd;
	private String ruptureDisk;
	private String samplingValve;
	private String harvestValve;
	private Long quantity;

	// Constructors

	/** default constructor */
	public SciFermJobDetails() {
	}

	/** minimal constructor */
	public SciFermJobDetails(Long seqJobDetailsId) {
		this.seqJobDetailsId = seqJobDetailsId;
	}

	/** full constructor */
	public SciFermJobDetails(Long seqJobDetailsId,
			SciWorkorderMaster sciWorkorderMaster, Long designCode,
			String vesselVolume, Double htDiaRatio, Long standardVessel,
			Long fermBrothViscos, Long densityBroth, String suspendedSolids,
			Long airFlowRate, Double designShellPres, Double designJackPress,
			Double designTempShell, Double designJackTemp,
			String internalSurfFinish, String extSurfFinish, Long mocContptLov,
			Long mocNoncontptLov, Long supportTypeLov, Long supportMocLov,
			String agitatorType, Long impellerNum, Long impellerDia,
			Long agitatorSpeed, String lanternType, Long motorPower,
			Long motorSpeed, String powerSupply, String classProtection,
			String transmissionBy, String mechanicalSeal,
			Long equispacedBaffles, String vfd, String ruptureDisk,
			String samplingValve, String harvestValve, Long quantity) {
		this.seqJobDetailsId = seqJobDetailsId;
		this.sciWorkorderMaster = sciWorkorderMaster;
		this.designCode = designCode;
		this.vesselVolume = vesselVolume;
		this.htDiaRatio = htDiaRatio;
		this.standardVessel = standardVessel;
		this.fermBrothViscos = fermBrothViscos;
		this.densityBroth = densityBroth;
		this.suspendedSolids = suspendedSolids;
		this.airFlowRate = airFlowRate;
		this.designShellPres = designShellPres;
		this.designJackPress = designJackPress;
		this.designTempShell = designTempShell;
		this.designJackTemp = designJackTemp;
		this.internalSurfFinish = internalSurfFinish;
		this.extSurfFinish = extSurfFinish;
		this.mocContptLov = mocContptLov;
		this.mocNoncontptLov = mocNoncontptLov;
		this.supportTypeLov = supportTypeLov;
		this.supportMocLov = supportMocLov;
		this.agitatorType = agitatorType;
		this.impellerNum = impellerNum;
		this.impellerDia = impellerDia;
		this.agitatorSpeed = agitatorSpeed;
		this.lanternType = lanternType;
		this.motorPower = motorPower;
		this.motorSpeed = motorSpeed;
		this.powerSupply = powerSupply;
		this.classProtection = classProtection;
		this.transmissionBy = transmissionBy;
		this.mechanicalSeal = mechanicalSeal;
		this.equispacedBaffles = equispacedBaffles;
		this.vfd = vfd;
		this.ruptureDisk = ruptureDisk;
		this.samplingValve = samplingValve;
		this.harvestValve = harvestValve;
		this.quantity = quantity;
	}
	@Id
	@Column(name = "SEQ_JOB_DETAILS_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SCI_JOB_DESC_DETAILS_SEQ")
	@SequenceGenerator(allocationSize=1, sequenceName="SCI_JOB_DESC_DETAILS_SEQ" ,name="SCI_JOB_DESC_DETAILS_SEQ" )
	// Property accessors
	
	public Long getSeqJobDetailsId() {
		return this.seqJobDetailsId;
	}

	public void setSeqJobDetailsId(Long seqJobDetailsId) {
		this.seqJobDetailsId = seqJobDetailsId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SEQ_WORK_ID")
	public SciWorkorderMaster getSciWorkorderMaster() {
		return this.sciWorkorderMaster;
	}

	public void setSciWorkorderMaster(SciWorkorderMaster sciWorkorderMaster) {
		this.sciWorkorderMaster = sciWorkorderMaster;
	}

	@Column(name = "DESIGN_CODE", precision = 22, scale = 0)
	public Long getDesignCode() {
		return this.designCode;
	}

	public void setDesignCode(Long designCode) {
		this.designCode = designCode;
	}

	@Column(name = "VESSEL_VOLUME", length = 10)
	public String getVesselVolume() {
		return this.vesselVolume;
	}

	public void setVesselVolume(String vesselVolume) {
		this.vesselVolume = vesselVolume;
	}

	@Column(name = "HT_DIA_RATIO", precision = 1, scale = 4)
	public Double getHtDiaRatio() {
		return this.htDiaRatio;
	}

	public void setHtDiaRatio(Double htDiaRatio) {
		this.htDiaRatio = htDiaRatio;
	}

	@Column(name = "STANDARD_VESSEL", precision = 22, scale = 0)
	public Long getStandardVessel() {
		return this.standardVessel;
	}

	public void setStandardVessel(Long standardVessel) {
		this.standardVessel = standardVessel;
	}

	@Column(name = "FERM_BROTH_VISCOS", precision = 22, scale = 0)
	public Long getFermBrothViscos() {
		return this.fermBrothViscos;
	}

	public void setFermBrothViscos(Long fermBrothViscos) {
		this.fermBrothViscos = fermBrothViscos;
	}

	@Column(name = "DENSITY_BROTH", precision = 22, scale = 0)
	public Long getDensityBroth() {
		return this.densityBroth;
	}

	public void setDensityBroth(Long densityBroth) {
		this.densityBroth = densityBroth;
	}

	@Column(name = "SUSPENDED_SOLIDS", length = 10)
	public String getSuspendedSolids() {
		return this.suspendedSolids;
	}

	public void setSuspendedSolids(String suspendedSolids) {
		this.suspendedSolids = suspendedSolids;
	}

	@Column(name = "AIR_FLOW_RATE", precision = 22, scale = 0)
	public Long getAirFlowRate() {
		return this.airFlowRate;
	}

	public void setAirFlowRate(Long airFlowRate) {
		this.airFlowRate = airFlowRate;
	}

	@Column(name = "DESIGN_SHELL_PRES", precision = 1, scale = 7)
	public Double getDesignShellPres() {
		return this.designShellPres;
	}

	public void setDesignShellPres(Double designShellPres) {
		this.designShellPres = designShellPres;
	}

	@Column(name = "DESIGN_JACK_PRESS", precision = 1, scale = 7)
	public Double getDesignJackPress() {
		return this.designJackPress;
	}

	public void setDesignJackPress(Double designJackPress) {
		this.designJackPress = designJackPress;
	}

	@Column(name = "DESIGN_TEMP_SHELL", precision = 2, scale = 5)
	public Double getDesignTempShell() {
		return this.designTempShell;
	}

	public void setDesignTempShell(Double designTempShell) {
		this.designTempShell = designTempShell;
	}

	@Column(name = "DESIGN_JACK_TEMP", precision = 2, scale = 5)
	public Double getDesignJackTemp() {
		return this.designJackTemp;
	}

	public void setDesignJackTemp(Double designJackTemp) {
		this.designJackTemp = designJackTemp;
	}

	@Column(name = "INTERNAL_SURF_FINISH", length = 10)
	public String getInternalSurfFinish() {
		return this.internalSurfFinish;
	}

	public void setInternalSurfFinish(String internalSurfFinish) {
		this.internalSurfFinish = internalSurfFinish;
	}

	@Column(name = "EXT_SURF_FINISH", length = 10)
	public String getExtSurfFinish() {
		return this.extSurfFinish;
	}

	public void setExtSurfFinish(String extSurfFinish) {
		this.extSurfFinish = extSurfFinish;
	}

	@Column(name = "MOC_CONTPT_LOV", precision = 22, scale = 0)
	public Long getMocContptLov() {
		return this.mocContptLov;
	}

	public void setMocContptLov(Long mocContptLov) {
		this.mocContptLov = mocContptLov;
	}

	@Column(name = "MOC_NONCONTPT_LOV", precision = 22, scale = 0)
	public Long getMocNoncontptLov() {
		return this.mocNoncontptLov;
	}

	public void setMocNoncontptLov(Long mocNoncontptLov) {
		this.mocNoncontptLov = mocNoncontptLov;
	}

	@Column(name = "SUPPORT_TYPE_LOV", precision = 22, scale = 0)
	public Long getSupportTypeLov() {
		return this.supportTypeLov;
	}

	public void setSupportTypeLov(Long supportTypeLov) {
		this.supportTypeLov = supportTypeLov;
	}

	@Column(name = "SUPPORT_MOC_LOV", precision = 22, scale = 0)
	public Long getSupportMocLov() {
		return this.supportMocLov;
	}

	public void setSupportMocLov(Long supportMocLov) {
		this.supportMocLov = supportMocLov;
	}

	@Column(name = "AGITATOR_TYPE", length = 100)
	public String getAgitatorType() {
		return this.agitatorType;
	}

	public void setAgitatorType(String agitatorType) {
		this.agitatorType = agitatorType;
	}

	@Column(name = "IMPELLER_NUM", precision = 2, scale = 0)
	public Long getImpellerNum() {
		return this.impellerNum;
	}

	public void setImpellerNum(Long impellerNum) {
		this.impellerNum = impellerNum;
	}

	@Column(name = "IMPELLER_DIA", precision = 9, scale = 0)
	public Long getImpellerDia() {
		return this.impellerDia;
	}

	public void setImpellerDia(Long impellerDia) {
		this.impellerDia = impellerDia;
	}

	@Column(name = "AGITATOR_SPEED", precision = 9, scale = 0)
	public Long getAgitatorSpeed() {
		return this.agitatorSpeed;
	}

	public void setAgitatorSpeed(Long agitatorSpeed) {
		this.agitatorSpeed = agitatorSpeed;
	}

	@Column(name = "LANTERN_TYPE", length = 100)
	public String getLanternType() {
		return this.lanternType;
	}

	public void setLanternType(String lanternType) {
		this.lanternType = lanternType;
	}

	@Column(name = "MOTOR_POWER", precision = 9, scale = 0)
	public Long getMotorPower() {
		return this.motorPower;
	}

	public void setMotorPower(Long motorPower) {
		this.motorPower = motorPower;
	}

	@Column(name = "MOTOR_SPEED", precision = 9, scale = 0)
	public Long getMotorSpeed() {
		return this.motorSpeed;
	}

	public void setMotorSpeed(Long motorSpeed) {
		this.motorSpeed = motorSpeed;
	}

	@Column(name = "POWER_SUPPLY", length = 100)
	public String getPowerSupply() {
		return this.powerSupply;
	}

	public void setPowerSupply(String powerSupply) {
		this.powerSupply = powerSupply;
	}

	@Column(name = "CLASS_PROTECTION", length = 100)
	public String getClassProtection() {
		return this.classProtection;
	}

	public void setClassProtection(String classProtection) {
		this.classProtection = classProtection;
	}

	@Column(name = "TRANSMISSION_BY", length = 50)
	public String getTransmissionBy() {
		return this.transmissionBy;
	}

	public void setTransmissionBy(String transmissionBy) {
		this.transmissionBy = transmissionBy;
	}

	@Column(name = "MECHANICAL_SEAL", length = 100)
	public String getMechanicalSeal() {
		return this.mechanicalSeal;
	}

	public void setMechanicalSeal(String mechanicalSeal) {
		this.mechanicalSeal = mechanicalSeal;
	}

	@Column(name = "EQUISPACED_BAFFLES", precision = 2, scale = 0)
	public Long getEquispacedBaffles() {
		return this.equispacedBaffles;
	}

	public void setEquispacedBaffles(Long equispacedBaffles) {
		this.equispacedBaffles = equispacedBaffles;
	}

	@Column(name = "VFD", length = 1)
	public String getVfd() {
		return this.vfd;
	}

	public void setVfd(String vfd) {
		this.vfd = vfd;
	}

	@Column(name = "RUPTURE_DISK", length = 1)
	public String getRuptureDisk() {
		return this.ruptureDisk;
	}

	public void setRuptureDisk(String ruptureDisk) {
		this.ruptureDisk = ruptureDisk;
	}

	@Column(name = "SAMPLING_VALVE", length = 1)
	public String getSamplingValve() {
		return this.samplingValve;
	}

	public void setSamplingValve(String samplingValve) {
		this.samplingValve = samplingValve;
	}

	@Column(name = "HARVEST_VALVE", length = 1)
	public String getHarvestValve() {
		return this.harvestValve;
	}

	public void setHarvestValve(String harvestValve) {
		this.harvestValve = harvestValve;
	}

	@Column(name = "QUANTITY", precision = 22, scale = 0)
	public Long getQuantity() {
		return this.quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

}