package com.jobsity.bowling.validator;

import com.jobsity.bowling.frame.Frame;

/**
 *
 * @author jodevan
 */
public class SpareFrameValidator extends DefaultChanceValidator {

	@Override
	public boolean isValid(Frame frame, int... chances) {
		if (frame == null || chances == null) {
			return false;
		}
		
		int chance1 = 0;
		int chance2 = 0;
		
		switch(chances.length) {
			case 1:
				chance1 = chances[0];
				break;
			case 2:
				chance1 = chances[0];
				chance2 = chances[1];
				break;
			default:
				return false;
		}
		
		if (!isChanceValid(chance1, Frame.MAX_SCORE - 1)) {
			return false;
		}
		
		return chance1 + chance2 == Frame.MAX_SCORE ? true : false;
	}
}
