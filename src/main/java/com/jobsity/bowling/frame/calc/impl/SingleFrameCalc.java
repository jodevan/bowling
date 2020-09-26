package com.jobsity.bowling.frame.calc.impl;

import com.jobsity.bowling.frame.Frame;
import com.jobsity.bowling.frame.calc.CalcBehavior;
import java.util.Arrays;

/**
 * @author jodevan
 */
public class SingleFrameCalc implements CalcBehavior {

	@Override
	public int calc(Frame frame) {
		
		if (frame == null || frame.getChances() == null) {
			return 0;
		}
		
		return Arrays.stream(frame.getChances())
				.reduce(0, (chance1, chance2) -> chance1 + chance2);
	}

}
