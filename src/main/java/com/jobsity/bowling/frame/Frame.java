package com.jobsity.bowling.frame;

import com.jobsity.bowling.frame.exception.FrameCreationException;
import com.jobsity.bowling.score.ScoreCalcBehavior;
import com.jobsity.bowling.frame.print.PrintChancesBehavior;
import com.jobsity.bowling.validator.ValidatorBehavior;

/**
 * Represents an abstract frame. Each type of frame will provide its
 * own implementation
 * @author jodevan
 */
public abstract class Frame {

	
	/**
	 * Frame number
	 */
	private final int frameNumber;

	/**
	 * The number of chances of a frame
	 */
	protected final Chance[] chances;
	
	/**
	 * The frame that follows the current frame. They become specially important
	 * when calculating the current frame score for spares and strikes.
	 * It's also used to chain the list of frames of a player
	 */
	protected Frame nextFrame;
	
	/**
	 * Strategy use to calculate the current frame score
	 */
	private final ScoreCalcBehavior scoreCalcBehavior;

	/**
	 * Strategy use to print the current frame chances
	 */
	private final PrintChancesBehavior printChancesBehavior;
	
	/*
	 * Note: This class use to instances of the strategy pattern: 
	 * ScoreCalcBehavior, PrintChancesBehavior, and ValidatorBehavior. 
	 * One option would be having class instances to store and use them, 
	 * even being possible to switch the behaviors on the fly. However,
	 * opted by defining all the behaviors of the frame during the instantion
	 * time
	 */

	/**
	 * Instantiates a frame
	 * @param frameNumber The number of the current frame
	 * @param chances The number of chances of each frame
	 * @param nextFrame Next frame
	 * @param calcBehavior Strategy use to calculate the current frame score
	 * @param printBehavior Strategy use to print the current frame chances
	 * @param validatorBehavior It's not possible to instatiate invalid frames, 
	 * i.e., frames with without chances or invalid chance values. This 
	 * validator represents a strategy to validade each frame according to 
	 * its type.
	 */
	protected Frame(
			int frameNumber, 
			Chance[] chances, 
			Frame nextFrame, 
			ScoreCalcBehavior calcBehavior, 
			PrintChancesBehavior printBehavior, 
			ValidatorBehavior validatorBehavior) {
		
		this.frameNumber = frameNumber;
		this.nextFrame = nextFrame;
		this.chances = chances;
		this.scoreCalcBehavior = calcBehavior;
		this.printChancesBehavior = printBehavior;
		
		if (validatorBehavior == null) {
			throw new FrameCreationException("Validator can't be null");
		}
		if (!validatorBehavior.isValid(frameNumber, chances)) {
			throw new FrameCreationException("Invalid parameters");
		}
	}

	protected Frame(
			int frameNumber, 
			Chance[] chances, 
			ScoreCalcBehavior calcBehavior, 
			PrintChancesBehavior printBehavior, 
			ValidatorBehavior validator) {
		this(frameNumber, chances, null, calcBehavior, 
				printBehavior, validator);
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
	
	/**
	 * Print the chances according to the frame type (spare, strike, etc.)
	 * @return 
	 */
	public String printChances() {
		return printChancesBehavior != null ? 
				printChancesBehavior.print(this) : null;
	}
	
	public int getFrameNumber() {
		return frameNumber;
	}
	
	public Chance[] getChances() {
		return chances;
	}
	
	public Frame getNextFrame() {
		return nextFrame;
	}

	public void setNextFrame(Frame nextFrame) {
		this.nextFrame = nextFrame;
	}
}
