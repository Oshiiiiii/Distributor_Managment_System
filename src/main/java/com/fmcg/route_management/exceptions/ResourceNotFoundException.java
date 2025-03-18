package com.fmcg.route_management.exceptions;

public class ResourceNotFoundException extends RuntimeException{
 
	private static final long serialVersionUID = 1348771109171435607L;

	public ResourceNotFoundException(String message)
	{
		super(message);
	}
}
