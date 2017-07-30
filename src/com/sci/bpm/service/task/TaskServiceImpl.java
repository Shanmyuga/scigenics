package com.sci.bpm.service.task;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.activation.DataHandler;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;

import org.apache.commons.lang.StringUtils;
import org.apache.fop.area.OffDocumentExtensionAttachment;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sci.bpm.dao.task.TaskProcessDAO;
import com.sci.bpm.db.model.SciIssueDetails;
import com.sci.bpm.db.model.SciIssueMaster;
import com.sci.bpm.db.model.SciReportConfiguration;

@Service("taskservice")
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskProcessDAO daoimpl;
	Properties properties = null;
	public TaskServiceImpl() {
		 properties = new Properties();
			InputStream inputStream = this.getClass().getResourceAsStream(
					"maildetails.properties");
			try {
				properties.load(inputStream);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	@Transactional
	public boolean addNewTask(SciIssueMaster master) {
	
		return daoimpl.addNewTask(master);
	}

	@Transactional
	public boolean closeTasks(SciIssueDetails issueDetails) {
		daoimpl.closeTasks(issueDetails);
		return false;
	}

	
	
	

	@Transactional
	public boolean forwardTasks(SciIssueDetails issueDetails) {
	
		daoimpl.addNewDetails(issueDetails);
		return true;
	}

	@Transactional
	public List searchTasks(String status, int startpage,String userid) {
		
		
		return daoimpl.searchOpenTask(status, startpage,userid);
	}

	@Transactional
	public String getNextSeqID() {
		
		return daoimpl.getNextSeqTaskID();
	}
	@Transactional
	public SciIssueDetails loadDetails(String seqid) {
	
		return daoimpl.loadDetails(seqid);
	}
	@Transactional
	public boolean esclateTasks(SciIssueDetails details) {
		// TODO Auto-generated method stub
		daoimpl.addNewDetails(details);
		return false;
	}
	@Transactional
	public List loadForEscalation(int numberOfdays) {
		// TODO Auto-generated method stub
		
		List<SciIssueDetails> opentasks = daoimpl.escalateTasks(numberOfdays);
		System.out.println(opentasks.size());
		return opentasks;
	}
	@Transactional
	public Map<String, Map<Integer,String>> getReportCount() {
		// TODO Auto-generated method stub
		return daoimpl.getTotalCount();
	}

	public List<Map<Integer, String>> getWOTotalCount() {
		// TODO Auto-generated method stub
		return daoimpl.getWOTotalCount();
	}
	@Transactional
	public void generateReports() {
		// TODO Auto-generated method stub
		List<SciReportConfiguration> configurations  = daoimpl.loadDailyReports();
		System.out.println("config.zide" + configurations.size());
		for(SciReportConfiguration report:configurations) {
			
	generateExcelReports(report);
			
		}
	}
	
	public void sendEmail(String aFromEmailAddr, String aToEmailAddr,
			String aSubject, String aBody,byte[] array) throws NoSuchProviderException {
		// Here, no Authenticator argument is used (it is null).
		// Authenticators are used to prompt the user for user
		// name and password.
		System.out.println(array);
		

		Session session = Session.getDefaultInstance(properties,
				new Authenticator() {
					protected PasswordAuthentication getPasswordAuthentication() {
						return new PasswordAuthentication((String) properties
								.get("mail.login.username"),
								(String) properties.get("mail.login.password"));
					}
				});
		session.setDebug(false);

		MimeMessage message = new MimeMessage(session);
		try {
			// the "from" address may be set in code, or set in the
			// config file under "mail.from" ; here, the latter style is used
			message.setFrom(new InternetAddress(properties
					.getProperty("mail.from")));
			
			/*InternetAddress[] address = new InternetAddress[1];
			address[0] = new InternetAddress("sundaraswamy@gmail.com");*/
			String[] addressarray = StringUtils.split(aToEmailAddr, ",");
				InternetAddress[] address = new InternetAddress[addressarray.length];
			for(int i=0;i<addressarray.length;i++) {
				address[i] = new InternetAddress(addressarray[i]);
			}
			message.addRecipients(javax.mail.internet.MimeMessage.RecipientType.TO, address);
			
			message.setSubject(aSubject);
			
			MimeBodyPart mbp1 = new MimeBodyPart(); 
			mbp1.setText(aSubject); 
			
			MimeBodyPart mbp2 = new MimeBodyPart(); 
			SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy");
			mbp2.setFileName("Report - " + aSubject + dateformat.format(new Date())+".xls");
			ByteArrayDataSource bds = new ByteArrayDataSource(array, "application/xls");
			mbp2.setDataHandler(new DataHandler(bds)); 
			Multipart mp = new MimeMultipart(); 
			
			mp.addBodyPart(mbp1); 
			mp.addBodyPart(mbp2); 
			message.setContent(mp); 
			message.saveChanges();  
			Transport.send(message);
		} catch (MessagingException ex) {
			ex.printStackTrace();
			System.err.println("Cannot send email. " + ex);
		}
	}

	@Transactional
	public void runSelectedReport(SciReportConfiguration configuration) {
		// TODO Auto-generated method stub
		generateExcelReports(configuration);
	}
	
	
	private void generateReports(SciReportConfiguration report) {
		
		List<LinkedHashMap<String, Object>> mylist =  daoimpl.generateReports(report.getReportQuery());
		HashMap<String,Object> colnameMap = mylist.get(0);
		Set<String> colkeyset = colnameMap.keySet();
		StringBuffer buffer = new StringBuffer("<table border=\"1\" width=\"100%\" style='font-size:8pt'>");
		buffer.append("<tr style='font-size:12pt'>");
		
		for(String intkey:colkeyset){
			buffer.append("<td>");
			
			buffer.append(intkey);
			buffer.append("</td>");
		}
		buffer.append("</tr>");
		for(int idx= 1;idx<mylist.size();idx++) {
			
			HashMap<String,Object> rowdataMap = mylist.get(idx);
			
			buffer.append("<tr>");
			
			for(String intkey:colkeyset){
				buffer.append("<td>");
				
				buffer.append(rowdataMap.get(intkey));
				buffer.append("</td>");
			}
			buffer.append("</tr>");
		}
		buffer.append("</table>");
		try {
			sendEmail(null, report.getReportEmail(), report.getReportSubject(), buffer.toString(),null);
			buffer.replace(0, buffer.toString().length(), "");
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
private void generateExcelReports(SciReportConfiguration report) {
		
		List<LinkedHashMap<String, Object>> mylist =  daoimpl.generateReports(report.getReportQuery());
		HashMap<String,Object> colnameMap = mylist.get(0);
		Set<String> colkeyset = colnameMap.keySet();
		
		HSSFWorkbook wb = new HSSFWorkbook();
	    //Workbook wb = new XSSFWorkbook();
	   
	    HSSFSheet sheet = wb.createSheet("Report sheet");

	   
	    // Create a cell and put a value in it.
	    

	 

	    // Write the output to a file
	    try {
			FileOutputStream fileOut = new FileOutputStream("workbook.xls");
			wb.write(fileOut);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	   
	    HSSFRow row = sheet.createRow(0);
		short id = 0;
		for(String intkey:colkeyset){
			 // Create a row and put some cells in it. Rows are 0 based.
			HSSFCell cell = row.createCell(id);
		    cell.setCellValue(new HSSFRichTextString(intkey));
		    id ++;
		    
		}
		
		for(int idx= 1;idx<mylist.size();idx++) {
			
			HashMap<String,Object> rowdataMap = mylist.get(idx);
			Set<String> colnameset = rowdataMap.keySet();
			
			 HSSFRow row1 = sheet.createRow(idx);
		
			short j =0;
			for(String intkey:colkeyset){
				
				HSSFCell cell = row1.createCell(j);
				Object celldata = rowdataMap.get(intkey);
				if(celldata instanceof String && celldata != null) {
					cell.setCellType(Cell.CELL_TYPE_STRING);
					cell.setCellValue(new HSSFRichTextString(celldata.toString()));
				}
				else if(celldata instanceof Double && celldata != null ) {
					cell.setCellValue(((Double) celldata).doubleValue());
				}
				else if(celldata instanceof BigDecimal && celldata != null) {
					cell.setCellValue(((BigDecimal) celldata).doubleValue());
				}
				else if(celldata instanceof java.sql.Date && celldata != null) {
					cell.setCellValue((java.sql.Date)celldata);
				}
				else if(celldata instanceof BigInteger && celldata != null) {
					cell.setCellType(Cell.CELL_TYPE_NUMERIC);
					cell.setCellValue(((BigInteger) celldata).doubleValue());
				}
				else {
					if(celldata==null) {
						celldata = new String("");
					}
					cell.setCellType(Cell.CELL_TYPE_STRING);
					cell.setCellValue(new HSSFRichTextString(celldata.toString()));
				}
				
			    j++;
				
			}
			
		}
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		
		try {
			wb.write(baos);
			sendEmail(null, report.getReportEmail(), report.getReportSubject(), null,baos.toByteArray());
			//buffer.replace(0, buffer.toString().length(), "");
		} catch (NoSuchProviderException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


public static void main(String args[]) throws NoSuchProviderException {
	TaskServiceImpl impl = new TaskServiceImpl();
	HSSFWorkbook wb = new HSSFWorkbook();
    //Workbook wb = new XSSFWorkbook();
   
    HSSFSheet sheet = wb.createSheet("Report sheet");
    HSSFRow row = sheet.createRow(0);
    HSSFCell cell = row.createCell((short) 0);
   
    cell.setCellValue(new Double(100.01).doubleValue());
    cell.setCellType(Cell.CELL_TYPE_NUMERIC);
    ByteArrayOutputStream outstream = new ByteArrayOutputStream();
    try {
		wb.write(outstream);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	impl.sendEmail("sundaraswamy@gmail.com","sundaraswamy@gmail.com","Report count Daily and Monthly", "",outstream.toByteArray()
			);
}

@Transactional
public void generateWeeklyReports() {
	// TODO Auto-generated method stub
	List<SciReportConfiguration> configurations  = daoimpl.loadWeeklyReports();
	
	System.out.println("config.zide" + configurations.size());
	for(SciReportConfiguration report:configurations) {
		
generateExcelReports(report);
		
	}
}
}
