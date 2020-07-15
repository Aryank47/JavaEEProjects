package com.netcracker.service;

import java.util.List;

import com.netcracker.customexception.DatabaseException;
import com.netcracker.dto.User;

public interface UserService {
	
	public boolean registerUser(User user) throws DatabaseException;
	public List<User> getAll() throws DatabaseException;

}
