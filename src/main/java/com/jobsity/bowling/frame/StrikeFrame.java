package com.jobsity.bowling.frame;

import com.jobsity.bowling.frame.print.impl.PrintStrikeFrameBehavior;
import com.jobsity.bowling.score.impl.StrikeFrameCalcBehavior;
import com.jobsity.bowling.validator.impl.StrikeFrameValidator;

/**
 *
 * @author jodevan
 */
public class StrikeFrame extends Frame {

	public StrikeFrame(int frameNumber, Frame nextFrame) {
		super(
				frameNumber,
				new int[]{Frame.MAX_SCORE}, 
				nextFrame, 
				new StrikeFrameCalcBehavior(),
				new PrintStrikeFrameBehavior(),
				new StrikeFrameValidator());
	}
}
