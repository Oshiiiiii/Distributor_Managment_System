package com.fmcg.route_management.exceptions;

public class ResourceAlreadyExistsException extends RuntimeException{
 
	private static final long serialVersionUID = 1348771109171435607L;

	public ResourceAlreadyExistsException(String message)
	{
		super(message);
	}
}
