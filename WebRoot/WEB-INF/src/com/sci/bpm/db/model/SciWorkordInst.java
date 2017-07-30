package com.sci.bpm.db.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * SciWorkordInst entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SCI_WORKORD_INST", schema = "SCIGENICS")
public class SciWorkordInst implements java.io.Serializable {

	// Fields

	private Long seqWorkInstru;
	private Long seqWorkId;
	private String flowRange;
	private String flowRangeSpec;
	private String inletAirFilter;
	private String inletAirFilterSpec;
	private String inlMake;
	private String exhAirFilter;
	private String exhAirFilterSpec;
	private String exhMake;
	private String flowmeter;
	private String flowmeterSpec;
	private String flowmeterMake;
	private String exhCondensor;

	// Constructors

	/** default constructor */
	public SciWorkordInst() {
	}

	/** minimal constructor */
	public SciWorkordInst(Long seqWorkInstru) {
		this.seqWorkInstru = seqWorkInstru;
	}

	/** full constructor */
	public SciWorkordInst(Long seqWorkInstru, Long seqWorkId, String flowRange,
			String flowRangeSpec, String inletAirFilter,
			String inletAirFilterSpec, String inlMake, String exhAirFilter,
			String exhAirFilterSpec, String exhMake, String flowmeter,
			String flowmeterSpec, String flowmeterMake, String exhCondensor) {
		this.seqWorkInstru = seqWorkInstru;
		this.seqWorkId = seqWorkId;
		this.flowRange = flowRange;
		this.flowRangeSpec = flowRangeSpec;
		this.inletAirFilter = inletAirFilter;
		this.inletAirFilterSpec = inletAirFilterSpec;
		this.inlMake = inlMake;
		this.exhAirFilter = exhAirFilter;
		this.exhAirFilterSpec = exhAirFilterSpec;
		this.exhMake = exhMake;
		this.flowmeter = flowmeter;
		this.flowmeterSpec = flowmeterSpec;
		this.flowmeterMake = flowmeterMake;
		this.exhCondensor = exhCondensor;
	}

	// Property accessors
	@Id
	@Column(name = "SEQ_WORK_INSTRU", unique = true, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	
	public Long getSeqWorkInstru() {
		return this.seqWorkInstru;
	}

	public void setSeqWorkInstru(Long seqWorkInstru) {
		this.seqWorkInstru = seqWorkInstru;
	}

	@Column(name = "SEQ_WORK_ID", precision = 22, scale = 0)
	public Long getSeqWorkId() {
		return this.seqWorkId;
	}

	public void setSeqWorkId(Long seqWorkId) {
		this.seqWorkId = seqWorkId;
	}

	@Column(name = "FLOW_RANGE", length = 20)
	public String getFlowRange() {
		return this.flowRange;
	}

	public void setFlowRange(String flowRange) {
		this.flowRange = flowRange;
	}

	@Column(name = "FLOW_RANGE_SPEC", length = 20)
	public String getFlowRangeSpec() {
		return this.flowRangeSpec;
	}

	public void setFlowRangeSpec(String flowRangeSpec) {
		this.flowRangeSpec = flowRangeSpec;
	}

	@Column(name = "INLET_AIR_FILTER", length = 20)
	public String getInletAirFilter() {
		return this.inletAirFilter;
	}

	public void setInletAirFilter(String inletAirFilter) {
		this.inletAirFilter = inletAirFilter;
	}

	@Column(name = "INLET_AIR_FILTER_SPEC", length = 20)
	public String getInletAirFilterSpec() {
		return this.inletAirFilterSpec;
	}

	public void setInletAirFilterSpec(String inletAirFilterSpec) {
		this.inletAirFilterSpec = inletAirFilterSpec;
	}

	@Column(name = "INL_MAKE", length = 20)
	public String getInlMake() {
		return this.inlMake;
	}

	public void setInlMake(String inlMake) {
		this.inlMake = inlMake;
	}

	@Column(name = "EXH_AIR_FILTER", length = 20)
	public String getExhAirFilter() {
		return this.exhAirFilter;
	}

	public void setExhAirFilter(String exhAirFilter) {
		this.exhAirFilter = exhAirFilter;
	}

	@Column(name = "EXH_AIR_FILTER_SPEC", length = 20)
	public String getExhAirFilterSpec() {
		return this.exhAirFilterSpec;
	}

	public void setExhAirFilterSpec(String exhAirFilterSpec) {
		this.exhAirFilterSpec = exhAirFilterSpec;
	}

	@Column(name = "EXH_MAKE", length = 20)
	public String getExhMake() {
		return this.exhMake;
	}

	public void setExhMake(String exhMake) {
		this.exhMake = exhMake;
	}

	@Column(name = "FLOWMETER", length = 20)
	public String getFlowmeter() {
		return this.flowmeter;
	}

	public void setFlowmeter(String flowmeter) {
		this.flowmeter = flowmeter;
	}

	@Column(name = "FLOWMETER_SPEC", length = 20)
	public String getFlowmeterSpec() {
		return this.flowmeterSpec;
	}

	public void setFlowmeterSpec(String flowmeterSpec) {
		this.flowmeterSpec = flowmeterSpec;
	}

	@Column(name = "FLOWMETER_MAKE", length = 20)
	public String getFlowmeterMake() {
		return this.flowmeterMake;
	}

	public void setFlowmeterMake(String flowmeterMake) {
		this.flowmeterMake = flowmeterMake;
	}

	@Column(name = "EXH_CONDENSOR", length = 20)
	public String getExhCondensor() {
		return this.exhCondensor;
	}

	public void setExhCondensor(String exhCondensor) {
		this.exhCondensor = exhCondensor;
	}

}