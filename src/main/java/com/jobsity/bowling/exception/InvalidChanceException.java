package com.jobsity.bowling.exception;

/**
 *
 * @author jodevan
 */
public class InvalidChanceException extends Exception {

	public InvalidChanceException(int maxChanceAllowedValue) {
		super("The value of the chance must be between 0 and " 
				+ maxChanceAllowedValue);
	}

	public InvalidChanceException(String msg) {
		super(msg);
	}
	
}
