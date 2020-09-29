package com.jobsity.bowling.validator.impl;

import com.jobsity.bowling.frame.Chance;
import com.jobsity.bowling.game.BowlingGame;

/**
 *
 * @author jodevan
 */
public class ThreeChancesFrameValidator extends DefaultFrameValidator {

	@Override
	public boolean isValid(Chance... chances) {
		if (chances == null || chances.length != 3) {
			return false;
		}
		
		if (!isChanceValid(chances[0]) 
				|| !isChanceValid(chances[1])
				|| !isChanceValid(chances[2])) {
			return false;
		}

		// First chance was a strike
		if (chances[0].getIntValue() == BowlingGame.MAX_SCORE) {
			// Second chance was a strike too
			if (chances[1].getIntValue() == BowlingGame.MAX_SCORE) {
				return true;
			} else {
				return Chance.sum(chances[1], chances[2]) <=
						BowlingGame.MAX_SCORE;
			}
		} else {
			return Chance.sum(chances[0], chances[1]) == BowlingGame.MAX_SCORE;
		}
	}
}
