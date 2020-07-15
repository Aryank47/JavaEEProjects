package com.netcracker.dto;

public class Consumers {
	private long consumerNo;
	private String name;
	private String address;
	
	
	public Consumers(long consumerNo, String name, String address) {
		super();
		this.consumerNo = consumerNo;
		this.name = name;
		this.address = address;
	}
	
	public long getConsumerNo() {
		return consumerNo;
	}
	
	public void setConsumerNo(long consumerNo) {
		this.consumerNo = consumerNo;
	}
	
	public Consumers(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
