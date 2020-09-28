package com.jobsity.bowling.validator.impl;

import com.jobsity.bowling.game.BowlingGame;

/**
 *
 * @author jodevan
 */
public class StrikeFrameValidator extends DefaultFrameValidator {

	@Override
	public boolean isValid(int[] chances) {
		
		if (chances.length != 1 || chances[0] != BowlingGame.MAX_SCORE) {
			return false;
		}
		
		return true;
	}
}
