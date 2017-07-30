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
import javax.persistence.Transient;


/**
 * SciStoreMaster entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="SCI_STORE_MASTER"
    ,schema="SCIGENICS"
)

public class SciStoreMaster  implements java.io.Serializable {


    // Fields    

     private Long seqStoreId;
     private Long seqItemId;
     private Long qcStatus;
     private Long itemType;
     private Date itemRecdDate;
     private Long numberPassed;
     private Date qcApprDate;
     private Long seqPurchId;
     private Date updatedDt;
     private String updatedBy;
     private String itemName;
     private Long currentCnt;
     private Date issuedDate;
     private Long issueCount;
     private String remarks;
     private Long qcAppCnt;
     private String itemRecdFull;
     private String receivedDimen;
     private Long seqMiID;
     private String receivedCnt;
    // Constructors

    /** default constructor */
    public SciStoreMaster() {
    }

	/** minimal constructor */
    public SciStoreMaster(Long seqStoreId, Long seqItemId, Long qcStatus, Long seqPurchId, Date updatedDt, String updatedBy, Long currentCnt) {
        this.seqStoreId = seqStoreId;
        this.seqItemId = seqItemId;
        this.qcStatus = qcStatus;
        this.seqPurchId = seqPurchId;
        this.updatedDt = updatedDt;
        this.updatedBy = updatedBy;
        this.currentCnt = currentCnt;
    }
    
    /** full constructor */
    public SciStoreMaster(Long seqStoreId, Long seqItemId, Long qcStatus, Long itemType, Date itemRecdDate, Long numberPassed, Date qcApprDate, Long seqPurchId, Date updatedDt, String updatedBy, String itemName, Long currentCnt, Date issuedDate, Long issueCount, String remarks) {
        this.seqStoreId = seqStoreId;
        this.seqItemId = seqItemId;
        this.qcStatus = qcStatus;
        this.itemType = itemType;
        this.itemRecdDate = itemRecdDate;
        this.numberPassed = numberPassed;
        this.qcApprDate = qcApprDate;
        this.seqPurchId = seqPurchId;
        this.updatedDt = updatedDt;
        this.updatedBy = updatedBy;
        this.itemName = itemName;
        this.currentCnt = currentCnt;
        this.issuedDate = issuedDate;
        this.issueCount = issueCount;
        this.remarks = remarks;
    }

   
    // Property accessors
	@Id
	@Column(name = "SEQ_STORE_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SCI_STORE_MASTER_SEQ")
	@SequenceGenerator(allocationSize=1, sequenceName="SCI_STORE_MASTER_SEQ" ,name="SCI_STORE_MASTER_SEQ" )

    public Long getSeqStoreId() {
        return this.seqStoreId;
    }
    
    public void setSeqStoreId(Long seqStoreId) {
        this.seqStoreId = seqStoreId;
    }
    
    @Column(name="SEQ_ITEM_ID", nullable=false, precision=22, scale=0)

    public Long getSeqItemId() {
        return this.seqItemId;
    }
    
    public void setSeqItemId(Long seqItemId) {
        this.seqItemId = seqItemId;
    }
    
    @Column(name="QC_STATUS", nullable=false, precision=22, scale=0)

    public Long getQcStatus() {
        return this.qcStatus;
    }
    
    public void setQcStatus(Long qcStatus) {
        this.qcStatus = qcStatus;
    }
    
    @Column(name="ITEM_TYPE", precision=22, scale=0)

    public Long getItemType() {
        return this.itemType;
    }
    
    public void setItemType(Long itemType) {
        this.itemType = itemType;
    }
@Temporal(TemporalType.DATE)
    @Column(name="ITEM_RECD_DATE", length=7)

    public Date getItemRecdDate() {
        return this.itemRecdDate;
    }
    
    public void setItemRecdDate(Date itemRecdDate) {
        this.itemRecdDate = itemRecdDate;
    }
    
    @Column(name="NUMBER_PASSED", precision=22, scale=0)

    public Long getNumberPassed() {
        return this.numberPassed;
    }
    
    public void setNumberPassed(Long numberPassed) {
        this.numberPassed = numberPassed;
    }
@Temporal(TemporalType.DATE)
    @Column(name="QC_APPR_DATE", length=7)

    public Date getQcApprDate() {
        return this.qcApprDate;
    }
    
    public void setQcApprDate(Date qcApprDate) {
        this.qcApprDate = qcApprDate;
    }
    
    @Column(name="SEQ_PURCH_ID", nullable=false, precision=22, scale=0)

    public Long getSeqPurchId() {
        return this.seqPurchId;
    }
    
    public void setSeqPurchId(Long seqPurchId) {
        this.seqPurchId = seqPurchId;
    }
@Temporal(TemporalType.DATE)
    @Column(name="UPDATED_DT", nullable=false, length=7)

    public Date getUpdatedDt() {
        return this.updatedDt;
    }
    
    public void setUpdatedDt(Date updatedDt) {
        this.updatedDt = updatedDt;
    }
    
    @Column(name="UPDATED_BY", nullable=false, length=20)

    public String getUpdatedBy() {
        return this.updatedBy;
    }
    
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }
    
    @Column(name="ITEM_NAME", length=1000)

    public String getItemName() {
        return this.itemName;
    }
    
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    
    @Column(name="CURRENT_CNT", nullable=false, precision=22, scale=0)

    public Long getCurrentCnt() {
        return this.currentCnt;
    }
    
    public void setCurrentCnt(Long currentCnt) {
        this.currentCnt = currentCnt;
    }
@Temporal(TemporalType.DATE)
    @Column(name="ISSUED_DATE", length=7)

    public Date getIssuedDate() {
        return this.issuedDate;
    }
    
    public void setIssuedDate(Date issuedDate) {
        this.issuedDate = issuedDate;
    }
    
    @Column(name="ISSUE_COUNT", precision=22, scale=0)

    public Long getIssueCount() {
        return this.issueCount;
    }
    
    public void setIssueCount(Long issueCount) {
        this.issueCount = issueCount;
    }
    
    @Column(name="REMARKS", length=2000)

    public String getRemarks() {
        return this.remarks;
    }
    
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    
    @Column(name="RECEIVED_DIMEN", length=200)
	public String getReceivedDimen() {
		return receivedDimen;
	}

	public void setReceivedDimen(String receivedDimen) {
		this.receivedDimen = receivedDimen;
	}

	 @Column(name="RECEIVED_CNT", precision=22, scale=0)
	public String getReceivedCnt() {
		return receivedCnt;
	}

	public void setReceivedCnt(String receivedCnt) {
		this.receivedCnt = receivedCnt;
	}

	 @Column(name="QC_APP_CNT", precision=22, scale=0)
	public Long getQcAppCnt() {
		return qcAppCnt;
	}

	public void setQcAppCnt(Long qcAppCnt) {
		this.qcAppCnt = qcAppCnt;
	}
	
    @Transient
	public Long getSeqMiID() {
		return seqMiID;
	}

	public void setSeqMiID(Long seqMiID) {
		this.seqMiID = seqMiID;
	}
	   @Column(name="ITEM_RECD_FULL", length=1)
	public String getItemRecdFull() {
		return itemRecdFull;
	}

	public void setItemRecdFull(String itemRecdFull) {
		this.itemRecdFull = itemRecdFull;
	}
   








}