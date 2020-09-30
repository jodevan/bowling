package com.jobsity.bowling.frame.exception;

/**
 * Represents an exception thrown during a creation of frame.
 * It could have simply extended Exception, but for the sake of 
 * not having to add exceptions everywhere, it has inherited  RuntimeException.
 * The exceptions are still caught at a higher level, though
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
