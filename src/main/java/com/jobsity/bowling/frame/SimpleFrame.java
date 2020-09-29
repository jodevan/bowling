package com.jobsity.bowling.frame;

import com.jobsity.bowling.frame.print.impl.PrintSimpleFrameBehavior;
import com.jobsity.bowling.score.impl.SingleFrameCalcBehavior;
import com.jobsity.bowling.validator.impl.SimpleFrameValidator;

/**
 *
 * @author jodevan
 */
public class SimpleFrame extends Frame {

	public SimpleFrame(int frameNumber, Frame nextFrame, 
			Chance chance1, Chance chance2) {
		super(
				frameNumber,
				new Chance[]{chance1, chance2}, 
				nextFrame,
				new SingleFrameCalcBehavior(),
				new PrintSimpleFrameBehavior(),
				new SimpleFrameValidator());
	}

	public SimpleFrame(int frameNumber,
			Chance chance1, Chance chance2) {
		super(
				frameNumber,
				new Chance[]{chance1, chance2}, 
				null,
				new SingleFrameCalcBehavior(),
				new PrintSimpleFrameBehavior(),
				new SimpleFrameValidator());
	}
}
