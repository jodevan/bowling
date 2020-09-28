package com.jobsity.bowling.validator.impl;

import com.jobsity.bowling.game.BowlingGame;
import com.jobsity.bowling.validator.Validator;

/**
 *
 * @author jodevan
 */
public abstract class DefaultFrameValidator implements Validator {
	
	@Override
	public boolean isValid(int frameNumber, int[] chances) {
		return frameNumber > BowlingGame.MAX_FRAMES ? false : isValid(chances);
	}
	
	public abstract boolean isValid(int chances[]);
	
	public boolean isChanceValid(int chance) {
		return isChanceValid(chance, BowlingGame.MAX_SCORE);
	}

	public boolean isChanceValid(int chance, int maxChanceAllowedValue) {
		return chance >= 0 && chance <= maxChanceAllowedValue;
	}
}
