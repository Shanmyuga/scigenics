package com.sci.bpm.command.marketing;

import java.io.Serializable;

public class SciWorkordInstCommand implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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
	public Long getSeqWorkInstru() {
		return seqWorkInstru;
	}
	public void setSeqWorkInstru(Long seqWorkInstru) {
		this.seqWorkInstru = seqWorkInstru;
	}
	public Long getSeqWorkId() {
		return seqWorkId;
	}
	public void setSeqWorkId(Long seqWorkId) {
		this.seqWorkId = seqWorkId;
	}
	public String getFlowRange() {
		return flowRange;
	}
	public void setFlowRange(String flowRange) {
		this.flowRange = flowRange;
	}
	public String getFlowRangeSpec() {
		return flowRangeSpec;
	}
	public void setFlowRangeSpec(String flowRangeSpec) {
		this.flowRangeSpec = flowRangeSpec;
	}
	public String getInletAirFilter() {
		return inletAirFilter;
	}
	public void setInletAirFilter(String inletAirFilter) {
		this.inletAirFilter = inletAirFilter;
	}
	public String getInletAirFilterSpec() {
		return inletAirFilterSpec;
	}
	public void setInletAirFilterSpec(String inletAirFilterSpec) {
		this.inletAirFilterSpec = inletAirFilterSpec;
	}
	public String getInlMake() {
		return inlMake;
	}
	public void setInlMake(String inlMake) {
		this.inlMake = inlMake;
	}
	public String getExhAirFilter() {
		return exhAirFilter;
	}
	public void setExhAirFilter(String exhAirFilter) {
		this.exhAirFilter = exhAirFilter;
	}
	public String getExhAirFilterSpec() {
		return exhAirFilterSpec;
	}
	public void setExhAirFilterSpec(String exhAirFilterSpec) {
		this.exhAirFilterSpec = exhAirFilterSpec;
	}
	public String getExhMake() {
		return exhMake;
	}
	public void setExhMake(String exhMake) {
		this.exhMake = exhMake;
	}
	public String getFlowmeter() {
		return flowmeter;
	}
	public void setFlowmeter(String flowmeter) {
		this.flowmeter = flowmeter;
	}
	public String getFlowmeterSpec() {
		return flowmeterSpec;
	}
	public void setFlowmeterSpec(String flowmeterSpec) {
		this.flowmeterSpec = flowmeterSpec;
	}
	public String getFlowmeterMake() {
		return flowmeterMake;
	}
	public void setFlowmeterMake(String flowmeterMake) {
		this.flowmeterMake = flowmeterMake;
	}
	public String getExhCondensor() {
		return exhCondensor;
	}
	public void setExhCondensor(String exhCondensor) {
		this.exhCondensor = exhCondensor;
	}
	
	
}
