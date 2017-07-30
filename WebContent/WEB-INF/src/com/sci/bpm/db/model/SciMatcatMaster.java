package com.sci.bpm.db.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;


/**
 * SciMatcatMaster entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="SCI_MATCAT_MASTER"
    ,schema="SCIGENICS"
)

public class SciMatcatMaster  implements java.io.Serializable {


    // Fields    

     private BigDecimal seqMatcatId;
     private String matcatType;
     private String matcatCode;

     private String matDept;
    // Constructors

    /** default constructor */
    public SciMatcatMaster() {
    }

	/** minimal constructor */
    public SciMatcatMaster(BigDecimal seqMatcatId) {
        this.seqMatcatId = seqMatcatId;
    }
    
    /** full constructor */
    public SciMatcatMaster(BigDecimal seqMatcatId, String matcatType, String matcatCode) {
        this.seqMatcatId = seqMatcatId;
        this.matcatType = matcatType;
        this.matcatCode = matcatCode;
    }

   
    // Property accessors
    @Id 
    
    @Column(name="SEQ_MATCAT_ID", unique=true, nullable=false, precision=22, scale=0)

    public BigDecimal getSeqMatcatId() {
        return this.seqMatcatId;
    }
    
    public void setSeqMatcatId(BigDecimal seqMatcatId) {
        this.seqMatcatId = seqMatcatId;
    }
    
    @Column(name="MATCAT_TYPE", length=50)

    public String getMatcatType() {
        return this.matcatType;
    }
    
    public void setMatcatType(String matcatType) {
        this.matcatType = matcatType;
    }
    
    @Column(name="MATCAT_CODE", length=10)

    public String getMatcatCode() {
        return this.matcatCode;
    }
    
    public void setMatcatCode(String matcatCode) {
        this.matcatCode = matcatCode;
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
		return this.matcatCode+","+matDept;
	}




}