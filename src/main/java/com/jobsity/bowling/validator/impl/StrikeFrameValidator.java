package com.jobsity.bowling.validator.impl;

import com.jobsity.bowling.frame.Chance;
import com.jobsity.bowling.game.BowlingGame;

/**
 * Behavior to validate a strike frame
 * @author jodevan
 */
public class StrikeFrameValidator extends DefaultFrameValidator {

	@Override
	public boolean isValid(Chance... chances) {

		return chances.length == 1
				&& chances[0].getIntValue() == BowlingGame.MAX_SCORE;

	}
}
