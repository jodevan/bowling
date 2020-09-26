package com.jobsity.bowling.frame.calc.impl;

import com.jobsity.bowling.frame.Frame;
import com.jobsity.bowling.frame.calc.CalcBehavior;

/**
 * @author jodevan
 */
public class StrikeFrameCalc implements CalcBehavior {

	@Override
	public int calc(Frame frame) {
		if (frame == null) {
			return 0;
		}
		
		int nextChance1 = 0;
		int nextChance2 = 0;
		
		Frame nextFrame = frame.getNextFrame();
		
		int[] nextChances = getNextChances(nextFrame);
		
		if (nextChances != null && nextChances.length > 0) {
			nextChance1 = nextChances[0];
			if (nextChances.length > 1) {
				nextChance2 = nextChances[1];
			} else {
				nextFrame = nextFrame.getNextFrame();
				int[] nextChancesNextFrame = getNextChances(nextFrame);
				if (nextChancesNextFrame != null 
						&& nextChancesNextFrame.length > 0) {
					nextChance2 = nextChancesNextFrame[0];
				}
			}
		}
		
		// A strike always counts 10;
		return 10 + nextChance1 + nextChance2;
	}
	
	private int[] getNextChances(Frame frame) {
		return frame != null ? frame.getChances() : null;
	}
	
}
