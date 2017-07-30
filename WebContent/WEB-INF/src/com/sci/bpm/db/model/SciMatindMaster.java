package com.sci.bpm.db.model;

import java.math.BigDecimal;
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
import javax.persistence.Transient;

/**
 * SciMatindMaster entity.
 * 
 * @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "SCI_MATIND_MASTER", schema = "SCIGENICS", uniqueConstraints = {})
public class SciMatindMaster implements java.io.Serializable {

	// Fields

	private Long seqMiId;
	private SciWorkorderMaster sciWorkorderMaster;
	private String matType;
	private String matSpec;
	private String matDesc;
	private BigDecimal matQty;
	private Date matDuedate;
	private String matDimesion;
	private String recommend;
	private Long purStatus;
	private String poDetails;
	private String preparedBy;
	private String approvedBy;
	private String updatedBy;
	private Date updatedDate;
	private String designRef;
	private String drawingRef;
	
	 private BigDecimal matEstcost;
		private String approvedStatus;
		private BigDecimal unitCost = new BigDecimal(0);
		private BigDecimal estUnintCost = new BigDecimal(0);
		private String matcode;
		private SciStoresRequest stRequestStatus;
		private Date podueDate;
private String oldQCId;

private int tempestCost;

private String requestStatus;

private Date unitCostDate;
private float tempunitCost;
private String prodRequestStatus;
private String purchRequestStatus;
private String workorderDesc;
private Long poID;

private String miForType;
	// Constructors

	

	/** default constructor */
	public SciMatindMaster() {
	}

	/** minimal constructor */
	public SciMatindMaster(Long seqMiId, SciWorkorderMaster sciWorkorderMaster,
			String matType, String matSpec, String matDesc, BigDecimal matQty,
			Date matDuedate, Long purStatus, String poDetails,
			String preparedBy, String updatedBy, Date updatedDate,
			String designRef, String drawingRef) {
		this.seqMiId = seqMiId;
		this.sciWorkorderMaster = sciWorkorderMaster;
		this.matType = matType;
		this.matSpec = matSpec;
		this.matDesc = matDesc;
		this.matQty = matQty;
		this.matDuedate = matDuedate;
		this.purStatus = purStatus;
		this.poDetails = poDetails;
		this.preparedBy = preparedBy;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.designRef = designRef;
		this.drawingRef = drawingRef;
	}
	
	

	/** full constructor */
	public SciMatindMaster(Long seqMiId, 
			String matType, String matSpec, String matDesc,String matcode, BigDecimal matQty,
			Date matDuedate, String matDimesion, String recommend,
			Long purStatus, String poDetails, String preparedBy,
			String approvedBy, String updatedBy, Date updatedDate,
			BigDecimal unitCost, 
			String designRef, String drawingRef,Date insertedby,String workorderdetails,String prodstatus,String requestStatus) {
		this.seqMiId = seqMiId;
		
		this.matType = matType;
		this.matSpec = matSpec;
		this.matDesc = matDesc;
		this.matQty = matQty;
		this.matDuedate = matDuedate;
		this.matDimesion = matDimesion;
		this.recommend = recommend;
		this.purStatus = purStatus;
		this.poDetails = poDetails;
		this.preparedBy = preparedBy;
		this.approvedBy = approvedBy;
		this.updatedBy = updatedBy;
		this.updatedDate = updatedDate;
		this.designRef = designRef;
		this.drawingRef = drawingRef;
	}

	public SciMatindMaster(Long seqMiId, String matType, String matSpec,
			String matDesc, BigDecimal matQty, String matDimesion,
			String recommend, Long purStatus, String preparedBy,
			BigDecimal estUnintCost, String matcode,
			SciStoresRequest stRequestStatus, String prodRequestStatus,
			String purchRequestStatus, String insertedBy, Date insertedDate) {
		super();
		this.seqMiId = seqMiId;
		this.matType = matType;
		this.matSpec = matSpec;
		this.matDesc = matDesc;
		this.matQty = matQty;
		this.matDimesion = matDimesion;
		this.recommend = recommend;
		this.purStatus = purStatus;
		this.preparedBy = preparedBy;
		this.estUnintCost = estUnintCost;
		this.matcode = matcode;
		this.stRequestStatus = stRequestStatus;
		this.prodRequestStatus = prodRequestStatus;
		this.purchRequestStatus = purchRequestStatus;
		this.insertedBy = insertedBy;
		this.insertedDate = insertedDate;
	}

	public SciMatindMaster(Object object, Object object2, Object object3,
			Object object4, Object object5, Object object6, Object object7,
			Object object8, Object object9, Object object10, Object object11,
			Object object12, Object object13, Object object14, Object object15,
			Object object16,Object object17,Object object18) {
		// TODO Auto-generated constructor stub
		
		this.seqMiId = (Long) object;
		this.matType = (String) object2;
		this.matSpec = (String) object3;
		this.matDesc = (String) object4;
		this.matQty = (BigDecimal) object5;
		this.matDimesion = (String) object6;
		this.recommend = (String) object7;
		this.purStatus = (Long) object8;
		this.preparedBy = (String) object9;
		this.estUnintCost = (BigDecimal) object10;
		this.matcode = (String) object11;
		this.requestStatus = (String)object12;
		this.prodRequestStatus = (String) object13;
		this.purchRequestStatus = (String) object14;
		this.insertedBy = (String) object15;
		this.insertedDate = (Date) object16;
		this.workorderDesc = (String)object17;
		this.poID = (Long)object18;
	}

	// Property accessors
	@Id
	@Column(name = "SEQ_MI_ID", unique = true, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "SCI_MATIND_MASTER_SEQ")
	@SequenceGenerator(allocationSize=1, sequenceName="SCI_MATIND_MASTER_SEQ" ,name="SCI_MATIND_MASTER_SEQ" )
	public Long getSeqMiId() {
		return this.seqMiId;
	}

	public void setSeqMiId(Long seqMiId) {
		this.seqMiId = seqMiId;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.EAGER)
	@JoinColumn(name = "SEQ_WORK_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public SciWorkorderMaster getSciWorkorderMaster() {
		return this.sciWorkorderMaster;
	}

	public void setSciWorkorderMaster(SciWorkorderMaster sciWorkorderMaster) {
		this.sciWorkorderMaster = sciWorkorderMaster;
	}

	@Column(name = "MAT_TYPE", unique = false, nullable = true, insertable = true, updatable = true, length=100)
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

	@Column(name = "MAT_DESC", unique = false, nullable = true, insertable = true, updatable = true, length = 1000)
	public String getMatDesc() {
		return this.matDesc;
	}

	public void setMatDesc(String matDesc) {
		this.matDesc = matDesc;
	}

	@Column(name = "MAT_QTY_MOD", unique = false, nullable = true, insertable = true, updatable = true, precision = 22, scale = 4)
	public BigDecimal getMatQty() {
		return this.matQty;
	}

	public void setMatQty(BigDecimal matQty) {
		this.matQty = matQty;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "MAT_DUEDATE", unique = false, nullable = false, insertable = true, updatable = true, length = 7)
	public Date getMatDuedate() {
		return this.matDuedate;
	}

	public void setMatDuedate(Date matDuedate) {
		this.matDuedate = matDuedate;
	}

	@Column(name = "MAT_DIMESION", unique = false, nullable = true, insertable = true, updatable = true, length = 1000)
	public String getMatDimesion() {
		return this.matDimesion;
	}

	public void setMatDimesion(String matDimesion) {
		this.matDimesion = matDimesion;
	}

	@Column(name = "RECOMMEND", unique = false, nullable = true, insertable = true, updatable = true, length = 1000)
	public String getRecommend() {
		return this.recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

	@Column(name = "PUR_STATUS", unique = false, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	public Long getPurStatus() {
		return this.purStatus;
	}

	public void setPurStatus(Long purStatus) {
		this.purStatus = purStatus;
	}

	@Column(name = "PO_DETAILS", unique = false, nullable = true, insertable = true, updatable = true, length = 1000)
	public String getPoDetails() {
		return this.poDetails;
	}

	public void setPoDetails(String poDetails) {
		this.poDetails = poDetails;
	}

	@Column(name = "PREPARED_BY", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public String getPreparedBy() {
		return this.preparedBy;
	}

	public void setPreparedBy(String preparedBy) {
		this.preparedBy = preparedBy;
	}

	@Column(name = "APPROVED_BY", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public String getApprovedBy() {
		return this.approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	@Column(name = "UPDATED_BY", unique = false, nullable = false, insertable = true, updatable = true, length = 20)
	public String getUpdatedBy() {
		return this.updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "UPDATED_DATE", unique = false, nullable = false, insertable = true, updatable = true, length = 7)
	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	@Column(name = "DESIGN_REF", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public String getDesignRef() {
		return this.designRef;
	}

	public void setDesignRef(String designRef) {
		this.designRef = designRef;
	}

	@Column(name = "DRAWING_REF", unique = false, nullable = true, insertable = true, updatable = true, length = 20)
	public String getDrawingRef() {
		return this.drawingRef;
	}

	public void setDrawingRef(String drawingRef) {
		this.drawingRef = drawingRef;
	}
	
	  @Column(name="MAT_ESTCOST_MOD", unique=false, nullable=true, insertable=true, updatable=true, precision=22,scale=4)

	    public BigDecimal getMatEstcost() {
	        return this.matEstcost;
	    }
	    
	    public void setMatEstcost(BigDecimal matEstcost) {
	        this.matEstcost = matEstcost;
	    }
	    
	    @Column(name="UNIT_COST", unique=false, nullable=true, insertable=true, updatable=true, precision=22,scale=4)
	    public BigDecimal getUnitCost() {
			return unitCost;
		}

		public void setUnitCost(BigDecimal unitCost) {
			this.unitCost = unitCost;
		}
	  
	    @Column(name = "APPROVED_STATUS", length = 1)
		public String getApprovedStatus() {
			return this.approvedStatus;
		}

		

		public void setApprovedStatus(String approvedStatus) {
			this.approvedStatus = approvedStatus;
		}

		public String getMatcode() {
			return matcode;
		}
		@Column(name = "MATCODE", length = 20)
		public void setMatcode(String matcode) {
			this.matcode = matcode;
		}
		@Transient
		public SciStoresRequest getStRequestStatus() {
			return stRequestStatus;
		}

		public void setStRequestStatus(SciStoresRequest stRequestStatus) {
			this.stRequestStatus = stRequestStatus;
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

		@Temporal(TemporalType.DATE)
		@Column(name = "PO_DUEDATE", nullable = true, length = 7)
		public Date getPodueDate() {
			return podueDate;
		}

		public void setPodueDate(Date podueDate) {
			this.podueDate = podueDate;
		}
		
		@Column(name = "OLD_QC_ID", length = 100)
		public String getOldQCId() {
			return oldQCId;
		}

		public void setOldQCId(String oldQCId) {
			this.oldQCId = oldQCId;
		}

		@Transient
		public String getRequestStatus() {
			if("NR".equals(requestStatus)) {
				if("R".equals(prodRequestStatus) || "R".equals(purchRequestStatus)) {
					requestStatus = "Rejected";
				}
				else if(prodRequestStatus == null && purchRequestStatus == null) {
					requestStatus = "Not raised";
				}
				
				else {
					requestStatus = "Pending";
				}
			}
			return requestStatus;
		}

		public void setRequestStatus(String requestStatus) {
			this.requestStatus = requestStatus;
		}
		   @Column(name="EST_UNIT_COST", unique=false, nullable=true, insertable=true, updatable=true, precision=9,scale=2)
		public BigDecimal getEstUnintCost() {
			return estUnintCost;
		}

		public void setEstUnintCost(BigDecimal estUnintCost) {
			this.estUnintCost = estUnintCost;
		}
		
		@Temporal(TemporalType.DATE)
		@Column(name = "COST_UPDATE_DATE", nullable = true, length = 7)
		public Date getUnitCostDate() {
			return unitCostDate;
		}

		public void setUnitCostDate(Date unitCostDate) {
			this.unitCostDate = unitCostDate;
		}

		@Transient
		public float getTempunitCost() {
			return tempunitCost;
		}

		public void setTempunitCost(float tempunitCost) {
			this.tempunitCost = tempunitCost;
		}
		@Transient
		public int getTempestCost() {
			return estUnintCost==null?0:estUnintCost.intValue();
		}

		public void setTempestCost(int tempestCost) {
			this.tempestCost = tempestCost;
		}

		@Transient
		public String getProdRequestStatus() {
			return prodRequestStatus;
		}

		public void setProdRequestStatus(String prodRequestStatus) {
			this.prodRequestStatus = prodRequestStatus;
		}
		@Transient
		public String getPurchRequestStatus() {
			return purchRequestStatus;
		}

		public void setPurchRequestStatus(String purchRequestStatus) {
			this.purchRequestStatus = purchRequestStatus;
		}
		@Transient
		public String getWorkorderDesc() {
			return workorderDesc;
		}

		public void setWorkorderDesc(String workorderDesc) {
			this.workorderDesc = workorderDesc;
		}
		@Transient
		public Long getPoID() {
			return poID;
		}

		public void setPoID(Long poID) {
			this.poID = poID;
		}
		@Column(name = "MI_FOR_TYPE", length = 200)
		public String getMiForType() {
			return miForType;
		}

		public void setMiForType(String miForType) {
			this.miForType = miForType;
		}
		
}