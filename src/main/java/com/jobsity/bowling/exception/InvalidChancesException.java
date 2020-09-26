package com.jobsity.bowling.exception;

/**
 *
 * @author jodevan
 */
public class InvalidChancesException extends Exception {

	public InvalidChancesException(int maxChancesAllowedValue) {
		super("The sum of the values of the chances must be between 0 and " 
				+ maxChancesAllowedValue);
	}
	
}
