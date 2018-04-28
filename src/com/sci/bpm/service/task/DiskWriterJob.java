package com.sci.bpm.service.task;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class DiskWriterJob  {

	
	

	
	public String getHost() {
		return host;
	}


	public void setHost(String host) {
		this.host = host;
	}


	public String getPort() {
		return port;
	}


	public void setPort(String port) {
		this.port = port;
	}


	public String getDiskfileloc() {
		return diskfileloc;
	}


	public void setDiskfileloc(String diskfileloc) {
		this.diskfileloc = diskfileloc;
	}


	private String host;
	
	private String port;
	
	private String diskfileloc;
	
public  Connection getConnection() throws Exception {
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = null;
		try {
			 conn = DriverManager.getConnection("jdbc:oracle:thin:@"+host+":"+port+":xe","scigenics","scigenics");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}


public  void writeDrawings() throws SQLException {
	Connection conn = null;
	try {
		 conn = getConnection();
		String query = "Select * from scigenics.sci_drwing_details where data_file is not null";
		ResultSet rst = conn.createStatement().executeQuery(query);
		int idx =1;
		while(rst.next()) {
			String key  =rst.getString("SEQ_DRW_DTLID");
			String filename = rst.getString("ORIGINAL_DOC");
			Blob blob = rst.getBlob("DATA_FILE");
			if(blob != null) {
			BufferedInputStream bis =
				new BufferedInputStream(blob.getBinaryStream());
				BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream(new File(diskfileloc+"DR_"+key+"_"+filename)));
				
				byte[] buf = new byte[4096];
				int n = 0;

				while ((n = bis.read(buf, 0, 4096)) != -1) {
				bo.write(buf, 0, n);
				}

				bo.flush();
				bo.close();
				bis.close();
			}
			idx++;
			System.out.println(idx);
		}
		
		conn.createStatement().executeUpdate("UPDATE scigenics.sci_drwing_details d set data_file = null where d.data_file is not null");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		if(conn != null) {
			conn.close();
		}
	}
	
}

public  void writeQC() throws SQLException  {
	Connection conn = null;
	
	try {
		 conn = getConnection();
		String query = "Select * from scigenics.SCI_QC_DOCS where data_file is not null";
		ResultSet rst = conn.createStatement().executeQuery(query);
		int idx =1;
		while(rst.next()) {
			String key  =rst.getString("SEQ_QC_DOC_ID");
			String filename = rst.getString("ORIGINAL_FILE");
			Blob blob = rst.getBlob("DATA_FILE");
			if(blob != null) {
			BufferedInputStream bis =
				new BufferedInputStream(blob.getBinaryStream());
				BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream(new File(diskfileloc+"QC_"+key+"_"+filename)));
				
				byte[] buf = new byte[4096];
				int n = 0;

				while ((n = bis.read(buf, 0, 4096)) != -1) {
				bo.write(buf, 0, n);
				}

				bo.flush();
				bo.close();
				bis.close();
			}
			idx++;
			System.out.println(idx);
		}
		conn.createStatement().executeUpdate("UPDATE scigenics.SCI_QC_DOCS d set data_file = null where d.data_file is not null");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		if(conn != null) {
			conn.close();
		}
	}
}

public  void writejdr() throws SQLException  {
	Connection conn  = null;
	try {
		 conn = getConnection();
		String query = "Select * from scigenics.SCI_JDR_DOCS where JDR_DOC is not null";
		ResultSet rst = conn.createStatement().executeQuery(query);
		int idx =1;
		while(rst.next()) {
			String key  =rst.getString("SEQ_JDR_ID");
			String filename = rst.getString("ORIGINAL_DOC");
			Blob blob = rst.getBlob("JDR_DOC");
			if(blob != null) {
			BufferedInputStream bis =
				new BufferedInputStream(blob.getBinaryStream());
				BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream(new File(diskfileloc+"JDR_"+key+"_"+filename)));
				
				byte[] buf = new byte[4096];
				int n = 0;

				while ((n = bis.read(buf, 0, 4096)) != -1) {
				bo.write(buf, 0, n);
				}

				bo.flush();
				bo.close();
				bis.close();
			}
			idx++;
			System.out.println(idx);
		}
		conn.createStatement().executeUpdate("UPDATE scigenics.SCI_JDR_DOCS d set JDR_DOC = null where JDR_DOC is not null");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally {
		if(conn != null) {
			conn.close();
		}
	}
}


	public  void writeEnquiryDoc() throws SQLException  {
		Connection conn  = null;
		try {
			conn = getConnection();
			String query = "Select * from scigenics.SCI_ENQUIRY_DOCS where ENQ_DOC_DATA is not null";
			ResultSet rst = conn.createStatement().executeQuery(query);
			int idx =1;
			while(rst.next()) {
				String key  =rst.getString("SEQ_ENQ_DOC_ID");
				String filename = rst.getString("ORIGINAL_DOC");
				Blob blob = rst.getBlob("ENQ_DOC_DATA");
				if(blob != null) {
					BufferedInputStream bis =
							new BufferedInputStream(blob.getBinaryStream());
					BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream(new File(diskfileloc+"ENQ_"+key+"_"+filename)));

					byte[] buf = new byte[4096];
					int n = 0;

					while ((n = bis.read(buf, 0, 4096)) != -1) {
						bo.write(buf, 0, n);
					}

					bo.flush();
					bo.close();
					bis.close();
				}
				idx++;
				System.out.println(idx);
			}
			conn.createStatement().executeUpdate("UPDATE scigenics.SCI_ENQUIRY_DOCS d set ENQ_DOC_DATA = null where ENQ_DOC_DATA is not null");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			if(conn != null) {
				conn.close();
			}
		}
	}
}
