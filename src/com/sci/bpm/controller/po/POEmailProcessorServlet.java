package com.sci.bpm.controller.po;

import org.apache.commons.lang.StringUtils;
import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.servlet.ServletContextURIResolver;
import org.apache.xmlgraphics.util.MimeConstants;

import javax.activation.DataHandler;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.util.ByteArrayDataSource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.*;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;


public class POEmailProcessorServlet extends HttpServlet {

	Properties properties = null;
	/**
	 * Constructor of the object.
	 */
	public POEmailProcessorServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}
	private FopFactory fopFactory = FopFactory.newInstance();
	private TransformerFactory tFactory = TransformerFactory.newInstance();
	protected URIResolver uriResolver; 
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		 //Setup a buffer to obtain the content length
	    ByteArrayOutputStream out = new ByteArrayOutputStream();

	    //Setup FOP
	    Fop fop;
		try {
			fop = fopFactory.newFop(MimeConstants.MIME_PDF, out);
			this.fopFactory.setURIResolver(this.uriResolver);
			String poxml = (String) request.getSession(true)
					.getAttribute("poxml");
			String vendorEmailId = (String) request.getSession(true)
					.getAttribute("vendorEmailID");
			if(poxml == null) {

			}
			
	    //Setup Transformer
			
	    Source xsltSrc = new StreamSource(new File(getServletContext().getRealPath("/")+"/xslt/po_template.xsl"));
	    Transformer transformer = tFactory.newTransformer(xsltSrc);
//transformer.setURIResolver(uriResolver);
	    //Make sure the XSL transformation's result is piped through to FOP
	    Result res = new SAXResult(fop.getDefaultHandler());

	    //Setup input
	    Source src = new StreamSource(new StringReader(poxml));

	    //Start the transformation and rendering process
	    transformer.transform(src, res);



	    //Prepare response
	    response.setContentType("application/pdf");
	    response.addHeader("Content-Disposition", "attachment; filename="
				+ "po.pdf");
	    response.setContentLength(out.size());
			byte[] pdfarray = out.toByteArray();

	    //Send content to Browser
			sendEmail("purchase@scigenics.in","shanmugasundarammuthuswamy@gmail.com","Purchase Order From Scigenics","Dear Sir <br> Please find the attached purchase order from Scigenics India Pvt Ltd.",pdfarray);
	    response.getOutputStream().write(pdfarray);
	    response.getOutputStream().flush();
		} catch (FOPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		}

	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

doGet(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		System.out.println(getServletContext().getRealPath("/"));
		  this.uriResolver = new ServletContextURIResolver(getServletContext());

		properties = new Properties();
		InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(
				"com/sci/bpm/service/task/maildetails.properties");
		try {
			properties.load(inputStream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	public void sendEmail(String aFromEmailAddr, String aToEmailAddr,
						  String aSubject, String aBody,byte[] array) throws NoSuchProviderException {
		// Here, no Authenticator argument is used (it is null).
		// Authenticators are used to prompt the user for user
		// name and password.
		System.out.println(array);
		Properties config = createConfiguration();

		Session session = Session.getDefaultInstance(config,
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
			message.setFrom(new InternetAddress("dbaseserver@scigenics.in"));

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
			mbp2.setFileName("PurchaseOrder -" +  dateformat.format(new Date())+".pdf");
			ByteArrayDataSource bds = new ByteArrayDataSource(array, "application/pdf");
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

	private Properties createConfiguration() {
		return new Properties() {{
			put("mail.smtp.host", "smtp.gmail.com");
			put("mail.smtp.auth", "true");
			put("mail.smtp.port", "465");
			put("mail.smtp.socketFactory.port", "465");
			put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		}};
	}

}
