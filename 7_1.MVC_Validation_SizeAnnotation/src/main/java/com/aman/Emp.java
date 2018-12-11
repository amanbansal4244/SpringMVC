package com.aman;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Emp {
	
	@Max(2222)
	private int id;
	
	
	@Pattern(regexp="[^0-9]*") @isValidName(listOfValidNames = "Aman|Bansal|Rahul|Abhishek")
	private String name;
	
	@Past
	private Date dateDob;
	/*private List<String> skills;*/
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
	
	/*public List<String> getSkills() {
		return skills;
	}

	public void setSkills(ArrayList<String> skills) {
		this.skills = skills;
	}
*/
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

