package com.aman;

import java.beans.PropertyEditorSupport;

public class EmployeeNameEditor extends PropertyEditorSupport{

	public void setAsText(String empName) throws IllegalArgumentException{
		if(empName.contains("Mr.") || empName.contains("Ms.")){
			setValue(empName);
		}else{
			empName = "Ms." +empName;
			setValue(empName);
		}
	}
	
}
