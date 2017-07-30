package com.sci.bpm.view;

import org.apache.tiles.Attribute;
import org.apache.tiles.AttributeContext;
import org.apache.tiles.context.TilesRequestContext;
import org.apache.tiles.preparer.PreparerException;
import org.apache.tiles.preparer.ViewPreparer;

public class TilesViewPreparer implements ViewPreparer {

	public void execute(TilesRequestContext arg0, AttributeContext arg1)
			throws PreparerException {
		String rolename = (String)arg0.getSessionScope().get("ROLE");
		
		Attribute menu = arg1.getAttribute("menu");
		
		String path = "/WEB-INF/jsp/layout/"+rolename+"/"+ "usermenu.jsp";
		menu.setValue(path);
	}

}
