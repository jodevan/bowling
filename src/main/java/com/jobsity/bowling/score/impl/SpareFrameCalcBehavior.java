package com.jobsity.bowling.score.impl;

import com.jobsity.bowling.frame.Frame;
import com.jobsity.bowling.score.ScoreCalcBehavior;

/**
 *
 * @author jodevan
 */
public class SpareFrameCalcBehavior implements ScoreCalcBehavior {

	@Override
	public int calculate(Frame frame) {
		if (frame == null) {
			return 0;
		}
		
		// Given that creating invalid frames is not allowed, we can
		// safely assume it will always have at least 1 chance in
		// its array
		
		// A spare frame always counts 10;
		return Frame.MAX_SCORE + frame.getNextFrame().getChances()[0];
	}
	
}