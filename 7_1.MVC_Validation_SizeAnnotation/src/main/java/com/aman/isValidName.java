package com.aman;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = { NameValidator.class })  // This line tells that we are using 'NameValidator' class to validate this annotation 
@Target(value = {ElementType.FIELD })	
@Retention(RetentionPolicy.RUNTIME)
public @interface isValidName {

	String listOfValidNames();
	
	// This is the message , we will show to user if error occurs.
	String message() default "Please provide a valid name; " +
			"accepted names are - Aman, Bansal, Rahul, Abhishek (choose anyone)";
	
	Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
