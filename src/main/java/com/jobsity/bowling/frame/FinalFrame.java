package com.jobsity.bowling.frame;

import com.jobsity.bowling.frame.print.impl.PrintSimpleFrameBehavior;
import com.jobsity.bowling.frame.print.impl.PrintThreeChancesFrameBehavior;
import com.jobsity.bowling.score.impl.SingleFrameCalcBehavior;
import com.jobsity.bowling.validator.impl.SimpleFrameValidator;
import com.jobsity.bowling.validator.impl.ThreeChancesFrameValidator;

/**
 *
 * @author jodevan
 */
public class FinalFrame extends Frame {
	
	public FinalFrame(int frameNumber, int chance1, int chance2) {
		super(
				frameNumber,
				new int[]{chance1, chance2}, 
				null,
				new SingleFrameCalcBehavior(),
				new PrintThreeChancesFrameBehavior(),
				new SimpleFrameValidator());
	}
	
	public FinalFrame(int frameNumber, int chance1, int chance2, int chance3) {
		super(
				frameNumber,
				new int[]{chance1, chance2, chance3}, 
				null,
				new SingleFrameCalcBehavior(),
				new PrintThreeChancesFrameBehavior(),
				new ThreeChancesFrameValidator());
	}
}
