package com.sci.bpm.db.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

/**
 * ScigenicsUserMaster entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SCIGENICS_USER_MASTER", schema = "SCIGENICS", uniqueConstraints = {})
public class ScigenicsUserMaster implements java.io.Serializable {

	// Fields

	private Long seqUserId;
	private String userFirstname;
	private String userLastname;
	private String userId;
	private String password;
	private Set<ScigenicsRoleMaster> scigenicsRoleMasters = new HashSet<ScigenicsRoleMaster>(
			0);
	private String userStatus;
	
private String userfullname;
	

	
	// Constructors

	/** default constructor */
	public ScigenicsUserMaster() {
	}

	/** minimal constructor */
	public ScigenicsUserMaster(Long seqUserId, String userId, String password) {
		this.seqUserId = seqUserId;
		this.userId = userId;
		this.password = password;
	}

	/** full constructor */
	public ScigenicsUserMaster(Long seqUserId, String userFirstname,
			String userLastname, String userId, String password,
			Set<ScigenicsRoleMaster> scigenicsRoleMasters) {
		this.seqUserId = seqUserId;
		this.userFirstname = userFirstname;
		this.userLastname = userLastname;
		this.userId = userId;
		this.password = password;
		this.scigenicsRoleMasters = scigenicsRoleMasters;
	}

	// Property accessors
	@Id
	@Column(name = "SEQ_USER_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 10, scale = 0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SCIGENICS_USER_MASTER_SEQ")
	@SequenceGenerator(allocationSize=1, sequenceName="SCIGENICS_USER_MASTER_SEQ" ,name="SCIGENICS_USER_MASTER_SEQ" )
	public Long getSeqUserId() {
		return this.seqUserId;
	}

	public void setSeqUserId(Long seqUserId) {
		this.seqUserId = seqUserId;
	}

	@Column(name = "USER_FIRSTNAME", unique = false, nullable = true, insertable = true, updatable = true, length = 40)
	public String getUserFirstname() {
		return this.userFirstname;
	}

	public void setUserFirstname(String userFirstname) {
		this.userFirstname = userFirstname;
	}

	@Column(name = "USER_LASTNAME", unique = false, nullable = true, insertable = true, updatable = true, length = 40)
	public String getUserLastname() {
		return this.userLastname;
	}

	public void setUserLastname(String userLastname) {
		this.userLastname = userLastname;
	}

	@Column(name = "USER_ID", unique = false, nullable = false, insertable = true, updatable = true, length=10)
	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Column(name = "PASSWORD", unique = false, nullable = false, insertable = true, updatable = true, length = 40)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
	@JoinTable(name = "SCI_USER_ROLE_DET", schema = "SCIGENICS", joinColumns = { @JoinColumn(name = "SEQ_USER_ID", unique = false, nullable = true, insertable = true, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "SEQ_ROLE_ID", unique = false, nullable = true, insertable = true, updatable = false) })
	public Set<ScigenicsRoleMaster> getScigenicsRoleMasters() {
		return this.scigenicsRoleMasters;
	}

	public void setScigenicsRoleMasters(
			Set<ScigenicsRoleMaster> scigenicsRoleMasters) {
		this.scigenicsRoleMasters = scigenicsRoleMasters;
	}
	
	@Column(name = "USER_STATUS", unique = false, nullable = true, insertable = true, updatable = true, length=1)
	public String getUserStatus() {
		return userStatus;
	}
	
	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

	@Transient
	public String getUserfullname() {
		return userFirstname + " - "+ userLastname;
	}

	public void setUserfullname(String userfullname) {
		this.userfullname = userfullname;
	}

	
	
}