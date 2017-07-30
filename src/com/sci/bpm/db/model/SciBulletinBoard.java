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
 * SciBulletinBoard entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SCI_BULLETIN_BOARD", schema = "SCIGENICS", uniqueConstraints = {})
public class SciBulletinBoard implements java.io.Serializable {

	// Fields

	private Long sciBulletinId;
	private String bulletinNews;
	private Date bulletinDate;
	private String updatedBy;
	private Date updateDate;
	private String bulletinSubject;
	private String createdBy;

	// Constructors

	/** default constructor */
	public SciBulletinBoard() {
	}

	/** minimal constructor */
	public SciBulletinBoard(Long sciBulletinId, String bulletinSubject) {
		this.sciBulletinId = sciBulletinId;
		this.bulletinSubject = bulletinSubject;
	}

	/** full constructor */
	public SciBulletinBoard(Long sciBulletinId, String bulletinNews,
			Date bulletinDate, String updatedBy, Date updateDate,
			String bulletinSubject, String createdBy) {
		this.sciBulletinId = sciBulletinId;
		this.bulletinNews = bulletinNews;
		this.bulletinDate = bulletinDate;
		this.updatedBy = updatedBy;
		this.updateDate = updateDate;
		this.bulletinSubject = bulletinSubject;
		this.createdBy = createdBy;
	}

	// Property accessors
	@Id
	@Column(name = "SCI_BULLETIN_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SCI_BULLETIN_BOARD_SEQ")
	@SequenceGenerator(allocationSize=1, sequenceName="SCI_BULLETIN_BOARD_SEQ" ,name="SCI_BULLETIN_BOARD_SEQ" )
	public Long getSciBulletinId() {
		return this.sciBulletinId;
	}

	public void setSciBulletinId(Long sciBulletinId) {
		this.sciBulletinId = sciBulletinId;
	}

	@Column(name = "BULLETIN_NEWS", unique = false, nullable = true, insertable = true, updatable = true, length = 2000)
	public String getBulletinNews() {
		return this.bulletinNews;
	}

	public void setBulletinNews(String bulletinNews) {
		this.bulletinNews = bulletinNews;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "BULLETIN_DATE", unique = false, nullable = true, insertable = true, updatable = true, length = 7)
	public Date getBulletinDate() {
		return this.bulletinDate;
	}

	public void setBulletinDate(Date bulletinDate) {
		this.bulletinDate = bulletinDate;
	}

	@Column(name = "UPDATED_BY", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATE_DATE", unique = false, nullable = true, insertable = true, updatable = true, length = 7)
	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	@Column(name = "BULLETIN_SUBJECT", unique = false, nullable = false, insertable = true, updatable = true, length = 50)
	public String getBulletinSubject() {
		return this.bulletinSubject;
	}

	public void setBulletinSubject(String bulletinSubject) {
		this.bulletinSubject = bulletinSubject;
	}

	@Column(name = "CREATED_BY", unique = false, nullable = true, insertable = true, updatable = true, length = 40)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

}