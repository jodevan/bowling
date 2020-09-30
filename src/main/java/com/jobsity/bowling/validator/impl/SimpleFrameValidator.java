package com.jobsity.bowling.validator.impl;

import com.jobsity.bowling.frame.Chance;
import com.jobsity.bowling.game.BowlingGame;

/**
 * Behavior to validate a two-chance frame
 * @author jodevan
 */
public class SimpleFrameValidator extends DefaultFrameValidator {

	@Override
	public boolean isValid(Chance... chances) {
		// A simple frame should have 2 chances
		if (chances == null || chances.length != 2) {
			return false;
		}
		
		if (!isChanceValid(chances[0]) || !isChanceValid(chances[1])) {
			return false;
		}

		// The sum of chances has to be < 10. If it's 10, a SpareFrame
		// validator has to be used instead
		if (Chance.sum(chances[0], chances[1]) >= BowlingGame.MAX_SCORE) {
			return false;
		}
		
		return true;
	}
}
