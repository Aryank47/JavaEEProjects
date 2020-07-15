package com.netcracker.service;

import java.util.List;

import com.netcracker.customexception.DatabaseException;
import com.netcracker.dao.UserDao;
import com.netcracker.dao.UserDaoImpl;
import com.netcracker.dto.User;

public class UserServiceImpl implements UserService {

	@Override
	public boolean registerUser(User user) throws DatabaseException {
		UserDao userdao = new UserDaoImpl();
		return userdao.registerUser(user);
	}

	@Override
	public List<User> getAll() throws DatabaseException {
		UserDao userdao = new UserDaoImpl();
		return userdao.getAll();
	}
	
	

}
