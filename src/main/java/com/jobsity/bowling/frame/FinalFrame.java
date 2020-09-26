package com.jobsity.bowling.frame;

import com.jobsity.bowling.exception.FrameCreationException;
import com.jobsity.bowling.exception.InvalidChanceException;
import com.jobsity.bowling.exception.InvalidChancesException;

/**
 *
 * @author jodevan
 */
public class FinalFrame extends Frame {
	
	public FinalFrame(Frame nextFrame) {
		super(null);
	}
	
	public FinalFrame(int chance1, int chance2) {
		super(null);
	}
	
	public FinalFrame(int chance1, int chance2, int chance3) {
		super(null);
		if (!isChanceValid(chance1)
				|| !isChanceValid(chance2)
				|| !isChanceValid(chance3)) {
			throw new FrameCreationException(
					new InvalidChanceException(Frame.MAX_SCORE));
		}
		
		if (chance1 + chance2 < Frame.MAX_SCORE) {
			throw new FrameCreationException(
					new InvalidChancesException(Frame.MAX_SCORE));
		}
		
		chances = new int[]{chance1, chance2, chance3};
	}
}
