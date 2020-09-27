package com.jobsity.bowling.frame;

import com.jobsity.bowling.score.impl.SpareFrameCalcBehavior;
import com.jobsity.bowling.validator.SpareFrameValidator;

/**
 *
 * @author jodevan
 */
public class SpareFrame extends Frame {
	
	public SpareFrame(Frame nextFrame, int chance) {
		super(
				new int[]{chance, Frame.MAX_SCORE - chance}, 
				nextFrame,
				new SpareFrameCalcBehavior(),
				new SpareFrameValidator());
	}
}
