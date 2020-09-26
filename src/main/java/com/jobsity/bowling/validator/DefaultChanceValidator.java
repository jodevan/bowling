package com.jobsity.bowling.validator;

import com.jobsity.bowling.frame.Frame;

/**
 *
 * @author jodevan
 */
public abstract class DefaultChanceValidator implements Validator {

	public boolean isChanceValid(int chance) {
		return isChanceValid(chance, Frame.MAX_SCORE);
	}

	public boolean isChanceValid(int chance, int maxChanceAllowedValue) {
		return chance >= 0 && chance <= maxChanceAllowedValue;
	}
}
