package com.sci.bpm.service.task;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class ReportCountService extends QuartzJobBean {

	@Override
	protected void executeInternal(JobExecutionContext arg0)
			throws JobExecutionException {
		// TODO Auto-generated method stub
		try {
			System.out.println("inside report count");
			StringBuffer buffer = new StringBuffer("<table border=\"1\" width=\"100%\" style='font-size:12pt'>");
			buffer.append("<tr style='font-size:18pt'><td>Category</td><td>Total Cost</td><td>Handled MI Count</td></tr>");
		Map<String,Map<Integer,String>> datamap = tservice.getReportCount();
			//Map<String,Map<Integer,String>> datamap =null;
			Set<String> dataset =datamap.keySet();
			for(String key: dataset) {
				buffer.append("<tr><td>");
				
				buffer.append(key);
				buffer.append("</td>");
				Map colmap = datamap.get(key);
				Set<Integer> coldataset =colmap.keySet();
				for(Integer intkey:coldataset){
					buffer.append("<td>");
					
					buffer.append(colmap.get(intkey));
					buffer.append("</td>");
				}
				
				
				buffer.append("</tr>");
				
			}
			buffer.append("</table>");
			System.out.println(buffer.toString());
			sendEmail("Report count Daily and Monthly", "",
					"Stock Report Daily and Monthly",buffer.toString());
			buffer= null;
			 buffer = new StringBuffer("<table border=\"1\" width=\"100%\" style='font-size:12pt'>");
			buffer.append("<tr style='font-size:18pt'><td>SNo</td><td>Job Desc</td><td>Client Details</td><td>Approved MI Cost</td><td>Approved MI Count</td><td>Approved MI MECH Count</td><td>Approved MI EI Count</td><td>Itemized MI Cost</td><td>Itemized Mi count</td><td>Received MI Cost</td><td>Received MI Count</td><td>Issued MI Cost</td><td>Issued MI Count</td><td>Issued MI MECH Count</td><td>Issued MI EI Count</td><td>WO Create Date</td></tr>");
		List<Map<Integer,String>> dataList = tservice.getWOTotalCount();
			//Map<String,Map<Integer,String>> datamap =null;
		System.out.println(dataList.size());
		int idx = 1;
			for(Map keymap: dataList) {
				buffer.append("<tr>");
				buffer.append("<td>");
				buffer.append(idx);
				buffer.append("</td>");
				Set<Integer> coldataset =keymap.keySet();
				for(Integer intkey:coldataset){
					buffer.append("<td>");
					
					buffer.append(keymap.get(intkey));
					buffer.append("</td>");
				}
				
				
				buffer.append("</tr>");
				idx = idx +1;
			}
			buffer.append("</table>");
			System.out.println(buffer.toString());
			//sendEmail("Report count Daily and Monthly", "","WO Cost Report Status ",buffer.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public TaskService getTservice() {
		return tservice;
	}

	public void setTservice(TaskService tservice) {
		this.tservice = tservice;
	}

	private TaskService tservice;

	Properties properties = null;

	public void sendEmail(String aFromEmailAddr, String aToEmailAddr,
			String aSubject, String aBody) throws NoSuchProviderException {
		// Here, no Authenticator argument is used (it is null).
		// Authenticators are used to prompt the user for user
		// name and password.

		try {
			properties = new Properties();
			InputStream inputStream = this.getClass().getResourceAsStream(
					"maildetails.properties");
			properties.load(inputStream);
		} catch (Exception e) {
			// Catching the exception as null condition
			// is handled in the methods.
			e.printStackTrace();
		}

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
			
				InternetAddress[] address = new InternetAddress[9];
			address[0] = new InternetAddress("skpotti@scigenics.in");
		
			address[1] = new InternetAddress("swaminathan@scigenics.in");
			address[2] = new InternetAddress("segar@scigenics.in");
			
			address[3] = new InternetAddress("purchase@scigenics.in");
			address[4] = new InternetAddress("selvi@scigenics.in");
			address[5] = new InternetAddress("muthu@scigenics.in");
			address[6] = new InternetAddress("mech@scigenics.in");
			address[7] = new InternetAddress("production@scigenics.in");
			address[8] = new InternetAddress("quality@scigenics.in");
			
			message.addRecipients(javax.mail.internet.MimeMessage.RecipientType.TO, address);
			
			message.setSubject(aSubject);
			message.setContent(aBody, "text/html");

			Transport.send(message);
		} catch (MessagingException ex) {
			ex.printStackTrace();
			System.err.println("Cannot send email. " + ex);
		}
	}

	public static void main(String args[]) throws NoSuchProviderException {
		ReportCountService countservice = new ReportCountService();
		countservice.sendEmail("Report count Daily and Monthly", "",
				"Report count Daily and Monthly", "Test Email");
	}
}
