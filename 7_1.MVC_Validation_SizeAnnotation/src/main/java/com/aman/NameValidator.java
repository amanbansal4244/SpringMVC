package com.aman;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<isValidName, String> {

	private String listOfValidNames;
	public void initialize(isValidName isValidName) {
		this.listOfValidNames = isValidName.listOfValidNames();
	}

	public boolean isValid(String empName, ConstraintValidatorContext ctx) {
		if(empName == null){
			return false;
		}
		if(empName.matches(listOfValidNames)){
			return true;
		}else{
			return false;
		}
	}

	
}
