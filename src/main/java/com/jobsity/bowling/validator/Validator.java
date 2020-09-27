package com.jobsity.bowling.validator;

/**
 *
 * @author jodevan
 */
public interface Validator {
	
	public boolean isValid(int frameNumber, int[] chances);
	
}
