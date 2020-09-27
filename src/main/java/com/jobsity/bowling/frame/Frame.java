package com.jobsity.bowling.frame;

import com.jobsity.bowling.exception.FrameCreationException;
import com.jobsity.bowling.validator.Validator;
import com.jobsity.bowling.score.ScoreCalcBehavior;

/**
 * Represents an abstract frame. Each type of frame will provide its
 * own implementation
 * @author jodevan
 */
public abstract class Frame {

	/**
	 * Constant to represent the max allowed score for a chance
	 */
	public static final int MAX_SCORE = 10;

	/**
	 * The number of chances of a frame
	 */
	protected final int[] chances;
	
	/**
	 * The frame that follows the current frame. They become specially important
	 * when calculating the current frame score for spares and strikes.
	 * It's also used to chain the list of frames of a player.
	 * Only the FinalFrame is allowed to do not have the next frame.
	 */
	protected final Frame nextFrame;
	
	/**
	 * Strategy use to calculate the current frame score
	 */
	private final ScoreCalcBehavior scoreCalcBehavior;
	
	/*
	 * Note: This class use to instances of the strategy pattern: 
	 * ScoreCalcBehavior and Validator. One option would be having class 
	 * instances to store and use them, even being possible to switch the 
	 * behaviors on the fly.
	 * Since the validation behavior is used to determine the frame validity,
	 * I opted by passing it in the constructor and validate it right away.
	 */

	/**
	 * Instantiates a frame
	 * @param chances The number of chances of each frame
	 * @param nextFrame Next frame
	 * @param calcBehavior Strategy use to calculate the current frame score
	 * @param validator It's not possible to instatiate invalid frames, i.e.,
	 * frames with without chances or invalid chance values. This validator
	 * is a represents a strategy to validade each frame according to its type.
	 */
	protected Frame(int[] chances, Frame nextFrame, 
			ScoreCalcBehavior calcBehavior, Validator validator) {
		this.nextFrame = nextFrame;
		this.chances = chances;
		this.scoreCalcBehavior = calcBehavior;
		
		if (validator == null) {
			throw new FrameCreationException("Validator can't be null");
		}
		if (!validator.isValid(nextFrame, chances)) {
			throw new FrameCreationException("Invalid parameters");
		}
	}

	/**
	 * Calculates the own current frame score. That means it doesn't keep track
	 * of the total player score so far.
	 * @return This frame score
	 */
	public int calcScore() {
		return scoreCalcBehavior != null ? 
				scoreCalcBehavior.calculate(this) : 0;
	}
	
	public int[] getChances() {
		return chances;
	}

	public Frame getNextFrame() {
		return nextFrame;
	}
}
