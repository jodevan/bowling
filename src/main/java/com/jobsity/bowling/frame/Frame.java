package com.jobsity.bowling.frame;

import com.jobsity.bowling.exception.FrameCreationException;
import com.jobsity.bowling.validator.Validator;

/**
 *
 * @author jodevan
 */
public abstract class Frame {

	public static final int MAX_SCORE = 10;

	protected final int[] chances;
	protected final Frame nextFrame;
//	private final 

	protected Frame(int[] chances, Frame nextFrame, Validator validator) {
		this.nextFrame = nextFrame;
		this.chances = chances;
		if (validator == null) {
			throw new FrameCreationException("Validator can't be null");
		}
		if (!validator.isValid(this)) {
			throw new FrameCreationException("Invalid parameters");
		}
	}

	public abstract int calcScore();
	
	public int[] getChances() {
		return chances;
	}

	public Frame getNextFrame() {
		return nextFrame;
	}
}
