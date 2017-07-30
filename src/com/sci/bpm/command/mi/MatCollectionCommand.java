package com.sci.bpm.command.mi;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;

public class MatCollectionCommand implements Serializable {
	
private String  productCat ;
private String  productType ;
	private Long seqprodID ;
	
	private BigDecimal matQty = null;
	private String matDuedatestr;
	private Date matDuedate;
	private String matDimesion = "NA";
	private String recommend;
	private String preparedBy;
	private String drawingRef;
	private String miForType;
	private String matDesc;
	private String productSpecid;
	private String matDept;
	private String matindex;
	private String matSpec;
	private String matEstUnitCost;
	
	public String getMatEstUnitCost() {
		return matEstUnitCost;
	}
	public void setMatEstUnitCost(String matEstUnitCost) {
		this.matEstUnitCost = matEstUnitCost;
	}
	public String getProductCat() {
		return productCat;
	}
	public void setProductCat(String productCat) {
		this.productCat = productCat;
	}
	public Long getSeqprodID() {
		return seqprodID;
	}
	public void setSeqprodID(Long seqprodID) {
		this.seqprodID = seqprodID;
	}
	public BigDecimal getMatQty() {
		return matQty;
	}
	public void setMatQty(BigDecimal matQty) {
		this.matQty = matQty;
	}
	
	public String getMatDuedatestr() {
		return matDuedatestr;
	}
	public void setMatDuedatestr(String matDuedatestr) {
		this.matDuedatestr = matDuedatestr;
	}
	public String getMatDimesion() {
		return matDimesion;
	}
	public void setMatDimesion(String matDimesion) {
		this.matDimesion = matDimesion;
	}
	public String getRecommend() {
		return recommend;
	}
	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}
	public String getPreparedBy() {
		return preparedBy;
	}
	public void setPreparedBy(String preparedBy) {
		this.preparedBy = preparedBy;
	}
	public String getDrawingRef() {
		return drawingRef;
	}
	public void setDrawingRef(String drawingRef) {
		this.drawingRef = drawingRef;
	}
	public String getMatDesc() {
		return matDesc;
	}
	public void setMatDesc(String matDesc) {
		this.matDesc = matDesc;
	}
	
	public Date getMatDuedate() throws ParseException {
	   SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
	   if(!"".equals(matDuedatestr)) {
		   return format.parse(this.matDuedatestr);   
	   }
		return null;
	}
	public void setMatDuedate(Date matDuedate) {
		this.matDuedate = matDuedate;
	}
	
	
	public void reset() {
		this.seqprodID = null;
		this.matDesc = null;
		this.drawingRef = null;
		this.preparedBy = null;
		this.recommend = null;
		this.matDimesion = null;
		this.matQty = null;
		this.matDuedate = null;
		this.seqprodID = null;
		this.productCat = null;
		this.matDuedatestr = null;
		this.productType = null;
		this.matSpec = null;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getProductSpecid() {
		return productSpecid;
	}
	public void setProductSpecid(String productSpecid) {
		this.productSpecid = productSpecid;
	}
	public String getMatDept() {
		return matDept;
	}
	public void setMatDept(String matDept) {
		this.matDept = matDept;
	}
	public String getMatindex() {
		return matindex;
	}
	public void setMatindex(String matindex) {
		this.matindex = matindex;
	}
	public String getMatSpec() {
		return matSpec;
	}
	public void setMatSpec(String matSpec) {
		this.matSpec = matSpec;
	}
	public String getMiForType() {
		return miForType;
	}
	public void setMiForType(String miForType) {
		this.miForType = miForType;
	}
	
}
