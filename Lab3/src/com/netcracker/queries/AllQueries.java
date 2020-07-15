package com.netcracker.queries;

public interface AllQueries {

	String INSERT = "insert into RegisteredUsers values(?,?,?,?,?,?)";
	String GETALL = "select * from RegisteredUsers";
	
}
