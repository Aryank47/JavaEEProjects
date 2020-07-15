package com.netcracker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.netcracker.allqueries.Query;
import com.netcracker.customexception.DatabaseException;
import com.netcracker.dbutil.DatabaseUtility;
import com.netcracker.dto.SessionScheduler;

public class SessionSchedulerDAOImpl implements SessionSchedulerDAO{

	@Override
	public List<SessionScheduler> getAll() throws DatabaseException {
		List<SessionScheduler> ss=new ArrayList<SessionScheduler>();
		SessionScheduler sessionScheduler=null;
		Connection connection=DatabaseUtility.getConnection();
		try {
			PreparedStatement statement=connection.prepareStatement(Query.GETALL);
			ResultSet res=statement.executeQuery();
			while(res.next()){
				sessionScheduler=new SessionScheduler(res.getInt(1), res.getString(2), res.getInt(3), res.getString(4), res.getString(5));
				ss.add(sessionScheduler);
			}
		} catch (SQLException e) {
			throw new DatabaseException(e.getMessage());
		}finally {
			DatabaseUtility.releaseConnection();
		}
		
		return ss;
	}

	@Override
	public int update(SessionScheduler sessionScheduler) throws DatabaseException {
		int count=0;
		Connection connection=DatabaseUtility.getConnection();
		try {
			PreparedStatement statement=connection.prepareStatement(Query.UPDATE);
			statement.setInt(1, sessionScheduler.getDuration());
			statement.setString(2, sessionScheduler.getFaculty());
			statement.setString(3, sessionScheduler.getMode1());
			statement.setInt(4, sessionScheduler.getId());
			count=statement.executeUpdate();
		} catch (SQLException e) {
			throw new DatabaseException(e.getMessage());
		}finally {
			DatabaseUtility.releaseConnection();
		}
		return count;
	}

}
