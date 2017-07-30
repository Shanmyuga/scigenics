package com.sci.bpm.controller.marketing;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.sci.bpm.command.design.DocPropery;
import com.sci.bpm.db.model.SciDrwingDetails;
import com.sci.bpm.db.model.SciJdrDocs;

public class JDRStreamerServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String idkey = req.getParameter("idkey");
		BufferedOutputStream bos = null;
		Long idkeynumber = new Long(idkey);
		SciJdrDocs selectedDetails = null;
		ApplicationContext cont = WebApplicationContextUtils.getRequiredWebApplicationContext(req.getSession(false).getServletContext());
		DocPropery dbean = (DocPropery) cont.getBean("docfilelocation");
		String docfileloc = dbean.getDocfilelocation();
		try {
			List<SciJdrDocs> deslist = (List) req.getSession(false)
					.getAttribute("workjdr");
			for (SciJdrDocs details : deslist) {
				if (details.getSeqJdrId().intValue() == idkeynumber
						.intValue()) {
					selectedDetails = details;
					break;
				}
			}
			 String filename =   selectedDetails.getOriginalDoc();
	            String filename2 = filename.replaceAll("[ \t]", "");
	            resp.setHeader("content-disposition", "attachment; filename=" + filename2);
			
           
            resp.setContentType(selectedDetails.getDocCnttype());
			bos = new BufferedOutputStream(resp.getOutputStream());

			String diskfile = "JDR_"+selectedDetails.getSeqJdrId().toString()+"_"+filename;
			BufferedInputStream bis =
				new BufferedInputStream(new FileInputStream(new File(docfileloc+diskfile)));
			

			byte[] buf = new byte[4096];
			int n = 0;

			while ((n = bis.read(buf, 0, 4096)) != -1) {
				bos.write(buf, 0, n);
			}
			bis.close();
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			   if( bos != null ) {
	                  bos.close();
	                }
	               

		}

	}


}
