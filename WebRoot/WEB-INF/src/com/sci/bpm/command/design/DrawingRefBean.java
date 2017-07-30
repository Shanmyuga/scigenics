package com.sci.bpm.command.design;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.sci.bpm.command.mi.MatCollectionCommand;

public class DrawingRefBean implements Serializable {

	private String drawingDesc;
	private String documentName;
	private Long seqworkID;
	private String drwingRefnum;
	private String revisionid;
	private String docNum;
	private String docuDesc;
	private String docuName;
	private Date[] docdueDate;
	private Long documentid;
	private String rejectComments;
	private int rowindex;
	private List<MatCollectionCommand> matList = new ArrayList();

	public DrawingRefBean() {
		super();
		for (int idx = 0; idx < 11; idx++) {
			this.matList.add(new MatCollectionCommand());
		}
	}

	private transient MultipartFile filedoc;

	private String[] detailID;

	public String getRevisionid() {
		return revisionid;
	}

	public String[] getDetailID() {
		return detailID;
	}

	public void setDetailID(String[] detailID) {
		this.detailID = detailID;
	}

	public void setRevisionid(String revisionid) {
		this.revisionid = revisionid;
	}

	public String getDrawingDesc() {

		return drawingDesc;
	}

	public void setDrawingDesc(String drawingDesc) {
		this.drawingDesc = drawingDesc;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public Long getSeqworkID() {
		return seqworkID;
	}

	public void setSeqworkID(Long seqworkID) {
		this.seqworkID = seqworkID;
	}

	public String getDrwingRefnum() {
		return drwingRefnum;
	}

	public void setDrwingRefnum(String drwingRefnum) {
		this.drwingRefnum = drwingRefnum;
	}

	public MultipartFile getFiledoc() {
		return filedoc;
	}

	public void setFiledoc(MultipartFile filedoc) {
		this.filedoc = filedoc;
	}

	public String getDocuDesc() {
		return docuDesc;
	}

	public void setDocuDesc(String docuDesc) {
		this.docuDesc = docuDesc;
	}

	public String getDocuName() {
		return docuName;
	}

	public void setDocuName(String docuName) {
		this.docuName = docuName;
	}

	public String getDocNum() {
		return docNum;
	}

	public void setDocNum(String docNum) {
		this.docNum = docNum;
	}

	public Date[] getDocdueDate() {
		return docdueDate;
	}

	public void setDocdueDate(Date[] docdueDate) {
		this.docdueDate = docdueDate;
	}

	public List<MatCollectionCommand> getMatList() {
		return matList;
	}

	public void setMatList(List<MatCollectionCommand> matList) {
		this.matList = matList;
	}

	public Long getDocumentid() {
		return documentid;
	}

	public void setDocumentid(Long documentid) {
		this.documentid = documentid;
	}

	public String getRejectComments() {
		return rejectComments;
	}

	public void setRejectComments(String rejectComments) {
		this.rejectComments = rejectComments;
	}

}
