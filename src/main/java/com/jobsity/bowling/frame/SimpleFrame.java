package com.jobsity.bowling.frame;

import com.jobsity.bowling.validator.SimpleFrameValidator;
import java.util.Arrays;

/**
 *
 * @author jodevan
 */
public class SimpleFrame extends Frame {
	
	public SimpleFrame(Frame nextFrame, int chance1, int chance2) {
		super(new int[]{chance1, chance2}, nextFrame, new SimpleFrameValidator());
	}

	@Override
	public int calcScore() {
		return Arrays.stream(chances)
				.reduce(0, (chance1, chance2) -> chance1 + chance2);
	}
}
