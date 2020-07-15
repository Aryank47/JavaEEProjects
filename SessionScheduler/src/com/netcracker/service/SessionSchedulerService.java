package com.netcracker.service;

import java.util.List;

import com.netcracker.customexception.DatabaseException;
import com.netcracker.dto.SessionScheduler;

public interface SessionSchedulerService {
	
	public List<SessionScheduler> getAll() throws DatabaseException;
	public int update(SessionScheduler sessionScheduler) throws DatabaseException;

}
