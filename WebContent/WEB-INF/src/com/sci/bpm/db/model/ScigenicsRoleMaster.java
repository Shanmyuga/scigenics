package com.sci.bpm.db.model;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 * ScigenicsRoleMaster entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SCIGENICS_ROLE_MASTER", schema = "SCIGENICS", uniqueConstraints = {})
public class ScigenicsRoleMaster implements java.io.Serializable {

	// Fields

	private Long seqRoleId;
	private String roleName;
	private Set<ScigenicsUserMaster> scigenicsUserMasters = new HashSet<ScigenicsUserMaster>(
			0);

	// Constructors

	/** default constructor */
	public ScigenicsRoleMaster() {
	}

	/** minimal constructor */
	public ScigenicsRoleMaster(Long seqRoleId) {
		this.seqRoleId = seqRoleId;
	}

	/** full constructor */
	public ScigenicsRoleMaster(Long seqRoleId, String roleName,
			Set<ScigenicsUserMaster> scigenicsUserMasters) {
		this.seqRoleId = seqRoleId;
		this.roleName = roleName;
		this.scigenicsUserMasters = scigenicsUserMasters;
	}

	// Property accessors
	@Id
	@Column(name = "SEQ_ROLE_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 10, scale = 0)
	@SequenceGenerator(allocationSize=1, sequenceName="SCIGENICS_ROLE_MASTER_SEQ", name="SCIGENICS_ROLE_MASTER_SEQ" )
	@GeneratedValue(generator = "SCIGENICS_ROLE_MASTER_SEQ")
	public Long getSeqRoleId() {
		return this.seqRoleId;
	}

	public void setSeqRoleId(Long seqRoleId) {
		this.seqRoleId = seqRoleId;
	}

	@Column(name = "ROLE_NAME", unique = false, nullable = true, insertable = true, updatable = true, length = 40)
	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	@ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER, mappedBy = "scigenicsRoleMasters")
	public Set<ScigenicsUserMaster> getScigenicsUserMasters() {
		return this.scigenicsUserMasters;
	}

	public void setScigenicsUserMasters(
			Set<ScigenicsUserMaster> scigenicsUserMasters) {
		this.scigenicsUserMasters = scigenicsUserMasters;
	}

}