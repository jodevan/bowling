package com.jobsity.bowling.frame;

/**
 *
 * @author jodevan
 */
public class StrikeFrame extends LookAheadFrame {

	public StrikeFrame(Frame nextFrame) {
		super(nextFrame);
		chances = new int[]{Frame.MAX_SCORE};
	}

	@Override
	public int calcScore() {
		int nextChance1 = 0;
		int nextChance2 = 0;

		int[] nextChances = nextFrame.getChances();

		// Given that creating Invalid frames is not allowed, we can
		// safely assume it will always have at least 1 chance in
		// its array
		nextChance1 = nextChances[0];

		if (nextChances.length > 1) {
			nextChance2 = nextChances[1];
		} else {
			Frame nextNextFrame = nextFrame.getNextFrame();
			if (nextNextFrame != null) {
				nextChance2 = nextNextFrame.getChances()[0];
			}
		}

		// A strike always counts 10;
		return Frame.MAX_SCORE + nextChance1 + nextChance2;
	}
}
