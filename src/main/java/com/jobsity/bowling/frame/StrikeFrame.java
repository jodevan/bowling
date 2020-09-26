package com.jobsity.bowling.frame;

/**
 *
 * @author jodevan
 */
public class StrikeFrame extends Frame {

	public StrikeFrame() {
		chances = new int[]{Frame.MAX_SCORE};
	}

	@Override
	public int calcScore() {
		int nextChance1 = 0;
		int nextChance2 = 0;

		if (nextFrame != null) {
			int[] nextChances = nextFrame.getChances();

			if (nextChances.length > 1) {
				nextChance1 = nextChances[0];
				nextChance2 = nextChances[1];
			} else if (nextChances.length == 1) {
				nextChance1 = nextChances[0];
				Frame nextNextFrame = nextFrame.getNextFrame();
				if (nextNextFrame != null
						&& nextNextFrame.getChances().length > 0) {
					nextChance2 = nextNextFrame.getChances()[0];
				}
			}
		}

		// A strike always counts 10;
		return Frame.MAX_SCORE + nextChance1 + nextChance2;
	}
}
