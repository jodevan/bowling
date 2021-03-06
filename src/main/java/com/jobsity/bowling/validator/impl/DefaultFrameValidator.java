package com.jobsity.bowling.validator.impl;

import com.jobsity.bowling.frame.Chance;
import com.jobsity.bowling.game.BowlingGame;
import com.jobsity.bowling.game.parser.PlayRecordParser;
import com.jobsity.bowling.validator.ValidatorBehavior;

/**
 * Implements a few handy validation methods
 * @author jodevan
 */
public abstract class DefaultFrameValidator implements ValidatorBehavior {
	
	public abstract boolean isValid(Chance... chances);
	
	@Override
	public boolean isValid(int frameNumber, Chance[] chances) {
		return frameNumber > BowlingGame.MAX_FRAMES ? false : isValid(chances);
	}
	
	public boolean isChanceValid(Chance chance) {
		return isChanceValid(chance, BowlingGame.MAX_SCORE);
	}

	public boolean isChanceValid(Chance chance, int maxChanceAllowedValue) {
		return chance.getIntValue() >= PlayRecordParser.FAULT_INT_VALUE
				&& chance.getIntValue() <= maxChanceAllowedValue;
	}
}
