package com.jobsity.bowling.frame;

import com.jobsity.bowling.validator.SpareFrameValidator;

/**
 *
 * @author jodevan
 */
public class SpareFrame extends Frame {
	
	public SpareFrame(Frame nextFrame, int chance) {
		super(new int[]{chance, Frame.MAX_SCORE - chance}, 
				nextFrame, new SpareFrameValidator());
	}

	@Override
	public int calcScore() {
		// A spare always counts 10;
		return Frame.MAX_SCORE + nextFrame.getChances()[0];
	}
}
