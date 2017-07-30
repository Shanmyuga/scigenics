package com.sci.bpm.service.bulletin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sci.bpm.dao.bulletin.BulletinDAO;
import com.sci.bpm.db.model.SciBulletinBoard;

@Service
public class BulletinServiceImpl implements BulletinService {

	@Autowired
	private BulletinDAO bulletindao;
	
	@Transactional
	public boolean addBulletin(SciBulletinBoard board) {
				return bulletindao.addBulletin(board);

	}

	@Transactional
	public List searchBulletin() {
		
		return bulletindao.searchBulletins();
	}

}
