package com.netcracker.allqueries;

public interface Query {
	String GETALLCONSUMERS="select * from consumers";
	String GETCONSUMER = "select * from Consumers where consumer_num = ?";
	String REGISTERCONSUMER="insert into consumers values(consumer_no.nextval,?,?)";
	String REGISTER="insert into consumerdata values(?,?)";
	String VERIFY= "select * from consumerdata";
	String INSERT="insert into billdetails values(seq_bill_num.nextval,?,?,?,?,SYSDATE)";
	String GETBILLDETAILS="select * from billdetails where consumer_num=?";

}
