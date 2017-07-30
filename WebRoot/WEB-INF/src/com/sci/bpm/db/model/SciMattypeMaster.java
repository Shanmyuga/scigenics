package com.sci.bpm.db.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * SciMattypeMaster entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="SCI_MATTYPE_MASTER"
    ,schema="SCIGENICS"
)

public class SciMattypeMaster  implements java.io.Serializable {


    // Fields    

     private BigDecimal seqMattypeId;
     private String matType;
     private String matCode;
     private String matDept;

    // Constructors

    /** default constructor */
    public SciMattypeMaster() {
    }

	/** minimal constructor */
    public SciMattypeMaster(BigDecimal seqMattypeId) {
        this.seqMattypeId = seqMattypeId;
    }
    
    /** full constructor */
    public SciMattypeMaster(BigDecimal seqMattypeId, String matType, String matCode) {
        this.seqMattypeId = seqMattypeId;
        this.matType = matType;
        this.matCode = matCode;
    }

   
    // Property accessors
    @Id 
    
    @Column(name="SEQ_MATTYPE_ID", unique=true, nullable=false, precision=22, scale=0)

    public BigDecimal getSeqMattypeId() {
        return this.seqMattypeId;
    }
    
    public void setSeqMattypeId(BigDecimal seqMattypeId) {
        this.seqMattypeId = seqMattypeId;
    }
    
    @Column(name="MAT_TYPE", length=20)

    public String getMatType() {
        return this.matType;
    }
    
    public void setMatType(String matType) {
        this.matType = matType;
    }
    
    @Column(name="MAT_CODE", length=10)

    public String getMatCode() {
        return this.matCode;
    }
    
    public void setMatCode(String matCode) {
        this.matCode = matCode;
    }
    @Column(name="MAT_DEPT", length=5)
	public String getMatDept() {
		return matDept;
	}

	public void setMatDept(String matDept) {
		this.matDept = matDept;
	}
   
	@Transient
	public String getDeptandcode() {
		return this.matCode+","+matDept;
	}







}