package com.jobsity.bowling.validator.impl;

import com.jobsity.bowling.frame.Frame;

/**
 *
 * @author jodevan
 */
public class ThreeChancesFrameValidator extends DefaultFrameValidator {

	@Override
	public boolean isValid(int[] chances) {
		if (chances == null || chances.length != 3) {
			return false;
		}
		
		if (!isChanceValid(chances[0]) 
				|| !isChanceValid(chances[1])
				|| !isChanceValid(chances[2])) {
			return false;
		}

		if (chances[0] + chances[1] < Frame.MAX_SCORE) {
			return false;
		}

		return true;
	}
	
}
