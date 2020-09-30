package com.jobsity.bowling.validator;

import com.jobsity.bowling.frame.Chance;

/**
 * A strategy pattern to define different behaviors when validating a frame
 * @author jodevan
 */
public interface ValidatorBehavior {
	
	public boolean isValid(int frameNumber, Chance... chances);
	
}
