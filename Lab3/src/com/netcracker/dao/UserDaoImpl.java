package com.netcracker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.netcracker.customexception.DatabaseException;
import com.netcracker.dbutil.DatabaseUtility;
import com.netcracker.dto.User;
import com.netcracker.queries.AllQueries;

public class UserDaoImpl implements UserDao {

	@Override
	public boolean registerUser(User user) throws DatabaseException {
		
		boolean flag=false;
		int i=0;
		
		Connection connection = DatabaseUtility.getConnection();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(AllQueries.INSERT);
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getGender());
			preparedStatement.setString(5, user.getSkills());
			preparedStatement.setString(6, user.getCity());
			i = preparedStatement.executeUpdate();
			if(i!=0) {
				flag = true;
			}
		} catch (SQLException e) {
			throw new DatabaseException(e.getMessage());
		}
		
		return flag;
		
	}

	@Override
	public List<User> getAll() throws DatabaseException {
		Connection connection = DatabaseUtility.getConnection();
		List<User> list = new ArrayList<User>();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(AllQueries.GETALL);
			ResultSet res = preparedStatement.executeQuery();
			while(res.next()) {
				User user = new User(res.getString(1),res.getString(2), res.getString(3), res.getString(4), res.getString(5),res.getString(6));
				list.add(user);
			}
		} catch (SQLException e) {
			throw new DatabaseException(e.getMessage());
		}
		return list;
	}

}
