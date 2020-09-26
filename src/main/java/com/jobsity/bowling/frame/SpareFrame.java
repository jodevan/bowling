package com.jobsity.bowling.frame;

import com.jobsity.bowling.exception.FrameCreationException;
import com.jobsity.bowling.exception.InvalidChanceException;

/**
 *
 * @author jodevan
 */
public class SpareFrame extends LookAheadFrame {
	
	public SpareFrame(Frame nextFrame) {
		super(nextFrame);
	}

	public SpareFrame(Frame nextFrame, int chance) {
		super(nextFrame);
		
		if (!isChanceValid(chance)) {
			throw new FrameCreationException(
					new InvalidChanceException(Frame.MAX_SCORE - 1));
		}
		
		chances = new int[]{chance, Frame.MAX_SCORE - chance};
	}

	@Override
	public int calcScore() {
		// A spare always counts 10;
		return Frame.MAX_SCORE + nextFrame.getChances()[0];
	}
}
