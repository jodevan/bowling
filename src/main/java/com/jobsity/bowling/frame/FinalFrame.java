package com.jobsity.bowling.frame;

import com.jobsity.bowling.validator.SimpleFrameValidator;

/**
 *
 * @author jodevan
 */
public class FinalFrame extends Frame {
	
	public FinalFrame(int chance1, int chance2) {
		super(new int[]{chance1, chance2}, null, new SimpleFrameValidator());
	}
	
	public FinalFrame(int chance1, int chance2, int chance3) {
		super(new int[]{chance1, chance2, chance3}, null, new SimpleFrameValidator());
	}

	@Override
	public int calcScore() {
		// TODO: Implement
		return 0;
	}
}
