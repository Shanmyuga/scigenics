package com.sci.bpm.dao.bulletin;



import java.util.List;

import com.sci.bpm.db.model.SciBulletinBoard;

public interface BulletinDAO {

	
	public boolean addBulletin(SciBulletinBoard board);
	
	public List searchBulletins();
}
