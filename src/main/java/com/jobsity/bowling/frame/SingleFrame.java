package com.jobsity.bowling.frame;

import java.util.Arrays;

/**
 *
 * @author jodevan
 */
public class SingleFrame extends Frame {

	public SingleFrame(int chance1, int chance2) {
		chances = new int[]{chance1, chance2};
	}

	public SingleFrame(int chance1, int chance2, int chance3) {
		chances = new int[]{chance1, chance2, chance3};
	}

	@Override
	public int calcScore() {
		return Arrays.stream(chances)
				.reduce(0, (chance1, chance2) -> chance1 + chance2);
	}
}
