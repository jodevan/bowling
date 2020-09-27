package com.jobsity.bowling.frame;

import com.jobsity.bowling.score.impl.SingleFrameCalcBehavior;
import com.jobsity.bowling.validator.SimpleFrameValidator;

/**
 *
 * @author jodevan
 */
public class SimpleFrame extends Frame {

	public SimpleFrame(Frame nextFrame, int chance1, int chance2) {
		super(
				new int[]{chance1, chance2}, 
				nextFrame,
				new SingleFrameCalcBehavior(),
				new SimpleFrameValidator());
	}
}
