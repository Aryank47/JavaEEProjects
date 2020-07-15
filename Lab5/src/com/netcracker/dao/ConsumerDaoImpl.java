package com.netcracker.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.netcracker.allqueries.Query;
import com.netcracker.customexception.DatabaseException;
import com.netcracker.dbutil.DatabaseUtility;
import com.netcracker.dto.BillDetails;
import com.netcracker.dto.ConsumerData;
import com.netcracker.dto.Consumers;

public class ConsumerDaoImpl implements ConsumerDao {

	@Override
	public int verifyConsumer(long consumerno) throws DatabaseException {
		
		Connection connection = DatabaseUtility.getConnection();
		int flag = 0;
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(Query.GETCONSUMER);
			preparedStatement.setLong(1, consumerno);
			ResultSet res = preparedStatement.executeQuery();
			if(res.next()) {
				flag = 1;
			}
		} catch (SQLException e) {
			throw new DatabaseException(e.getMessage());
		}finally {
			DatabaseUtility.releaseConnection();
		}
		
		return flag;
	}

	@Override
	public int insertBill(BillDetails billDetails) throws DatabaseException {
		Connection connection=DatabaseUtility.getConnection();
		int count=0;
		try {
			PreparedStatement statement=connection.prepareStatement(Query.INSERT);
			statement.setLong(1, billDetails.getConsumerNo());
			statement.setFloat(2,  billDetails.getCurReading());
			statement.setFloat(3,  billDetails.getUnitConsumed());
			statement.setFloat(4,  billDetails.getNetAmount());
			count=statement.executeUpdate();
			
		} catch (SQLException e) {
			throw new DatabaseException(e.getMessage());
		}finally {
			DatabaseUtility.releaseConnection();
		}
		
		return count;
	}

	@Override
	public boolean authentication(ConsumerData consumerData) throws DatabaseException {
		// TODO Auto-generated method stub
		boolean flag=false;
		Connection connection=DatabaseUtility.getConnection();
		try {
			PreparedStatement statement=connection.prepareStatement(Query.VERIFY);
			ResultSet res=statement.executeQuery();
			while(res.next()) {
				if(consumerData.getUsername().equals(res.getString(1)) & consumerData.getPassword().equals(res.getString(2))) {
					flag=true;
				}
			}
		}catch (SQLException e) {
			throw new DatabaseException(e.getMessage());
		}finally {
			DatabaseUtility.releaseConnection();
		}
		return flag;
	}

	@Override
	public int registerUser(ConsumerData consumerData) throws DatabaseException {
		// TODO Auto-generated method stub
		int count;
		Connection connection=DatabaseUtility.getConnection();
		try {
			PreparedStatement statement=connection.prepareStatement(Query.REGISTER);
			statement.setString(1, consumerData.getUsername());
			statement.setString(2, consumerData.getPassword());
			count=statement.executeUpdate();
		} catch (SQLException e) {
			throw new DatabaseException(e.getMessage());
		}finally {
			DatabaseUtility.releaseConnection();
		}
		
		return count;
	}

	@Override
	public int registerConsumer(Consumers consumer) throws DatabaseException {
		// TODO Auto-generated method stub
		int count;
		Connection connection=DatabaseUtility.getConnection();
		try {
			PreparedStatement statement=connection.prepareStatement(Query.REGISTERCONSUMER);
			statement.setString(1, consumer.getName());
			statement.setString(2, consumer.getAddress());
			count=statement.executeUpdate();
		} catch (SQLException e) {
			throw new DatabaseException(e.getMessage());
		}finally {
			DatabaseUtility.releaseConnection();
		}
		
		return count;
	}

	@Override
	public List<Consumers> getAllConsumers() throws DatabaseException {
		// TODO Auto-generated method stub
		Connection connection=DatabaseUtility.getConnection();
		List<Consumers> con=new LinkedList<Consumers>();
		Consumers consumer=null;
		try {
			PreparedStatement statement=connection.prepareStatement(Query.GETALLCONSUMERS);
			ResultSet res=statement.executeQuery();
			while(res.next()) {
				consumer=new Consumers(res.getLong(1), res.getString(2), res.getString(3));
				con.add(consumer);
			}
		} catch (SQLException e) {
			throw new DatabaseException(e.getMessage());
		}finally {
			DatabaseUtility.releaseConnection();
		}
		return con;
	}

	@Override
	public Consumers getConsumerDetails(long consumerNo) throws DatabaseException {
		// TODO Auto-generated method stub
		Consumers consumer=null;
		Connection connection=DatabaseUtility.getConnection();
		try {
			PreparedStatement statement=connection.prepareStatement(Query.GETCONSUMER);
			statement.setLong(1, consumerNo);
			ResultSet res = statement.executeQuery();
			if(res.next()) {
				consumer=new Consumers(res.getLong(1), res.getString(2), res.getString(3));
			}
		} catch (SQLException e) {
			throw new DatabaseException(e.getMessage());
		}finally {
			DatabaseUtility.releaseConnection();
		}
		return consumer;
	}

	@Override
	public List<BillDetails> getBillDetails(long consumerNo) throws DatabaseException {
		// TODO Auto-generated method stub
		BillDetails billDetail=null;
		List<BillDetails> bill= new LinkedList<BillDetails>();
		Connection connection=DatabaseUtility.getConnection();
		try {
			PreparedStatement statement=connection.prepareStatement(Query.GETBILLDETAILS);
			statement.setLong(1, consumerNo);
			ResultSet res=statement.executeQuery();
			while(res.next()) {
				billDetail=new BillDetails(res.getInt(1),res.getLong(2), res.getFloat(3), res.getFloat(4), res.getFloat(5),res.getDate(6));
				bill.add(billDetail);
			}
		}  catch (SQLException e) {
			throw new DatabaseException(e.getMessage());
		}finally {
			DatabaseUtility.releaseConnection();
		}
		return bill;
	}
	
	

}
