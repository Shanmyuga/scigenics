package com.sci.bpm.controller.po;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.StringReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.URIResolver;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.servlet.ServletContextURIResolver;
import org.apache.xmlgraphics.util.MimeConstants;



public class POFopProcessorServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public POFopProcessorServlet() {
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
	    
	    //Send content to Browser
	    response.getOutputStream().write(out.toByteArray());
	    response.getOutputStream().flush();
		} catch (FOPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
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
	}

}
