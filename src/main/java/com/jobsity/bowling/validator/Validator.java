package com.jobsity.bowling.validator;

import com.jobsity.bowling.frame.Chance;

/**
 *
 * @author jodevan
 */
public interface Validator {
	
	public boolean isValid(int frameNumber, Chance... chances);
	
}
