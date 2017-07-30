package com.sci.bpm.db.model;

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


/**
 * SciPurchaseItemdetails entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="SCI_PURCHASE_ITEMDETAILS_"
    ,schema="SCIGENICS"
, uniqueConstraints = {  }
)

public class SciPurchaseItemdetails  implements java.io.Serializable {


    // Fields    

     private Long seqPuritemId;
     private SciPurchaseMast sciPurchaseMast;
     private Long seqItemId;


    // Constructors

    /** default constructor */
    public SciPurchaseItemdetails() {
    }

	/** minimal constructor */
    public SciPurchaseItemdetails(Long seqPuritemId) {
        this.seqPuritemId = seqPuritemId;
    }
    
    /** full constructor */
    public SciPurchaseItemdetails(Long seqPuritemId, SciPurchaseMast sciPurchaseMast, Long seqItemId) {
        this.seqPuritemId = seqPuritemId;
        this.sciPurchaseMast = sciPurchaseMast;
        this.seqItemId = seqItemId;
    }

   
    // Property accessors
    @Id
	@Column(name = "SEQ_PURITEM_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SCI_PURCHASE_ITEMDETAILS__SEQ")
	@SequenceGenerator(allocationSize=1, sequenceName="SCI_PURCHASE_ITEMDETAILS__SEQ" ,name="SCI_PURCHASE_ITEMDETAILS__SEQ" )

    public Long getSeqPuritemId() {
        return this.seqPuritemId;
    }
    
    public void setSeqPuritemId(Long seqPuritemId) {
        this.seqPuritemId = seqPuritemId;
    }
    @ManyToOne(cascade={},
        fetch=FetchType.EAGER)
    
        @JoinColumn(name="SEQ_PURCH_ID", unique=false, nullable=true, insertable=true, updatable=true)

    public SciPurchaseMast getSciPurchaseMast() {
        return this.sciPurchaseMast;
    }
    
    public void setSciPurchaseMast(SciPurchaseMast sciPurchaseMast) {
        this.sciPurchaseMast = sciPurchaseMast;
    }
    
    @Column(name="SEQ_ITEM_ID", unique=false, nullable=true, insertable=true, updatable=true, precision=22, scale=0)

    public Long getSeqItemId() {
        return this.seqItemId;
    }
    
    public void setSeqItemId(Long seqItemId) {
        this.seqItemId = seqItemId;
    }
   








}