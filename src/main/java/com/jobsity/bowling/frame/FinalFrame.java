package com.jobsity.bowling.frame;

import com.jobsity.bowling.score.impl.SingleFrameCalcBehavior;
import com.jobsity.bowling.validator.ThreeChancesFrameValidator;
import com.jobsity.bowling.validator.TwoChancesFrameValidator;

/**
 *
 * @author jodevan
 */
public class FinalFrame extends Frame {
	
	public FinalFrame(int chance1, int chance2) {
		super(
				new int[]{chance1, chance2}, 
				null,
				new SingleFrameCalcBehavior(),
				new TwoChancesFrameValidator());
	}
	
	public FinalFrame(int chance1, int chance2, int chance3) {
		super(
				new int[]{chance1, chance2, chance3}, 
				null,
				new SingleFrameCalcBehavior(),
				new ThreeChancesFrameValidator());
	}
}
