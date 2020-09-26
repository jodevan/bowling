package com.jobsity.bowling.frame;

/**
 *
 * @author jodevan
 */
public class SpareFrame extends Frame {

	public SpareFrame(int chance) {
		chances = new int[]{chance, 10 - chance};
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
