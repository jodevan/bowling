package com.jobsity.bowling.frame;

import com.jobsity.bowling.frame.print.impl.PrintThreeChancesFrameBehavior;
import com.jobsity.bowling.score.impl.SingleFrameCalcBehavior;
import com.jobsity.bowling.validator.impl.SimpleFrameValidator;
import com.jobsity.bowling.validator.impl.ThreeChancesFrameValidator;

/**
 *
 * @author jodevan
 */
public class FinalFrame extends Frame {
	
	public FinalFrame(int frameNumber, Chance chance1, Chance chance2) {
		super(
				frameNumber,
				new Chance[]{chance1, chance2}, 
				null,
				new SingleFrameCalcBehavior(),
				new PrintThreeChancesFrameBehavior(),
				new SimpleFrameValidator());
	}
	
	public FinalFrame(int frameNumber, Chance chance1, Chance chance2, 
			Chance chance3) {
		super(
				frameNumber,
				new Chance[]{chance1, chance2, chance3}, 
				null,
				new SingleFrameCalcBehavior(),
				new PrintThreeChancesFrameBehavior(),
				new ThreeChancesFrameValidator());
	}
}
