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
		
//		if (chances[0] == Frame.MAX_SCORE) {
//			return chances[1] + chances[2] <= Frame.MAX_SCORE;
//		} else {
//			return chances[0] + chances[1] == Frame.MAX_SCORE
//					&& chances[1] + chances[2] <= Frame.MAX_SCORE;
//		}

		// First chance was a strike
		if (chances[0] == Frame.MAX_SCORE) {
			// Second chance was a strike too
			if (chances[1] == Frame.MAX_SCORE) {
				return true;
			} else {
				return chances[1] + chances[2] <= Frame.MAX_SCORE;
			}
		} else {
			return chances[0] + chances[1] == Frame.MAX_SCORE;
		}
	}
}
