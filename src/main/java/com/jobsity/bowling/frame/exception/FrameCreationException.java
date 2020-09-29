package com.jobsity.bowling.frame.exception;

/**
 *
 * @author jodevan
 */
public class FrameCreationException extends RuntimeException {
	
	public FrameCreationException(String msg) {
		super(msg);
	}

	public FrameCreationException(Throwable throwable) {
		super(throwable);
	}
}
