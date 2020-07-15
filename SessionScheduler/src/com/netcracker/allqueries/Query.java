package com.netcracker.allqueries;

public interface Query {
	String GETALL=" select * from scheduledsessions";
	String UPDATE="update scheduledsessions set duration=?,faculty=?,mode1=? where id=?";

}
