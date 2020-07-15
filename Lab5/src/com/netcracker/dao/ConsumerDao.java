package com.netcracker.dao;

import java.util.List;

import com.netcracker.customexception.DatabaseException;
import com.netcracker.dto.BillDetails;
import com.netcracker.dto.ConsumerData;
import com.netcracker.dto.Consumers;

public interface ConsumerDao {
	public int registerConsumer(Consumers consumer)throws DatabaseException;
	public int registerUser(ConsumerData consumerData)throws DatabaseException;
	public boolean authentication(ConsumerData consumerData)throws DatabaseException;
	public int verifyConsumer(long consumerno) throws DatabaseException;
	public int insertBill(BillDetails billDetails)throws DatabaseException;
	public List<Consumers> getAllConsumers()throws DatabaseException;
	public Consumers getConsumerDetails(long consumerNo)throws DatabaseException;
	public List<BillDetails> getBillDetails(long consumerNo)throws DatabaseException;

}
