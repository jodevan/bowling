package com.jobsity.bowling.frame;

import com.jobsity.bowling.score.impl.StrikeFrameCalcBehavior;
import com.jobsity.bowling.validator.StrikeFrameValidator;

/**
 *
 * @author jodevan
 */
public class StrikeFrame extends Frame {

	public StrikeFrame(Frame nextFrame) {
		super(
				new int[]{Frame.MAX_SCORE}, 
				nextFrame, 
				new StrikeFrameCalcBehavior(),
				new StrikeFrameValidator());
	}
}
