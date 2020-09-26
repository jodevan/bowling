package com.jobsity.bowling.validator;

import com.jobsity.bowling.frame.Frame;

/**
 *
 * @author jodevan
 */
public class TwoChancesFrameValidator extends DefaultChanceValidator {

	@Override
	public boolean isValid(Frame frame, int... chances) {
		// A simple frame should have 2 chances
		if (chances == null || chances.length != 2) {
			return false;
		}
		
		if (!isChanceValid(chances[0]) || !isChanceValid(chances[1])) {
			return false;
		}

		// The sum of chances has to be < 10. If it's 10, a SpareFrame
		// validator has to be used instead
		if (chances[0] + chances[1] >= Frame.MAX_SCORE) {
			return false;
		}
		
		return true;
	}
	
}
