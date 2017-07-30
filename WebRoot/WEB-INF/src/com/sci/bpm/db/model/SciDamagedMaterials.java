package com.sci.bpm.db.model;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * SciDamagedMaterials entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="SCI_DAMAGED_MATERIALS"
    ,schema="SCIGENICS"
)

public class SciDamagedMaterials  implements java.io.Serializable {


    // Fields    

     private Long seqDamageId;
    
     private String matcode;
     private Date updatedDate;
     private String updatedBy;
     private String availDimension;
     private String availQty;
     private String remarks;
     private String issuedFully;
     private Long seqQcId;	
     private Long seqStreqId;

    // Constructors

    /** default constructor */
    public SciDamagedMaterials() {
    }

	/** minimal constructor */
    public SciDamagedMaterials(Long seqDamageId, Long seqMiId, String matcode, Date updatedDate, String updatedBy) {
        this.seqDamageId = seqDamageId;
       
        this.matcode = matcode;
        this.updatedDate = updatedDate;
        this.updatedBy = updatedBy;
    }
    
    /** full constructor */
    public SciDamagedMaterials(Long seqDamageId, Long seqMiId, String matcode, Date updatedDate, String updatedBy, String availDimension, String availQty, String remarks) {
        this.seqDamageId = seqDamageId;
       
        this.matcode = matcode;
        this.updatedDate = updatedDate;
        this.updatedBy = updatedBy;
        this.availDimension = availDimension;
        this.availQty = availQty;
        this.remarks = remarks;
    }

   
    // Property accessors
	@Id
	@Column(name = "SEQ_DAMAGE_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SCI_DAMAGED_MATERIALS_SEQ")
	@SequenceGenerator(allocationSize=1,sequenceName="SCI_DAMAGED_MATERIALS_SEQ" ,name="SCI_DAMAGED_MATERIALS_SEQ" )
   public Long getSeqDamageId() {
		return seqDamageId;
	}

	public void setSeqDamageId(Long seqDamageId) {
		this.seqDamageId = seqDamageId;
	}
    
 
    
    @Column(name="MATCODE", nullable=false, length=20)

    public String getMatcode() {
        return this.matcode;
    }
    
  

	public void setMatcode(String matcode) {
        this.matcode = matcode;
    }
@Temporal(TemporalType.DATE)
    @Column(name="UPDATED_DATE", nullable=false, length=7)

    public Date getUpdatedDate() {
        return this.updatedDate;
    }
    
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
    
    @Column(name="UPDATED_BY", nullable=false, length=20)

    public String getUpdatedBy() {
        return this.updatedBy;
    }
    
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
    
    @Column(name="AVAIL_DIMENSION", length=1000)

    public String getAvailDimension() {
        return this.availDimension;
    }
    
    public void setAvailDimension(String availDimension) {
        this.availDimension = availDimension;
    }
    
    @Column(name="AVAIL_QTY", length=20)

    public String getAvailQty() {
        return this.availQty;
    }
    
    public void setAvailQty(String availQty) {
        this.availQty = availQty;
    }
    
    @Column(name="REMARKS", length=1000)

    public String getRemarks() {
        return this.remarks;
    }
    
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
    @Column(name="ISSUE_FULLY", length=1)
	public String getIssuedFully() {
		return issuedFully;
	}

	public void setIssuedFully(String issuedFully) {
		this.issuedFully = issuedFully;
	}

	@Column(name="SEQ_QC_ID",nullable=true,precision=22, scale=0)
	public Long getSeqQcId() {
		return seqQcId;
	}

	public void setSeqQcId(Long seqQcId) {
		this.seqQcId = seqQcId;
	}
	@Column(name="SEQ_STREQ_ID",nullable=true,precision=22, scale=0)
	public Long getSeqStreqId() {
		return seqStreqId;
	}

	public void setSeqStreqId(Long seqStreqId) {
		this.seqStreqId = seqStreqId;
	}
   

	


	
	private String matType = null;
	private String matSpec = null;
	@Column(name = "MAT_TYPE", unique = false, nullable = true, insertable = true, updatable = true, length=1000)
	public String getMatType() {
		return this.matType;
	}

	public void setMatType(String matType) {
		this.matType = matType;
	}

	@Column(name = "MAT_SPEC", unique = false, nullable = true, insertable = true, updatable = true, length = 1000)
	public String getMatSpec() {
		return this.matSpec;
	}

	public void setMatSpec(String matSpec) {
		this.matSpec = matSpec;
	}


private SciMatindMaster sciMiMaster;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "SEQ_MI_ID")
		public SciMatindMaster getSciMiMaster() {
		return sciMiMaster;
	}

	public void setSciMiMaster(SciMatindMaster sciMiMaster) {
		this.sciMiMaster = sciMiMaster;
	}

	
	private String insertedBy;
	
	private Date insertedDate;
	@Column(name = "INSERTED_BY", length = 20)
	public String getInsertedBy() {
		return insertedBy;
	}

	public void setInsertedBy(String insertedBy) {
		this.insertedBy = insertedBy;
	}
	@Temporal(TemporalType.DATE)
	@Column(name = "INSERTED_DATE", nullable = true, length = 7)
	public Date getInsertedDate() {
		return insertedDate;
	}

	public void setInsertedDate(Date insertedDate) {
		this.insertedDate = insertedDate;
	}

}