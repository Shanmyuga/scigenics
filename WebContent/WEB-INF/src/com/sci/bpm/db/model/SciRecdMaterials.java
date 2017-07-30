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
 * SciRecdMaterials entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="SCI_RECD_MATERIALS"
    ,schema="SCIGENICS"
)

public class SciRecdMaterials  implements java.io.Serializable {


    // Fields    

     private Long seqRecdId;
    
     private String recdDimension;
     private String recdQuantity;
     private Date recdDate;
     private String updatedBy;
     private Date updatedDate;
     private Long poId;
     private String matcode;
     private String remarks;

     private Long seqPurchItemID;
    // Constructors

    /** default constructor */
    public SciRecdMaterials() {
    }

	/** minimal constructor */
    public SciRecdMaterials(Long seqRecdId, Long seqMiId, Date recdDate, String updatedBy, Date updatedDate, String matcode) {
        this.seqRecdId = seqRecdId;
       
        this.recdDate = recdDate;
        this.updatedBy = updatedBy;
        this.updatedDate = updatedDate;
        this.matcode = matcode;
    }
    
    /** full constructor */
    public SciRecdMaterials(Long seqRecdId, Long seqMiId, String recdDimension, String recdQuantity, Date recdDate, String updatedBy, Date updatedDate, Long poId, String matcode) {
        this.seqRecdId = seqRecdId;
      
        this.recdDimension = recdDimension;
        this.recdQuantity = recdQuantity;
        this.recdDate = recdDate;
        this.updatedBy = updatedBy;
        this.updatedDate = updatedDate;
        this.poId = poId;
        this.matcode = matcode;
    }

   
    // Property accessors
    @Id
	@Column(name = "SEQ_RECD_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SCI_RECD_MATERIALS_SEQ")
	@SequenceGenerator(allocationSize=1, sequenceName="SCI_RECD_MATERIALS_SEQ" ,name="SCI_RECD_MATERIALS_SEQ" )

    public Long getSeqRecdId() {
        return this.seqRecdId;
    }
    
    public void setSeqRecdId(Long seqRecdId) {
        this.seqRecdId = seqRecdId;
    }
    
  
    
    @Column(name="RECD_DIMENSION", length=1000)

    public String getRecdDimension() {
        return this.recdDimension;
    }
    
    public void setRecdDimension(String recdDimension) {
        this.recdDimension = recdDimension;
    }
    
    @Column(name="RECD_QUANTITY", length=20)

    public String getRecdQuantity() {
        return this.recdQuantity;
    }
    
    public void setRecdQuantity(String recdQuantity) {
        this.recdQuantity = recdQuantity;
    }
@Temporal(TemporalType.DATE)
    @Column(name="RECD_DATE", nullable=false, length=7)

    public Date getRecdDate() {
        return this.recdDate;
    }
    
    public void setRecdDate(Date recdDate) {
        this.recdDate = recdDate;
    }
    
    @Column(name="UPDATED_BY", nullable=false, length=20)

    public String getUpdatedBy() {
        return this.updatedBy;
    }
    
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
@Temporal(TemporalType.DATE)
    @Column(name="UPDATED_DATE", nullable=false, length=7)

    public Date getUpdatedDate() {
        return this.updatedDate;
    }
    
    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }
    
    @Column(name="PO_ID", precision=22, scale=0)

    public Long getPoId() {
        return this.poId;
    }
    
    public void setPoId(Long poId) {
        this.poId = poId;
    }
    
    @Column(name="MATCODE", nullable=false, length=20)

    public String getMatcode() {
        return this.matcode;
    }
    
    public void setMatcode(String matcode) {
        this.matcode = matcode;
    }
    @Column(name="REMARKS", length=1000)
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
	@Column(name="SEQ_PURCHITEM_ID", precision=9, scale=0)
	public Long getSeqPurchItemID() {
		return seqPurchItemID;
	}

	public void setSeqPurchItemID(Long seqPurchItemID) {
		this.seqPurchItemID = seqPurchItemID;
	}

}