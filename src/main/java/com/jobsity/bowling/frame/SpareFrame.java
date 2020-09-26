package com.jobsity.bowling.frame;

import com.jobsity.bowling.exception.FrameCreationException;
import com.jobsity.bowling.exception.InvalidChanceException;

/**
 *
 * @author jodevan
 */
public class SpareFrame extends Frame {

	public SpareFrame(int chance) {
		if (!isChanceValid(chance)) {
			throw new FrameCreationException(
					new InvalidChanceException(Frame.MAX_SCORE - 1));
		}
		
		chances = new int[]{chance, Frame.MAX_SCORE - chance};
	}

	@Override
	public int calcScore() {
		int nextFrameChance = 0;

		if (nextFrame != null) {
			int[] chances = nextFrame.getChances();
			if (chances.length > 0) {
				nextFrameChance = chances[0];
			}
		}

		// A spare always counts 10;
		return Frame.MAX_SCORE + nextFrameChance;
	}
}
