package com.sci.bpm.controller.design;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.sci.bpm.command.design.DocPropery;
import com.sci.bpm.command.design.DrawingDetailsBean;
import com.sci.bpm.dao.design.DesignDocDAO;
import com.sci.bpm.db.model.SciDrwingDetails;
import com.sci.bpm.service.design.DesignDocService;

public class DocumentStreamServlet extends HttpServlet {

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
		SciDrwingDetails selectedDetails = null;
		Long idkeynumber = new Long(idkey);
		DrawingDetailsBean detailbean= null;
		ApplicationContext cont = WebApplicationContextUtils.getRequiredWebApplicationContext(req.getSession(false).getServletContext());
		DesignDocService service = (DesignDocService) cont.getBean("designservice");
		DocPropery dbean = (DocPropery) cont.getBean("docfilelocation");
		String docfileloc = dbean.getDocfilelocation();
		
		try {
			List<DrawingDetailsBean> deslist = (List) req.getSession(false)
					.getAttribute("workdes");
			if(deslist != null) {
			for (DrawingDetailsBean details : deslist) {
				if (details.getSeqDrwDtlid().intValue() == idkeynumber
						.intValue()) {
					detailbean = details;
					selectedDetails = service.loadDrawingdetails(detailbean.getSeqDrwDtlid());
					break;
				}
			}
			}
			
            String filename =   selectedDetails.getOriginalDoc();
            String filename2 = filename.replaceAll("[ \t]", "");
            resp.setHeader("content-disposition", "attachment; filename=" + filename2);
            resp.setContentType(selectedDetails.getDocCnttype());
			bos = new BufferedOutputStream(resp.getOutputStream());
			String diskfile = "DR_"+selectedDetails.getSeqDrwDtlid().toString()+"_"+filename;
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
	
	 private String getMimeType(String format)
	    {
	          if(format.equalsIgnoreCase(".pdf")) //check the out type
	              return "application/pdf";
	          else if(format.equalsIgnoreCase(".doc"))
	              return "application/x-msword";
	          else if(format.equalsIgnoreCase(".xls"))
	              return "application/x-excel";
	          else if(format.equalsIgnoreCase("image_gif"))
	              return "image/gif";
	          else if(format.equalsIgnoreCase("image_jpeg"))
	              return "image/jpeg";
	          else if(format.equalsIgnoreCase("image_bmp"))
	              return "image/bmp";
	          else if(format.equalsIgnoreCase("image_x-png"))
	              return "image/x-png";
	          else if(format.equalsIgnoreCase("msdownload"))
	              return "application/x-msdownload";
	          else if(format.equalsIgnoreCase("video_avi"))
	              return "video/avi";
	          else if(format.equalsIgnoreCase("video_mpeg"))
	              return "video/mpeg";
	          else if(format.equalsIgnoreCase("html"))
	              return "text/html";
	          else if(format.equalsIgnoreCase("xml"))
	              return "text/xml";
	          else
	              return null;
	    }


}
