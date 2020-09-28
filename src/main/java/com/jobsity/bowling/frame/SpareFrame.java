package com.jobsity.bowling.frame;

import com.jobsity.bowling.frame.print.impl.PrintSpareFrameBehavior;
import com.jobsity.bowling.score.impl.SpareFrameCalcBehavior;
import com.jobsity.bowling.validator.impl.SpareFrameValidator;

/**
 *
 * @author jodevan
 */
public class SpareFrame extends Frame {
	
	public SpareFrame(int frameNumber, Frame nextFrame, int chance) {
		super(
				frameNumber,
				new int[]{chance, Frame.MAX_SCORE - chance}, 
				nextFrame,
				new SpareFrameCalcBehavior(),
				new PrintSpareFrameBehavior(),
				new SpareFrameValidator());
	}
}
