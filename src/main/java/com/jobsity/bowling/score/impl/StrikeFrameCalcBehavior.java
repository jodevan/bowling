package com.jobsity.bowling.score.impl;

import com.jobsity.bowling.frame.Frame;
import com.jobsity.bowling.game.BowlingGame;
import com.jobsity.bowling.score.ScoreCalcBehavior;

/**
 *
 * @author jodevan
 */
public class StrikeFrameCalcBehavior implements ScoreCalcBehavior {

	@Override
	public int calculate(Frame frame) {
		if (frame == null) {
			return 0;
		}
		
		Frame nextFrame = frame.getNextFrame();
		
		int nextChance1 = 0;
		int nextChance2 = 0;

		if (nextFrame != null) {
			int[] nextChances = nextFrame.getChances();

			// Given that creating invalid frames is not allowed, we can
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
		}

		// A strike always counts 10;
		return BowlingGame.MAX_SCORE + nextChance1 + nextChance2;
	}
}
