package com.aman;


import java.util.Date;

public class Emp {
	
	private int id;
	private String name;
	private Date dateDob;
	private Address empAddress;

	public Emp() {}
	
	public Address getEmpAddress() {
		return empAddress;
	}

	public void setEmpAddress(Address empAddress) {
		this.empAddress = empAddress;
	}
	
	public Date getDateDob() {
		return dateDob;
	}

	public void setDateDob(Date dateDob) {
		this.dateDob = dateDob;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

