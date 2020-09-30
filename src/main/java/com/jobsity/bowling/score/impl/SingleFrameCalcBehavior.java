package com.jobsity.bowling.score.impl;

import com.jobsity.bowling.frame.Frame;
import java.util.Arrays;
import com.jobsity.bowling.score.ScoreCalcBehavior;

/**
 * Behavior to calculate a regular two-chance frame
 * @author jodevan
 */
public class SingleFrameCalcBehavior implements ScoreCalcBehavior {

	@Override
	public int calculate(Frame frame) {
		if (frame == null || frame.getChances() == null) {
			return 0;
		}
		return Arrays.stream(frame.getChances())
				.map(chance -> chance.getIntValue())
				.reduce(0, (chance1, chance2) -> chance1 + chance2);
	}
	
}
