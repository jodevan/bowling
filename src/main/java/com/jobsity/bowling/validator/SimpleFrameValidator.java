package com.jobsity.bowling.validator;

import com.jobsity.bowling.frame.Frame;

/**
 *
 * @author jodevan
 */
public class SimpleFrameValidator extends TwoChancesFrameValidator {

	@Override
	public boolean isValid(Frame frame, int... chances) {
		return frame == null ? false : super.isValid(frame, chances);
	}
}
