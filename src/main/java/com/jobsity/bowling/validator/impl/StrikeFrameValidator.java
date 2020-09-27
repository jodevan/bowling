package com.jobsity.bowling.validator.impl;

import com.jobsity.bowling.frame.Frame;

/**
 *
 * @author jodevan
 */
public class StrikeFrameValidator extends DefaultFrameValidator {

	@Override
	public boolean isValid(int[] chances) {
		
		if (chances.length != 1 || chances[0] != Frame.MAX_SCORE) {
			return false;
		}
		
		return true;
	}
}
