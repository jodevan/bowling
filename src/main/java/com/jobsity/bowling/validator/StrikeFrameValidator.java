package com.jobsity.bowling.validator;

import com.jobsity.bowling.frame.Frame;

/**
 *
 * @author jodevan
 */
public class StrikeFrameValidator extends DefaultChanceValidator {

	@Override
	public boolean isValid(Frame frame, int... chances) {
		
		if (frame == null || chances == null) {
			return false;
		}
		
		if (chances.length != 1 || chances[0] != Frame.MAX_SCORE) {
			return false;
		}
		
		return true;
	}
}
