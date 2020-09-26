package com.jobsity.bowling.exception;

/**
 *
 * @author jodevan
 */
public class NextFrameException extends Exception {

	public NextFrameException() {
		super("The frame that follows the current frame couldn't be found");
	}
}
