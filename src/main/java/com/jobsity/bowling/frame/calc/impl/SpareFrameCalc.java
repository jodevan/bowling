package com.jobsity.bowling.frame.calc.impl;

import com.jobsity.bowling.frame.Frame;
import com.jobsity.bowling.frame.calc.CalcBehavior;

/**
 * @author jodevan
 */
public class SpareFrameCalc implements CalcBehavior {

	@Override
	public int calc(Frame frame) {
		if (frame == null || frame.getChances() == null
				|| frame.getChances().length == 0) {
			return 0;
		}
		
		int nextFrameChance = 0;
		Frame nextFrame = frame.getNextFrame();

		if (nextFrame != null) {
			int[] chances = nextFrame.getChances();
			if (chances != null && chances.length > 0) {
				nextFrameChance = chances[0];
			}
		}
		
		// A spare always counts 10;
		return 10 + nextFrameChance;
	}

}
