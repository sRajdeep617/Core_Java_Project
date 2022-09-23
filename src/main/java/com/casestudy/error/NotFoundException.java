package com.casestudy.error;

// exception for when an element is not found, in other words when a particular data is not found
@SuppressWarnings("serial")
public class NotFoundException extends Exception 
{
	private String message ; 
	public NotFoundException(String message)
	{
		super(message); // passing the error message to the super class 
		this.message = message ; 
	}
	
	@Override
	// overriding the getMessage method
	public String getMessage() 
	{
		 return this.message ; 
	}
}
