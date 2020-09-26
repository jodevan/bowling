package com.jobsity.bowling.validator;

import com.jobsity.bowling.frame.Frame;

/**
 *
 * @author jodevan
 */
public interface Validator {
	
	public boolean isValid(Frame frame, int... chances);
	
}
