package com.sci.bpm.service.bulletin;

import java.util.List;

import com.sci.bpm.db.model.SciBulletinBoard;

public interface BulletinService {

	
	public boolean addBulletin(SciBulletinBoard board);
	
	public List searchBulletin();
		
	
}
