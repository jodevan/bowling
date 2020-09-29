package com.jobsity.bowling.validator.exception;

/**
 *
 * @author jodevan
 */
public class ValidationException extends RuntimeException {
	
	public ValidationException(String msg) {
		super(msg);
	}

	public ValidationException(Throwable throwable) {
		super(throwable);
	}
}
