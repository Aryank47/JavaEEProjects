package com.netcracker.services;

import java.util.List;

import com.netcracker.customexception.DatabaseException;
import com.netcracker.dao.ConsumerDao;
import com.netcracker.dao.ConsumerDaoImpl;
import com.netcracker.dto.BillDetails;
import com.netcracker.dto.ConsumerData;
import com.netcracker.dto.Consumers;

public class ConsumerServicesImpl implements ConsumerServices {
	
	ConsumerDao consumerDao = new ConsumerDaoImpl();

	@Override
	public int verifyConsumer(long consumerno) throws DatabaseException {
		return consumerDao.verifyConsumer(consumerno);
	}

	@Override
	public int insertBill(BillDetails billDetails) throws DatabaseException {
		// TODO Auto-generated method stub
		return consumerDao.insertBill(billDetails);
	}

	@Override
	public boolean authentication(ConsumerData consumerData) throws DatabaseException {
		// TODO Auto-generated method stub
		return consumerDao.authentication(consumerData);
	}

	@Override
	public int registerUser(ConsumerData consumerData) throws DatabaseException {
		// TODO Auto-generated method stub
		return consumerDao.registerUser(consumerData);
	}

	@Override
	public int registerConsumer(Consumers consumer) throws DatabaseException {
		// TODO Auto-generated method stub
		return consumerDao.registerConsumer(consumer);
	}

	@Override
	public List<Consumers> getAllConsumers() throws DatabaseException {
		// TODO Auto-generated method stub
		return consumerDao.getAllConsumers();
	}

	@Override
	public Consumers getConsumerDetails(long consumerNo) throws DatabaseException {
		// TODO Auto-generated method stub
		return consumerDao.getConsumerDetails(consumerNo);
	}

	@Override
	public List<BillDetails> getBillDetails(long consumerNo) throws DatabaseException {
		// TODO Auto-generated method stub
		return consumerDao.getBillDetails(consumerNo);
	}

}
