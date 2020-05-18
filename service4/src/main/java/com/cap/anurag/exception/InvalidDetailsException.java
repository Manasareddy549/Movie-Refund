package com.cap.anurag.exception;

public class InvalidDetailsException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4289785294106145699L;

	public InvalidDetailsException(String error_Msg) {
		super(error_Msg);
		//super("custom exception");
	}
}
