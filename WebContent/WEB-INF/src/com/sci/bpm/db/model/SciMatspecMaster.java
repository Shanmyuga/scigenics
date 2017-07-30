package com.sci.bpm.db.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;


/**
 * SciMatspecMaster entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="SCI_MATSPEC_MASTER"
    ,schema="SCIGENICS"
)

public class SciMatspecMaster  implements java.io.Serializable {


    // Fields    

     private Long seqMaterialId;
     private String matcatCode;
     private String matSpecDesc;
     private String materialSpec;
     private String specCode;

     private String matDept;
    // Constructors

    /** default constructor */
    public SciMatspecMaster() {
    }

	/** minimal constructor */
    public SciMatspecMaster(Long seqMaterialId) {
        this.seqMaterialId = seqMaterialId;
    }
    
    /** full constructor */
    public SciMatspecMaster(Long seqMaterialId, String matcatCode, String matSpecDesc, String materialSpec, String specCode) {
        this.seqMaterialId = seqMaterialId;
        this.matcatCode = matcatCode;
        this.matSpecDesc = matSpecDesc;
        this.materialSpec = materialSpec;
        this.specCode = specCode;
    }

   
    // Property accessors
   
	@Id
	@Column(name = "SEQ_MATERIAL_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SCI_MATSPEC_MAST_SEQ")
	@SequenceGenerator(allocationSize=1, sequenceName="SCI_MATSPEC_MAST_SEQ" ,name="SCI_MATSPEC_MAST_SEQ" )
    public Long getSeqMaterialId() {
        return this.seqMaterialId;
    }
    
    public void setSeqMaterialId(Long seqMaterialId) {
        this.seqMaterialId = seqMaterialId;
    }
    
    @Column(name="MATCAT_CODE", length=20)

    public String getMatcatCode() {
        return this.matcatCode;
    }
    
    public void setMatcatCode(String matcatCode) {
        this.matcatCode = matcatCode;
    }
    
    @Column(name="MAT_SPEC_DESC", length=100)

    public String getMatSpecDesc() {
        return this.matSpecDesc;
    }
    
    public void setMatSpecDesc(String matSpecDesc) {
        this.matSpecDesc = matSpecDesc;
    }
    
    @Column(name="MATERIAL_SPEC", length=100)

    public String getMaterialSpec() {
        return this.materialSpec;
    }
    
    public void setMaterialSpec(String materialSpec) {
        this.materialSpec = materialSpec;
    }
    
    @Column(name="SPEC_CODE", length=10)

    public String getSpecCode() {
        return this.specCode;
    }
    
    public void setSpecCode(String specCode) {
        this.specCode = specCode;
    }
   

    @Transient
    public String getSpecValue() {
    	return this.specCode+","+this.matSpecDesc;
    }




    @Column(name="MAT_DEPT", length=5)
	public String getMatDept() {
		return matDept;
	}

	public void setMatDept(String matDept) {
		this.matDept = matDept;
	}
   
	private String updatedBy;
	private Date updatedDate;
	
	@Column(name = "UPDATED_BY", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DATE", unique = false, nullable = true, insertable = true, updatable = true, length = 7)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}