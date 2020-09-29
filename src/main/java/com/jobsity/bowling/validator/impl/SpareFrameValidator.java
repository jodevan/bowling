package com.jobsity.bowling.validator.impl;

import com.jobsity.bowling.frame.Chance;
import com.jobsity.bowling.game.BowlingGame;

/**
 *
 * @author jodevan
 */
public class SpareFrameValidator extends DefaultFrameValidator {

	@Override
	public boolean isValid(Chance... chances) {
		if (chances.length != 2) {
			return false;
		}
		
		Chance chance1 = chances[0];
		Chance chance2 = chances[1];
		
		if (!isChanceValid(chance1, BowlingGame.MAX_SCORE - 1)
				|| !isChanceValid(chance1, BowlingGame.MAX_SCORE)) {
			return false;
		}
		
		return Chance.sum(chance1, chance2) == BowlingGame.MAX_SCORE ?
				true : false;
	}
}
