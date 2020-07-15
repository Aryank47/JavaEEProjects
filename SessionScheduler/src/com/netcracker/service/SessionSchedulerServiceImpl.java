package com.netcracker.service;

import java.util.List;

import com.netcracker.customexception.DatabaseException;
import com.netcracker.dao.SessionSchedulerDAO;
import com.netcracker.dao.SessionSchedulerDAOImpl;
import com.netcracker.dto.SessionScheduler;

public class SessionSchedulerServiceImpl implements SessionSchedulerService {
	
	SessionSchedulerDAO ssDao=new SessionSchedulerDAOImpl();

	@Override
	public List<SessionScheduler> getAll() throws DatabaseException {
		
		return ssDao.getAll();
	}

	@Override
	public int update(SessionScheduler sessionScheduler) throws DatabaseException {
		
		return ssDao.update(sessionScheduler);
	}

}
