package org.nutans.r.web.app.exceptions;

@SuppressWarnings("serial")
public class NRPSupportException extends Exception {
	
	private String message;
	
	
	public NRPSupportException() {
		super();
		// TODO Auto-generated constructor stub
	}


	public NRPSupportException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}


	public NRPSupportException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}


	public NRPSupportException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}


	public NRPSupportException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage()
	{
		return this.message;
	}

	@Override
	public String toString() {
		return message;
	}

}
