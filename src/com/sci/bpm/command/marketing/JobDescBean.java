package com.sci.bpm.command.marketing;

import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

public class JobDescBean implements Serializable {

	private String jdrDesc;
	private transient MultipartFile filedoc;
	private String jdrDocName;
	private String docVersion;
	public String getJdrDesc() {
		return jdrDesc;
	}
	public void setJdrDesc(String jdrDesc) {
		this.jdrDesc = jdrDesc;
	}
	public MultipartFile getFiledoc() {
		return filedoc;
	}
	public void setFiledoc(MultipartFile filedoc) {
		this.filedoc = filedoc;
	}
	public String getJdrDocName() {
		return jdrDocName;
	}
	public void setJdrDocName(String jdrDocName) {
		this.jdrDocName = jdrDocName;
	}
	public String getDocVersion() {
		return docVersion;
	}
	public void setDocVersion(String docVersion) {
		this.docVersion = docVersion;
	}
	
	
	

}
