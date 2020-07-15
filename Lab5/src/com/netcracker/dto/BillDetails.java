package com.netcracker.dto;

import java.sql.Date;
import java.time.LocalDateTime;

public class BillDetails {
	
	private int billNo;
	private long consumerNo;
	private float curReading;
	private float unitConsumed;
	private float netAmount;
	private LocalDateTime billDate;
	String date;

	public BillDetails(long consumerNo, float curReading, float unitConsumed, float netAmount) {
		super();
		this.consumerNo = consumerNo;
		this.curReading = curReading;
		this.unitConsumed = unitConsumed;
		this.netAmount = netAmount;
	}
	
	
	

	public BillDetails(int billNo, long consumerNo, float curReading, float unitConsumed, float netAmount,
			Date billDate) {
		super();
		this.billNo = billNo;
		this.consumerNo = consumerNo;
		this.curReading = curReading;
		this.unitConsumed = unitConsumed;
		this.netAmount = netAmount;
		date=setBillDate(billDate);
	}




	public String getDate() {
		return date;
	}




	public long getConsumerNo() {
		return consumerNo;
	}

	public void setConsumerNo(long consumerNo) {
		this.consumerNo = consumerNo;
	}

	public float getCurReading() {
		return curReading;
	}

	public void setCurReading(float curReading) {
		this.curReading = curReading;
	}

	public float getUnitConsumed() {
		return unitConsumed;
	}

	public void setUnitConsumed(float unitConsumed) {
		this.unitConsumed = unitConsumed;
	}

	public float getNetAmount() {
		return netAmount;
	}

	public void setNetAmount(float netAmount) {
		this.netAmount = netAmount;
	}

	public Date getBillDate() {
		billDate=LocalDateTime.now();
		java.sql.Date sqlDate = java.sql.Date.valueOf(billDate.toLocalDate());
		return sqlDate;
	}


	
	public int getBillNo() {
		return billNo;
	}


	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}




	public String setBillDate(Date billDate) {
		String str=billDate.toString();
		return str;
	}
	
	
}
