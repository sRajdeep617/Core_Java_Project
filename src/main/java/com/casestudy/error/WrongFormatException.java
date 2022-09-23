package com.casestudy.error;

@SuppressWarnings("serial")
public class WrongFormatException extends Exception 
{
	private String message ; 
	public WrongFormatException(String message)
	{
		super(message); 
		this.message = message ; 
	}
	
	@Override
	// overriding the getMessage method here
	public String getMessage() {
		 return this.message ; 
	}
}

