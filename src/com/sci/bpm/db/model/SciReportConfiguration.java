package com.sci.bpm.db.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * SciReportConfiguration entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SCI_REPORT_CONFIGURATION", schema = "SCIGENICS")
public class SciReportConfiguration implements java.io.Serializable {

	// Fields

	private Long seqRepConfigId;
	private String reportQuery;
	private String reportSubject;
	private String reportEmail;
	private String reportSchedule;
	private Date insertedDate;
	private String insertedBy;
	private Date updatedDate;
	private String updatedBy;
	private String reportParameters;
	private String reportStatus;

	// Constructors

	/** default constructor */
	public SciReportConfiguration() {
	}

	/** minimal constructor */
	public SciReportConfiguration(Long seqRepConfigId, String reportQuery,
			String reportSubject, Date insertedDate, String insertedBy,
			Date updatedDate, String updatedBy) {
		this.seqRepConfigId = seqRepConfigId;
		this.reportQuery = reportQuery;
		this.reportSubject = reportSubject;
		this.insertedDate = insertedDate;
		this.insertedBy = insertedBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
	}

	/** full constructor */
	public SciReportConfiguration(Long seqRepConfigId, String reportQuery,
			String reportSubject, String reportEmail, String reportSchedule,
			Date insertedDate, String insertedBy, Date updatedDate,
			String updatedBy, String reportParameters) {
		this.seqRepConfigId = seqRepConfigId;
		this.reportQuery = reportQuery;
		this.reportSubject = reportSubject;
		this.reportEmail = reportEmail;
		this.reportSchedule = reportSchedule;
		this.insertedDate = insertedDate;
		this.insertedBy = insertedBy;
		this.updatedDate = updatedDate;
		this.updatedBy = updatedBy;
		this.reportParameters = reportParameters;
	}

	// Property accessors
	
	@Id
	@Column(name = "SEQ_REP_CONFIG_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SCI_REPORT_CONFIG_SEQ")
	@SequenceGenerator(allocationSize=1, sequenceName="SCI_REPORT_CONFIG_SEQ" ,name="SCI_REPORT_CONFIG_SEQ" )
	public Long getSeqRepConfigId() {
		return this.seqRepConfigId;
	}

	public void setSeqRepConfigId(Long seqRepConfigId) {
		this.seqRepConfigId = seqRepConfigId;
	}

	@Column(name = "REPORT_QUERY", nullable = false)
	public String getReportQuery() {
		return this.reportQuery;
	}

	public void setReportQuery(String reportQuery) {
		this.reportQuery = reportQuery;
	}

	@Column(name = "REPORT_SUBJECT", nullable = false, length = 250)
	public String getReportSubject() {
		return this.reportSubject;
	}

	public void setReportSubject(String reportSubject) {
		this.reportSubject = reportSubject;
	}

	@Column(name = "REPORT_EMAIL", length = 300)
	public String getReportEmail() {
		return this.reportEmail;
	}

	public void setReportEmail(String reportEmail) {
		this.reportEmail = reportEmail;
	}

	@Column(name = "REPORT_SCHEDULE", length = 20)
	public String getReportSchedule() {
		return this.reportSchedule;
	}

	public void setReportSchedule(String reportSchedule) {
		this.reportSchedule = reportSchedule;
	}
	@Temporal(TemporalType.DATE)
	
	@Column(name = "INSERTED_DATE", nullable = false, length = 7)
	public Date getInsertedDate() {
		return this.insertedDate;
	}

	public void setInsertedDate(Date insertedDate) {
		this.insertedDate = insertedDate;
	}

	@Column(name = "INSERTED_BY", nullable = false, length = 20)
	public String getInsertedBy() {
		return this.insertedBy;
	}

	public void setInsertedBy(String insertedBy) {
		this.insertedBy = insertedBy;
	}
	@Temporal(TemporalType.DATE)
	
	@Column(name = "UPDATED_DATE", nullable = false, length = 7)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name = "UPDATED_BY", nullable = false, length = 20)
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Column(name = "REPORT_PARAMETERS", length = 100)
	public String getReportParameters() {
		return this.reportParameters;
	}

	public void setReportParameters(String reportParameters) {
		this.reportParameters = reportParameters;
	}
	@Column(name = "REPORT_STATUS", length = 1)
	public String getReportStatus() {
		return reportStatus;
	}

	public void setReportStatus(String reportStatus) {
		this.reportStatus = reportStatus;
	}

}